package practicetest;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {

		System.out.println("enter name");
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		char[] ar = s.toCharArray();
		int count =0;
		for (char c : ar) {
			count++;
		}
		String rev="";
		for (int i = 0; i < count; i++) {
			rev=s.charAt(i)+rev;
			
		}
		System.out.println(rev);
	}

}
