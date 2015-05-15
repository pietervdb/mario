package jumpingalien.model;

import jumpingalien.model.exceptions.IllegalPixelException;

public class Tile extends SuperObject {

	public Tile(int xCor, int yCor, World world) {
		this.setXCor(xCor);
		this.setYCor(yCor);
		this.setWorld(world);
	}
	
	private int xCor;
	private int yCor;
	
	private void setXCor(int xPos) {
		this.xCor = xPos;		
	}
	private void setYCor(int yPos) {
		this.yCor = yPos;		
	}

	protected int getXCor() {
		return this.xCor;
	}
	protected int getYCor() {
		return this.yCor;
	}
	
	private World world;
	private World getWorld() {
		return this.world;
	}
	private void setWorld(World world) {
		this.world = world;
	}
	
	@Override
	public int getXDim() {
		return this.getWorld().getTileLength();
	}
	@Override
	public int getYDim() {
		return this.getWorld().getTileLength();
	}
	@Override
	public int getHitpoints() {
		// TODO Mss hier een exeption throwen -> of gewoon uit superObject halen en enkel voor een gameObject maken?
		// throw new IllegalArgumentException();
		return 0;
	}

	@Override
	public double getXPos() {
		return this.getWorld().getTileLength() * this.getXCor();
	}

	@Override
	public double getYPos() {
		return this.getWorld().getTileLength() * this.getYCor();
	}

	public int getGeologicalFeature() {
		try {
			return this.getWorld().getGeologicalFeature((int) getXPos(), (int) getYPos());
		} catch (IllegalPixelException e) {
			// TODO moet hier air worden teruggegeven? want normaal geeft die hierboven dat toch al terug als het air is?
			// mss iets throwen -> dees is nu een beetje cheaten
			if (true) {
				throw new IllegalArgumentException();
			}
			return 0;
		}
	}

}
