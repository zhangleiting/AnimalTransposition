package ch1.gui;
import javax.swing.*;
import java.awt.*;
import ch1.view.GamePanel;
public class AppWindow extends JFrame {
    GamePanel gamePanel;
    public AppWindow(){
       setTitle("动物换位游戏");
       gamePanel = new GamePanel();
       gamePanel.setAnimalCount(6);
       gamePanel.setLeftAnimalImage("image/cat.jpg");
       gamePanel.setRightAnimalImage("image/dog.jpg");
       add(gamePanel,BorderLayout.CENTER);
       gamePanel.setBackground(Color.white);
       JPanel northP = new JPanel();
       northP.add(gamePanel.buttonReStart);
       northP.add(gamePanel.buttonRedo);
       add(northP,BorderLayout.NORTH);        
       setBounds(60,60,9*gamePanel.width+9*gamePanel.gap,300);  
       validate();
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true); 
    }
    public static void main(String args[] ){
       AppWindow win = new AppWindow();  
    }
}