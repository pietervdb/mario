package jumpingalien.model;

public class IllegalTileSizeException {
	
	/**
	 * the size  of the tiles
	 */
	private final int tilesize;
	
	/**
	 * initialize this new illegal tilesize exception with a given tilesize
	 * @param tilesize
	 * @post the value of the illegal tilesize exception is equal to the 
	 * 			given tilesize
	 * 			| new. getTileSize = tilesize
	 */
	public IllegalTileSizeException(int tilesize) {
		this.tilesize = tilesize;
	}
	
	/**
	 * 
	 * @return tilesize
	 */
	public int getTileSize() {
		return tilesize;
	}
}
