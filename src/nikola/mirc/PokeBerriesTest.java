package nikola.mirc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class PokeBerriesTest {

	@Test
	void testGetNumberOfBerries() throws IOException {
		assertEquals(64, BerryApiUtils.getNumberOfBerries());
	}

	@Test
	void testGetLargestFastestGrowingBerry() throws IOException {
		ArrayList<Berry> berries = new ArrayList<Berry>();
		berries.add(new Berry("blueberry", 66, 4));
		berries.add(new Berry("strawberry", 21, 3));
		berries.add(new Berry("raspberry", 50, 3));
		berries.add(new Berry("blackberry", 39, 3));
		assertEquals("raspberry", BerryApiUtils.getLargestFastestGrowingBerry(berries).getBerryName());
	}

	@Test
	void testGetBerryName() throws IOException {
		ArrayList<Berry> berryGarden = new ArrayList<Berry>();
		BerryFactory berryFactory = new BerryFactory(berryGarden);
		assertEquals(BerryApiUtils.getBerryName(7), berryGarden.get(7).getBerryName());
	}

	@Test
	void testGetBerrySize() throws IOException {
		ArrayList<Berry> berryGarden = new ArrayList<Berry>();
		BerryFactory berryFactory = new BerryFactory(berryGarden);
		assertEquals(BerryApiUtils.getBerrySize(17), berryGarden.get(17).getBerrySize());
	}

	@Test
	void testGetBerryGrowthTime() throws IOException {
		ArrayList<Berry> berryGarden = new ArrayList<Berry>();
		BerryFactory berryFactory = new BerryFactory(berryGarden);
		assertEquals(BerryApiUtils.getBerryGrowthTime(27), berryGarden.get(27).getBerryGrowthTime());
	}

}
