package jumpingalien.model;

import java.util.ArrayList;
import java.util.List;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Immutable;
import be.kuleuven.cs.som.annotate.Raw;
import jumpingalien.util.Sprite;

public class Slime extends GameObject {
	
	/**
	 * Creates a new slime, located at the provided pixel location (x, y).
	 * The returned slime should not belong to a world.
	 * 
	 * @param x
	 * 			The x-coordinate of the slime's initial position
	 * @param y
	 * 			The y-coordinate of the slime's initial position
	 * @param sprites
	 * 			An array of sprites for the new slime
	 * @param school
	 *			The initial school to which the new slime belongs
	 * @effect the Slime is created at the given position with the given sprites
	 * 			| super(xPos, yPos, sprites)
	 * @effect the slime is added to a School school
	 * 			| setSchool(school)
	 * 			| school.newSlime(this)
	 * @effect the Slime gets it's default amount of hitpoints
	 * 			| setHitpoints(getInitHitpoints())
	 * @effect the maximum speed gets initialized
	 * 			| setMaxSpeed(Slime.getMaxXSpeed())
	 * @throws	IllegalPositionException
	 * 			The given position is not valid for the slime
	 * 			| ! isValidPosition(x_pos,y_pos)
	 * @throws IllegalSpriteException
	 * 			The given sprite is not valid
	 * 			| ! isValidSprite(sprites) 
	 */
	public Slime(int xPos,int yPos, Sprite[] sprites,School school) 
			throws IllegalPositionException, IllegalSpriteException {
		super(xPos, yPos, sprites);
		this.setSchool(school);
		this.getSchool().newSlime(this);
		this.setHitpoints(Slime.getInitHitpoints());
		this.setMaxSpeed(Slime.getMaxXSpeed());
	}
	
	
	/**
	 * the amount of hitpoints a slime loses when drowning (per 0.2 seconds)
	 */
	private static final int LOSS_HITPOINTS_IN_WATER = 6;
	/**
	 * returns the int that gives the amount of hitpoints a slime loses when 
	 * drowning in water
	 * @return the amount of hitpoints to lose er 0.2 seconds
	 * 			| LOSS_HITPOINTS_IN_WATER
	 */
	@Basic @Immutable 
	private static final int getLossHitpointsInWater() {
		return LOSS_HITPOINTS_IN_WATER;
	}	
	/**
	 * a double counting the duration of a movement period
	 */
	private double movementDuration = 0;
	/**
	 * returns the double giving the duration of a movement period
	 * @return the movement duration
	 * 			| movementDuration
	 */
	@Basic
	private double getMovementDuration() {
		return movementDuration;
	}	
	/**
	 * Sets movementDuration to a new value
	 * @param time
	 * 			the new value for movementDuration
	 * @pre  time should always be bigger than or equal to zero
	 * 			| time >= 0
	 * @post the value of movementDuration is set to the given value
	 * 			| this.movementDuration = time
	 */
	private void setMovementDuration(double time) {
		assert time >= 0;
		this.movementDuration = time;
	}
	/**
	 * a double indicating the passed time since the Slime has moved
	 */
	private double timeSinceMove = 0;
	/**
	 * returns the time passed since the last movement
	 * @return timeSinceMove
	 */
	@Basic
	private double getTimeSinceMove() {
		return timeSinceMove;
	}
	/**
	 * Sets timeSinceEndMove to the given value
	 * @param timeSinceMove the timeSinceMove to set
	 * @pre  time should always be bigger than or equal to zero
	 * 		| time >= 0
	 * @post this.movementDuration = time
	 */
	private void setTimeSinceMove(double time) {
		assert time >= 0;
		this.timeSinceMove = time;
	}
	/**
	 * the amount of hitpoints a Slime possesses when initialized
	 */
	private static final int INIT_HITPOINTS = 100;
	/**
	 * returns the amount of hitpoints a Slime possesses when initialized
	 * @return the amount of initial hitpoints
	 * 			| INIT_HITPOINTS
	 */
	@Basic @Immutable 
	private static final int getInitHitpoints() {
		return INIT_HITPOINTS;
	}
	/**
	 * the horizontal acceleration of a slime
	 */
	private static final double xAcc = 0.7;
	/**
	 * returns the horizontal acceleration of a Slime
	 */
	@Override @Basic @Immutable 
	public final double getXAcc() {
		return xAcc;
	}
	/**
	 * the maximum horizontal speed a slime can reach
	 */
	private static final double MAX_X_SPEED = 2.5;
	/**
	 * returns the maximum horizontal speed a Slime may reach
	 * @return the max speed
	 * 			| MAX_X_SPEED	
	 */
	@Basic @Immutable 
	private static final double getMaxXSpeed() {
		return  MAX_X_SPEED;
	}	
	/**
	 * the amount of hitpoints a slime loses when touching 
	 * a Shark or mazub.
	 */
	private static final int CONTACT_DAMAGE = 50;
	/**
	 * returns the lost hitpoints when colliding with a Mazub of Shark
	 * @return the hitpoints upon making contact
	 * 			| CONTACT_HITPOINTS
	 */
	@Basic @Immutable 
	public static final int getContactDamage() {
		return CONTACT_DAMAGE;
	}
	/**
	 * the damage every slime in the school looses when a single
	 * slime looses some hitpoints
	 */
	private static final int SCHOOL_DAMAGE = 1;
	/**
	 * returns the hitpoints to lose wxhen a Slime in a school loses hitpoints
	 * @return the hitpoints to lose
	 * 			| SCHOOL_DAMAGE
	 */
	@Basic @Immutable 
	public static final int getSchoolDamage() {
		return SCHOOL_DAMAGE;
	}
	/**
	 * the maximum amount of slime schools in a game world
	 */
	private static final int MAX_AMOUNT_OF_SCHOOLS = 10;
	/**
	 * returns the maximal amount of schools that may exist
	 * @return the maximal amount of schools
	 * 			| MAX_AMOUNT_OF_SCHOOLS
	 */
	@Basic @Immutable 
	private static final int getMaxAmountOfSchools() {
		return MAX_AMOUNT_OF_SCHOOLS;
	}
	/**
	 * the School school of this Slime
	 */
	private School school;
	/**
	 * Returns the current school to which the given slime belongs.
	 * 
	 * @param slime
	 *            The slime for which to retrieve the school.
	 * 
	 * @return The current school of the given slime.
	 * 			| this.school
	 */
	@Basic
	public School getSchool() {
		return this.school;
	}
	/**
	 * sets the School of this Slime to school
	 * @param school
	 * 			the new value for the School school
	 * @post the School is equal to the given School school
	 * 			| this.school = school
	 */
	public void setSchool(School school) {
		this.school = school;
	}
	/**
	 * the maximal amount of hitpoints a Slime may posses
	 */
	private static final int MAX_HITPOINTS = 500;
	@Override
	/**
	 * the maximum amount of hitpoints
	 * @return the max amount of hitpoints
	 * 			| MAXHITPOINTS
	 */
	@Basic @Immutable 
	protected final int getMaxHitpoints() {
		return MAX_HITPOINTS;
	}
	
	
//	VALIDATIONS
	
