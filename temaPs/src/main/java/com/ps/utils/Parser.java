package com.ps.utils;
//package com.sdms.utils;
//
//import java.util.List;
//
//public class Parser {
//	/*
//	 * private getStudentId(List<String> str, int category) {
//	 * 
//	 * return Integer.parseInt(str.get(0).split("[\t]")[0]); }
//	 */
//
//
//	private Integer getStudent(String str) {
//
//		return Integer.parseInt(str.split("[\t]")[0]);
//	}
//	
//	private Integer getCategory(String str) {
//
//		return Integer.parseInt(str.split("[\t]")[1]);
//	}
//
//	private Integer getHours(String str) {
//
//		return Integer.parseInt(str.split("[\t]")[2]);
//	}
//
//	public Integer getHoursBycategoryId(List<String> str, int category) {
//
//		for (String s : str) {
//			if (getCategory(s) == category) {
//				return getHours(s);
//			}
//		}
//		return null;
//		
//	}
//	
//	public List<String> setHoursByCategoryId(List<String>str, int category, int hoursDone){
//		String toMod = new String();
//		for (String s : str) {
//			if (getCategory(s) == category) {
//				str.remove(str.indexOf(s));
//				toMod+=this.getStudent(s)+" "+category+" "+hoursDone;
//				
//			}
//		}
//		str.add(toMod);
//		
//		return str;
//	}
//}
