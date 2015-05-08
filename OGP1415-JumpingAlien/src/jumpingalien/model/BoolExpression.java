package jumpingalien.model;

public class BoolExpression extends Expression {
	public BoolExpression(BoolOperation operation, Expression expression) throws IllegalArgumentException {
		if(expression.getType() != Type.BOOL) {
			throw new IllegalArgumentException();
		}
	}
	
	public Type type = Type.BOOL;
	
	public boolean evaluate() {
		return true;
	}

}