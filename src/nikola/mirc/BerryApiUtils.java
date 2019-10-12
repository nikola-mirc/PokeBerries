package nikola.mirc;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

public class BerryApiUtils {

	private final static String ROOT_URL = "https://pokeapi.co/api/v2/berry/";
	private static URL request;
	private static String response;
	private static JSONObject rootObject;

	public static int getNumberOfBerries() throws IOException {
		int numberOfBerries;
		request = new URL(ROOT_URL);
		response = IOUtils.toString(request.openStream(), "UTF-8");
		rootObject = new JSONObject(response);
		numberOfBerries = rootObject.getInt("count");
		return numberOfBerries;
	}

	public static String getBerryName(int berryId) throws IOException {
		berryId++;
		String berryName = "";
		request = new URL(ROOT_URL + berryId);
		response = IOUtils.toString(request.openStream(), "UTF-8");
		rootObject = new JSONObject(response);
		berryName = rootObject.get("name").toString();
		return berryName;
	}

	public static int getBerryId(String berryName) throws IOException {
		int id;
		request = new URL(ROOT_URL + berryName);
		response = IOUtils.toString(request.openStream(), "UTF-8");
		rootObject = new JSONObject(response);
		id = Integer.valueOf(rootObject.get("id").toString());
		return id;
	}

	public static int getBerrySize(int berryId) throws IOException {
		berryId++;
		int berrySize;
		request = new URL(ROOT_URL + berryId);
		response = IOUtils.toString(request.openStream(), "UTF-8");
		rootObject = new JSONObject(response);
		berrySize = Integer.valueOf(rootObject.get("size").toString());
		return berrySize;
	}

	public static int getBerryGrowthTime(int berryId) throws IOException {
		berryId++;
		int berryGrowthTime;
		request = new URL(ROOT_URL + berryId);
		response = IOUtils.toString(request.openStream(), "UTF-8");
		rootObject = new JSONObject(response);
		berryGrowthTime = Integer.valueOf(rootObject.get("growth_time").toString());
		return berryGrowthTime;
	}

	public static Berry getLargestFastestGrowingBerry(ArrayList<Berry> berries) {
		Collections.sort(berries, Comparator.comparing(Berry::getBerryGrowthTime).reversed().thenComparing(Berry::getBerrySize));
		return berries.get(berries.size() - 1);
	}

	public static String getBerryFirmness(int berryId) throws IOException {
		String berryFirmness = "";
		berryId++;
		request = new URL(ROOT_URL + berryId);
		response = IOUtils.toString(request.openStream(), "UTF-8");
		rootObject = new JSONObject(response);
		JSONObject firmnessObject = (JSONObject) rootObject.get("firmness");
		berryFirmness = firmnessObject.get("name").toString();
		return berryFirmness;
	}

}
