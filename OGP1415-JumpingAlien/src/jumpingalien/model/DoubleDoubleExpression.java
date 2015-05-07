package jumpingalien.model;

public class DoubleDoubleExpression extends DoubleExpression {

	

	public DoubleDoubleExpression(DoubleOperation operation,
			Expression expression1, Expression expression2) throws IllegalArgumentException {
		super(operation, expression1);
		if (expression2.getType() != Type.DOUBLE) {
			throw new IllegalArgumentException();
		}
		setExpression2(expression2);
	}
	
	private Expression expression2;
	
	private Expression getExpression2() {
		return expression2;
	}
	
	private void setExpression2(Expression expr) {
		this.expression2 = expr;
	}

	@Override
	public double evaluate() {
		if ((this.getExpression1().getType() == Type.DOUBLE) || (this.getExpression2().getType() == Type.DOUBLE)) {
			if (this.getOperation() == DoubleOperation.ADDITION) {
				return this.getExpression1().evaluate() + this.getExpression2().evaluate();
			}
			else if (this.getOperation() == DoubleOperation.SUBTRACTION) {
				return this.getExpression1().evaluate() - this.getExpression2().evaluate();
			}
			else if (this.getOperation() == DoubleOperation.MULTIPLICATION) {
				return this.getExpression1().evaluate() * this.getExpression2().evaluate();
			}
			else if (this.getOperation() == DoubleOperation.DIVISION) {
				return this.getExpression1().evaluate() / this.getExpression2().evaluate();
			}
		}
		else {
			// TODO throw
		}
			
	}

	

}
