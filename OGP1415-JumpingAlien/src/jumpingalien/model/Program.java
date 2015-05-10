package jumpingalien.model;

import java.util.ArrayList;
import java.util.Map;


public class Program<T> {
	public Program(Statement mainStatement, Map<String, Type> globalVariables) {
		this.setMainStatement(mainStatement);
		this.setGlobalVariables(globalVariables);
	}
	
	private Statement mainStatement;
	
	private Statement getMainStatement() {
		return this.mainStatement;
	}
	
	private void setMainStatement(Statement main) {
		this.mainStatement = main;
		main.setWorld(this.getGameObject().getWorld());
	}
	
	private Map<String, Type> globalVariables;
	
	private Map<String, Type> getGlobalVariables() {
		return this.globalVariables;
	}
	
	private void setGlobalVariables(Map<String, Type> var) {
		this.globalVariables = var;
	}
	
	private GameObject gameObject;
	
	private GameObject getGameObject() {
		return this.gameObject;
	}
	
	public void setGameObject(GameObject obj) {
		this.gameObject = obj;
	}
	
	private Map<String, T> environment;
	protected Map<String, T> getEnvironment() {
		return this.environment;
	}
	protected void setEnvironment(Map<String, Type> map) {
		if (map.values().iterator().next() == Type.Boolean) {
			this.environment = 
		}
	}
	//TODO dit oplossen
	protected void addToEnvironment(String name, T value ) {
		
	}
	
	
	public void execute(double dt) {
		if(dt <= 0.001) {
			this.getMainStatement().execute(getGlobalVariables());
		}
		else {
			this.getMainStatement().execute(getGlobalVariables());
			this.execute(dt - 0.001);
		}
	}
	
	
	
	
//	private ArrayList<Statement> statements = new ArrayList<Statement>();
//	
//	private ArrayList<Statement> getStatements() {
//		return this.getStatements();
//	}
//	
//	private int index = 0;
//	
//	private int getIndex() {
//		return index;
//	}
//	
//	private void setIndex(int i) {
//		this.index = i;
//	}
//	
//	private void addStatement(Statement s) {
//		this.getStatements().add(s);
//	}
//	
//	// hier mss nen iterator 
//	private Statement nextStatement() {
//		if (hasNextStatement()) {
//			return this.getStatements().get(getIndex());
//		}
//		else {
//			return null;
//		}
//	}
//	
//	private boolean hasNextStatement() {
//		if(this.getIndex() >= this.getStatements().size()) {
//			return false;
//		}
//		return true;
//	}
	
	

	public boolean isWellFormed() {
		return true;
	}


}
