import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StopWatch implements ActionListener{
JFrame frame = new JFrame("StopWatch");
JButton startButton = new JButton("Start");
JButton stopButton = new JButton("Stop");
JButton resetButton = new JButton("Reset");
JLabel time = new JLabel();
private int elapsedTime = 0;
private int hrs = 0;
private int min = 0;
private int sec = 0;
private boolean start = false;
private String sec_String = String.format("%02d",sec);
private String min_String = String.format("%02d",min);
private String hrs_String = String.format("%02d",hrs);
public StopWatch(){
frame.add(startButton);
frame.add(stopButton);
frame.add(resetButton);
frame.add(time);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(500,500);
frame.getContentPane().setBackground(Color.BLACK);
frame.setLayout(null);
frame.setVisible(true);

time.setText(hrs_String + ":" + min_String + ":" + sec_String);
time.setBounds(100,100,225,100);
time.setFont(new Font("FS_BOLD",Font.PLAIN,35));
time.setBorder(BorderFactory.createBevelBorder(1));
time.setOpaque(true);
time.setHorizontalAlignment(JTextField.CENTER);


startButton.setBounds(100,200,75,50);
startButton.setFont(new Font("FS_BOLD",Font.PLAIN,20));
startButton.setFocusable(false);
startButton.addActionListener(this);

stopButton.setBounds(170,200,75,50);
stopButton.setFont(new Font("FS_BOLD",Font.PLAIN,20));
stopButton.setFocusable(false);
stopButton.addActionListener(this);

resetButton.setBounds(240,200,75,50);
resetButton.setFont(new Font("FS_BOLD",Font.PLAIN,20));
resetButton.setFocusable(false);
resetButton.addActionListener(this);

}
Timer clock = new Timer(1000,new ActionListener(){
public void actionPerformed(ActionEvent e){
elapsedTime = elapsedTime + 1000;
hrs = (elapsedTime/3600000);
min = (elapsedTime/60000)%60;
sec = (elapsedTime/1000)%60;
sec_String = String.format("%02d",sec);
min_String = String.format("%02d",min);
hrs_String = String.format("%02d",hrs);
time.setText(hrs_String + ":" + min_String + ":" + sec_String);

}
});

public void actionPerformed(ActionEvent e){
if(e.getSource() == startButton){
start();
}else if(e.getSource() == stopButton){
stop();
} else if(e.getSource() == resetButton){
reset();
}
}
private void start(){
clock.start();
}

private void stop(){
clock.stop();
}

private void reset(){
clock.stop();
elapsedTime = 0;
sec = 0;
min = 0;
hrs = 0;
sec_String = String.format("%02d",sec);
min_String = String.format("%02d",min);
hrs_String = String.format("%02d",hrs);

}
}