	/**
	 * returns true if the Sprite sprites is valid
	 * @return the length of sprites is 2
	 * 			| sprites.length == 2
	 */
	@Override
	protected boolean isValidSprite(Sprite[] sprites) {
		return sprites.length == 2;
	}
	
	/**
	 * checks the surroundings of the Slime and adapts the movement if needed
	 * @param newXPos
	 * 			the new horizontal position
	 * @param newYPos
	 * 			the new vertical position
	 * @effect if the Slime collides with a wall, it stops moving if not falling and the horizontal position is adapted
	 * 			| if (getOrientation() == Orientation.LEFT && againstLeftWall(newXPos, newYPos))
	 * 			| 	then newXPos = getTilesLeft(newXPos, newYPos)[0][0] * world.geTileLength() - getSize()[0]
	 * 			| 		 stopMoving()
	 *			| if (getOrientation() == Orientation.RIGHT && againstRightWall(newXPos, newYPos))
	 * 			| 	then newXPos = getTilesRight(newXPos, newYPos)[0][0] * world.geTileLength() - getSize()[0]
	 * 			| 		 stopMoving()
	 * @effect if the Slime collides with a roof, the vertical speed drops to zero and the vertical position is adapted
	 * 			| if (isAgainstRoof(newXPos, newYPos))
	 * 			| 	then newYPos = getTilesAbove(newXPos, newYPos[0][1] * world.getTileLength() - getSize()[1] - 1
	 * 			| 		 stopMoving()
	 * @effect if the Slime collides with a floor when falling, the fall is ended and the vertical position is adapted
	 * 			| if (isFalling() && onFloor(newXPos, newYPos))
	 * 			| 	then newYPos = ((getTilesUnder(newXPos, newYPos)[0][1] + 1) * getWorld().getTileLength() - 1)
	 * 			| 		 endFall()
	 * @effect the Slime falls when not touching a floor and not falling
	 * 			| if (( ! isFalling()) && ( ! onFloor(newXPos, newYPos)))
	 * 			| 	then fall()
	 * @return {newXPos, newYPos}
	 */
	private double[] checkSurroundings(double newXPos, double newYPos) {

		if (this.getOrientation() == Orientation.LEFT && this.againstLeftWall(newXPos, newYPos)) {
			newXPos = (this.getTilesLeft(newXPos, newYPos)[0][0] + 1) * this.getWorld().getTileLength();
			this.stopMoving();
		}
		if (this.getOrientation() == Orientation.RIGHT && againstRightWall(newXPos,newYPos)) {
			newXPos = (this.getTilesRight(newXPos,newYPos)[0][0]) * this.getWorld().getTileLength() - this.getSize()[0];
			this.stopMoving();
		}
		if (this.isAgainstRoof(newXPos, newYPos)) {
			newYPos = (this.getTilesAbove(newXPos,newYPos)[0][1]) * this.getWorld().getTileLength() - this.getSize()[1] - 1;
			this.setYSpeed(0);
		}		
		if (this.isFalling() && this.onFloor(newXPos, newYPos)) {
			newYPos = ((this.getTilesUnder(newXPos, newYPos)[0][1] +1) * this.getWorld().getTileLength() -1);
			this.endFall();
		}		
		if (( ! this.isFalling()) && ( ! this.onFloor(newXPos, newYPos))) {
			fall();
		}
		
		return new double[] {newXPos, newYPos};
	}
	
