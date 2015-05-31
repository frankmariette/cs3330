package fhmqpd.cs3330.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Grid {
	private ArrayList<Server> servers;
	
	public Grid(){
		loadServers();
	}
	
	private void loadServers(){
		File serverDatafile = new File("servers.txt");
		Scanner input = null;
		
		try{
			input = new Scanner(serverDatafile);
		} catch (FileNotFoundException e){
			System.out.println("Unable to load servers");
			System.exit(-1);
		}
		
		servers = new ArrayList<Server>();
		String string = null;
		String[] tokens = null;
	 	 while (input.hasNextLine()){
	 		 string = input.nextLine();
	 		 tokens = string.split(",");
	 		 servers.add(new Server(tokens[0], tokens[1], Integer.parseInt(tokens[2]))); 
	 	 }
	 	 
	 	 input.close();
		
		
		
	}
	
	public int search(String name){
		for(int i = 0; i < servers.size(); i++){
			if(name.equals(servers.get(i))){
				return i;
			}
		}
		
		return -1;
	}
	
	public int numberOfServers(){
		return servers.size();
	}
	
	public int attack(Tool tool, int server){
		int result;
		Server target_server = servers.get(server);
		System.out.println(target_server.toString());
		
		if( tool.getType().equals("BASHER")){
			if( target_server.getType().equals("UNENCRYPTED")){
				if(tool.getStrength() > target_server.getStrength()){
					result = 10000;
				}
				else{ // Tool isn't strong enough
					result = -10;
				}
			}
			else { // Wrong tool type
				result = -30;
			}
		}
		else {
			if (target_server.getType().equals("ENCRYPTED")){
				if ( tool.getStrength() > target_server.getStrength()){
					result = 10000;
				}
				else {
					result = -20;
				}
			}
			else {
				result = -30;
			}
		}
		
		return result;
	}

}
