package jumpingalien.model;


public class BoolFalse extends Expression<Boolean> {
	
	public BoolFalse() {
		
	}
	
	@Override
	protected Boolean evaluate(Program program) {
		return false;
	}
}