	/**
	 * adapts the hitpoints of the Slime and a touched other GameObject other or changes the School
	 * when other is a Slime
	 * @param other
	 * 			the touched GameObject
	 * @param touched
	 * 			a boolean indicating if the slime touched other
	 * @param dt	
	 * 			a small time interval
	 * @effect if this Slime touched other and other isn't dying, both object's hitpoints are adjusted
	 * 			or the schools are adapted if other is a Slime
	 * 			| if ((touched == 1) && ( ! other.isDying()))
	 * 			| 	then if (other instanceof Slime) 
	 * 			| 			then if (this.getSchool().getLength() > ((Slime) other).getSchool().getLength()) 
	 * 			|					then school.addSlime((Slime) other);
	 * 			| 				 else if (this.getSchool().getLength() < ((Slime) other).getSchool().getLength()) 
	 * 			| 					then ((Slime) other).getSchool().addSlime(this)
	 * 			| 		 else 	
	 * 			| 			then this.contactDamage(dt)
	 * 			| 				 other.contactDamage(dt);
	 */
	private void adjustHitpoints(GameObject other, double touched, double dt) {
		if ((touched == 1) && ( ! other.isDying())) {
			if (other instanceof Slime) {
				if (this.getSchool().getLength() > ((Slime) other).getSchool().getLength()) {
					this.getSchool().addSlime((Slime) other);
				}
				else if (this.getSchool().getLength() < ((Slime) other).getSchool().getLength()) {
					((Slime) other).getSchool().addSlime(this);
				}
			}
			else   {
				this.contactDamage(dt);
				other.contactDamage(dt);
			}
		}	
	}
	
	/**
	 * 
	 * @param newXPos
	 * @param newYPos
	 * @param dt
	 * @return
	 */
	private double[] collidingSharksSlimesMazub(double newXPos, double newYPos, double dt) {
		List<GameObject> allSharksSlimesMazub =  new ArrayList<GameObject>(this.getWorld().getSharks());
		allSharksSlimesMazub.addAll(this.getWorld().getSlimes());
		allSharksSlimesMazub.add(this.getWorld().getAlien());	
		boolean onGameObject = false;
		double[] newPos = {newXPos, newYPos};
		for(GameObject other: allSharksSlimesMazub) {
			if(other != this) {
				double xDim1 = this.getXDim();
				double yDim1 = this.getYDim();
				double x2 = other.getXPos();
				double xDim2 = other.getXDim();
				double y2 = other.getYPos();
				double yDim2 = other.getYDim();
				newPos = collidesSomewhere(newPos[0], xDim1, newPos[1], yDim1, x2, xDim2, y2, yDim2);
				if (newPos[3] == 1) {
					onGameObject = true;
				}
				this.adjustHitpoints(other, newPos[2], dt);
			}
		}
		if (this.isFalling() && onGameObject) {
			this.endFall();
		}
		else if ( ! this.isFalling() && ( ! onGameObject) && ( ! this.onFloor(newPos[0],newPos[1]))) {
			fall();
		}
		return new double[] {newPos[0], newPos[1]};
	}
	
