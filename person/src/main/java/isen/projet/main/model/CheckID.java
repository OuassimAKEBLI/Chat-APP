package isen.projet.main.model;

public class CheckID {
	
	/*
	 * this function check if the string can be an integer or not
	 * @param: String strNum
	 * @return : Boolean
	 * @author : Ouassim AKEBLI
	 * */
	public boolean chek_id(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        @SuppressWarnings("unused")
			int change = Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
}
