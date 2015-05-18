package jumpingalien.model.program.expression;

import jumpingalien.model.GameObject;
import jumpingalien.model.program.Program;

public class GetHeightObject extends UnaryExpression<Double, GameObject>{

	public GetHeightObject(Expression<GameObject> expression1) {
		super(expression1); 
	}

	@Override
	public Double evaluate(Program program) {
		return (double) ((GameObject) this.getExpression1().evaluate(program)).getYDim();
	}

}