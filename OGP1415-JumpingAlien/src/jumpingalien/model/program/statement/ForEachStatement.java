package jumpingalien.model.program.statement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import jumpingalien.model.SuperObject;
import jumpingalien.model.program.Program;
import jumpingalien.model.program.expression.Expression;
import jumpingalien.part3.programs.IProgramFactory.Kind;
import jumpingalien.part3.programs.IProgramFactory.SortDirection;

public class ForEachStatement extends LoopStatement {

	public ForEachStatement(String variableName,
			jumpingalien.part3.programs.IProgramFactory.Kind variableKind,
			Expression<Boolean> where,
			Expression<Double> sort,
			jumpingalien.part3.programs.IProgramFactory.SortDirection sortDirection,
			Statement body) {
		this.setVariableName(variableName);
		this.setWhere(where);
		this.setSort(sort);
		this.setKind(variableKind);
		this.setSortDirection(sortDirection);
		this.setBody(body);
	}
	
	private String variableName;
	private String getVariableName() {
		return variableName;
	}
	private void setVariableName(String variableName) {
		this.variableName = variableName;
	}
	
	private Kind kind;
	private Kind getKind() {
		return kind;
	}
	private void setKind(Kind kind) {
		this.kind = kind;
	}
	
	private Expression<Boolean> where;
	private Expression<Boolean> getWhere() {
		return where;
	}
	private void setWhere(Expression<Boolean> where) {
		this.where = where;
	}
	
	private Expression<Double> sort;
	private Expression<Double> getSort() {
		return sort;
	}
	private void setSort(Expression<Double> sort) {
		this.sort = sort;
	}
	
	private SortDirection sortDirection;
	private SortDirection getSortDirection() {
		return sortDirection;
	}
	private void setSortDirection(SortDirection sortDirection) {
		this.sortDirection = sortDirection;
	}


		
	private List<SuperObject> listObjectByKind(Program program) {
		List<SuperObject> list = new CopyOnWriteArrayList<SuperObject>();
		switch(this.getKind()) {
		case MAZUB:
			list.add(program.getGameObject().getWorld().getAlien());
			break;
		case BUZAM:
			if (program.getGameObject().getWorld().getBuzam() != null) {
				list.add(program.getGameObject().getWorld().getBuzam());
			}			
			break;
		case PLANT:
			list.addAll(program.getGameObject().getWorld().getPlants());
			break;
		case SHARK:
			list.addAll(program.getGameObject().getWorld().getSharks());
			break;
		case SLIME:
			list.addAll(program.getGameObject().getWorld().getSlimes());
			break;
		case TERRAIN:
			list.addAll(program.getGameObject().getWorld().listAllTiles());
			break;
		case ANY:
			list.add(program.getGameObject().getWorld().getAlien());
			if(program.getGameObject().getWorld().getBuzam() != null) {
				list.add(program.getGameObject().getWorld().getBuzam());
			}
			list.addAll(program.getGameObject().getWorld().getPlants());
			list.addAll(program.getGameObject().getWorld().getSlimes());
			list.addAll(program.getGameObject().getWorld().getSharks());
			list.addAll(program.getGameObject().getWorld().listAllTiles());
			break;
		default: 
			throw new IllegalArgumentException();
		}
		return list;
	}
	
	private List<SuperObject> listObjectWhereTrue(Program program) {
		List<SuperObject> list = this.listObjectByKind(program);
		if (this.getWhere() != null) {
			for (SuperObject object: list) {
				program.addToEnvironment(getVariableName(), object);
				if (!this.getWhere().evaluate(program)) {
					list.remove(object);
				}
			}
		}
		return list;
	}
	
	private List<SuperObject> listObjectWhereTrueSorted(Program program) {
		List<SuperObject> listWhereTrue = this.listObjectWhereTrue(program);
		if (this.getSort() != null) {
			List<SuperObject> listToReturn = new ArrayList<SuperObject>();
			for (int i = 0; i < listWhereTrue.size(); i++) {
				if (this.getSortDirection() == SortDirection.ASCENDING) {
					double min = Double.POSITIVE_INFINITY;
					SuperObject nextInLine = null;
					for (SuperObject object: listWhereTrue) {
						program.addToEnvironment(getVariableName(), object);
						double value = this.getSort().evaluate(program);
						if (value < min) {
							min = value;
							nextInLine = object;
						}
					}
					listToReturn.add(nextInLine);
					listWhereTrue.remove(nextInLine);
				}
				else {
					double max = Double.NEGATIVE_INFINITY;
					SuperObject nextInLine = null;
					for (SuperObject object: listWhereTrue) {
						program.addToEnvironment(getVariableName(), object);
						double value = this.getSort().evaluate(program);
						if (value > max) {
							max = value;
							nextInLine = object;
						}
					}
					listToReturn.add(nextInLine);
					listWhereTrue.remove(nextInLine);
				}			
			}		
			return listToReturn;
		}
		return listWhereTrue;
	}
	
	private List<SuperObject> executeList = null;
	private List<SuperObject> getExecuteList() {
		return this.executeList;
	}
	private void setExecuteList(List<SuperObject> list) {
		this.executeList = list;
	}
	
	@Override
	public void execute(Program program) {
		if ( ! this.getInBody()) {
			this.setExecuteList(listObjectWhereTrueSorted(program));
			this.setInBody(true);
		}
		else {
			program.addToEnvironment(getVariableName(), this.getExecuteList().get(0));
			while(!this.getBody().isReady()) {
				this.getBody().execute(program);
			}
			this.getBody().setNotReady();
			this.getExecuteList().remove(this.getExecuteList().get(0));	
		}
		if (this.getExecuteList().isEmpty()) {
			this.setReady();
			this.setInBody(false);
		}
		
		
	}
	@Override
	public void reset() {
		this.setNotReady();
		this.setInBody(false);
	}
	@Override
	public boolean isWellFormed() {
		return this.getBody().isWellFormed();
	}
	
}
