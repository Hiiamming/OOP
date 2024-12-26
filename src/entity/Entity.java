package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Entity {
	GamePanel gp;
	
	public int worldX, worldY;
	
	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
	public String direction;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;

	public Rectangle solidArea;
	public boolean collisionOn = false;

	// Player status
	public int maxLife;
	public int life;
	public int atk;
	public int def;
	public int maxMana;
	public int Mana;
	public int speed;
	public int maxExp;
	public int exp;
	public int level;


	public Entity(GamePanel gp) {
		this.gp = gp;
	}

	
}
