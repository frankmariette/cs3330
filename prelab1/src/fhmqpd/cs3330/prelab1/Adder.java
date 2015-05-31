/**
 * 
 */
package fhmqpd.cs3330.prelab1;

/**
 * @author fhmqpd
 *
 */
public class Adder {

	private int num1;
	private int num2;
	
	public Adder( int x, int y){
		setNum1(x);
		setNum2(y);
	}
	
	public int getNum1(){
		return num1;
	}
	
	public int getNum2(){
		return num2;
	}
	
	public int add(){
		return num1 + num2;
	}
	
	private void setNum1(int n){
		num1 = n;
	}
	
	private void setNum2(int n){
		num2 = n;
	}
}
