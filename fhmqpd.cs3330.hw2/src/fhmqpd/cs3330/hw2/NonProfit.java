package fhmqpd.cs3330.hw2;

public class NonProfit extends Business{
	public NonProfit(String name, String contact, Grid grid){
		super(name, contact, grid);
	}
	
	@Override
	public String toString(){
		return "[Contact " + this.getContact() + "   Non Profit: " + this.getName();
	}
}
