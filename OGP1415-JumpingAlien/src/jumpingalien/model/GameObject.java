package jumpingalien.model;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Immutable;
import be.kuleuven.cs.som.annotate.Raw;
import jumpingalien.util.Sprite;

/**
 * 
 * @author Pieter Van den Berghe, Ward Romanus
 *
 */
public abstract class GameObject {
	
	/**
	 * Creates a new gameObject, located at the provided pixel location (x, y).
	 * The returned gameObject should not belong to a world.
	 * 
	 * @param x
	 *            The x-coordinate of the gameObject's initial position
	 * @param y
	 *            The y-coordinate of the gameObject's initial position
	 * @param sprites
	 *            An array of sprites for the new gameObject
	 * @effect the x and y position and the sprites are set
	 * 			| this.setXPos(xPos)
	 * 			| this.setYPos(yPos)
	 *			| this.setSprite(sprites)
	 * @throws	IllegalPositionException
	 * 			The given position is not valid for the gameObject
	 * 			| !isValidPosition(x_pos,y_pos)
	 * @throws IllegalSpriteException
	 * 			The given sprite is not valid
	 * 			| !isValidSprite(sprites)  	
	 */
	@Raw
	protected GameObject(int xPos,int yPos, Sprite[] sprites ) 
			throws IllegalPositionException, IllegalSpriteException {
				if(!isValidPosition(xPos,yPos))
					throw new IllegalPositionException(xPos,yPos); 
				if (!isValidSprite(sprites))
					throw new IllegalSpriteException(sprites);
		this.setXPos(xPos);
		this.setYPos(yPos);
		this.setSprite(sprites);
	}
		
	
	/**
	 * the horizontal position of the object
	 */
	private double xPos = 0;
	/**
	 * Returns the horizontal position
	 * @return xPos
	 */
	@Basic @Raw 
	protected double getXPos() {
		return xPos;
	}	
	/**
	 * Sets the horizontal position of the game object to the rounded down value of x
	 * @param x
	 * 			The new value for the horizontal position
	 * @pre the position x should  be bigger than or equal to zero and 
	 * 		smaller than the boundary of the world
	 * 		| x >= 0
	 * 		| x <= this.getWorld().getX()
	 * @post the position is set
	 * 		| this.xPos = x
	 */
	@Raw 
	protected void setXPos(double x) {
		assert x >= 0;
		assert x <= this.getWorld().getX();
		this.xPos = x;
	}	
	/**
	 * the vertical position of the object
	 */
	private double yPos = 0;
	/**
	 * Returns the vertical position
	 * @return yPos
	 */
	@Basic @Raw 
	public double getYPos() {
		return yPos;
	}		
	/**
	 * Sets the vertical position of the game object to the rounded down value of y
	 * @param y
	 * 			The new value for the vertical position
	 * @pre the position y should  be bigger than or equal to zero and 
	 * 		smaller than the boundary of the world
	 * 		| y >= 0
	 * 		| y <= this.getWorld().getY()
	 * @post the position is set
	 * 		| this.yPos = y
	 */	
	@Raw 
	public void setYPos(double y) {
		assert y >= 0;
		assert y <= this.getWorld().getY();
		this.yPos = y;
	}	
	/**
	 * the orientation of the object
	 */
	private Orientation orientation  = Orientation.RIGHT;	
	/**
	 * Returns the orientation of the object
	 * @return orientation
	 */
	@Basic @Raw 
	public Orientation getOrientation() {
		return orientation;
	}
	/**
	 * Sets the orientation to right
	 * @post the orientation is right
	 * 		| this.orientation = Orientation.RIGHT
	 */
	@Raw 
	protected void setOrientationRight() {
		this.orientation = Orientation.RIGHT;
	}
	/**
	 * Sets the orientation to left
	 *@post the orientation is left
	 * 		| this.orientation = Orientation.LEFT
	 */
	@Raw 
	protected void setOrientationLeft() {
		this.orientation = Orientation.LEFT;
	}
	/**
	 * the sprites of an object
	 */
	protected Sprite[] sprites;
	/**
	 * Returns the sprites of the object
	 * @return sprites
	 */
	@Basic @Raw
	protected Sprite[] getSprite() {
		return sprites;
	}
	/**
	 * Sets the sprites to a new set of sprites
	 * @param sprites 
	 * 			the sprites to set
	 * @pre the sprites should be valid
	 * 		| this.isValidSprite(sprites)
	 * @post the sprites are set
	 */
	private void setSprite(Sprite[] sprites) {
		assert this.isValidSprite(sprites);
		this.sprites = sprites;
	}	
	/**
	 * the world where the object appears
	 */
	private World world;
	/**
	 * returns the world where the object appears
	 * @return world
	 */
	@Basic @Raw
	protected World getWorld() {
		return this.world;
	}
	/**
	 * Sets the world to the givan value world
	 * @param world
	 * 		the world to set
	 * @post world is set
	 * 		| this.world = world
	 */
	@Raw
	public void setWorld(World world) {
		this.world = world;
	}	
	/**
	 * the horizontal speed of the object
	 */
	protected double xSpeed;
	/**
	 * returns the horizontal speed
	 * @return xSpeed
	 */
	@Basic @Raw
	protected double getXSpeed() {
		return this.xSpeed;
	}
	/**
	 * Sets the horizontal speed to a new value speed
	 * @param speed
	 * 		the speed to set
	 * @pre the speed should be valid
	 * 		| this.isValidXSpeed(speed)
	 * @post the xSpeed is set
	 */
	@Raw
	protected void setXSpeed(double speed) {
		assert this.isValidXSpeed(speed);
		this.xSpeed = speed;
	}	
	/**
	 * the vertical speed of the object
	 */
	private double ySpeed;
	
