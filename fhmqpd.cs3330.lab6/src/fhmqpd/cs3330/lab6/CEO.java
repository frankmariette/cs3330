package fhmqpd.cs3330.lab6;

public class CEO extends Employee {
	private int netWorth;
	
	public CEO(String name, int SSN, int netWorth){
		super(name, SSN);
		setNetWorth(netWorth);
	}

	protected void setNetWorth(int netWorth) {
		this.netWorth = netWorth;
		
	}
	
	public int getNetWorth(){
		return netWorth;
	}
	
	@Override
	public String toString(){
		return "CEO " + super.getName() + "\n\tSSN: " + super.getSSN() + "\n\tNet Worth: " + this.getNetWorth();
	}
}
