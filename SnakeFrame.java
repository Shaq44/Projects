import javax.swing.*;

public class  SnakeFrame extends JFrame{
SnakePanel snakepanel = new SnakePanel();
public SnakeFrame(){


this.getContentPane().add(snakepanel);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setResizable(false);
this.setTitle("SNAKE");
this.pack();
this.setLocationRelativeTo(null);
this.setVisible(true);

}

}