	/**
	 * returns the vertical speed
	 * @return ySpeed
	 */
	@Basic @Raw
	public double getYSpeed() {
		return this.ySpeed;
	}
	/**
	 * Sets the vertical speed to a new value speed
	 * @param speed
	 * 		the speed to set
	 * @pre the speed should be valid
	 * 		| this.isValidYSpeed(speed)
	 * @post the ySpeed is set
	 */
	@Raw
	public void setYSpeed(double speed) {
		assert this.isValidYSpeed(speed);
		this.ySpeed = speed;
	}	
	/**
	 * the horizontal acceleration 
	 */
	private double xAcc;
	/**
	 * returns the horizontal acceleration
	 * @return xAcc
	 */
	@Basic @Raw
	public double getXAcc() {
		return xAcc;
	}
	/**
	 * Sets the horizontal acceleration to a new value
	 * @param xAcc
	 * 			the new value of the horizontal acceleration
	 * @pre xAcc should be a number and bigger than or equal to zero
	 * 			| ( ! Double.isNaN(xAcc))
	 * 			|  (xAcc >= 0)
	 * @post xAcc is set
	 */
	@Raw 
	public void setXAcc(double xAcc) {
		assert ( ! Double.isNaN(xAcc));
		assert (xAcc >= 0);	
		this.xAcc = xAcc;
	}
	/**
	 * the vertical acceleration 
	 */
	private double yAcc;
	/**
	 *  Returns the vertical acceleration 
	 * @return the vertical acceleration
	 * 			| yAcc
	 */
	@Basic @Raw 
	protected double getYAcc() {
		return yAcc;
	}
	/**
	 * Sets the vertical acceleration to a new value
	 * @param yAcc
	 * 			the new value of the vertical acceleration
	 * @pre yAcc should be a number
	 * 			| ( ! Double.isNaN(yAcc))
	 * @post yAcc is set
	 */
	@Raw 
	protected void setYAcc(double yAcc) {
		assert  ! Double.isNaN(yAcc);
		this.yAcc = yAcc;
	}	
	/**
	 * boolean to show or the object is dying or not
	 */
	private boolean dying = false;
	/**
	 * Returns or the object is dying
	 * @return dying
	 */
	@Basic @Raw
	protected boolean isDying() {
		return this.dying;
	}
	/**
	 * Sets the boolean dying to true and so the object dies
	 * @post dying is true
	 * 		| this.dying = true
	 */
	protected void setDying() {
		this.dying = true;
	}	
	/**
	 * Returns the current location of the object. With the positions both casted into
	 * integers (rounded down)
	 * 
	 * @return An array, consisting of 2 integers {x, y}, that represents the rounded
	 *         down coordinates of the bottom left pixel in the world.
	 *         | new int[]{(int) this.getXPos(), (int) this.getYPos()}
	 */
	@Basic @Raw
	public int[] getLocation(){
		return new int[]{(int) this.getXPos(), (int) this.getYPos()};
	}	
	/**
	 * a variable containing the amount of hitpoints an object possesses
	 */
	private int hitpoints;
	/**
	 * Returns the amount of hitpoints the gameObject has
	 * @return hitpoints
	 */ 
	@Basic @Raw
	public int getHitpoints() {
		return this.hitpoints;
	}
	/**
	 * Sets the hitpoints of an object to a new value
	 * @param number
	 * 			the value for hitpoints to set
	 * @pre number should be bigger than or equal to zero
	 * @post hitpoints is set to number if number is smaller than the maximum amount of
	 * 			hitpoints, otherwise hitpoints is set to the maximum amount of hitpoints
	 * 			the object can posses
	 * 			| if ( number < this.getMaxHitpoints()) 
	 * 			|	then this.hitpoints = number	
	 * 			|else 
	 * 			|	then this.hitpoints = this.getMaxHitpoints()
	 */
	@Raw
	public void setHitpoints(int number) {
		assert number >= 0;
		if ( number < this.getMaxHitpoints()) {
			this.hitpoints = number;
		}		
		else {
			this.hitpoints = this.getMaxHitpoints();
		}
	}
	/**
	 * the maximum amount of hitpoints an object can posses
	 */
	private int MAX_HITPOINTS = 100;
	/**
	 * the maximum amount of hitpoints
	 * @return MAXHITPOINTS
	 */
	@Basic @Immutable 
	protected int getMaxHitpoints() {
		return MAX_HITPOINTS;
	}
	/**
	 * the time since the object has died
	 */
	private double timeSinceDeath = 0;
	/**
	 * the time since the object has died
	 * @return timeSinceDeath
	 */
	@Basic @Raw
	public double getTimeSinceDeath() {
		return this.timeSinceDeath;
	}
	/**
	 * sets the timeSinceDeath to a new value
	 * @param t
	 * 		the time to set
	 * @pre the time t should be bigger than or equal to zero
	 * 		| t >= 0
	 * @post the time is set to t
	 */
	@Raw
	public void setTimeSinceDeath(double t) {
		assert t >= 0;
		this.timeSinceDeath = t;
	}	
	/**
	 * Returns the horizontal and vertical velocity
	 * @return the velocities
	 * 			| new double[] {this.getXSpeed(),this.getYSpeed()}
	 */
	@Basic @Raw 
	public double[] getVelocity(){
		return new double[] {this.getXSpeed(),this.getYSpeed()};
	}	
	/**
	 * Returns an array consisting of the horizontal and 
	 * 		vertical acceleration.
	 * @return an array consisting of the horizontal and 
	 * 		vertical acceleration.
	 * 			| new double[] {this.getXAcc(),this.getYAcc()}
	 */
	@Basic @Raw 
	public double[] getAcceleration(){
		return new double[] {this.getXAcc(),this.getYAcc()};
	}	
	/**
	 * Returns the horizontal dimension (width)
	 * @return the horizontal dimension (width)
	 * 			| this.getCurrentSprite().getWidth()
	 */
	@Basic @Raw 
	protected int getXDim() {
		return this.getCurrentSprite().getWidth();
	}
	/**
	 * Returns the vertical dimension (height)
	 * @return the vertical dimension (height)
	 * 			| this.getCurrentSprite().getHeight()
	 */
	@Basic @Raw 
	protected int getYDim() {
		return this.getCurrentSprite().getHeight();
	}	
	/**
	 * Returns an array consisting of the width and height
	 * @return an array consisting of the width and height
	 * 			| new int[] {this.getXDim(),this.getYDim()}
	 */
	@Basic @Raw 
	public int[] getSize() {
		return new int[] {this.getXDim(),this.getYDim()};
	}
	/**
	 * the maximum horizontal speed an object can have
	 */
	private double maxSpeed; 
	/**
	 * Returns the maximum speed
	 * @return the maximum speed
	 * 			| maxSpeed
	 */
	@Basic @Immutable @Raw
	protected double getMaxSpeed() {
		return maxSpeed;
	}
	/**
	 * Sets the maximum horizontal speed to a new value maxspeed
	 * @param speed
	 * 			the new maximum horizontal speed
	 * @pre the speed should be valid
	 * 			| this.isValidXSpeed(speed)
	 * @post the maxSpeed is set to speed
	 * 			| this.maxSpeed = speed
	 * 		
	 */
	@Raw
	protected void setMaxSpeed(double speed) {
		assert this.isValidXSpeed(speed);
		this.maxSpeed = speed;
	}
	/**
	 * the vertical acceleration at which a GameObject falls
	 */
	private static final double FALL_ACC = -10;
	/**
	 * Returns the acceleration when the GameObject falls
	 * @return FALL_ACC
	 */
	@Basic @Immutable @Raw 
	protected static final double getFallAcc() {
		return FALL_ACC;
	}
	/**
	 * The boolean to reflect or a gameObject is falling or not
	 */
	private boolean falling = false;
	/**
	 * checks or the object is falling or not
	 * @return falling
	 */
	@Basic @Raw
	protected boolean isFalling() {
		return falling;
	}
	/**
	 * Marks the boolean falling as true
	 * @post falling == true
	 */
	protected void setFalling() {
		this.falling = true;
	}	
	/**
	 * Marks the boolean falling as false
	 * @post falling == false
	 */
	protected void endFalling() {
		this.falling = false;
	}	
	/**
	 * Makes the object fall by setting the yAcc and falling
	 * @effect making the object fall
	 * 			| this.setYAcc(GameObject.getFallAcc())
	 * 			| this.setFalling()
	 */
	protected void fall() {
		this.setYAcc(GameObject.getFallAcc());
		this.setFalling();
	}	
	/**
	 * Ends the object's fall
	 * @effect	the acceleration and speed is set to 0 and endFalling is called
	 * 		|	this.setYAcc(0)
	 * 		|	this.setYSpeed(0)
	 * 		|	this.endFalling()
	 */
	protected void endFall() {
		this.setYAcc(0);
		this.setYSpeed(0);
		this.endFalling();		
	}	
	/**
	 * Boolean to reflect or the object is immune
	 */
	protected boolean immune = false;
	/**
	 * Returns whether the given object is currently immune against enemies
	 * 
	 * @return True if the given object is immune against other enemies (i.e.,
	 *         there are no interactions between the object and enemy objects).
	 */
	@Basic 
	protected boolean isImmune() {
		return this.immune;
	}
	/**
	 * Makes the object immune by setting immune to true
	 * @post immune is set to true
	 * 			| this.immune = true
	 */
	protected void setImmune() {
		this.immune = true;
	}
	/**
	 * Ends the object's immunity by setting immune to false
	 * @post immune is set to false
	 * 			| this.immune = false
	 */
	protected void setNotImmune() {
		this.immune = false;
	}
	/**
	 * the time since the abject started to be immune
	 */
	private double timeSinceImmune = 0;
	/**
	 * Returns the time since the object got immune
	 * @return timeSinceImmune
	 */
	@Basic @Raw
	protected double getTimeSinceImmune() {
		return this.timeSinceImmune;
	}
	/**
	 * Sets a new value to the timeSinceImmune
	 * @param t
	 * 			the new time to set
	 * @pre the time t should be bigger than or equal to zero
	 * 		 | t >= 0
	 * @post timeSinceImmune is set to t
	 * 		 | this.timeSinceImmune = t
	 */
	@Raw
	protected void setTimeSinceImmune(double t) {
		assert t >= 0;
		this.timeSinceImmune = t;
	}
	/**
	 * The time that an object stays immune
	 */
	protected static final double IMMUNE_TIME = 0.6;
	/**
	 * returns the time that an object stays immune
	 * @return IMMUNE_TIME
	 */
	@Basic @Immutable 
	protected static final double getImmuneTime() {
		return IMMUNE_TIME;
	}
	/**
	 * The amount of hitpoints an object loses by touching an enemy
	 */
	private static final int TOUCH_ENEMY = 50;
	/** 
	 * returns the amount of hitpoints an object loses by touching an enemy
	 * @return TOUCH_ENEMY
	 */
	@Basic @Immutable @Raw
	private static final int getTouchEnemy() {
		return TOUCH_ENEMY;
	}
	/**
	 * the time the object touches magma
	 */
	protected double timeInMagma = 0;
	/**
	 * returns the time the object is in magma
	 * @return timeInMagma
	 */
	@Basic @Raw
	protected double getTimeInMagma() {
		return this.timeInMagma;
	}
	/**
	 * Sets the timeInMagma to a new value t
	 * @param t
	 * 			the new time to set
	 * @pre the time t should be bigger than or equal to zero
	 * 		 | t >= 0
	 * @post timeInMagma is set to t
	 * 		 | this.timeInMagma = t
	 */
	@Raw
	protected void setTimeInMagma(double t) {
		assert t >= 0;
		this.timeInMagma = t;
	}	
	/**
	 * the time the object is in water
	 */
	protected double timeInWater = 0;
	/**
	 * returns the time the object is in water
	 * @return timeInWater
	 */
	@Basic @Raw
	protected double getTimeInWater() {
		return this.timeInWater;
	}
	/**
	 * Sets the timeInWater to a new value t
	 * @param t
	 * 			the new time to set
	 * @pre the time t should be bigger than or equal to zero
	 * 		 | t >= 0
	 * @post timeInWater is set to t
	 * 		 | this.timeInWater = t
	 */
	@Raw
	protected void setTimeInWater(double t) {
		assert t >= 0;
		this.timeInWater = t;
	}
	/**
	 * Time until the object starts drowning
	 */
	protected static final double DROWN_TIME = 0.2;
	/**
	 * returns the time until the object starts drowning
	 * @return DROWN_TIME
	 */
	@Basic @Immutable @Raw
	protected static final double getDrownTime() {
		return DROWN_TIME;
	}
	/**
	 * The amount of hitpoints an object loses when touching magma
	 */
	protected static final double LOSS_HITPOINTS_IN_MAGMA = 50;
	/**
	 * Returns the amount of hitpoints an object loses when touching magma
	 * @return LOSS_HITPOINTS_IN_MAGMA
	 */
	@Basic @Immutable 
	protected static final double getLossHitpointsInMagma() {
		return LOSS_HITPOINTS_IN_MAGMA;
	}
	/**
	 * The time after an object loses hitpoints again when touching magma
	 */
	protected static final double BURN_TIME = 0.2;
	/**
	 * returns the time after an object loses hitpoints again when touching magma
	 * @return BURN_TIME
	 */
	@Basic @Immutable 
	protected static final double getBurnTime() {
		return BURN_TIME;
	}
	/**
	 * The time until an object is removed after dying
	 */
	protected static final double TIME_UNTIL_REMOVE = 0.6;
	/**
	 * Returns the time until an object is removed after dying
	 * @return TIME_UNTIL_REMOVE
	 */
	@Basic @Immutable @Raw
	protected static final double getTimeUntilRemove() {
		return TIME_UNTIL_REMOVE;
	}
	/**
	 * when the game object is in touch with magma, it imediatly loses hitpoints,
	 * this variable counts the difference between the double value 
	 * of the hitpoints which are to lose and the int value
	 */
	protected double hitpointsDifference;
	/**
	 * Returns the difference between the amount of hitpoints lost when touching magma
	 * @return hitpointsDifference
	 */
	@Basic @Raw
	protected double getHitpointsDifference() {
		return hitpointsDifference;
	}
	/**
	 * sets the hitpointsDifference to a new value
	 * @param difference	
	 * 			the difference to set
	 * @pre	the difference should be a number between -1 and 1
	 * 			| !Double.isNaN(difference)
	 * 			| difference < 1 && difference > -1
	 * @post the difference is set
	 * 			| this.hitpointsDifference = difference
	 * 		
	 */
	@Raw
	protected void setHitpointsDifference(double difference) {
		assert !Double.isNaN(difference);
		assert difference < 1 && difference > -1;
		this.hitpointsDifference = difference;
	}
	
//	Validations
	
