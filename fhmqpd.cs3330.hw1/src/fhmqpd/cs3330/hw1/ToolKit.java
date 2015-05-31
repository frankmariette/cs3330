package fhmqpd.cs3330.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ToolKit {
	private ArrayList<Tool> tools;
	private static Scanner input = null;
	
	public ToolKit(){
		loadTools();
	}
	
	private void loadTools(){
		tools = new ArrayList<Tool>();
		File toolDataFile = new File("tools.txt");
		try{
			input = new Scanner(toolDataFile);
		} catch(FileNotFoundException	e){
		 	 System.out.println("Error:	Tool stats file not found.");
		 	 System.exit(0); 
		}
		
		String string = null;
		String[] tokens = null;
	 	 while (input.hasNextLine()){
	 		 string = input.nextLine();
	 		 tokens = string.split(",");
	 		 tools.add(new Tool(tokens[0], tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]))); 
	 	 }
	 	 
	 	 input.close();
	}
	
	public void displayTools(){
		Iterator<Tool> toolIT = tools.iterator();
		int i = 1;
		while (toolIT.hasNext()){
			System.out.println( i +")" + toolIT.next().toString());
			i++;
		}
		
	}
	
	public Tool getTool(int tool_index){
		return tools.get(tool_index);
	}
	
	public int getNumberOfTools(){
		return tools.size();
	}
	
	public void updateTool(int tool_index, int additional_strength){
		tools.get(tool_index).updateStrength(additional_strength);

	}
	
}
