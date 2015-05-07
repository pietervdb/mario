package jumpingalien.model;

public abstract class Expression {
	public Expression(Type type) {
		this.setType(type);
	}
	
	public Type type;
	
	protected Type getType() {
		return type;
	}
	
	private void setType(Type type) {
		this.type = type;
	}
	
	//public abstract Expression getValue();
	
}