	/**
	 * Checks or the given sprites are valid
	 * @param sprites
	 * 			the sprites to check
	 * @return true if the number of sprites is even and sprites is not null
	 * 			otherwise false
	 * 			| (sprites.length % 2 == 0 && sprites != null)
	 * 			
	 */
	protected boolean isValidSprite(Sprite[] sprites) {
		return (sprites.length % 2 == 0 && sprites != null) ;
	}	
	/**
	 * Checks whether the current vertical speed is valid
	 * @param ySpeed
	 * 			the ySpeed to check
	 * @return True if the current vertical speed isn't equal to NaN 
	 * 			| ( ! Double.isNaN(ySpeed))
	 */
	protected boolean isValidYSpeed(double ySpeed) {
		return ( ! Double.isNaN(ySpeed));
	}
	/**
	 * 	Checks whether the given positions are valid positions
	 * @param x
	 * 			the horizontal position to check
	 * @param y
	 * 			the vertical position to check
	 * @return 	True if the horizontal position x and and the vertical 
	 * 			position y are bigger than or equal to zero
	 *			| ((x >= 0) && (y >= 0))
	 */
	public boolean isValidPosition(double x, double y) {
		return ((x >= 0) && (y >= 0));
	}	
	/**
	 * Checks if dt has a proper value between 0 and 0.2.
	 * @param dt
	 * 			the time interval to check
	 * @return True if dt is a value between 0 and 0.2 otherwise false.
	 * 		| (dt <= 0.2 && dt > 0)
	 */
	protected boolean isValidDt(double dt) {
		return ( dt <= 0.2 && dt > 0);
	}	
	/**
	 * Checks or the amount of hitpoints for an object is valid
	 * @param hitpoints
	 * 			the hitpoints to check
	 * @return true is between zero and the maximum amount of hitpoints
	 * 			| (hitpoints <= this.getMaxHitpoints() && hitpoints >= 0)
	 * 		
	 */
	protected boolean isValidAmountOfHitpoints(int hitpoints) {
		return (hitpoints <= this.getMaxHitpoints() && hitpoints >= 0);
	}	
	/**
	 * Checks whether the current horizontal speed is valid
	 * @param speed
	 * 			the horizontal speed to check
	 * @return True if the current horizontal speed is valid
	 * 			| ((speed() >= 0) && (speed() <= this.getMaxSpeed())
	 * 			| && ( ! Double.isNaN(speed)))
	 */
	protected boolean isValidXSpeed(double speed) {
		return ((speed >= 0) && (speed <= this.getMaxSpeed()) && ( ! Double.isNaN(speed)));
	}
	/**
	 * Checks or the object is within the horizontal boundaries of the world
	 * @param x	
	 * 			the horizontal position
	 * @return true if x is between zero and the width of the world
	 * 			| ((x >= 0) && (x <= this.getWorld().getX()))
	 */
	protected boolean isWithinBoundariesX(double x) {
		return ((x >= 0) && (x <= this.getWorld().getX()));
	}
	/**
	 * Checks or the object is within the vertical boundaries of the world
	 * @param y
	 * 			the vertical position
	 * @return true if y is between zero and the height of the world
	 * 			| (y >= 0) && (y <= this.getWorld().getY())
	 */
	protected boolean isWithinBoundariesY(double y) {
		return (y >= 0) && (y <= this.getWorld().getY());
	}
	/**
	 * Checks or an object is within the boundaries of the world
	 * @param x
	 * 			the horizontal position
	 * @param y
	 * 			the vertical position
	 * @return true if x and y are within their boundaries
	 * 			| isWithinBoundariesX(x) && isWithinBoundariesY(y)
	 */
	protected boolean isWithinBoundaries(double x, double y) {
		return isWithinBoundariesX(x) && isWithinBoundariesY(y);
	}	
	
