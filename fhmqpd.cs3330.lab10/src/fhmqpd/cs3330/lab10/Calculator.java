package fhmqpd.cs3330.lab10;
/**
 * Name: Francois Mariette
 * PawPrint: FHMQPD
 * Submission Code: Sunny
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class Calculator extends JFrame{
	
	private JTextField textField = new JTextField();
	private JButton btn0;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btn10;
	private JButton btn11;
	private JButton btn12;
	private JButton btn13;
	private JButton btn14;
	private JButton btntan;
	private JButton btncos;
	private JButton btnsin;
	private JButton btnequals;
	private JPanel panel1;
	private JPanel panel2;
	
	public Calculator(){
		
		super("Calculator");
		setLayout(new FlowLayout());
		textField.setHorizontalAlignment(JTextField.RIGHT);
		textField.setEditable(false);
		panel1 = new JPanel();
		panel1.setSize(300,300);
		
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(5,4,4,4));
		panel2.setSize(200,200);
		
		panel1.add(panel2, BorderLayout.NORTH);
		
		btn1 = new JButton("1");
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		btn4 = new JButton("4");
		btn5 = new JButton("5");
		btn6 = new JButton("6");
		btn7 = new JButton("7");
		btn8 = new JButton("8");
		btn9 = new JButton("9");
		btn0 = new JButton("0");
		btn10= new JButton("/");
		btn11= new JButton("*");
		btn12= new JButton("-");
		btn13= new JButton("+");
		
		
		//add panels
		panel2.add(textField);
		panel2.add(btn7);
		panel2.add(btn8);
		panel2.add(btn9);
		panel2.add(btn11);
		panel2.add(btn4);
		panel2.add(btn5);
		panel2.add(btn6);
		panel2.add(btn12);
		panel2.add(btn1);
		panel2.add(btn2);
		panel2.add(btn3);
		panel2.add(btn13);
		panel2.add(btn0);
	
	}	
	
	private class ButtonHandler implements ActionListener{
			
			private String output = "";
			
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				if(event.getSource() == btn0){
					output += 0;
				}
			}
	}


	public static void main(String[] args){
		Calculator calculator = new Calculator();
		calculator.setSize(300,300);
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculator.setVisible(true);
	}


}

