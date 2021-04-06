import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Game implements ActionListener{

private int elapsedTime = 0;
private int min = 0;
private int sec = 0;
private String min_String = String.format("%02d" , min);
private String sec_String = String.format("%02d", sec);
JFrame frame = new JFrame("SnakeGame");
//JLabel Time = new JLabel();
JLabel Title = new JLabel ("SNAKE");
JButton Start = new JButton("Start");
JButton Pause = new JButton ("Pause");
//JButton Play = new JButton("Play");
JLabel screen = new JLabel("NEW SCREEN");


public Game(){
Title.setBounds(200,100,400,250);
//Title.setPreferredSize(new Dimension (500,500));
Title.setFont(new Font("FS_BOLD",Font.PLAIN,90));
//Title.setBorder(BorderFactory.createBevelBorder(1));
Title.setForeground(Color.GREEN);
Title.setHorizontalAlignment(JTextField.CENTER);

Start.setBounds(250,300,300,200);
Start.setBackground(Color.yellow);
Start.setForeground(Color.blue);
Start.setFont(new Font("FS_BOLD",Font.PLAIN,70));
Start.setFocusable(false);
Start.addActionListener(this);

frame.add(Start);
frame.add(Title);
frame.setResizable(false);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(800,800);
frame.getContentPane().setBackground(Color.BLACK);
frame.setLayout(null);
frame.setVisible(true);
}

public void gameScreen(){
Title.setVisible(false);
Start.setVisible(false);
Pause.setBounds(250,300,300,250);
Pause.setFont(new Font("FS_BOLd",Font.PLAIN,90));
Pause.setHorizontalAlignment(JTextField.CENTER);
frame.add(Pause);
}

public void actionPerformed(ActionEvent e){
if(e.getSource() == Start){
gameScreen();

}
}
}
