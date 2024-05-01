package com.springsecuritybyeazybytes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@SpringBootApplication
public class EasyBankBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyBankBackendApplication.class, args);

		String bgColorYellow = "\u001B[103m";
		String greenColorCode = "\u001B[32;1m";
		String resetColorCode = "\u001B[0m";
		System.out.println(  greenColorCode + bgColorYellow +"   Hello Piyush   " + resetColorCode );


		String str = "azzbcdaccbd";
		System.out.println(characterCount(str));
	}
    public static String characterCount(String str) {
		Map<Character,Integer> map = new HashMap<>();
		for(int i=0;i<str.length();i++)  {
			char ch = str.charAt(i);
			if(map.containsKey(ch)) {
				int count = map.get(ch);
				count++;
				map.put(ch, count);

			} else{
				map.put(ch, 1);
			}
		}
		StringBuilder result = new StringBuilder();
		for(Map.Entry<Character,Integer> entry:map.entrySet()){
			result.append(entry.getKey() + " " + entry.getValue()+", ");
		}
		return result.toString();
	}

}
