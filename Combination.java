import java.util.LinkedList;
import java.util.List;


public class Combination {
	public static List<String> combination(String s, int n)
	{
//		System.out.println(s+" "+n);
		List<String> ret = new LinkedList<String>();
		if(s.length()==n)
		{
			ret.add(s);
			return ret;
		}
		if(n==1)
		{
			for(char c:s.toCharArray())
			{
				ret.add(""+c);
			}
			return ret;
		}
		for(int i=0; i<=s.length()-n; i++)
		{
			List<String> sub = combination(s.substring(i+1), n-1);
			for(String temp:sub)
			{
				ret.add(s.charAt(i)+temp);
			}
		}
		return ret;
	}
	public static void main(String[] args)
	{
		for(String s:combination("1234567890", 6))
		{
			System.out.println(s);
		}
	}
}
