package fhmqpd.cs3330.prelab5;

/*
 * Class definition for Overseer. Takes in three strings for the constructor with 2 of them being called from methods extended from the Goon class.
 */
public class Overseer extends Goon {
	private String sector;
	
	public Overseer(String name, String DOB, String sector){
		super(name, DOB);
		setSector(sector);
	}
	
	public String getSector(){
		return this.sector;
	}
	
	protected void setSector(String sector){
		this.sector = sector;
	}

}

