package jumpingalien.model.exceptions;
/**
 * 
 * A class to check for an illegal initSartSpeed or maxSpeed 
 * 
 * @version 1.0
 * @author Pieter Van den Berghe, Ward Romanus 
 *
 */
@SuppressWarnings("serial")
public class IllegalSpeedException extends Exception {
	
	/**
	 * the initial speed of mazub when he starts moving horizontally
	 */	
	private final int initStartSpeed;
	/**
	 * the maximum speed mazub can reach when he's moving horizontally
	 */
	private final int maxSpeed;

	/**
	 * initialize this new illegal speed exception with a given
	 * initial speed and maximum speed
	 * @param	initStartSpeed
	 * 			the initial speed of mazub
	 * @param maxSpeed
	 * 			the maximum speed mazub can reach (when moving
	 * 			horizontally)
	 * @post	the value of the new illegal speed exception is equal to 
	 * 			the given initStartSpeed and maxSpeed
	 * 			| new.getInitStartSpeed = initStartSpeed
	 * 			| new.getMaxSpeed = maxSpeed
	 */
	public IllegalSpeedException(int initStartSpeed, int maxSpeed) {
		this.initStartSpeed = initStartSpeed;
		this.maxSpeed = maxSpeed;
	}
	
	public double getinitStartSpeed() {
		return initStartSpeed;
	}
	public double getMaxSpeed() {
		return maxSpeed;
	}
}