	private void loseHitpointsBecauseOfFeature(double dt, double newXPos, double newYPos) {
		if (this.isInContactWithFeature(newXPos,newYPos,3)) {
			this.setTimeInMagma(this.getTimeInMagma() + dt);
			if(this.getTimeInMagma() >= Slime.getBurnTime()) {
				this.loseHitpoints( (int) GameObject.getLossHitpointsInMagma());
				this.setTimeInMagma(this.getTimeInMagma() - dt);
			}
		}
		if (this.isInContactWithFeature(newXPos,newYPos,2)) {
			this.setTimeInWater(this.getTimeInWater() + dt);
			if(this.getTimeInWater() >= Slime.getDrownTime()) {
				this.loseHitpoints(Slime.getLossHitpointsInWater());
				this.setTimeInWater(this.getTimeInWater() - dt);
			}			
		}
		else {
			this.setTimeInWater(0);
		}
	}
	
	/**
	 * checks if this Slime is within the boundaries of the game world, if not
	 * the Slime is removed
	 * @param newXPos
	 * 			the new horizontal position of the Slime
	 * @param newYPos
	 * 			the new vertical position of the Slime
	 * @effect the Slime gets removed if not within the boundaries
	 * 			| if ( ! isWithinBoundaries(newXPos, newYPos))
	 * 			| 	then remove()
	 */
	private void checkIfWithinBoundaries(double newXPos, double newYPos) {
		if ( ! isWithinBoundaries(newXPos, newYPos)) {
			this.remove();
		}
	}
	
	private void advanceTimeWhileLiving(double dt) {
		this.randomMovement(dt);			
		double[] newCalculatedPos = this.calculateNewPos(dt);
		double newXPos = newCalculatedPos[0];
		double newYPos = newCalculatedPos[1];
		this.checkIfWithinBoundaries(newXPos, newYPos);
				
		double[] newPos = checkSurroundings(newXPos,newYPos);
		newPos = collidingSharksSlimesMazub(newPos[0],newPos[1], dt);
		this.setNewSpeed(dt);
		
		this.setXPos(newPos[0]);
		this.setYPos(newPos[1]);
		
		this.loseHitpointsBecauseOfFeature(dt, this.getXPos(), this.getYPos());			
		this.updateImmunity(dt);
		
		if (this.getHitpoints() <= 0) {
			this.die();
		}
	}
	
	private void advanceTimeWhileDeath(double dt) {
		setTimeSinceDeath(this.getTimeSinceDeath() + dt);
		if (this.getTimeSinceDeath() >= GameObject.getTimeUntilRemove()) {
			this.remove();
		}
	}
	
	/**
	 * advances the time with dt seconds
	 * @param dt
	 * 			a small time interval
	 * @throws IllegalDtException
	 * 			the given dt is not valid 
	 * 			| ! isValidDt(dt)	 
	 * @effect advances the time if the Slime is still alive or dying
	 * 			| if ( ! isDying())
	 * 			| 	then advanceTimeWhileLiving(dt)
	 * 			| else
	 * 			| 	then advanceTimeWhileDeath(dt)
	 */
	public void advanceTime(double dt) throws IllegalDtException {
		if ( ! isValidDt(dt))
			throw new IllegalDtException(dt);
		
		if ( ! this.isDying()) {
			this.advanceTimeWhileLiving(dt);
		}
		else {
			this.advanceTimeWhileDeath(dt);
		}		
	}
	
	/**
	 * Return the current sprite image for the given slime.
	 * 
	 * @return The current sprite image for the given slime, determined by its
	 *         orientation as defined in the assignment.
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
	
	public void remove() {
		this.getSchool().removeSlime(this);
		this.setSchool(null);
		this.getWorld().removeSlime(this);
		this.setWorld(null);		
	}
	
	private void randomMovement(double dt) {
		if(this.getTimeSinceMove() >= this.getMovementDuration()) {
			this.stopMove();
			this.setMovementDuration(Math.random() * 4 + 2);
			this.setTimeSinceMove(dt);
			if(Math.random()>=0.5) {
				this.startMoveRight();
			}
			else {
				this.startMoveLeft();
			}
		}
		else {
			this.setTimeSinceMove(this.getTimeSinceMove() + dt);
		}
	}	

	/**
	 * Mazub starts moving to the right
	 * @effect 	| 
	 */
	public void startMoveRight(){
		if(this.getOrientation() == Orientation.LEFT) {
			this.setXSpeed(0);
			this.setOrientationRight();
		}
	}
	
	/**
	 * Mazub starts moving to the left
	 * @effect 	|
	 */
	public void startMoveLeft(){
		this.setOrientationLeft();
	}	
	
	public void stopMove() {
		this.setXSpeed(0);
	}
	
	@Override
	public void loseHitpoints(int nb) {
		this.setHitpoints(this.getHitpoints() - nb);
		for (Slime other: this.getSchool().getMembers()) {
			if (other != this) {
				other.setHitpoints(other.getHitpoints() - 1);
			}
		}
	}
	
	
}
	