	/**
	 * Makes the object die
	 * @pre the hitpoints of the object should be smaller than or equal to zero
	 * @effect the horiontal speed and acceleration are set to zero
	 * 			| this.setXSpeed(0)
	 * 			| this.setXAcc(0)
	 * @effect the object is set dying, waiting for his removal
	 * 			| this.setDying()
	 */
	@Raw
	protected void die() {
		assert this.getHitpoints() <= 0;
		this.setXSpeed(0);
		this.setXAcc(0);
		this.setDying();
	}	
	
	/**
	 * changes the orientation of the object
	 * @effect if the orientation is LEFT, orientation is set to RIGHT
	 * 			if the orientation if RIGHT, orientation is set to LEFT
	 * 			| if (this.getOrientation() == Orientation.LEFT) 
	 * 			| 	then setOrientationRight()
	 * 			| else 
	 * 			| 	then setOrientationLeft()
	 */
	protected void changeOrientation() {
		if (this.getOrientation() == Orientation.LEFT) {
			this.setOrientationRight();
		}
		else {
			this.setOrientationLeft();
		}
	}	
	
	/**
	 * calculates and returns the new horizontal and vertical position
	 * of the GameObject
	 * @param dt
	 * 			a small time interval
	 * @return the new horizontal en vertical position is calculated with given time interval
	 * 			and then they are both returned
	 * 			| let 
	 * 			| 	double newXPos
	 * 			| 	if (this.getOrientation() == Orientation.RIGHT)
	 * 			| 		then newXPos = this.getXPos() + this.getXSpeed() * 100 * dt
	 * 			|						+ 0.5 * this.getXAcc() * 100 * Math.pow(dt,2)
	 * 			| 	else 
	 * 			| 		then newXPos = this.getXPos() - this.getXSpeed() * 100 * dt
	 * 			| 						- 0.5 * this.getXAcc() * 100 * Math.pow(dt,2)
	 * 			| 	double newYPos = getYPos() + getYSpeed() * 100 * dt + 0.5 * 100 *
	 * 			| 						getYAcc() * Math.pow(dt,2)
	 * 			| in
	 * 			| 	return new double[] {newXPos, newYPos}
	 */
	@Raw
	protected double[] calculateNewPos(double dt) {		
		double newXPos;
		if (this.getOrientation() == Orientation.RIGHT) {
			newXPos = this.getXPos() + this.getXSpeed() * 100 * dt
					+ 0.5 * this.getXAcc() * 100 * Math.pow(dt,2);		
		}
		else {
			newXPos = this.getXPos() - this.getXSpeed() * 100 * dt
					- 0.5 * this.getXAcc() * 100 * Math.pow(dt,2);
		}
		double newYPos = this.getYPos() + this.getYSpeed() * 100 * dt + 0.5 * 100 *
				this.getYAcc() * Math.pow(dt,2);
		return new double[] {newXPos, newYPos};
	}
	
	/**
	 * Computes the dt for the object, small enough, so that the object does not move 
	 * more than one pixel at a time
	 * @param dt
	 * @return the minimum of the dt for the horizontal and vertical direction, 
	 * 			calculated for acceleration equal to zero or not
	 * 			| let 
	 * 			| 	double dtX;
	 * 			| 	double dtY;	
	 * 			|	 if (this.getXAcc() == 0) 
	 * 			| 		then dtX = 0.01 / Math.abs(this.getXSpeed())
	 * 			|	 else 
	 * 			|	 	then dtX = 0.01 / (Math.abs(this.getXSpeed()) + Math.abs(this.getXAcc()) * dt)
	 * 				| if (this.getYAcc() == 0) 
	 * 			|	 	then dtY = 0.01 / Math.abs(this.getYSpeed())
	 * 			|	 else 
	 * 			|	 	then dtY = 0.01 / (Math.abs(this.getYSpeed()) + Math.abs(this.getYAcc()) * dt)
	 * 			| in
	 * 			| 	return Math.min(dtX,dtY);
	 */
	@Raw
	protected double computeDt(double dt) {
		double dtX;
		double dtY;
		
		if (this.getXAcc() == 0) {
			dtX = 0.01 / Math.abs(this.getXSpeed());
		}
		else {
			dtX = 0.01 / (Math.abs(this.getXSpeed()) + Math.abs(this.getXAcc()) * dt);
		}
		
		if (this.getYAcc() == 0) {
			dtY = 0.01 / Math.abs(this.getYSpeed());
		}
		else {
			dtY = 0.01 / (Math.abs(this.getYSpeed()) + Math.abs(this.getYAcc()) * dt);
		}		
		return Math.min(dtX,dtY);
	}	
	
