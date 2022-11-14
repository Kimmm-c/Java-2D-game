import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Java Adventure Game");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack(); //set the window to the size of gamePanel.

        window.setLocationRelativeTo(null); //Window location not specified -> Window will be displayed at the center of the screen.
        window.setVisible(true);

        gamePanel.startGameThread();
    }
}