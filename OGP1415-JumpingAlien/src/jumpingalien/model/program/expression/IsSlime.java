package jumpingalien.model.program.expression;

import jumpingalien.model.Slime;
import jumpingalien.model.SuperObject;
import jumpingalien.model.Type;
import jumpingalien.model.program.Program;

public class IsSlime extends UnaryExpression<Boolean, SuperObject> {
	
	public IsSlime(Expression<SuperObject> expr) {
		super(expr);
		if (expr.getType() != Type.OBJECT) {
			throw new IllegalArgumentException();
		}
		this.setType(Type.BOOLEAN);
	}

	@Override
	public Boolean evaluate(Program program) {
		return (this.getExpression1().evaluate(program) instanceof Slime);
	}

}
