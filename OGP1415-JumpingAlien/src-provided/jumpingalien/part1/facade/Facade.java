package jumpingalien.part1.facade;


import jumpingalien.model.Mazub;
import jumpingalien.util.Sprite;


public class Facade implements IFacade {

	
	public Mazub createMazub(int pixelLeftX, int pixelBottomY, Sprite[] sprites) {
		alien = Mazub(pixelLeftX,pixelBottomY,sprites);
		// zoiets ofzo?
	}

	
	public int[] getLocation(Mazub alien) {
		return alien.getLocation();
	}

	 
	public double[] getVelocity(Mazub alien) {
		return alien.getVelocity();
	}

	 
	public double[] getAcceleration(Mazub alien) {
		return alien.getAcceleration();
	}

	 
	public int[] getSize(Mazub alien) {
		return alien.getSize();
	}

	 
	public Sprite getCurrentSprite(Mazub alien) {
		return alien.getCurrentSprite();
	}

	 
	public void startJump(Mazub alien) {
		alien.startJump();
		
	}

	 
	public void endJump(Mazub alien) {
		alien.endJump();
	}

	 
	public void startMoveLeft(Mazub alien) {
		alien.startMoveLeft();
	}

	 
	public void endMoveLeft(Mazub alien) {
		alien.endMove();
	}

	 
	public void startMoveRight(Mazub alien) {
		alien.startMoveRight();
	}

	 
	public void endMoveRight(Mazub alien) {
		alien.endMove();		
	}

	 
	public void startDuck(Mazub alien) {
		alien.startDuck();
	}

	 
	public void endDuck(Mazub alien) {
		alien.endDuck();
	}

	 
	public void advanceTime(Mazub alien, double dt) {
		alien.advanceTime(dt);
	}

}
