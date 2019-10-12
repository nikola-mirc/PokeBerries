package nikola.mirc;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Berry {

	private String berryName;
	private int berrySize;
	private int berryGrowthTime;

	public Berry(String berryName, int berrySize, int berryGrowthTime) {
		this.berryName = berryName;
		this.berrySize = berrySize;
		this.berryGrowthTime = berryGrowthTime;
	}

	public String getBerryName() {
		return berryName;
	}

	public void setBerryName(String berryName) {
		this.berryName = berryName;
	}

	public int getBerrySize() {
		return berrySize;
	}

	public void setBerrySize(int berrySize) {
		this.berrySize = berrySize;
	}

	public int getBerryGrowthTime() {
		return berryGrowthTime;
	}

	public void setBerryGrowthTime(int berryGrowthTime) {
		this.berryGrowthTime = berryGrowthTime;
	}

	@Override
	public String toString() {
		return "Name: " + this.berryName + " Size: " + this.berrySize + " Growth time: " + this.berryGrowthTime;
	}

	public InputStream getImage(String berryName) throws IOException {
		URL imgUrl = new URL("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/items/" + berryName + "-berry.png");
		return imgUrl.openStream();

	}

}
