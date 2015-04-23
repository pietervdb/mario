package jumpingalien.part2.tests;

import static jumpingalien.tests.util.TestUtils.doubleArray;
import static jumpingalien.tests.util.TestUtils.intArray;
import static jumpingalien.tests.util.TestUtils.spriteArrayForSize;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import jumpingalien.model.Mazub;
import jumpingalien.model.Plant;
import jumpingalien.model.World;
import jumpingalien.model.Shark;
import jumpingalien.model.Slime;
import jumpingalien.part2.facade.Facade;
import jumpingalien.part2.facade.IFacadePart2;
import jumpingalien.util.Sprite;
import jumpingalien.util.Util;

import org.junit.Test;

public class PlantTest {
	
	@Test 
	public void testAdvanceTime() {
		IFacadePart2 facade = new Facade();
		World world = facade.createWorld(5, 4, 3, 1, 1, 1, 1);
		Mazub alien = facade.createMazub(0, 499, spriteArrayForSize(3, 3));
		Plant plant = facade.createPlant(0, 0, spriteArrayForSize(1, 1, 2));
		plant.advanceTime(0.5);
		assertArrayEquals(intArray(50, 0), facade.getLocation(plant));
	}	
	//TODO dat werkt precies niet e :D
	
}
