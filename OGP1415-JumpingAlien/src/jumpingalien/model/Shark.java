package jumpingalien.model;

import jumpingalien.util.Sprite;

public class Shark {
	

	/**
	 * Creates a new shark, located at the provided pixel location (x, y).
	 * The returned shark should not belong to a world.
	 * 
	 * @param x
	 *            The x-coordinate of the shark's initial position
	 * @param y
	 *            The y-coordinate of the shark's initial position
	 * @param sprites
	 *            An array of sprites for the new shark
	 */
	public Shark(int x, int y, Sprite[] sprites) {
		this.setX(x);
		this.setY(y);
		this.setSprites(sprites);
	}
	
	private int x;
	private int y;
	private Sprite[] sprites;
	
	/**
	 * the initial amount of hitpoints a shark possesses
	 */
	private static int INITHITPOINTS = 100;
	/**
	 * the horizontal acceleration of a shark
	 */
	private double xAcc = 1.5;
	/**
	 * the maximum horizontal speed a slime can reach
	 */
	private static double MAXXSPEED = 4;
	/**
	 * the vertical speed at which the shark moves when 
	 * startJump() is initiated
	 */
	private static int JUMP_SPEED = 2;
	/**
	 * the minimal duration of a movement period (1s)
	 */
	private static int MINMOVEMENTDURATION = 1;
	/**
	 * the maximal duration of a movement period (4s)
	 */
	private static int MAXMOVEMENTDURATION = 4;
	/**
	 * the amount of hitpoints a shark loses when touching 
	 * a mazub or a slime
	 */
	private int CONTACTDAMAGE = 50;
	
// GETTERS
	
	private static int getINITHITPOINTS() {
		return INITHITPOINTS;
	}
	private double getXAcc() {
		return xAcc;
	}
	private static double getMAXXSPEED() {
		return  MAXXSPEED;
	}
	private static int getMaxMovementDuration() {
		return MAXMOVEMENTDURATION;
	}
	private static int getMinMovementDuration() {
		return MINMOVEMENTDURATION;
	}
	/**
	 * @return the x
	 */
	private int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	private int getY() {
		return y;
	}

	/**
	 * @return the sprites
	 */
	private Sprite[] getSprites() {
		return sprites;
	}
	
	/**
	 * Returns the current location of the given shark.
	 * 
	 * @return An array, consisting of 2 integers {x, y}, that represents the
	 *         coordinates of the given shark's bottom left pixel in the world.
	 */
	public int[] getLocation(){
		return new int[]{this.getX(),this.getY()};
	}
	
	
//	SETTERS
	/**
	 * @param x the x to set
	 */
	private void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y the y to set
	 */
	private void setY(int y) {
		this.y = y;
	}
	
	/**
	 * @param sprites the sprites to set
	 */
	private void setSprites(Sprite[] sprites) {
		this.sprites = sprites;
	}

	private int HITPOINTS = 1;
	
	
	/**
	 * starts the action period for an object
	 */
	public void start<action> {
		
	}
	
	/**
	 * ends the action period for an object
	 */
	public void stop<action> {
		
	}
	
	private void advanceTime() {		
		
	}
	
	/**
	 * Return the current sprite image for the given shark.
	 * 
	 * @return The current sprite image for the given shark, determined by its
	 *         orientation as defined in the assignment.
	 */
	public Sprite getCurrentSprite(){
		
	}

}
