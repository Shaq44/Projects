import javax.swing.*;

public class  SnakeFrame extends JFrame{
SnakePanel snakepanel = new SnakePanel();
public SnakeFrame(){

//tomorrow I will add a title screen with a play button that start the game 
//I will also add a timer and a score tracker 



//this frame holds the components of the snake game and loads in the middle of the screen

this.getContentPane().add(snakepanel);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setResizable(false);
this.setTitle("SNAKE");
this.pack();
this.setLocationRelativeTo(null);
this.setVisible(true);

}

}

