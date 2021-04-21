import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;

public class SnakePanel extends JPanel implements ActionListener{

// these two feild instances define the size of the panel
final int screen_width = 800;
final int screen_height = 800;
//this feild instance shows the unit size of the snake and enemies
private int unit_size = 25;
private int game_units = (screen_width*screen_height)/unit_size;
//these two feild instances are the coordinates of the snakes body 
int x[]  = new int[game_units];
int y[]  = new int [game_units];
private int body = 3;
int enemyX;
int enemyY;
int score;
int elapsedtime = 0;
int sec = 0;
int min = 0 ;
private String sec_String = String.format("%02d",sec);
private String min_String = String.format("%02d",min);
private String score_String = String.format("%02d",score);
boolean left = false;
boolean right = true;
boolean up = false;
boolean down = false;
int Delay = 75;
boolean gameRunning = true;
Random random;
Timer time;
JLabel Score = new JLabel();
JLabel Timer = new JLabel();




public SnakePanel(){

random = new Random();

this.setPreferredSize(new Dimension(screen_width,screen_height));
this.add(Score);
this.setBackground(Color.BLACK);
this.setFocusable(true);
this.addKeyListener(new Keys());

Score.setText(score_String);
Score.setBounds(50,25,70,70);
Score.setFont(new Font ("FS_BOLD",Font.PLAIN,35));
Score.setBorder(BorderFactory.createBevelBorder(1));
Score.setForeground(Color.green);
Score.setBackground(Color.black);
Score.setOpaque(true);

Timer.setText(min_String + ":" + sec_String);
Timer.setBounds(0,0,70,70);
Timer.setFont(new Font("FS_BOLd",Font.PLAIN,35));
Timer.setBorder(BorderFactory.createBevelBorder(1));
Timer.setForeground(Color.green);
Timer.setBackground(Color.white);
Timer.setOpaque(true);  

startGame();
}

@Override
public void actionPerformed(ActionEvent e){
if(gameRunning){
move();
enemyEaten();
checkCollision();
String score_String = String.format("%02d",score);
Score.setText(score_String);
elapsedtime = elapsedtime + 1000;
min = (elapsedtime/60000)%60;
sec = (elapsedtime/1000)%60;
Timer.setText(min_String + ":" + sec_String);

}
repaint();

}

public void stop(){

time.stop();

}

//this method allows the snake to travel passed the border and appear on the other side of the border

public void checkCollision(){
for(int i=body;i>0;i--){
if((x[0] == x[i])&&(y[0]==y[i])){
gameRunning = true;
}
}
if(x[0]<0){
x[0] = screen_width;
}
if(x[0] > screen_width){
x[0] = 0;
}
if(y[0] <0){
y[0] = screen_height;
}
if(y[0] >screen_height){
y[0] = 0;
}
if(!gameRunning){
time.stop();
}
}



//this method initiates the game once the program is open

public void startGame(){
gameRunning = true;
time = new Timer(Delay,this);
newEnemy();
move();
time.start();
checkCollision();
enemyEaten();
}




//this method creates new enemies randomly in the game. you have a x and y coordinate that
//uses the Random class and takes the height and width and divides it by the unit size and multiply
//the created are then put in the x and y arguments in fillOval to create new enemies

public void newEnemy(){
enemyX = random.nextInt((int)(screen_width/unit_size))*unit_size;
enemyY = random.nextInt((int)(screen_height/unit_size))*unit_size;
}



//this enemyEaten method checks if an enemy has been eaten and keeps track of the score


public void enemyEaten(){
if((x[0] == enemyX)&&(y[0] == enemyY)){
body++;
score++;
newEnemy();
}
}

public void paintComponent(Graphics g){
super.paintComponent(g);
g.setColor(Color.RED);
g.fillOval(enemyX,enemyY,unit_size,unit_size);

for(int i=0;i<body;i++){
if(i==0){
g.setColor(Color.green);
g.fillOval(x[i],y[i],unit_size,unit_size);
}else {
g.setColor(new Color(45,180,0));
g.fillOval(x[i],y[i],unit_size,unit_size);
}

}
}



//This move method is connects to the Keys class and allows the the snake to move 



public void move(){
for(int i=body;i>0;i--){

x[i] = x[(i-1)];
y[i] = y[(i-1)];

}

if(right){
x[0]+=unit_size;;
}

if(left){
x[0]-=unit_size;
}

if(up){
y[0]-=unit_size;;
}
if(down){
y[0]+=unit_size;
}


}





//This class is used as an object in the parent class and extends the KeyAdapter
//it extends the KeyAdapter cause it only uses the KeyPressed method and added to the outer class
//you can only use the extends keyword once per class.


public class Keys extends KeyAdapter{


@Override
public void keyPressed(KeyEvent e){
int key = e.getKeyCode();

if((key == e.VK_W)&&(!down)){
up = true;
left = false;
right = false;
}
if((key == e.VK_S)&&(!up)){
down = true;
left = false;
right = false;
}
if((key == e.VK_D)&&(!left)){
right = true;
up = false;
down = false;
}
if((key == e.VK_A)&&(!right)){
left = true;
up = false;
down = false;
}

if(key == e.VK_SPACE){
time.stop();
}

if(key == e.VK_J){
time.start();
}

}


}


}











