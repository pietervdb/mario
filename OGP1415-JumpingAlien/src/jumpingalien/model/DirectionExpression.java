package jumpingalien.model;

public class DirectionExpression extends Expression<jumpingalien.part3.programs.IProgramFactory.Direction> {
	
	
	public DirectionExpression(jumpingalien.part3.programs.IProgramFactory.Direction v) {
		this.setValue(v);
	}

	private jumpingalien.part3.programs.IProgramFactory.Direction value;
	
	private jumpingalien.part3.programs.IProgramFactory.Direction getValue() {
		return this.value;
	}
	
	private void setValue(jumpingalien.part3.programs.IProgramFactory.Direction v) {
		this.value = v;
	}
	
	@Override
	protected jumpingalien.part3.programs.IProgramFactory.Direction evaluate() {
		return this.getValue();
	}
	
}
