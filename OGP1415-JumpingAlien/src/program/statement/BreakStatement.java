package program.statement;

import program.Program;


public class BreakStatement extends Statement {

	public BreakStatement() {
		
	}
	
	
	public boolean breakWellFormed() {
		if (this.getLoopStatement(this) != null) {
			return true;
		}
		return false;
	}
	
	// Classy recursie
	private LoopStatement getLoopStatement(Statement stat) {
		if(stat.getSuperStatement() instanceof LoopStatement) {
			return (LoopStatement) stat.getSuperStatement();
		}
		// de breakstatement is niet wellFormed
		else if (stat.getSuperStatement() == null) {
			return null;
		}
		else {
			return this.getLoopStatement(stat.getSuperStatement());
		}
	}
	
	// meer classy recursie
	private void resetAllSuperStatTillLoop(Statement stat) {
		if( ! (stat.getSuperStatement() instanceof LoopStatement)) {
			stat.getSuperStatement().reset();
			this.resetAllSuperStatTillLoop(stat.getSuperStatement());
		}
	}
	
	
	@Override
	public void execute(Program program) {
		this.resetAllSuperStatTillLoop(this);
		LoopStatement loopStat = this.getLoopStatement(this);
		loopStat.setInBody(false);
		loopStat.setReady();
	}

	@Override
	public void reset() {
		this.setNotReady();
	}

}
