import java.awt.EventQueue;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PetTesterWindow {

	private JFrame frame;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PetTesterWindow window = new PetTesterWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PetTesterWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("helo i am pet");
		lblNewLabel.setBounds(128, 63, 74, 78);
		frame.getContentPane().add(lblNewLabel);
		//initialize pet
		Timer gameTimer = new Timer();
		PetBehavior testPet = new PetBehavior(lblNewLabel);
		//a smooth and buttery 60 fps so gamer's wont get mad 
		gameTimer.scheduleAtFixedRate(new GameUpdateTask(testPet), 16, 16);
		
	}
}
