package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;

public class Player2 extends Entity {
    
    KeyHandler keyH;
    
    public final int screenX;
    public final int screenY;
    
    public Player2 (GamePanel gp, KeyHandler keyH, String heroType) {
        super(gp);
        this.keyH = keyH;
        
        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);
        
        solidArea = new Rectangle(0, 0, 96, 96);
        solidArea.x = 16;
        solidArea.y = 32;
        solidArea.width = 64;
        solidArea.height = 64;
        
        setDefaultValues();
        getPlayerImage();
    }
    
    public void setDefaultValues() {
        worldX = gp.tileSize * 5; // Different starting position
        worldY = gp.tileSize * 5;
        speed = 3; // Different speed
        direction = "right";
        
        // Player status
        maxLife = 8;
        life = maxLife;
    }
    
    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/warrior_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/warrior_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/warrior_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/warrior_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/warrior_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/warrior_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/warrior_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/warrior_right_2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void update() {
        // Similar update logic as Player class
        boolean isStanding = true;

        if(keyH.upPressed) {
            direction = "up";
            isStanding = false;
        }
        else if(keyH.downPressed) {
            direction = "down";
            isStanding = false;
        }
        else if(keyH.leftPressed) {
            direction = "left";
            isStanding = false;
        }
        else if(keyH.rightPressed) {
            direction = "right";
            isStanding = false;
        }

        collisionOn = false;
        gp.cChecker.checkTile(this);

        if (!collisionOn && !isStanding) {
            switch (direction) {
                case "up": 
                    worldY -= speed; 
                    break;
                case "down": 
                    worldY += speed; 
                    break;
                case "left": 
                    worldX -= speed; 
                    break;
                case "right": 
                    worldX += speed; 
                    break;
            }
        }
    }
    
    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        
        switch(direction) {
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
