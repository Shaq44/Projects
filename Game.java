import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Game implements ActionListener{

private boolean started = false;
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
JButton Play = new JButton("Play");
JLabel time = new JLabel();
JPanel header = new JPanel();


public Game(){
Title.setBounds(200,100,400,250);
//Title.setPreferredSize(new Dimension (500,500));
Title.setFont(new Font("FS_BOLD",Font.PLAIN,90));
//Title.setBorder(BorderFactory.createBevelBorder(1));
Title.setForeground(Color.GREEN);
Title.setHorizontalAlignment(JTextField.CENTER);

Play.setBounds(250,300,300,200);
Play.setBackground(Color.yellow);
Play.setForeground(Color.blue);
Play.setFont(new Font("FS_BOLD",Font.PLAIN,70));
Play.setFocusable(false);
Play.addActionListener(this);

time.setText(min_String + ":" + sec_String);
time.setBounds(200,100,100,50);
time.setFont(new Font("Verdana",Font.PLAIN,20));
time.setOpaque(true);

frame.add(Play);
frame.add(Title);
frame.setResizable(false);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(800,800);
frame.getContentPane().setBackground(Color.BLACK);
frame.setLayout(null);
frame.setVisible(true);
}

Timer clock = new Timer(1000,new ActionListener(){
public void actionPerformed(ActionEvent e){
elapsedTime = elapsedTime + 1000;
min = (elapsedTime/60000)%60;
sec = (elapsedTime/1000)%60;
min_String = String.format("%02d" , min);
sec_String = String.format("%02d", sec);
time.setText(min_String + ":" + sec_String);
}  
});

public void actionPerformed(ActionEvent e){
if(e.getSource() == Play){
gameScreen();
start();
}else if(e.getSource() == Pause){
started = false;
pause();
Pause.setText("Start");
}
}


private void start(){
clock.start();
}
private void pause(){
clock.stop();
}





public void gameScreen(){
Title.setVisible(false);
Play.setVisible(false);
header.setBounds(100,100,1000,50);
header.setBackground(Color.WHITE);


Start.setBounds(300,100,100,50);
Start.setFont(new Font("FS_BOLd",Font.PLAIN,20));
Start.setHorizontalAlignment(SwingConstants.LEFT);
Start.addActionListener(this);


Pause.setBounds(300,100,100,50);
Pause.setFont(new Font("FS_BOLd",Font.PLAIN,20));
Pause.setHorizontalAlignment(SwingConstants.LEFT);
Pause.addActionListener(this);
header.add(Pause);
header.add(time);
frame.add(header);


}




}
