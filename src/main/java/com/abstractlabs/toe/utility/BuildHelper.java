package com.abstractlabs.toe.utility;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import com.abstractlabs.toe.init.ToeBlocks;

public class BuildHelper {
	
	/**
	 * Builds multiple blocks.
	 * @param world World object.
	 * @param x Starting x position.
	 * @param y Starting y position.
	 * @param z Starting z position.
	 * @param block Block to build with.
	 * @param xTimesTotal How many layers to build into the x axis. (Minimum: 1)
	 * @param yTimesTotal How many layers to build into the y axis. (Minimum: 1)
	 * @param zTimesTotal How many layers to build into the z axis. (Minimum: 1)
	 */
	public static void build(World world, int x, int y, int z, Block block, int xTimesTotal, int yTimesTotal, int zTimesTotal) {
		int z2 = z;
		int x2 = x;
		for (int yTimes = 0; yTimes < yTimesTotal; yTimes++) {
			for (int zTimes = 0; zTimes < zTimesTotal; zTimes++) {
				for (int xTimes = 0; xTimes < xTimesTotal; xTimes++) {
					world.setBlock(x2, y, z2, block);
					z2++;
				}
				z2 = z;
				x2++;
			}
			x2 = x;
			y++;
		}
	}
	
	/**
	 * Builds a hollow rectangle from around the coordinates.
	 * @param world World object.
	 * @param x Center x position of the rectangle.
	 * @param y Center y position of the rectangle.
	 * @param z Center z position of the rectangle.
	 * @param block Block to build with.
	 * @param size The size to build with. (Preferably an odd number)
	 */
	public static void buildHR(World world, int x, int y, int z, Block block, int size) {
		int x2 = x - (size/2);
		int z2 = z - (size/2);

		build(world, x2, y, z2, block, size, 1, 1);
		build(world, x2, y, z2, block, 1, 1, size);
		
		build(world, x2+(size-1), y, z2, block, size, 1, 1);
		build(world, x2, y, z2+(size-1), block, 1, 1, size);
	}
	
	/**
	 * Builds a solid rectangle from around the coordinates.
	 * @param world World object.
	 * @param x Center x position of the rectangle.
	 * @param y Center y position of the rectangle.
	 * @param z Center z position of the rectangle.
	 * @param block Block to build with.
	 * @param size The size to build with. (Preferably an odd number)
	 */
	public static void buildR(World world, int x, int y, int z, Block block, int size) {
		int x2 = x - (size/2);
		int z2 = z - (size/2);

		build(world, x2, y, z2, block, size, 1, size);
	}
	
	/**
	 * Builds a rectangle from around the coordinates. (Skips air blocks) (Used to clean the pyramid from inside)
	 * @param world World object.
	 * @param x Center x position of the rectangle.
	 * @param y Center y position of the rectangle.
	 * @param z Center z position of the rectangle.
	 * @param block Block to build with.
	 * @param size The size to build with. (Preferably an odd number)
	 */
	public static void buildRIfNotAir(World world, int x, int y, int z, Block block, int size) {
		int x2 = x - (size/2);
		int z2 = z - (size/2);
		
		buildIfNotAir(world, x2, y, z2, block, size, 1, size);
	}
	
	/**
	 * Builds multiple blocks. (Skips air blocks)
	 * @param world World object.
	 * @param x Starting x position.
	 * @param y Starting y position.
	 * @param z Starting z position.
	 * @param block Block to build with.
	 * @param xTimesTotal How many layers to build into the x axis. (Minimum: 1)
	 * @param yTimesTotal How many layers to build into the y axis. (Minimum: 1)
	 * @param zTimesTotal How many layers to build into the z axis. (Minimum: 1)
	 */
	public static void buildIfNotAir(World world, int x, int y, int z, Block block, int xTimesTotal, int yTimesTotal, int zTimesTotal) {
		int z2 = z;
		int x2 = x;
		for (int yTimes = 0; yTimes < yTimesTotal; yTimes++) {
			for (int zTimes = 0; zTimes < zTimesTotal; zTimes++) {
				for (int xTimes = 0; xTimes < xTimesTotal; xTimes++) {
					if(world.getBlock(x2, y, z2) != Blocks.air) {
						world.setBlock(x2, y, z2, block);
					}
					z2++;
				}
				z2 = z;
				x2++;
			}
			x2 = x;
			y++;
		}
	}
	
	/**
	 * Checks if a block is in the radius.
	 * @param world World object.
	 * @param X Center x position.
	 * @param Y Center y position.
	 * @param Z Center z position.
	 * @param radius Radius in which to check.
	 * @param block Block to check for.
	 * @return true if it finds the block.
	 */
	public static boolean isBlockNear(World world, int X, int Y, int Z, int radius, Block block) {
        int x = (int) (X -radius);
        int y = (int) (Y +radius);
        int z = (int) (Z -radius);
   
        int bx = x;
        int bz = z;
 
        for (int i=0; i<radius*2+1; i++) {
            for (int j=0; j<radius*2+1; j++) {
                for (int k=0; k<radius*2+1; k++) {
                    Block curBlock = world.getBlock(x, y, z);
                    
                    if(curBlock == block) {
                    	return true;
                    }
                    
                    x++;
                }
                z++;
                x = bx;
            }
            z = bz;
            x = bx;
            y--;
        }
        return false;
    }
	
