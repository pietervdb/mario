package jumpingalien.model.program.expression;

import jumpingalien.model.Type;
import jumpingalien.model.program.Program;

public class LessThan extends BinaryExpression<Boolean, Double> {

	public LessThan(Expression<Double> expression1,
			Expression<Double> expression2) {
		super(expression1, expression2);
		if (expression1.getType() != Type.DOUBLE || expression2.getType() != Type.DOUBLE) {
			throw new IllegalArgumentException();
		}
		this.setType(Type.BOOLEAN);
	}

	@Override
	public Boolean evaluate(Program program) {
		return this.getExpression1().evaluate(program) < this.getExpression2().evaluate(program);
	}
	
}
