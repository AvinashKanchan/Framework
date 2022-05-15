package practicetest;

import java.util.LinkedHashSet;

public class Test2 {

	public static void main(String[] args) {

		String s="my name is my name";
		String[] ar = s.split(" ");
		LinkedHashSet<String> lhs=new LinkedHashSet<String>();
		for (int i = 0; i < ar.length; i++) {
			lhs.add(ar[i]);
		}
		for (String str : lhs) {
			int count=0;
			for (int j = 0; j < ar.length; j++) {
				if(str.equals(ar[j]))
				{
					count++;
				}
			}
			if(count>1)
			{
				System.out.print(str+" ");
			}
		}
	}

}
