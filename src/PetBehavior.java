import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

//The pet behavior class 
public class PetBehavior {
	//x and y positions of the pet's visual/logical representation, in pixels
	private int xPos;
	private int yPos;
	private int targetX;
	private int targetY;
	private int fullness;
	private int happiness;
	private int health;
	private int moveSpeed = 1;
	private ArrayList<Image> petImgNeutral;
	private ArrayList<Image> petImgHappy;
	private ArrayList<Image> petImgSad;
	private ArrayList<Image> petImgDead;
	private ArrayList<Image> petImgLeft;
	private ArrayList<Image> petImgRight;
	private ArrayList<Image> petImgEat;
	private JLabel container;
	private int idleTime = 0;
	private Random rng;
	private int hungerTime = 850; //850
	private int happinessTime = 850; //850
	private int animTimer = 15;
	private int animFrame = 0;
	private int dir = 0; //0 = left, 1 = right
	private JLabel food;
	private boolean eating;

	//constants
	private final int MAX_FRAMES = 1;
	private final int ANIM_TIMER_MAX = 15;
	private final int MAX_IDLE_TIME = 300;
	//Creates a new pet object at 0,0 using a provided image
	public PetBehavior(BufferedImage petImg, JLabel container)
	{
		xPos = 0;
		yPos = 0;
		targetX = 500;
		targetY = 500;
		fullness = 6;
		happiness = 6;
		this.container = container;
		rng = new Random();
	}

	public PetBehavior(JLabel container)
	{
		xPos = 0;
		yPos = 0;
		targetX = 100;
		targetY = 100;
		fullness = 6;
		happiness = 6;
		health = 6;
		this.container = container;
		rng = new Random();
		petImgNeutral = new ArrayList<Image>();
		petImgHappy = new ArrayList<Image>();
		petImgSad = new ArrayList<Image>();
		petImgDead = new ArrayList<Image>();
		petImgLeft = new ArrayList<Image>();
		petImgRight = new ArrayList<Image>();
		petImgEat = new ArrayList<Image>();
	}

	public void update()
	{
		updatePos();
		updateHunger();
		updateHappy();
		updateHealth();
		updateHolder();
		animate();
	}

	private void updatePos() {
		int xSpeed = targetX-xPos;
		int ySpeed = targetY-yPos;
		if (ySpeed == 0 && xSpeed == 0)
			idleTime += 1;
		if (idleTime > MAX_IDLE_TIME && !eating)
		{
			targetX = rng.nextInt(500);
			targetY = rng.nextInt(500);
			idleTime = 0;
		}

		if (xSpeed > 1) xSpeed = 1;
		if (ySpeed > 1) ySpeed = 1;
		if (xSpeed < -1) xSpeed = -1;
		if (ySpeed < -1) ySpeed = -1;

		if (health > 0)
		{
			xPos += xSpeed;
			yPos += ySpeed;
		}
	}

	private void animate()
	{
		if (health <= 0)
		{
			animFrame = 0;
			container.setIcon(new ImageIcon(petImgDead.get(animFrame)));
		}
		//moving left
		else if (targetX < xPos)
		{
			dir = 0;
		}
		//moving right
		else if (targetX > xPos)
		{
			dir = 1;
		}
		if (targetX == xPos && targetY == yPos)
		{
			//standing still
			//eating
			if (eating)
			{
				animTimer--;
				if (animTimer < 1)
				{
					animFrame++;
					animTimer = ANIM_TIMER_MAX;
					if (animFrame >7)
					{
						animFrame = 0;
						eating = false;
						food.setVisible(false);
						if (fullness < 6)
						fullness += 1;
					}
				}
				container.setIcon(new ImageIcon(petImgEat.get(animFrame)));
			}
			//happy
			else
			{
				animTimer = ANIM_TIMER_MAX;
				animFrame = 0;
				if (happiness > 3 && fullness > 3)
				{
					container.setIcon(new ImageIcon(petImgHappy.get(animFrame)));
				}
				//hungery
				else if (happiness > 3)
				{
					container.setIcon(new ImageIcon(petImgNeutral.get(animFrame)));
				}
				//sad
				else if (health > 0)
				{
					container.setIcon(new ImageIcon(petImgNeutral.get(animFrame)));
				}
			}
		}
		else if (health > 0)
		{
			animTimer--;
			if (dir == 0)
			{

				if (animTimer <= 0)
				{
					animFrame += 1;
					if (animFrame > MAX_FRAMES)
					{
						animFrame = 0;
					}
					animTimer = ANIM_TIMER_MAX;
				}
				container.setIcon(new ImageIcon(petImgLeft.get(animFrame)));
			}

			if (dir == 1)
			{
				if (animTimer <= 0)
				{
					animFrame += 1;
					if (animFrame > MAX_FRAMES)
					{
						animFrame = 0;
					}
					animTimer = ANIM_TIMER_MAX;
				}
				container.setIcon(new ImageIcon(petImgRight.get(animFrame)));
			}
		}
	}

