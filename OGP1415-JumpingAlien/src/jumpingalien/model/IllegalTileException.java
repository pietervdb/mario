package jumpingalien.model;
/**
 * 
 * A class to check for an when the given tiles and tiletype are valid * 
 * 
 * @version 1.0
 * @author Pieter Van den Berghe, Ward Romanus
 * 
 *
 */
@SuppressWarnings("serial")
public class IllegalTileException extends Exception {
	
	/**
	 * Variable registering the x-tile evolved in this illegal 
	 * tile exception.
	 */
	private final int tileX;
	/**
	 * Variable registering the y-tile evolved in this illegal 
	 * tile exception.
	 */
	private final int tileY;
	/**
	 * the geological feature of the tile
	 */
	private final int tileType;

	/**
	 * initialize this new illegal tile exception with a given pixel
	 * @param	tileX
	 * 			the x tile
	 * @param 	tileY
	 * 			the y tile
	 * @post	the value of the new illegal tile exception is equal to 
	 * 			the given positions and the tileType
	 * 			| new.getPixelX() = pixelX
	 * 			| new.getPixelY() = pixelY
	 * 			| new.getTileType() = tileType
	 */
	public IllegalTileException(int tileX, int tileY, int tileType) {
		this.tileX = tileX;
		this.tileY = tileY;
		this.tileType = tileType;
	}
	
	public int getTileX() {
		return tileX;
	}
	public int getTileY() {
		return tileY;
	}
	public int getTileType() {
		return tileType;
	}

}
