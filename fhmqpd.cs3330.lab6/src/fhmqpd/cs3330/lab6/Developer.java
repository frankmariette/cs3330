package fhmqpd.cs3330.lab6;

public class Developer extends Employee {
	private String langProf;
	
	public Developer(String name, int ssn, String langProf){
		super(name, ssn);
		setLangProf(langProf);
	}
	
	protected void setLangProf(String langProf){
		this.langProf = langProf;
	}
	
	public String getLangProf(){
		return langProf;
	}
	
	@Override
	public String toString(){
		return "Developer " + super.getName() + "\n\tSSN: " + super.getSSN() + "\n\tLanguage Proficiency: " + this.getLangProf();
	}
}