	/**
	 * Checks if a block is in a selection.
	 * @param world World object.
	 * @param X Starting x position.
	 * @param Y Starting y position.
	 * @param Z Starting z position.
	 * @param block Block to check for.
	 * @param xTimesTotal How many layers to check in the x axis. (Minimum: 1)
	 * @param yTimesTotal How many layers to check in the y axis. (Minimum: 1)
	 * @param zTimesTotal How many layers to check in the z axis. (Minimum: 1)
	 * @return true if it finds the block.
	 */
	public boolean isBlockNear2(World world, int x, int y, int z, Block block, int xTimesTotal, int yTimesTotal, int zTimesTotal) {
		int z2 = z;
		int x2 = x;
		for (int yTimes = 0; yTimes < yTimesTotal; yTimes++) {
			for (int zTimes = 0; zTimes < zTimesTotal; zTimes++) {
				for (int xTimes = 0; xTimes < xTimesTotal; xTimes++) {
					Block curBlock = world.getBlock(x2, y, z2);
					
					if(curBlock == block) {
						//LogHelper.info("return true;");
                    	return true;
                    }
					
					z2++;
				}
				z2 = z;
				x2++;
			}
			x2 = x;
			y++;
		}
		//LogHelper.info("return false;");
		return false;
	}
	
	/**
	 * Checks if any of the blocks in the selection can see the sky. (Which means they have no solid blocks above them until the sky)
	 * @param world World object.
	 * @param x Starting x position.
	 * @param y Starting y position.
	 * @param z Starting z position.
	 * @param xTimesTotal How many layers to check in the x axis. (Minimum: 1)
	 * @param yTimesTotal How many layers to check in the y axis. (Minimum: 1)
	 * @param zTimesTotal How many layers to check in the z axis. (Minimum: 1)
	 * @return true if it finds a block that can see the sky.
	 */
	public static boolean canBlocksSeeSky(World world, int x, int y, int z, int xTimesTotal, int yTimesTotal, int zTimesTotal) {
		int z2 = z;
		int x2 = x;
		for (int yTimes = 0; yTimes < yTimesTotal; yTimes++) {
			for (int zTimes = 0; zTimes < zTimesTotal; zTimes++) {
				for (int xTimes = 0; xTimes < xTimesTotal; xTimes++) {
					//world.setBlock(x2, y, z2, block);
					
					if(world.canBlockSeeTheSky(x2, y, z2)) {
						//LogHelper.info("canBlocksSeeSky() returned true");
                    	return true;
                    }
					
					z2++;
				}
				z2 = z;
				x2++;
			}
			x2 = x;
			y++;
		}
		//LogHelper.info("canBlocksSeeSky() returned false");
		return false;
	}
	
	/**
	 * Checks if any of the blocks in a hollow rectangle can see the sky. (Which means they have no solid blocks above them until the sky)
	 * @param world World object.
	 * @param x Center x position.
	 * @param y Center y position.
	 * @param z Center z position.
	 * @param size Size of the hollow rectangle to check with.
	 * @return true if it finds a block that can see the sky.
	 */
	public static boolean canBlocksSeeSkyHR(World world, int x, int y, int z, int size) {
		int x2 = x - (size/2);
		int z2 = z - (size/2);

		if(canBlocksSeeSky(world, x2, y, z2, size, 1, 1) || canBlocksSeeSky(world, x2, y, z2, 1, 1, size) || canBlocksSeeSky(world, x2+(size-1), y, z2, size, 1, 1) || canBlocksSeeSky(world, x2, y, z2+(size-1), 1, 1, size)) {
			//LogHelper.info("canBlocksSeeSkyHR() returned true");
			return true;
		}
		
		//LogHelper.info("canBlocksSeeSkyHR() returned false");
		return false;
	}
	
	/**
	 * Builds a pool of quicksand.
	 * @param world World object.
	 * @param x X position.
	 * @param y Y position.
	 * @param z Z position.
	 */
	public static void buildQuicksandPool(World world, int x, int y, int z) {
		Random rand = new Random();
		int xTimes = rand.nextInt(2)+2; //From 2-3
		int yTimes = rand.nextInt(3)+1; //From 1-3
		int zTimes = rand.nextInt(2)+2; //From 2-3
		
		build(world, x, y, z, ToeBlocks.quicksand, xTimes, yTimes, zTimes);
	}
	
