package nikola.mirc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BerryController {

	@FXML
	private ImageView imageView;

	@FXML
	private Button randomButton;

	@FXML
	private Button bestButton;

	@FXML
	private TextField textViewName;

	@FXML
	private TextField textViewSize;

	@FXML
	private TextField textViewGrowth;

	@FXML
	private TextField textViewFirmness;

	public void getBestBerry() throws IOException {
		ArrayList<Berry> berries = new ArrayList<>();
		BerryFactory berryFactory = new BerryFactory(berries);
		Berry bestBerry = BerryApiUtils.getLargestFastestGrowingBerry(berries);
		imageView.setImage(new Image((bestBerry.getImage(bestBerry.getBerryName()))));
		imageView.setVisible(true);
		textViewName.setText(bestBerry.getBerryName());
		textViewSize.setText(String.valueOf(bestBerry.getBerrySize()));
		textViewGrowth.setText(String.valueOf(bestBerry.getBerryGrowthTime()));
		textViewFirmness.setText(BerryApiUtils.getBerryFirmness(BerryApiUtils.getBerryId(bestBerry.getBerryName())));
	}

	public void getRandomBerry() throws IOException {
		ArrayList<Berry> berries = new ArrayList<>();
		BerryFactory berryFactory = new BerryFactory(berries);
		Berry randomBerry = berries.get(new Random().nextInt(64) + 1);
		imageView.setImage(new Image((randomBerry.getImage(randomBerry.getBerryName()))));
		imageView.setVisible(true);
		textViewName.setText(randomBerry.getBerryName());
		textViewSize.setText(String.valueOf(randomBerry.getBerrySize()));
		textViewGrowth.setText(String.valueOf(randomBerry.getBerryGrowthTime()));
		textViewFirmness.setText(BerryApiUtils.getBerryFirmness(BerryApiUtils.getBerryId(randomBerry.getBerryName())));
	}

}
