package nikola.mirc;

import java.io.IOException;
import java.util.ArrayList;

public class BerryFactory {

	public BerryFactory(ArrayList<Berry> berryGarden) throws IOException {
		fillList(berryGarden);
	}

	private void fillList(ArrayList<Berry> berryGarden) throws IOException {
		for (int i = 0; i < BerryApiUtils.getNumberOfBerries(); i++) {
			berryGarden.add(new Berry(BerryApiUtils.getBerryName(i), BerryApiUtils.getBerrySize(i), BerryApiUtils.getBerryGrowthTime(i)));
		}
	}

}
