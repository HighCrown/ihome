package com.ihome.util;

import java.util.Random;

public class CodeUtil {
	
	
	public static String getCode(){
		String content = "1234567890";
		Random random = new Random();
		String result = "";
		for(int i =0 ;i<6;i++){
			int index = random.nextInt(content.length());
			char c = content.charAt(index);
			result+=c;
		}
		return result;
	}
	

}
