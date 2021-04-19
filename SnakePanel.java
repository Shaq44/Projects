import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;

public class SnakePanel extends JPanel implements ActionListener{
final int screen_width = 800;
final int screen_height = 800;
private int unit_size = 25;
private int game_units = (screen_width*screen_height)/unit_size;
int x[]  = new int[game_units];
int y[]  = new int [game_units];
private int body = 3;
int enemyX;
int enemyY;
int score;
boolean left = false;
boolean right = true;
boolean up = false;
boolean down = false;
int Delay = 75;
boolean gameRunning = true;
Random random;
Timer time;


public SnakePanel(){

random = new Random();

this.setPreferredSize(new Dimension(screen_width,screen_height));
this.setBackground(Color.BLACK);
this.setFocusable(true);
this.addKeyListener(new Keys());
startGame();
}

@Override
public void actionPerformed(ActionEvent e){
if(gameRunning){
move();
enemyEaten();
checkCollision();
}
repaint();
}


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

public void startGame(){
gameRunning = true;
time = new Timer(Delay,this);
newEnemy();
move();
time.start();
checkCollision();
enemyEaten();
}

public void newEnemy(){
enemyX = random.nextInt((int)(screen_width/unit_size))*unit_size;
enemyY = random.nextInt((int)(screen_height/unit_size))*unit_size;
}


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
}

}


}














