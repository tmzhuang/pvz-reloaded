import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
public class PlantFactoryTest extends TestCase{

	Square square;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		square = new Square("",0,0,null);

	}
	
	@Test (expected = NullPointerException.class)
	public void testMakePlantWithNullSquare(){
		PlantFactory.makePlant(Plant.Type.PEASHOOTER, null);
	}
	
	@Test
	public void testMakePlantWithNullType(){
		assertFalse(PlantFactory.makePlant(null, square) instanceof Plant);
	}
	
	@Test
	public void testMakePlant(){
		assertTrue(PlantFactory.makePlant(Plant.Type.PEASHOOTER, square).getClass() == PeaShooterPlant.class);
	}
	
	@Test
	public void testGetClass(){
		assertTrue(PlantFactory.getClass(Plant.Type.PEASHOOTER) == PeaShooterPlant.class);
	
	}
	
	@Test
	public void testGetCooldown(){
		assertTrue(PlantFactory.getCooldown(Plant.Type.SUNFLOWER)== 3);
	}

	@Test
	public void testGetCost(){
		assertTrue(PlantFactory.getCost(Plant.Type.SUNFLOWER)== 50);
	}
}
