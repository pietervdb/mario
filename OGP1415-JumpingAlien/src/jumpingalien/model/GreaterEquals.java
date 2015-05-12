package jumpingalien.model;

public class GreaterEquals extends BinaryExpression<Boolean, Double> {

	public GreaterEquals(Expression<Double> expression1,
			Expression<Double> expression2) {
		super(expression1, expression2);
	}

	@Override
	protected Boolean evaluate(Program program) {
		return this.getExpression1().evaluate(program) >= this.getExpression2().evaluate(program);
	}
	
}
