package nikola.mirc;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.imageio.ImageIO;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

public class BerryApiUtils {

	private final static String ROOT_URL = "https://pokeapi.co/api/v2/berry/";
	private static int numberOfBerries;
	private static URL request;
	private static String response;
	private static JSONObject rootObject;

	public static int getNumberOfBerries() throws IOException {
		request = new URL(ROOT_URL);
		response = IOUtils.toString(request.openStream(), "UTF-8");
		rootObject = new JSONObject(response);
		numberOfBerries = rootObject.getInt("count");
		return numberOfBerries;
	}

	public static String getBerryName(int berryId) throws IOException {
		String berryName = "";
		berryId++;
		request = new URL(ROOT_URL + berryId);
		response = IOUtils.toString(request.openStream(), "UTF-8");
		rootObject = new JSONObject(response);
		berryName = rootObject.get("name").toString();
		return berryName;
	}

	public static int getBerrySize(int berryId) throws IOException {
		int berrySize;
		berryId++;
		request = new URL(ROOT_URL + berryId);
		response = IOUtils.toString(request.openStream(), "UTF-8");
		rootObject = new JSONObject(response);
		berrySize = Integer.valueOf(rootObject.get("size").toString());
		return berrySize;
	}

	public static int getBerryGrowthTime(int berryId) throws IOException {
		int berryGrowthTime;
		berryId++;
		request = new URL(ROOT_URL + berryId);
		response = IOUtils.toString(request.openStream(), "UTF-8");
		rootObject = new JSONObject(response);
		berryGrowthTime = Integer.valueOf(rootObject.get("growth_time").toString());
		return berryGrowthTime;
	}

	public static BufferedImage getBerryImage(String berryName) throws MalformedURLException, IOException {
		String imgUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/items/" + berryName + "-berry.png";
		BufferedImage berryImg = ImageIO.read(new URL(imgUrl));
		return berryImg;
	}

	public static Berry getLargestFastestGrowingBerry(ArrayList<Berry> berries) {
		Collections.sort(berries, Comparator.comparing(Berry::getBerryGrowthTime).reversed().thenComparing(Berry::getBerrySize));
		return berries.get(berries.size() - 1);
	}

}
