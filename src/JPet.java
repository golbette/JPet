import java.awt.EventQueue;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.awt.EventQueue;
import java.util.Timer;
import java.awt.Font;
import java.awt.Color;


public class JPet {

	static JLabel lblHungerMtr;
	static JLabel lblHapMtr;
	static JLabel lblHealthMtr;

	private JFrame frmJpet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPet window = new JPet();
					window.frmJpet.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JPet() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmJpet = new JFrame();
		frmJpet.setTitle("JPet");
		frmJpet.setBounds(100, 100, 800, 600);
		frmJpet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJpet.getContentPane().setLayout(null);

		lblHungerMtr = new JLabel("");
		lblHungerMtr.setBounds(740, 357, 30, 162);
		frmJpet.getContentPane().add(lblHungerMtr);

		lblHealthMtr = new JLabel("");
		lblHealthMtr.setBounds(617, 357, 30, 162);
		frmJpet.getContentPane().add(lblHealthMtr);

		lblHapMtr = new JLabel("");
		lblHapMtr.setBounds(680, 357, 30, 162);
		frmJpet.getContentPane().add(lblHapMtr);
		
		//initialize food
		final JLabel DELICIOUS_BURG = new JLabel("");
		DELICIOUS_BURG.setIcon(new ImageIcon(this.getClass().getResource("/Hamburger.png")));
		DELICIOUS_BURG.setBounds(0,0, 48, 48);
		DELICIOUS_BURG.setOpaque(false);
		DELICIOUS_BURG.setVisible(false);
		frmJpet.getContentPane().add(DELICIOUS_BURG);

		JLabel lblPet = new JLabel("");
		Image pet = new ImageIcon(this.getClass().getResource("/JPet Neutral.png")).getImage();
		lblPet.setIcon(new ImageIcon(pet));
		lblPet.setBounds(128, 63, 74, 78);
		frmJpet.getContentPane().add(lblPet);

		//initialize pet
		Timer gameTimer = new Timer();
		final PetBehavior testPet = new PetBehavior(lblPet);
		testPet.addPetImgNeutral(pet);
		Image petHappy = new ImageIcon(this.getClass().getResource("/JPet Happy.png")).getImage();
		testPet.addPetImgHappy(petHappy);
		Image petSad = new ImageIcon(this.getClass().getResource("/JPet Sad.png")).getImage();
		testPet.addPetImgSad(petSad);
		Image petDead = new ImageIcon(this.getClass().getResource("/JPet Dead.png")).getImage();
		testPet.addPetImgDead(petDead);
		Image petLeft1 = new ImageIcon(this.getClass().getResource("/Neutral Left 1.png")).getImage();
		testPet.addPetImgLeft(petLeft1);
		Image petLeft2 = new ImageIcon(this.getClass().getResource("/Neutral Left 2.png")).getImage();
		testPet.addPetImgLeft(petLeft2);
		Image petRight1 = new ImageIcon(this.getClass().getResource("/Neutral Right 1.png")).getImage();
		testPet.addPetImgRight(petRight1);
		Image petRight2 = new ImageIcon(this.getClass().getResource("/Neutral Right 2.png")).getImage();
		testPet.addPetImgRight(petRight2);

		//a smooth and buttery 60 fps so gamer's wont get mad 
		gameTimer.scheduleAtFixedRate(new GameUpdateTask(testPet), 16, 16);

		JLabel lblAppleIcon = new JLabel("");
		lblAppleIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				testPet.setFullness(testPet.getFullness() + 1);
			}
		});
		Image apple = new ImageIcon(this.getClass().getResource("/apple.jpg")).getImage();
		lblAppleIcon.setOpaque(true);
		lblAppleIcon.setVisible(true);
		lblAppleIcon.setIcon(new ImageIcon(apple));
		lblAppleIcon.setBounds(653, 34, 85, 85);
		frmJpet.getContentPane().add(lblAppleIcon);

		JLabel lblHandIcon = new JLabel("");
		lblHandIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				testPet.setFullness(testPet.getFullness() + 1);
			}
		});
		Image hand = new ImageIcon(this.getClass().getResource("/hand.jpg")).getImage();
		lblHandIcon.setOpaque(true);
		lblHandIcon.setVisible(true);
		lblHandIcon.setIcon(new ImageIcon(hand));
		lblHandIcon.setBounds(653, 187, 85, 85);
		lblHandIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				testPet.pet();
				//JOptionPane.showMessageDialog(null, "Food!");
			}
		});
		frmJpet.getContentPane().add(lblHandIcon);

		JLabel lblHealth = new JLabel("<html><b>Health</html>");
		lblHealth.setForeground(Color.white);
		lblHealth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHealth.setBounds(610, 508, 46, 32);
		frmJpet.getContentPane().add(lblHealth);

		JLabel lblHappiness = new JLabel("<html><b>Mood</html>");
		lblHappiness.setForeground(Color.white);
		lblHappiness.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHappiness.setBounds(669, 508, 46, 32);
		frmJpet.getContentPane().add(lblHappiness);

		JLabel lblHunger = new JLabel("<html><b>Hunger</html>");
		lblHunger.setForeground(Color.white);
		lblHunger.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHunger.setBounds(720, 508, 64, 32);
		frmJpet.getContentPane().add(lblHunger);

		JLabel lblFood = new JLabel("<html><b>Feed</html>");
		lblFood.setForeground(Color.WHITE);
		lblFood.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFood.setBounds(677, 117, 63, 24);
		frmJpet.getContentPane().add(lblFood);

		JLabel lblMood = new JLabel("<html><b><center>Improve Mood</html>");
		lblMood.setForeground(Color.WHITE);
		lblMood.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMood.setBounds(662, 273, 74, 42);
		frmJpet.getContentPane().add(lblMood);

		JLabel lblBackground = new JLabel("");
		Image background = new ImageIcon(this.getClass().getResource("/background4.jpg")).getImage();
		lblBackground.setIcon(new ImageIcon(background));
		lblBackground.setBounds(0, 0, 784, 562);
		frmJpet.getContentPane().add(lblBackground);


		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 557, 784, -554);
		frmJpet.getContentPane().add(layeredPane);

		//eating animation
		Image eating1 = new ImageIcon(this.getClass().getResource("/Eating 1.png")).getImage();
		testPet.addPetImgEat(eating1);
		Image eating2 = new ImageIcon(this.getClass().getResource("/Eating 2.png")).getImage();
		testPet.addPetImgEat(eating2);
		Image eating3 = new ImageIcon(this.getClass().getResource("/Eating 3.png")).getImage();
		testPet.addPetImgEat(eating3);
		Image eating4 = new ImageIcon(this.getClass().getResource("/Eating 4.png")).getImage();
		testPet.addPetImgEat(eating4);
		Image eating5 = new ImageIcon(this.getClass().getResource("/Eating 5.png")).getImage();
		testPet.addPetImgEat(eating5);
		Image eating6 = new ImageIcon(this.getClass().getResource("/Eating 6.png")).getImage();
		testPet.addPetImgEat(eating6);
		Image eating7 = new ImageIcon(this.getClass().getResource("/Eating 7.png")).getImage();
		testPet.addPetImgEat(eating7);
		Image eating8 = new ImageIcon(this.getClass().getResource("/Eating 7.png")).getImage();
		testPet.addPetImgEat(eating8);

		lblPet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				testPet.pet();
				//JOptionPane.showMessageDialog(null, "Food!");
			}
		});

		lblAppleIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				testPet.feed(DELICIOUS_BURG); 
				//JOptionPane.showMessageDialog(null, "Food!");
			}
		});
	}
}