	private void updateHolder() {
		container.setBounds(xPos, yPos, container.getWidth(), container.getHeight());
	}

	private void updateHappy() {
		happinessTime -= 1;
		if (happinessTime <= 0)
		{
			happiness -= 1;
			happinessTime = 850; //850
		}

	}

	private void updateHunger() {
		hungerTime -= 1;
		if (hungerTime <= 1)
		{
			fullness -= 1;
			hungerTime = 850; //850
		}
	}

	private void updateHealth() {
		health = (happiness + fullness)/2;

	}

	//returns the absolute position of the pet on the screen
	public int[] getPos()
	{
		int[] pos = new int[2];
		pos[0] = xPos;
		pos[1] = yPos;
		return null;
	}

	//sets a target destination in the window for the pet to move to
	public void setDestination(int tarX, int tarY)
	{
		targetX = tarX;
		targetY = tarY;
	}

	public void setPos(int x, int y)
	{
		xPos = x;
		yPos = y;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getTargetX() {
		return targetX;
	}

	public void setTargetX(int targetX) {
		this.targetX = targetX;
	}

	public int getTargetY() {
		return targetY;
	}

	public void setTargetY(int targetY) {
		this.targetY = targetY;
	}

	public int getFullness() {
		return fullness;
	}

	public void setFullness(int fullness) {
		this.fullness = fullness;
	}

	public int getHappiness() {
		return happiness;
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	public int getMoveSpeed() {
		return moveSpeed;
	}

	public void setMoveSpeed(int moveSpeed) {
		this.moveSpeed = moveSpeed;
	}

	public ArrayList<Image> getPetImg() {
		return petImgNeutral;
	}

	public void addPetImgNeutral(Image petImgNeutral) {
		this.petImgNeutral.add(petImgNeutral);
	}

	public void addPetImgHappy(Image petImg) {
		this.petImgHappy.add(petImg);
	}

	public void addPetImgSad(Image petImg) {
		this.petImgSad.add(petImg);
	}

	public void addPetImgDead(Image petImg) {
		this.petImgDead.add(petImg);
	}

	public void addPetImgLeft(Image petImg) {
		this.petImgLeft.add(petImg);
	}

	public void addPetImgRight(Image petImg) {
		this.petImgRight.add(petImg);
	}
	public JLabel getContainer() {
		return container;
	}

	public void setContainer(JLabel container) {
		this.container = container;
	}

	@Override
	public String toString() {
		return "PetBehavior [health=" + health + " hungerTime=" + hungerTime + "]";
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void addPetImgEat(Image petImg) {
		// TODO Auto-generated method stub
		petImgEat.add(petImg);
	}

	public void feed(JLabel food)
	{
		this.food = food;
		food.setVisible(true);
		food.setBounds(rng.nextInt(600), rng.nextInt(500), food.getWidth(), food.getHeight());
		targetX = food.getX();
		targetY = food.getY() - 40;
		eating = true;
	}
	
	public void pet()
	{
		targetX = xPos;
		targetY = yPos;
		animFrame = 0;
		animTimer = ANIM_TIMER_MAX;
		idleTime = 0;
		container.setIcon(new ImageIcon(petImgHappy.get(animFrame)));
		if (happiness < 6)
		happiness += 1;
	}

}
