package fhmqpd.cs3330.prelab5;


/*
 * Class definition for Talent. Takes in three strings for the constructor with 2 of them being called from methods extended from the Goon class.
 * Contains an ArrayList of jobs that represents the Talent's skill level.
 */
public class Talent extends Goon {
	private String skill;
	
	public Talent(String name, String DOB, String skill){
		super(name, DOB);
		setSkill(skill);
	}
	
	public String getSkill(){
		return this.skill;
	}
	
	protected void setSkill(String skill){
		this.skill = skill;
	}
	
}	
