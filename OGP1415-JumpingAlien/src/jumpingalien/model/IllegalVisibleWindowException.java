package jumpingalien.model;

public class IllegalVisibleWindowException {
	/**
	 * the (vertical) visible height of the screen;
	 */
	private final int visibleHeight;
	/**
	 * the (horizontal) visible width of the screen;
	 */
	private final int visibleWidth;
	/**
	 * initialize this new illegal visibleHeight exception with a given
	 * visible width 
	 * @param visibleHeight
	 * @post the value of the new illegal visible height exception is equal
	 * 			to the given visibleHeight
	 * 			| new.getVisibleHeight = visibleHeight
	 */
	public IllegalVisibleWindowException(int visibleHeight, int visibleWidth) {
		this.visibleHeight = visibleHeight;
		this.visibleWidth = visibleWidth;
	}
	
	/**
	 * the visible height of the screen
	 * @return visibleHeight
	 */
	public int getVisibleHeight() {
		return visibleHeight;
	}
	/**
	 * the visible width of the screen
	 * @return visibleWidth
	 */
	public int getVisibleWidth() {
		return visibleWidth;
	}
}
