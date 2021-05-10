import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Game implements ActionListener{

boolean Started = false;
final int screen_width = 800;
final int screen_height = 800;
final int unit_size = 50;
final int game_units = (screen_width*screen_height)/unit_size;
final int x[] = new int [game_units];
final int y[] = new int [game_units];
int bodyparts = 4;
int enemyX;
int enemyY;
boolean running = false;
//Random random;
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
}
if(e.getSource() == Pause){
pause();
}
if(e.getSource() == Start){
start();
}
}


private void start(){
clock.start();
}
private void pause(){
clock.stop();
}





public void  gameScreen(){

GamePlay gameplay = new GamePlay();
Title.setVisible(false);
Play.setVisible(false);
FlowLayout FLayOut = new FlowLayout();
header.setBounds(100,100,750,100);
header.setBackground(Color.black);


Start.setBounds(160,100,100,50);
Start.setFont(new Font("FS_BOLd",Font.PLAIN,20));
Start.setHorizontalAlignment(SwingConstants.LEFT);
Start.addActionListener(this);

time.setForeground(Color.green);
time.setBackground(Color.black);


Pause.setBounds(150,100,100,50);
Pause.setFont(new Font("FS_BOLd",Font.PLAIN,20));
Pause.setHorizontalAlignment(SwingConstants.LEFT);
Pause.addActionListener(this);
header.add(Pause);
header.add(Start);
header.add(time);
header.setLayout(FLayOut);
frame.add(header);
frame.add(gameplay);

}
public class GamePlay extends JPanel{

public  void draw(Graphics g){
for(int i=0;i<screen_height/unit_size;i++){
g.drawLine(i*unit_size,0,i*unit_size,screen_height);
g.drawLine(i*unit_size,screen_width,i*unit_size,0);
}
}

public void paintComponent(Graphics g){
super.paintComponent(g);
draw(g);
}
}

}
