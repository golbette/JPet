import java.util.Timer;
import java.util.TimerTask;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;

public class GameUpdateTask extends TimerTask{

	PetBehavior pet;
	Image hungerMtr5 = new ImageIcon(this.getClass().getResource("/HungerMeter55.jpg")).getImage();
	Image hungerMtr4 = new ImageIcon(this.getClass().getResource("/HungerMeter45.jpg")).getImage();
	Image hungerMtr3 = new ImageIcon(this.getClass().getResource("/HungerMeter35.jpg")).getImage();
	Image hungerMtr2 = new ImageIcon(this.getClass().getResource("/HungerMeter25.jpg")).getImage();
	Image hungerMtr1 = new ImageIcon(this.getClass().getResource("/HungerMeter15.jpg")).getImage();
	Image hungerMtr0 = new ImageIcon(this.getClass().getResource("/HungerMeter05.jpg")).getImage();
	Image hapMtr5 = new ImageIcon(this.getClass().getResource("/HappinessMeter55.jpg")).getImage();
	Image hapMtr4 = new ImageIcon(this.getClass().getResource("/HappinessMeter45.jpg")).getImage();
	Image hapMtr3 = new ImageIcon(this.getClass().getResource("/HappinessMeter35.jpg")).getImage();
	Image hapMtr2 = new ImageIcon(this.getClass().getResource("/HappinessMeter25.jpg")).getImage();
	Image hapMtr1 = new ImageIcon(this.getClass().getResource("/HappinessMeter15.jpg")).getImage();
	Image hapMtr0 = new ImageIcon(this.getClass().getResource("/HappinessMeter05.jpg")).getImage();
	Image healthMtr5 = new ImageIcon(this.getClass().getResource("/HealthMeter55.jpg")).getImage();
	Image healthMtr4 = new ImageIcon(this.getClass().getResource("/HealthMeter45.jpg")).getImage();
	Image healthMtr3 = new ImageIcon(this.getClass().getResource("/HealthMeter35.jpg")).getImage();
	Image healthMtr2 = new ImageIcon(this.getClass().getResource("/HealthMeter25.jpg")).getImage();
	Image healthMtr1 = new ImageIcon(this.getClass().getResource("/HealthMeter15.jpg")).getImage();
	Image healthMtr0 = new ImageIcon(this.getClass().getResource("/HealthMeter05.jpg")).getImage();

	public GameUpdateTask(PetBehavior pet)
	{
		this.pet = pet;
	}
	public void run()
	{
		//System.out.println("update time!");
		pet.update();
		JPet.lblHungerMtr.setIcon(new ImageIcon(hungerMtr5));
		if (pet.getFullness() ==6) {
			//System.out.println("5");
			JPet.lblHungerMtr.setIcon(new ImageIcon(hungerMtr5));
		} else if (pet.getFullness() == 5 && pet.getFullness() > 4) {
			//System.out.println("4");
			JPet.lblHungerMtr.setIcon(new ImageIcon(hungerMtr4));
		} else if (pet.getFullness() == 4 && pet.getFullness() > 3) {
			//System.out.println("3");
			JPet.lblHungerMtr.setIcon(new ImageIcon(hungerMtr3));
		} else if (pet.getFullness() == 3 && pet.getFullness() > 2) {
			//System.out.println("2");
			JPet.lblHungerMtr.setIcon(new ImageIcon(hungerMtr2));
		} else if (pet.getFullness() == 2 || pet.getFullness() == 1) {
			//System.out.println("1");
			JPet.lblHungerMtr.setIcon(new ImageIcon(hungerMtr1));
		} else if (pet.getFullness() < 1) {
			//System.out.println("0");
			JPet.lblHungerMtr.setIcon(new ImageIcon(hungerMtr0));
		}
		if (pet.getHappiness() >= 6) {
			//System.out.println("5");
			JPet.lblHapMtr.setIcon(new ImageIcon(hapMtr5));
		} else if (pet.getHappiness() <= 5 && pet.getHappiness() > 4) {
			//System.out.println("4");
			JPet.lblHapMtr.setIcon(new ImageIcon(hapMtr4));
		} else if (pet.getHappiness() <= 4 && pet.getHappiness() > 3) {
			//System.out.println("3");
			JPet.lblHapMtr.setIcon(new ImageIcon(hapMtr3));
		} else if (pet.getHappiness() <= 3 && pet.getHappiness() > 2) {
			//System.out.println("2");
			JPet.lblHapMtr.setIcon(new ImageIcon(hapMtr2));
		} else if (pet.getHappiness() <= 1 && pet.getHappiness() > 1) {
			//System.out.println("1");
			JPet.lblHapMtr.setIcon(new ImageIcon(hapMtr1));
		} else if (pet.getHappiness() < 1) {
			//System.out.println("0");
			JPet.lblHapMtr.setIcon(new ImageIcon(hapMtr0));
		}
		if (pet.getHealth() >= 6) {
			//System.out.println("5");
			JPet.lblHealthMtr.setIcon(new ImageIcon(healthMtr5));
		} else if (pet.getHealth() <= 5 && pet.getHealth() > 4) {
			//System.out.println("4");
			JPet.lblHealthMtr.setIcon(new ImageIcon(healthMtr4));
		} else if (pet.getHealth() <= 4 && pet.getHealth() > 3) {
			//System.out.println("3");
			JPet.lblHealthMtr.setIcon(new ImageIcon(healthMtr3));
		} else if (pet.getHealth() <= 3 && pet.getHealth() > 2) {
			//System.out.println("2");
			JPet.lblHealthMtr.setIcon(new ImageIcon(healthMtr2));
		} else if (pet.getHealth() <= 2 && pet.getHealth() > 1) {
			//System.out.println("1");
			JPet.lblHealthMtr.setIcon(new ImageIcon(healthMtr1));
		} else if (pet.getHealth() < 1) {
			//System.out.println("0");
			JPet.lblHealthMtr.setIcon(new ImageIcon(healthMtr0));
		}
	}


}
