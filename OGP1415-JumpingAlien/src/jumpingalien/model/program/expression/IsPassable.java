package jumpingalien.model.program.expression;

import jumpingalien.model.Tile;
import jumpingalien.model.program.Program;

public class IsPassable extends UnaryExpression<Boolean, Tile> {
	
	public IsPassable(Expression<Tile> expr) {
		super(expr);
	}

	@Override
	public Boolean evaluate(Program program) {
		return (this.getExpression1().evaluate(program).getGeologicalFeature() != 0);
	}

}