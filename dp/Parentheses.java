package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Parentheses {
	public static List<String> solveDp(int n)
	{
		List<List<String>> dp = new ArrayList<List<String>>();
		List<String> theNull = new LinkedList<String>(){{add("");}};
		dp.add(theNull);
		for(int i=1; i<=n; i++)
		{
			List<String> parenthese = new LinkedList<String>();
			for(int j=0; j<i; j++)
			{
				for(String left:dp.get(j))
				{
					for(String right:dp.get(i-1-j))
					{
						parenthese.add("("+left+")"+right);
//						parenthese.add(left+"("+right+")");
					}
				}
			}
			dp.add(parenthese);
		}
		return dp.get(n);
	}
	
	public static void main(String[] args)
	{
		System.out.println(solveDp(4));
	}
}