	/**
	 * Returns the tiles where the object overlaps left with
	 * @param XPos
	 * 		the horizontal position of the object
	 * @param YPos
	 * 		the vertical position of the object
	 * @return the pixelpositions of the left corners are used the find the tile positions so
	 *			the positions of the tiles where the object overlaps left with are returned
	 * 		| let
	 * 		| 	int pixelLeft = (int) XPos
	 * 		| 	int pixelTop = (int) YPos + this.getSize()[1]
	 * 		| 	int pixelBottom = (int) YPos
	 * 		| in the positions of the tiles where the object overlaps left with are returned
	 * 		| 	return getWorld().getTilePositionsIn(pixelLeft,pixelBottom + 2, pixelLeft, pixelTop - 1)
	 */
	@Raw
	protected int[][] getTilesLeft(double XPos, double YPos) {
		int pixelLeft = (int) XPos;
		int pixelTop = (int) YPos + this.getSize()[1];
		int pixelBottom = (int) YPos;

		return getWorld().getTilePositionsIn(pixelLeft,pixelBottom + 2, pixelLeft, pixelTop - 1);
	}
	/**
	 * Returns the tiles where the object overlaps right with
	 * @param XPos
	 * 		the horizontal position of the object
	 * @param YPos
	 * 		the vertical position of the object
	 * @return the pixelpositions of the right corners are used the find the tile positions so
	 *			the positions of the tiles where the object overlaps right with are returned
	 * 		| let	 
	 * 		| 	int pixelRight = (int) XPos + this.getSize()[0]
	 * 		|	int pixelTop = (int) YPos + this.getSize()[1]
	 * 		|	int pixelBottom = (int) YPos
	 * 		| in
	 * 		| 	return getWorld().getTilePositionsIn(pixelRight -1, pixelBottom + 2, pixelRight -1, pixelTop - 1)
	 */
	@Raw
	protected int[][] getTilesRight(double XPos, double YPos) {
		int pixelRight = (int) XPos + this.getSize()[0];
		int pixelTop = (int) YPos + this.getSize()[1];
		int pixelBottom = (int) YPos;
		return getWorld().getTilePositionsIn(pixelRight -1, pixelBottom + 2, pixelRight -1, pixelTop - 1);		
	}
	/**
	 * Returns the tiles where the object overlaps above with
	 * @param xPos
	 * 		the horizontal position of the object
	 * @param xPos
	 * 		the vertical position of the object
	 * @return the pixelpositions of the upper corners are used the find the tile positions so
	 *			the positions of the tiles where the object overlaps above with are returned
	 * 		| let	 
	 * 		| 	int pixelLeft = (int)(xPos)
	 * 		| 	int pixelTop = (int) yPos + this.getSize()[1]
	 * 		| 	int pixelRight = pixelLeft + this.getSize()[0]
	 * 		| in
	 * 		| 	return getWorld().getTilePositionsIn(pixelLeft,pixelTop, pixelRight-1, pixelTop)
	 */
	@Raw
	protected int[][] getTilesAbove(double xPos,double yPos) {
		int pixelLeft = (int)(xPos);
		int pixelTop = (int)(yPos) + this.getSize()[1];
		int pixelRight = pixelLeft + this.getSize()[0];
		return getWorld().getTilePositionsIn(pixelLeft,pixelTop, pixelRight-1, pixelTop);
	}
	/**
	 * Returns the tiles where the object overlaps under with
	 * @param xPos
	 * 		the horizontal position of the object
	 * @param xPos
	 * 		the vertical position of the object
	 * @return the pixelpositions of the under corners are used the find the tile positions so
	 *			the positions of the tiles where the object overlaps under with are returned
	 * 		| let	 
	 * 		| 	int pixelLeft = (int)(xPos)
	 * 		| 	int pixelBottom = (int) yPos 
	 * 		| 	int pixelRight = pixelLeft + this.getSize()[0]
	 * 		| in
	 * 		| 	return getWorld().getTilePositionsIn(pixelLeft,pixelBottom, pixelRight -1, pixelBottom)
	 */
	@Raw
	protected int[][] getTilesUnder(double xPos, double yPos) {
		int pixelLeft = (int)(xPos);
		int pixelBottom = (int)(yPos);
		int pixelRight = pixelLeft + this.getSize()[0];
		return getWorld().getTilePositionsIn(pixelLeft,pixelBottom, pixelRight -1, pixelBottom);
	}
	/**
	 * returns the tiles from the region of the object with a certain position
	 * @param xPos
	 * 		the horizontal position of the object
	 * @param xPos
	 * 		the vertical position of the object
	 * @return the position of the tiles in the region of the object
	 * 		| this.getWorld().getTilePositionsIn((int)xPos,(int) yPos,(int) xPos + this.getXDim(),(int) yPos + this.getYDim())
	 */
	@Raw
	protected int[][] getTiles(double xPos, double yPos) {
		return this.getWorld().getTilePositionsIn((int)xPos,(int) yPos,(int) xPos + this.getXDim(),(int) yPos + this.getYDim());
	}
	/**
	 * returns true if the gameObject is on a floor
	 * @param xPos
	 * 			the horizontal position
	 * @param yPos
	 * 			the vertical position
	 * @return true if on floor
	 * 			| let
	 * 			| 	int[][] tileUnder getTilesUnder(xPos, yPos)
	 * 			| in
	 * 			| for each int[] tile: tileUnder:
	 * 			| 	try
	 * 			|		if world.getGeologicalFeature(world.getBottomLeftPixelOfTile(tile[0], tile[1])[0],
	 * 			|			world.getBottomLeftPixelOfTile(tile[0],tile[1])[1]) == 1)
	 * 			| 		then return true
	 * 			|	catch (IllegalPixelException e)
	 * 			|		then assert false
	 * 			| return false
	 */
	@Raw
	protected boolean onFloor(double xPos, double yPos) {
		int[][] tilesUnder = this.getTilesUnder(xPos, yPos);
		for (int[] tile: tilesUnder) {
			try {
				if (this.getWorld().getGeologicalFeature(this.getWorld().getBottomLeftPixelOfTile(tile[0], tile[1])[0],
							this.getWorld().getBottomLeftPixelOfTile(tile[0],tile[1])[1]) == 1) {
					return true;
				}
			} catch (IllegalPixelException e) {
				assert false;
			}
		}
		return false;
	}
	/**
	 * Checks or the object is against the roof
	 * @param xPos
	 * 		the horizontal position of the object
	 * @param xPos
	 * 		the vertical position of the object
	 * @return true if one of the tiles overlapping above the object is impassable terrain
	 * 		otherwise false
	 * 		| let
	 * 		| 	int[][] tilesAbove = this.getTilesAbove(xPos, yPos)
	 * 		|in
	 * 		| 	for each tile in tilesAbove {
	 * 		| 		try {
	 * 		| 			if (getWorld().getGeologicalFeature(getWorld().getBottomLeftPixelOfTile(tile[0],tile[1])[0],
	 * 		| 						getWorld().getBottomLeftPixelOfTile(tile[0],tile[1])[1]) == 1) 
	 * 		| 				then return true
	 * 		| 		} catch (IllegalPixelException e) {
	 * 		| 			assert false;
	 * 		| 		}
	 * 		| 	}
	 * 		|	 return false
	 */
	@Raw
	protected boolean isAgainstRoof(double xPos, double yPos) {
		int[][] tilesAbove = this.getTilesAbove(xPos, yPos);
		for (int[] tile: tilesAbove) {
			try {
				if (getWorld().getGeologicalFeature(getWorld().getBottomLeftPixelOfTile(tile[0],tile[1])[0],
							getWorld().getBottomLeftPixelOfTile(tile[0],tile[1])[1]) == 1) {
					return true;
				}
			} catch (IllegalPixelException e) {
				assert false;
			}
		}
		return false;
	}
	//TODO in de volgende functies try/catch weghalen. Of mss moeten we dat maar gewoon zo laten. Wat denk jij?
	/**
	 * Checks or the object is against the left wall
	 * @param xPos
	 * 		the horizontal position of the object
	 * @param xPos
	 * 		the vertical position of the object
	 * @return true if one of the tiles overlapping left of the object is impassable terrain
	 * 		otherwise false
	 * 		| int[][] tilesLeft = this.getTilesLeft(xPos, yPos);
	 * 		| for each tile in tilesLeft
	 * 		| 	try {
	 * 		| 		if (getWorld().getGeologicalFeature(getWorld().getBottomLeftPixelOfTile(tile[0],tile[1])[0],
	 * 		| 					getWorld().getBottomLeftPixelOfTile(tile[0],tile[1])[1]) == 1)
	 * 		| 			then return true
	 * 		| 	} catch (IllegalPixelException e) {
	 * 		| 		assert false;
	 * 		| 	}
	 * 		| }
	 * 		| return false;
	 */
	@Raw
	protected boolean againstLeftWall(double xPos, double yPos) {
		int[][] tilesLeft = this.getTilesLeft(xPos, yPos);
		for (int[] tile: tilesLeft) {
			try {
				if (getWorld().getGeologicalFeature(getWorld().getBottomLeftPixelOfTile(tile[0],tile[1])[0],
							getWorld().getBottomLeftPixelOfTile(tile[0],tile[1])[1]) == 1) {
					return true;
				}
			} catch (IllegalPixelException e) {
				assert false;
			}
		}
		return false;
	}
	/**
	 * Checks or the object is against the right wall
	 * @param xPos
	 * 		the horizontal position of the object
	 * @param xPos
	 * 		the vertical position of the object
	 * @return true if one of the tiles overlapping right of the object is impassable terrain
	 * 		otherwise false
	 * 		| int[][] tilesLeft = this.getTilesRight(xPos, yPos);
	 * 		| for each tile in tilesRight:
	 * 		| 	try
	 * 		| 		if (getWorld().getGeologicalFeature(getWorld().getBottomLeftPixelOfTile(tile[0], tile[1])[0],
	 * 		| 					getWorld().getBottomLeftPixelOfTile(tile[0],tile[1])[1]) == 1) 
	 * 		| 			then return true
	 * 		| 	catch (IllegalPixelException e) 
	 * 		| 		then assert false
	 * 		| return false
	 */
	@Raw
	protected boolean againstRightWall(double xPos, double yPos) {
		int[][] tilesRight = this.getTilesRight(xPos, yPos);
		for (int[] tile: tilesRight) {
			try {
				if (getWorld().getGeologicalFeature(getWorld().getBottomLeftPixelOfTile(tile[0], tile[1])[0],
							getWorld().getBottomLeftPixelOfTile(tile[0],tile[1])[1]) == 1) {
					return true;
				}
			} catch (IllegalPixelException e) {
				assert false;
			}
		}
		return false;
	}
	/**
	 * Checks or the object is fully overlapping with tiles with the given feature
	 * @param xPos
	 * 		the horizontal position of the object
	 * @param xPos
	 * 		the vertical position of the object
	 * @param feature
	 * 		the number of the feature of the tiles where the object should fully overlap with
	 * @pre feature should be smaller than or equal to 3, because there are no feature with numbers
	 * 		higher than three
	 * 		| feature <= 3
	 * @return true if the object fully overlaps with tiles with the given feature, otherwise false
	 * 		| int[][][] tileFamilies = new int[][][] {this.getTilesRight(xPos,yPos),this.getTilesAbove(xPos, yPos),this.getTilesLeft(xPos, yPos)};
	 * 		| for (int[][] tiles: tileFamilies) 
	 * 		| 	for each tile in tiles:
	 * 		| 		try 
	 * 		| 			if (this.getWorld().getGeologicalFeature(getWorld().getBottomLeftPixelOfTile(tile[0],tile[1])[0],
	 * 		| 					getWorld().getBottomLeftPixelOfTile(tile[0],tile[1])[1]) != feature)
	 * 		| 				the return false
	 * 		| 		catch (IllegalPixelException e) 
	 * 		| 			assert false
	 * 		| return true
	 */
	@Raw
	protected boolean isFullyInFeature(double xPos, double yPos,int feature) {
		assert(feature <= 3);
		int[][][] tileFamilies = new int[][][] {this.getTilesRight(xPos,yPos),this.getTilesAbove(xPos, yPos),this.getTilesLeft(xPos, yPos)};
		for (int[][] tiles: tileFamilies) {	
			for (int[] tile: tiles) {
				try {
					if (this.getWorld().getGeologicalFeature(getWorld().getBottomLeftPixelOfTile(tile[0],tile[1])[0],
							getWorld().getBottomLeftPixelOfTile(tile[0],tile[1])[1]) != feature) {
						return false;
					}
				} catch (IllegalPixelException e) {
					assert false;
				}
			}
		}
		return true;
	}
	/**
	 * Checks or the object is in contact with a given feature
	 * @param xPos
	 * 		the vertical position of the object
	 * @param feature
	 * 		the number of the feature of the tiles where the object should fully overlap with
	 * @pre feature should be smaller than or equal to 3, because there are no feature with numbers
	 * 		higher than three
	 * 		| feature <= 3
	 * @return true if the object is in contact with tiles with the given feature, otherwise false
	 * 		| int[][] tiles = this.getTiles(xPos,yPos);
	 * 		| for each tile in tiles) {
	 * 		| 	try 
	 * 		| 		if (this.getWorld().getGeologicalFeature(getWorld().getBottomLeftPixelOfTile(tile[0],tile[1])[0],
	 * 		| 				getWorld().getBottomLeftPixelOfTile(tile[0],tile[1])[1]) == feature) 
	 * 		| 			then return true
	 * 		|  catch (IllegalPixelException e) 
	 * 		| 		assert false
	 * 		| return false;
	 */
	@Raw
	protected boolean isInContactWithFeature(double xPos, double yPos,int feature) {
		assert(feature <= 3);
		int[][] tiles = this.getTiles(xPos,yPos);
		for (int[] tile: tiles) {
			try {
				if (this.getWorld().getGeologicalFeature(getWorld().getBottomLeftPixelOfTile(tile[0],tile[1])[0],
						getWorld().getBottomLeftPixelOfTile(tile[0],tile[1])[1]) == feature) {
					return true;
				}
			} catch (IllegalPixelException e) {
				assert false;
			}
		}	
		return false;
	}	
	/**
	 * Return the current sprite image for the given object.
	 * @pre the given sprite must be valid
	 * 			| assert isValidSprite(getSprite())
	 * @return depending of the orientation (left or right) the current sprite image
	 * 			 for the given object defined in the assignment.
	 * 			| if (this.getOrientation() == Orientation.RIGHT) 
	 * 			| 	then return sprites[1]
	 * 			| else 
	 * 			| 	then return sprites[0]
	 */
	public Sprite getCurrentSprite(){
		assert isValidSprite(this.getSprite());
		if (this.getOrientation() == Orientation.RIGHT) {
			return sprites[1];
		}
		else {
			return sprites[0];
		}
	}
	/**
	 * Changes the speed of the given object with a given time interval dt
	 * @param dt
	 * 		time interval to calculate new speed
	 * @effect Calculating and setting the horizontal and vertical speed
	 * 		| this.setXSpeed(this.getXSpeed() + dt * this.getXAcc())
	 * 		| this.setYSpeed(this.getYSpeed() + dt * this.getYAcc())
	 * @effect setting the acceleration to zero and speed to the maximum speed if the
	 * 		new speed is higher than the maximum speed
	 * 		| if (this.getXSpeed() >= this.getMaxSpeed())
	 * 		| 	then this.setXSpeed(this.getMaxSpeed());
	 * 		| 	then this.setXAcc(0)
	 */
	@Raw
	protected void setNewSpeed(double dt) {
		this.setXSpeed(this.getXSpeed() + dt * this.getXAcc());
		this.setYSpeed(this.getYSpeed() + dt * this.getYAcc());
		
		if (this.getXSpeed() >= this.getMaxSpeed()){
			this.setXSpeed(this.getMaxSpeed());
			this.setXAcc(0);
		}
	}
	/**
	 * Checks or two objects with given positions and dimensions are thouching eachother
	 * @param x1
	 * 		the horizontal position of the first object
	 * @param xDim1
	 * 		the horizontal dimenesion of the first object
	 * @param y1
	 * 		the vertical position of the first object
	 * @param yDim1
	 * 		the vertical dimension of the first object
	 * @param x2
	 * 		the horizontal position of the second object
	 * @param xDim2
	 * 		the horizontal dimenesion of the second object
	 * @param y2
	 * 		the vertical position of the second object
	 * @param yDim2
	 * 		the vertical dimension of the second object
	 * @return True of one of the perimeters of the first object overlaps with a perimeter of the second object
	 * 		otherwise false
	 * 		| let 
	 * 		| 	boolean xStatement = ( (x2 >= x1) && (x2 <= x1 + xDim1) ) 
	 *		|			|| ( (x2 + xDim2 >= x1) && (x2 + xDim2 <= x1 + xDim1) )
	 * 		| 	boolean yStatement = ( (y2 >= y1) && (y2 <= y1 + yDim1) ) 
	 * 		| 			|| ( (y2 + yDim2 >= y1) && (y2 + yDim2 <= y1 + yDim1) )
	 * 		| in 
	 * 		| 	 return ((xStatement) && (yStatement))
	 */	
	@Raw
	protected boolean touches(double x1, double xDim1, double y1, double yDim1,
			double x2, double xDim2, double y2, double yDim2) {
		boolean xStatement = ( (x2 >= x1) && (x2 <= x1 + xDim1) ) 
				|| ( (x2 + xDim2 >= x1) && (x2 + xDim2 <= x1 + xDim1) );
		boolean yStatement = ( (y2 >= y1) && (y2 <= y1 + yDim1) ) 
				|| ( (y2 + yDim2 >= y1) && (y2 + yDim2 <= y1 + yDim1) );
		return ((xStatement) && (yStatement));
	}
	/**
	 * Checks if the first object collides with his right side with the a second object
	 * 			with given positions and dimensions
	 * @param x1
	 * 		the horizontal position of the first object
	 * @param xDim1
	 * 		the horizontal dimenesion of the first object
	 * @param y1
	 * 		the vertical position of the first object
	 * @param yDim1
	 * 		the vertical dimension of the first object
	 * @param x2
	 * 		the horizontal position of the second object
	 * @param xDim2
	 * 		the horizontal dimenesion of the second object
	 * @param y2
	 * 		the vertical position of the second object
	 * @param yDim2
	 * 		the vertical dimension of the second object
	 * @return True of the right perimeter of the first object overlaps with a perimeter of the second object
	 * 		otherwise false
	 * 		| let 
	 * 		| 	boolean xStatement = (x2 >= x1) && (x2 <= x1 + xDim1)
	 * 		| 	boolean yStatement = ( (y2 + 1 >= y1 + 1) && (y2 + 1 <= y1 + yDim1 - 1) ) 
	 *		|			|| ( (y2 + yDim2 - 1>= y1 + 1) && (y2 + yDim2 -1 <= y1 + yDim1 - 1) );
	 * 		| in 
	 * 		| 	 return ((xStatement) && (yStatement))
	 */
	@Raw
	protected boolean collidesRight(double x1, double xDim1, double y1, double yDim1,
									double x2, double xDim2, double y2, double yDim2) {
		boolean xStatement = (x2 >= x1) && (x2 <= x1 + xDim1);
		boolean yStatement = ( (y2 + 1 >= y1 + 1) && (y2 + 1 <= y1 + yDim1 - 1) ) 
				|| ( (y2 + yDim2 - 1>= y1 + 1) && (y2 + yDim2 -1 <= y1 + yDim1 - 1) );
		return ((xStatement) && (yStatement));
	}
	/**
	 * Checks if the first object collides with his left side with the a second object
	 * 			with given positions and dimensions
	 * @param x1
	 * 		the horizontal position of the first object
	 * @param xDim1
	 * 		the horizontal dimenesion of the first object
	 * @param y1
	 * 		the vertical position of the first object
	 * @param yDim1
	 * 		the vertical dimension of the first object
	 * @param x2
	 * 		the horizontal position of the second object
	 * @param xDim2
	 * 		the horizontal dimenesion of the second object
	 * @param y2
	 * 		the vertical position of the second object
	 * @param yDim2
	 * 		the vertical dimension of the second object
	 * @return True of the left perimeter of the first object overlaps with a perimeter of the second object
	 * 		otherwise false
	 * 		| let 
	 * 		| 	boolean xStatement = (x2 + xDim2 >= x1) && (x2 + xDim2 <= x1 + xDim1)
	 * 		| 	boolean yStatement = ( (y2 + 1 >= y1 + 1) && (y2 + 1 <= y1 + yDim1 - 1) ) 
	 *		|			|| ( (y2 + yDim2 - 1>= y1 + 1) && (y2 + yDim2 -1 <= y1 + yDim1 - 1) );
	 * 		| in 
	 * 		| 	 return ((xStatement) && (yStatement))
	 */
	@Raw
	protected boolean collidesLeft(double x1, double xDim1, double y1, double yDim1,
									double x2, double xDim2, double y2, double yDim2) {
		boolean xStatement = (x2 + xDim2 >= x1) && (x2 + xDim2 <= x1 + xDim1);
		boolean yStatement = ( (y2 + 1 >= y1 + 1) && (y2 + 1 <= y1 + yDim1 - 1) ) 
				|| ( (y2 + yDim2 - 1>= y1 + 1) && (y2 + yDim2 -1 <= y1 + yDim1 - 1) );
		return ((xStatement) && (yStatement));
	}
	/**
	 * Checks if the first object collides with his upper perimeter with the a second object
	 * 			with given positions and dimensions
	 * @param x1
	 * 		the horizontal position of the first object
	 * @param xDim1
	 * 		the horizontal dimenesion of the first object
	 * @param y1
	 * 		the vertical position of the first object
	 * @param yDim1
	 * 		the vertical dimension of the first object
	 * @param x2
	 * 		the horizontal position of the second object
	 * @param xDim2
	 * 		the horizontal dimenesion of the second object
	 * @param y2
	 * 		the vertical position of the second object
	 * @param yDim2
	 * 		the vertical dimension of the second object
	 * @return True of the upper perimeter of the first object overlaps with a perimeter of the second object
	 * 		otherwise false
	 * 		| let 
	 * 		| 	boolean xStatement = ( (x2  >= x1 ) && (x2 < x1 + xDim1) ) 
	 * 		| 			|| ( (x2 + xDim2 > x1) && (x2 + xDim2 <= x1 + xDim1) );
	 * 		| 	boolean yStatement =  (y2 >= y1) && (y2 <= y1 + yDim1 - 1);	 
	 * 		| in 
	 * 		| 	 return ((xStatement) && (yStatement))
	 */
	@Raw
	protected boolean collidesAbove(double x1, double xDim1, double y1, double yDim1,
									double x2, double xDim2, double y2, double yDim2) {
		boolean xStatement = ( (x2  >= x1 ) && (x2 < x1 + xDim1) ) 
				|| ( (x2 + xDim2 > x1) && (x2 + xDim2 <= x1 + xDim1) );
		boolean yStatement =  (y2 >= y1) && (y2 <= y1 + yDim1 - 1);			
		return ((xStatement) && (yStatement));
	}
	/**
	 * Checks if the first object collides with his under perimeter with the a second object
	 * 			with given positions and dimensions
	 * @param x1
	 * 		the horizontal position of the first object
	 * @param xDim1
	 * 		the horizontal dimenesion of the first object
	 * @param y1
	 * 		the vertical position of the first object
	 * @param yDim1
	 * 		the vertical dimension of the first object
	 * @param x2
	 * 		the horizontal position of the second object
	 * @param xDim2
	 * 		the horizontal dimenesion of the second object
	 * @param y2
	 * 		the vertical position of the second object
	 * @param yDim2
	 * 		the vertical dimension of the second object
	 * @return True of the under perimeter of the first object overlaps with a perimeter of the second object
	 * 		otherwise false
	 * 		| let 
	 * 		| 	boolean xStatement = ( (x2  >= x1 ) && (x2 < x1 + xDim1) ) 
	 * 		| 			|| ( (x2 + xDim2 > x1) && (x2 + xDim2 <= x1 + xDim1) )
	 * 		|		boolean yStatement = (y2 + yDim2 >= y1 + 1) && (y2 + yDim2 <= y1 + yDim1)
	 * 		| in 
	 * 		| 	 return ((xStatement) && (yStatement))
	 */
	@Raw
	protected boolean collidesUnder(double x1, double xDim1, double y1, double yDim1,
								double x2, double xDim2, double y2, double yDim2) {
		
		boolean xStatement = ( (x2  >= x1 ) && (x2 < x1 + xDim1) ) 
				|| ( (x2 + xDim2 > x1) && (x2 + xDim2 <= x1 + xDim1) );
		boolean yStatement = (y2 + yDim2 >= y1) && (y2 + yDim2 <= y1 + yDim1);
		
		return ((xStatement) && (yStatement));
	}	
	
