package fhmqpd.cs3330.hw2;

public class Job {
	private String target_address;
	private int reward;
	
	public Job(String target_address, int reward){
		setReward(reward);
		setTargetAddress(target_address);
	}

	private void setTargetAddress(String target_address) {
		this.target_address = target_address;
		
	}

	private void setReward(int reward) {
		this.reward = reward;
	}
	
	public int getReward(){
		return this.reward;
	}
	
	public String getTargetAddress(){
		return this.target_address;
	}
}