	/**
	 * Changes the given y position to the floor.
	 * @param world World object.
	 * @param x X position.
	 * @param y Y position.
	 * @param z Z position.
	 * @return the new y value.
	 */
	public static int positionYOnTheFloor(World world, int x, int y, int z) {
		while (!world.isAirBlock(x, y, z)) {
			y++;
        }
		
		while (world.isAirBlock(x, y-1, z)) {
			y--;
        }
		
		return y;
	}
    
    /**
     * Builds a circle around the coordinates with the given radius.
     * @param world World object.
     * @param X Center x position.
     * @param Y Center y position.
     * @param Z Center z position.
     * @param block Block to build with.
     * @param radius Radius of the circle.
     */
    public static void buildCircle(World world, int X, int Y, int Z, Block block, int radius) {
    	int x = radius;
    	int z = 0;
    	int radiusError = 1-x;
     
    	while(x >= z) {
    		world.setBlock( x + X, Y, z + Z, block);
	        world.setBlock( z + X, Y, x + Z, block);
	        world.setBlock(-x + X, Y, z + Z, block);
	        world.setBlock(-z + X, Y, x + Z, block);
	        world.setBlock(-x + X, Y,-z + Z, block);
	        world.setBlock(-z + X, Y,-x + Z, block);
	        world.setBlock( x + X, Y,-z + Z, block);
	        world.setBlock( z + X, Y,-x + Z, block);
	        z++;
	        
	        if (radiusError<0) {
	        	radiusError += 2 * z + 1;
	        } else {
		        x--;
		        radiusError += 2 * (z - x) + 1;
	        }
    	}
    }

    /**
     * Builds a sphere from the center of the coordinates. (Modified code from sk89q's WorldEdit)
     * @param world World object.
     * @param x0 Center x position.
     * @param y0 Center y position.
     * @param z0 Center z position.
     * @param block Block to build with.
     * @param radius Radius of the sphere.
     * @param filled If false, only the exterior will be generated.
     */
    public static void buildSphere(World world, int x0, int y0, int z0, Block block, double radius, boolean filled) {
    	buildSphere(world, x0, y0, z0, block, radius, radius, radius, filled);
    }

    /**
     * Builds a sphere/ellipsoid from the center of the coordinates. (Modified code from sk89q's WorldEdit)
     * @param world World object.
     * @param x0 Center x position.
     * @param y0 Center y position.
     * @param z0 Center z position.
     * @param block Block to build with.
     * @param radiusX Radius of the sphere from the x axis.
     * @param radiusY Radius of the sphere from the y axis.
     * @param radiusZ Radius of the sphere from the z axis.
     * @param filled If false, only the exterior will be generated.
     */
    public static void buildSphere(World world, int x0, int y0, int z0, Block block, double radiusX, double radiusY, double radiusZ, boolean filled) {
    	radiusX += 0.5;
        radiusY += 0.5;
        radiusZ += 0.5;

        final double invRadiusX = 1 / radiusX;
        final double invRadiusY = 1 / radiusY;
        final double invRadiusZ = 1 / radiusZ;

        final int ceilRadiusX = (int) Math.ceil(radiusX);
        final int ceilRadiusY = (int) Math.ceil(radiusY);
        final int ceilRadiusZ = (int) Math.ceil(radiusZ);

        double nextXn = 0;
        forX: for (int x = 0; x <= ceilRadiusX; ++x) {
            final double xn = nextXn;
            nextXn = (x + 1) * invRadiusX;
            double nextYn = 0;
            forY: for (int y = 0; y <= ceilRadiusY; ++y) {
                final double yn = nextYn;
                nextYn = (y + 1) * invRadiusY;
                double nextZn = 0;
                forZ: for (int z = 0; z <= ceilRadiusZ; ++z) {
                    final double zn = nextZn;
                    nextZn = (z + 1) * invRadiusZ;

                    double distanceSq = lengthSq(xn, yn, zn);
                    if (distanceSq > 1) {
                        if (z == 0) {
                            if (y == 0) {
                                break forX;
                            }
                            break forY;
                        }
                        break forZ;
                    }

                    if (!filled) {
                        if (lengthSq(nextXn, yn, zn) <= 1 && lengthSq(xn, nextYn, zn) <= 1 && lengthSq(xn, yn, nextZn) <= 1) {
                            continue;
                        }
                    }

                    world.setBlock( x+x0,  y+y0,  z+z0, block);
                    world.setBlock(-x+x0,  y+y0,  z+z0, block);
                    world.setBlock( x+x0, -y+y0,  z+z0, block);
                    world.setBlock( x+x0,  y+y0, -z+z0, block);
                    world.setBlock(-x+x0, -y+y0,  z+z0, block);
                    world.setBlock( x+x0, -y+y0, -z+z0, block);
                    world.setBlock(-x+x0,  y+y0, -z+z0, block);
                    world.setBlock(-x+x0, -y+y0, -z+z0, block);
                }
            }
        }
    }
    
    private static double lengthSq(double x, double y, double z) {
        return (x * x) + (y * y) + (z * z);
    }
}