	/**
	 * loses the given amount of hitpoints
	 * @param nb
	 * 			the number of hitpoints to lose
	 * @effect hitpoints is set to the new value
	 * 			| setHitpoints(getHitpoints() - nb)
	 */
	@Raw
	protected void loseHitpoints(int nb) {
		this.setHitpoints(this.getHitpoints() - nb);
	}
	
	/**
	 * when making contact with an enemy and not immune, immunity is set to true,
	 * hitpoints are deducted and the timeSinceImmunity is updated
	 * @param dt
	 * 			 a small time interval
	 * @effect if not immunt, immune is set to true, hitpoints are deducted and
	 * 			timeSinceImmune is updated
	 * 			| if ( ! this.isImmune())	
	 * 			| 	then setImmune()
	 * 			| 		 loseHitpoints(GameObject.getTouchEnemy())
	 * 			| 		 setTimeSinceImmune(dt)
	 */
	@Raw
	protected void contactDamage(double dt) {
		if ( ! this.isImmune()) {
			this.setImmune();
			this.loseHitpoints(GameObject.getTouchEnemy());
			this.setTimeSinceImmune(dt);
		}
	}
	
	/**
	 * updates the immunity of a game object
	 * @param dt
	 * 			 a small time interval
	 * @effect if immune, the time since immunity is updated and if this time is great enough
	 * 			the immunity is set to false
	 * 			| if (isImmune())
	 * 			|	then if (getTimeSinceImmune() > GameObject.getImmuneTime())
	 * 			| 			then setNotImmune()
	 * 			| 				 setTimeSinceImmune(0)
	 * 			| else 
	 * 			| 	then setTimeSinceImmune(getTimeSinceImmune() + dt)
	 */
	@Raw
	protected void updateImmunity(double dt) {
		if (this.isImmune()) {
			if (this.getTimeSinceImmune() > GameObject.getImmuneTime()) {
				this.setNotImmune();
				this.setTimeSinceImmune(0);				
			}
			else {
				this.setTimeSinceImmune(this.getTimeSinceImmune() + dt);
			}
		}
	}
	
