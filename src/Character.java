import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Character extends Entity {

    GamePanel gamePanel;
    KeyHandler keyHandle;

    public final int screenX;
    public final int screenY;

    public Character(GamePanel panel, KeyHandler keyH) {
        this.gamePanel = panel;
        this.keyHandle = keyH;
        screenX = panel.screenWidth/2 - panel.tileSize/2;
        screenY = panel.screenHeight/2 - panel.tileSize/2;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gamePanel.tileSize * 19;
        worldY = gamePanel.tileSize * 8;
        speed = 3;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("resources/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("resources/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("resources/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("resources/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("resources/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("resources/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("resources/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("resources/boy_right_2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyHandle.goUp || keyHandle.goDown || keyHandle.goLeft || keyHandle.goRight) {
            if (keyHandle.goUp == true) {
                direction = "up";
                worldY -= speed;
            } else if (keyHandle.goDown == true) {
                direction = "down";
                worldY += speed;
            } else if (keyHandle.goLeft == true) {
                direction = "left";
                worldX -= speed;
            } else if (keyHandle.goRight == true) {
                direction = "right";
                worldX += speed;
            }
            spriteCounter++;

            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }

        g2.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
    }

}
