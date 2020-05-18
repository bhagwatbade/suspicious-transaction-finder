package com.stf.utils;

/**
 * Common utility class for application
 * 
 * @author bhagwat
 *
 */
public class StfUtils {

	public static boolean stringNullEmptyCheck(String value){
		if(value == null){
			return false;
		}else{
			return value.trim().equals("");
		}
	}
}
