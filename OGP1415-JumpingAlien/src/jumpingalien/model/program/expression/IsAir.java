package jumpingalien.model.program.expression;

import jumpingalien.model.Tile;
import jumpingalien.model.Type;
import jumpingalien.model.program.Program;

public class IsAir extends UnaryExpression<Boolean, Tile> {
	
	public IsAir(Expression<Tile> expr) {
		super(expr);
		if (expr.getType() != Type.OBJECT) {
			throw new IllegalArgumentException();
		}
		this.setType(Type.BOOLEAN);
	}

	@Override
	public Boolean evaluate(Program program) {
		return (this.getExpression1().evaluate(program).getGeologicalFeature() == 0);
	}

}
