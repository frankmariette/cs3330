package fhmqpd.cs3330.prelab5;

/*
 * Class definition for Don. Takes in three strings and an int for the constructor with 2 of them being called from methods extended from the Goon class.
 */
public class Don extends Goon {
	private String mobName;
	private int netWorth;
	
	public Don(String name, String DOB, String mobName, int netWorth){
		super(name, DOB);
		setNetWorth(netWorth);
		setMobName(mobName);
	}
	
	public int getNetWorth(){
		return this.netWorth;
	}
	
	protected void setNetWorth(int netWorth){
		this.netWorth = netWorth;
	}
	
	public String getMobName(){
		return this.mobName;
	}
	
	protected void setMobName(String mobName){
		this.mobName = mobName;
	}
	
}