	/**
	 * stops the horizontal movement
	 * @effect the horizontal acceleration and speed are set to zero
	 * 			| setXSpeed(0)
	 * 			| setXAcc(0)
	 */
	protected void stopMovingX() {
		this.setXSpeed(0);
		this.setXAcc(0);
	}
	
	/**
	 * stops the vertical speed if the game object isn't moving downwards
	 * @effect the vertical speed is set to zero if positive
	 * 			| if (getYSpeed() > 0)
	 * 			|	then setYSpeed(0)
	 */
	protected void stopMovingY() {
		if (this.getYSpeed() > 0) {
			this.setYSpeed(0);
		}
	}
	
	/**
	 * stops the movement in the x and y direction
	 * @effect stops moving horizontally and vertically if moving up
	 * 			| stopMovingX()
	 * 			| stopMovingY()
	 */
	protected void stopMoving() {
		this.stopMovingX();
		this.stopMovingY();
	}
	
	/**
	 * returns the new horizontal and vertical position, if the gameobjects touched and if on top of the 
	 * second game object
	 * @param newXPos
	 * 			the new horizontal position of the first game object
	 * @param xDim1
	 * 			the new horizontal dimension of the first game object
	 * @param newYPos
	 * 			the new vertical position of the first game object
	 * @param yDim1
	 * 			the new vertical dimension of the first game object
	 * @param x2
	 * 			the horizontal position of the second game object
	 * @param xDim2
	 * 			the horizontal dimension of the second game object
	 * @param y2
	 * 			the vertical position of the second game object
	 * @param yDim2
	 * 			the vertical dimension of the second game object
	 * @effect when colliding right, left, under or above, the position is adapted,
	 * 			the movement is adapted (stopped) and touched is set to 1 (indicating
	 * 			that the game objects touched)
	 * 			| let 
	 * 			|	int touched = 0
	 * 			|	int onGameObject = 0
	 * 			| in
	 * 			| if (collidesRight(newXPos, xDim1, newYPos, yDim1, x2, xDim2, y2, yDim2))
	 * 			| 	then newXPos = x2 - xDim1
	 * 			| 		 stopMoving()
	 * 			| 		 touched = 1
	 * 			| if (collidesLeft(newXPos, xDim1, newYPos, yDim1, x2, xDim2, y2, yDim2))
	 * 			| 	then newXPos = x2 + xDim2
	 * 			| 		 stopMoving()
	 * 			| 		 touched = 1
	 * 			| if (collidesAbove(newXPos,xDim1, newYPos, yDim1, x2, xDim2, y2, yDim2)) 
	 * 			|	then newYPos = y2 - yDim1 + 1
	 * 			| 		 setYSpeed(0)
	 * 			| 		 touched = 1
	 * 			| if  (collidesUnder(newXPos, xDim1, newYPos, yDim1, x2, xDim2, y2, yDim2))
	 * 			| 	then newYPos = y2 + yDim2 - 1 
	 * 			| 		 onGameObject = 1
	 * 			| 		 touched = 1
	 * @return {newXPos, newYPos, touched, onGameObject}
	 */
	@Raw
	public double [] collidesSomewhere(double newXPos, double xDim1, double newYPos, double yDim1, 
			double x2, double xDim2, double y2, double yDim2) {
		int touched = 0; // if 2 game objects touched each other, the value of touched will be 1
		int onGameObject = 0;
		if (this.collidesRight(newXPos, xDim1, newYPos, yDim1, x2, xDim2, y2, yDim2)) {
			newXPos = x2 - xDim1;
			this.stopMoving();
			touched = 1;
		}
		if (this.collidesLeft(newXPos, xDim1, newYPos, yDim1, x2, xDim2, y2, yDim2)) {
			newXPos = x2 + xDim2;
			this.stopMoving();
			touched = 1;
		}
		if (this.collidesAbove(newXPos,xDim1, newYPos, yDim1, x2, xDim2, y2, yDim2)) {
			newYPos = y2 - yDim1 + 1;
			this.setYSpeed(0);
			touched = 1;
		}
		if  (this.collidesUnder(newXPos, xDim1, newYPos, yDim1, x2, xDim2, y2, yDim2)) {
			newYPos = y2 + yDim2 - 1 ;
			onGameObject = 1;
			touched = 1;
		}	
		return new double[] {newXPos, newYPos, touched, onGameObject};
	}
	
}
