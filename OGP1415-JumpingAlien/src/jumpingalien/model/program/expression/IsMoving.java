package jumpingalien.model.program.expression;

import jumpingalien.model.GameObject;
import jumpingalien.model.Orientation;
import jumpingalien.model.Type;
import jumpingalien.model.program.Program;
import jumpingalien.part3.programs.IProgramFactory.Direction;

public class IsMoving extends UnaryExpression<Boolean, GameObject> {
	
	public IsMoving(Expression<GameObject> expr, Expression<Direction> direc) {
		super(expr);
		if (expr.getType() != Type.OBJECT || direc.getType() != Type.DIRECTION) {
			throw new IllegalArgumentException();
		}
		this.setType(Type.BOOLEAN);
		this.setDirection(direc);
		
	}
	
	private Expression<Direction> direction;
	
	private Expression<Direction> getDirection() {
		return direction;
	}
	
	private void setDirection(Expression<Direction> direc) {
		this.direction = direc;
	}
	
	@Override
	public Boolean evaluate(Program program) {
		if (this.getDirection().evaluate(program) == Direction.RIGHT) {
			return ((this.getExpression1().evaluate(program).getXSpeed() > 0) && 
					(this.getExpression1().evaluate(program).getOrientation() == Orientation.RIGHT));
		}
		else if (this.getDirection().evaluate(program) == Direction.LEFT) {
			return ((this.getExpression1().evaluate(program).getXSpeed() > 0) && 
					(this.getExpression1().evaluate(program).getOrientation() == Orientation.LEFT));
		}
		else if (this.getDirection().evaluate(program) == Direction.UP) {
			return (this.getExpression1().evaluate(program).getYSpeed() > 0);
		}
		else if (this.getDirection().evaluate(program) == Direction.DOWN) {
			return (this.getExpression1().evaluate(program).getYSpeed() < 0);
		}
		return false;
	}

}
