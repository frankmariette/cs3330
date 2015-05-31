package fhmqpd.cs3330.hw2;

public class Corporation extends Business{
	
	public Corporation(String name, String contact, Grid grid) {
		super(name, contact, grid);
	}
	
	@Override
	public String toString(){
		return "[Contact " + this.getContact() + "   Coporation: " + this.getName();
	}
}
