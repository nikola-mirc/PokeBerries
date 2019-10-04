package nikola.mirc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BerryGarden extends JFrame {

	public static void main(String[] args) throws IOException {

		ArrayList<Berry> berryGarden = new ArrayList<Berry>();
		BerryFactory berryFactory = new BerryFactory(berryGarden);
		startIt(berryGarden);

	}

	private static void startIt(ArrayList<Berry> berries) throws MalformedURLException, IOException {

		JFrame frame = new JFrame("Berry picker");
		JPanel panel = new JPanel();
		JLabel infoLabel = new JLabel(BerryApiUtils.getLargestFastestGrowingBerry(berries).toString(), SwingConstants.CENTER);
		JLabel picLabel = new JLabel(new ImageIcon(BerryApiUtils.getBerryImage(BerryApiUtils.getLargestFastestGrowingBerry(berries).getBerryName())), SwingConstants.CENTER);
		JButton button = new JButton("Pick largest fastest growing berry");
		infoLabel.setVisible(false);
		picLabel.setVisible(false);
		panel.add(button);
		panel.add(picLabel);
		panel.add(infoLabel);
		frame.add(panel);
		frame.setSize(250, 200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				infoLabel.setVisible(true);
				picLabel.setVisible(true);
			}
		});
	}

}
