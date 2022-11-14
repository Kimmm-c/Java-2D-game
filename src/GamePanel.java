import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    //Screen Settings
    final int originalTileSize = 16; //16x16 tile -> create 16x16px canvas to draw pixelated sprite.
    final int scale = 3;
    public final int tileSize = originalTileSize * scale; //48x48 tile

    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; //768px
    public final int screenHeight = tileSize * maxScreenRow; //576px

    KeyHandler keyHandle = new KeyHandler();

    //Set FPS
    int FPS = 60;

    // Create game clock for animation.
    Thread gameThread;

    TileManager tileM = new TileManager(this);
    Character player = new Character(this, keyHandle);

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); //instead of drawing every single objects, draw them all on an image and render the whole image.
        this.addKeyListener(keyHandle);
        this.setFocusable(true); //make the gamePanel focus on receiving key input.
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    //Starting a game thread will automatically call the run method. The game loop will be inside this run method.
    @Override
    public void run() {
        double drawInterval = 1000000000/FPS; //60 frames per second ->0.01666sec/frame.
//        double nextDrawTime = System.nanoTime() + drawInterval; //draw new screen after every 0.01666 sec.

        while (gameThread != null) {
            // Update character position
            update();
            // draw the screen with the updated info
            repaint();

            try {
                Thread.sleep((long) drawInterval/1000000); //delaying the update and draw of new screen.

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void update() {
            player.update();
    }

    public void paintComponent(Graphics g) {    //Graphics is a class that provides many functions to draw an object.
        super.paintComponent(g); // This will call the method in JComponent class which is the parent of JPanel class.

        Graphics2D g2 = (Graphics2D) g; //Graphics2D class is subclass of Graphics that provides more complex control over geometry, coordinate transformations, color, text layout.

        tileM.draw(g2);
        player.draw(g2);

        g2.dispose(); //dispose this graphics and release any system resources it is using. Purpose is to save memory.
    }
}