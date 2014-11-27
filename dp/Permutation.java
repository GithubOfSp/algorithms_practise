package dp;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Permutation {
	public static List<String> solveDp(String s)
	{
		List<String> ret = new LinkedList<String>();
		if(s.length()>0)
		{
			ret.add(""+s.charAt(0));
			s = s.substring(1);
		}
		for(char c:s.toCharArray())
		{
			List<String> dp = new LinkedList<String>();
			for(String old:ret)
			{
				char[] cur = new char[old.length()+1];
				cur[0] = c;
				System.arraycopy(old.toCharArray(), 0, cur, 1, cur.length-1);
				dp.add(new String(cur));
				for(int j=0; j<old.length(); j++)
				{
					char temp = cur[j];
					cur[j] = cur[j+1];
					cur[j+1] = temp;
					dp.add(new String(cur));
				}
			}
			ret = dp;
		}
		return ret;
	}
	
	public static void main(String[] args)
	{
		System.out.println(solveDp("abc"));
	}
}
