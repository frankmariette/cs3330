package fhmqpd.cs3330.hw2;

import java.util.ArrayList;
import java.util.Random;

public class Business {
	private String name;
	private String contacts_name;
	private ArrayList<Job> jobOffers;
	protected Grid grid;
	protected int JOB_OFFER_SIZE = 10;
	
	public Business ( String name, String contact, Grid grid){
		setBusinessName(name);
		setGrid(grid);
		setBusinessContact(contact);
		fillJobOffers();
	}

	private void setBusinessContact(String contact) {
		this.contacts_name = contact;
		
	}

	private void setGrid(Grid grid) {
		this.grid = grid;
		
	}

	private void setBusinessName(String name) {
		this.name = name;
	}
	
	protected String getName(){
		return this.name;
	}
	
	protected String getContact(){
		return this.contacts_name;
	}
	
	protected void fillJobOffers(){
		Random randomNum = new Random();
		jobOffers = new ArrayList<Job>(JOB_OFFER_SIZE);
		int server_idx;
		String address = null;
		for (int i = 0; i < JOB_OFFER_SIZE; i++){
			server_idx = randomNum.nextInt(this.grid.numberOfServers());
			address = grid.getServerName(server_idx);
			jobOffers.add(new Job(address, determineWorth()));
		}
		
		
		
	}
	
	public void viewJobOffers(){
		for (int i = 0; i < jobOffers.size(); i++){
			System.out.println((i+1) + ") " + jobOffers.get(i).getTargetAddress() + " worth " + jobOffers.get(i).getReward() );
		}
	}
	
	public Job getJobOffer(int job_offer){
		return jobOffers.get(job_offer);
	}
	
	public int getJobOfferCount(){
		return jobOffers.size();
	}
	
	protected int determineWorth(){
		Random randNum = new Random();
		int worth = randNum.nextInt(15000) + 10000;
		return worth;
	}
}
