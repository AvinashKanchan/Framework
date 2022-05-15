package practice;

import java.util.LinkedHashSet;

import org.testng.annotations.Test;

public class Array {

	@Test
	public void rev()
	{
		String s ="Akshay";
		s=s.toLowerCase();
		String rev="";
		for(int i=0;i<s.length();i++)
		{
			rev=s.charAt(i)+rev;
		}
		System.out.println(rev);
	}
	
	@Test
	public void occurance()
	{
		String s="mahabharat";
		LinkedHashSet<Character> lhs=new LinkedHashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			lhs.add(s.charAt(i));
		}
		for (Character ch : lhs) {
			int count=0;
			for (int j = 0; j < s.length(); j++) {
				if(ch==s.charAt(j))
				{
					count++;
				}
			}
			System.out.println(ch+" = "+count);
		}
	}
	
	@Test
	public void position()
	{
		String s="tester";
		LinkedHashSet<Character> lhs=new LinkedHashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			lhs.add(s.charAt(i));
		}
		for (Character ch : lhs) {
			int temp=s.indexOf(ch)+1;
			System.out.println(ch+" = "+temp);
		}
	}
}
