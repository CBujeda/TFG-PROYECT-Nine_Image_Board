package com.nib.app.utils;

public class NIBShell {

	public NIBShell() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void print() {
		
	}
	
	public void printInfo(String str) {
	    String YELLOW_BOLD = "\033[1;33m"; // YELLOW
	    String PURPLE_BOLD = "\033[1;35m"; // PURPLE
	    String RESET = "\033[0m"; // RESET
	    String date = java.time.Clock.systemUTC().instant().toString();
		System.out.println(date.substring(0, date.length()-1)+"  "+YELLOW_BOLD+"[NIB] "+PURPLE_BOLD+"    --- "+RESET + str);
	}
	
	public void printInfoSql(String str) {
	    String YELLOW_BOLD = "\033[1;33m"; // YELLOW
	    String CYAN	= "\u001B[36m";
	    String PURPLE_BOLD = "\033[1;35m"; // PURPLE
	    String RESET = "\033[0m"; // RESET
	    String date = java.time.Clock.systemUTC().instant().toString();
		System.out.println(date.substring(0, date.length()-1)+"  "+YELLOW_BOLD+"[NIB] "+CYAN+"[SQL] "+PURPLE_BOLD+"    --- "+RESET + str);
	}
}
