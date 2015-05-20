package jumpingalien.part3.tests;
import jumpingalien.model.Buzam;
import jumpingalien.model.Mazub;
import jumpingalien.model.World;
import jumpingalien.model.program.Program;
import jumpingalien.part3.facade.Facade;
import jumpingalien.part3.facade.IFacadePart3;
import jumpingalien.part3.programs.ParseOutcome;
import jumpingalien.util.ModelException;
import jumpingalien.util.Sprite;

import org.junit.Before;
import org.junit.Test;

import static jumpingalien.tests.util.TestUtils.intArray;
import static jumpingalien.tests.util.TestUtils.spriteArrayForSize;
import static org.junit.Assert.*;

public class BuzamTest {
	
	public static final int FEATURE_AIR = 0;
	public static final int FEATURE_SOLID = 1;
	public static final int FEATURE_WATER = 2;
	public static final int FEATURE_MAGMA = 3;
	
	private IFacadePart3 facade;
	private World world;
	private Mazub alien;
	Sprite[] sprites;
	Sprite[] sprites2;
	
	
	@Before
	public void createFacadeAndWorld() {
		facade = new Facade();
		world = facade.createWorld(500, 2, 2, 2, 2, 1, 1);
		facade.setGeologicalFeature(world, 0, 0, FEATURE_SOLID);
		facade.setGeologicalFeature(world, 1, 0, FEATURE_SOLID);
		int m = 10;
		sprites = spriteArrayForSize(2, 2, 10 + 2 * m);
		sprites2 = spriteArrayForSize(2, 2, 2);
		alien = facade.createMazub(0, 499, sprites);
		facade.setMazub(world, alien);
	}
	
	@Test
	public void constructBuzam() {
		Buzam buzam = facade.createBuzam(499, 50, sprites);
		facade.addBuzam(world, buzam);
		assertArrayEquals(intArray(499, 50), facade.getLocation(buzam));
		assertEquals(world.getBuzam(), buzam);
	}
	
	@Test(expected = ModelException.class)
	public void constructBadSpriteBuzam() {
		Buzam buzam = facade.createBuzam(499, 50, sprites2);		
	}
	
	@Test(expected = ModelException.class)
	public void constructBadPosBuzam() {
		Buzam buzam = facade.createBuzam(-50, 50, sprites);		
	}
	
	@Test
	public void ProgramMoveRight() {
		ParseOutcome<?> outcome = facade.parse("start_jump;");
		Program program = (Program) outcome.getResult();
		facade.createBuzamWithProgram(0, 0, sprites, program);
		
	}
	
	
	
	
	
	
	
	
	

}
