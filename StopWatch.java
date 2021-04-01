import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StopWatch{
JFrame frame = new JFrame("StopWatch");
//JButton startButton = new JButton("Start");
//JButton stopButton = new JButton("Stop");
//JButton resetButton = new JButton("Reset");
//JLabel time = new JLabel();
private int elapsedTime = 0;
private int hrs = 0;
private int min = 0;
private int sec = 0;
private boolean start = false;
private String sec_String = String.format("%02d",sec);
private String min_String = String.format("%02d",min);
private String hrs_String = String.format("%02d",hrs);
public StopWatch(){
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(500,500);
frame.setLayout(null);
frame.setVisible(true);
}
}
