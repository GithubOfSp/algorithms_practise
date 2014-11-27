package dp;

import java.util.HashMap;

//calculate the total count of association ways of a boolean expression to get a certain result
public class BooleanExp {
	public static int solveRe(String exp, boolean expectantResult)
	{
		assert(exp.length()%2==1);
		if(exp.length()==1)
		{
			assert(exp.equals("0")||exp.equals("1"));
			return (exp.equals("0")&&!expectantResult||exp.equals("1")&&expectantResult)?1:0;
		}
		int ret = 0;
		for(int i=1; i<exp.length(); i+=2)
		{
			assert(exp.charAt(i)=='&'||exp.charAt(i)=='|'||exp.charAt(i)=='^');
			switch(exp.charAt(i))
			{
			case '&':
				if(expectantResult)
				{
					ret += solveRe(exp.substring(0, i), true)*solveRe(exp.substring(i+1), true);
				}
				else
				{
					ret += solveRe(exp.substring(0, i), false)*solveRe(exp.substring(i+1), true);
					ret += solveRe(exp.substring(0, i), false)*solveRe(exp.substring(i+1), false);
					ret += solveRe(exp.substring(0, i), true)*solveRe(exp.substring(i+1), false);
				}
				break;
			case '|':
				if(expectantResult)
				{
					ret += solveRe(exp.substring(0, i), false)*solveRe(exp.substring(i+1), true);
					ret += solveRe(exp.substring(0, i), false)*solveRe(exp.substring(i+1), false);
					ret += solveRe(exp.substring(0, i), true)*solveRe(exp.substring(i+1), false);
				}
				else
				{
					ret += solveRe(exp.substring(0, i), false)*solveRe(exp.substring(i+1), false);
				}
				break;
			case '^':
				if(expectantResult)
				{
					ret += solveRe(exp.substring(0, i), true)*solveRe(exp.substring(i+1), false);
					ret += solveRe(exp.substring(0, i), false)*solveRe(exp.substring(i+1), true);
				}
				else
				{
					ret += solveRe(exp.substring(0, i), true)*solveRe(exp.substring(i+1), true);
					ret += solveRe(exp.substring(0, i), false)*solveRe(exp.substring(i+1), false);
				}
				break;
			default:
				return -1;
			}
		}
		return ret;
	}
	
	public static int solveReDp(String exp, boolean expectantResult, HashMap<String, Integer> map)
	{
		assert(exp.length()%2==1);
		if(exp.length()==1)
		{
			assert(exp.equals("0")||exp.equals("1"));
			return (exp.equals("0")&&!expectantResult||exp.equals("1")&&expectantResult)?1:0;
		}
		if(map==null) map = new HashMap<String, Integer>();
		if(map.containsKey(exp+expectantResult)) return map.get(exp+expectantResult);
		int ret = 0;
		for(int i=1; i<exp.length(); i+=2)
		{
			assert(exp.charAt(i)=='&'||exp.charAt(i)=='|'||exp.charAt(i)=='^');
			switch(exp.charAt(i))
			{
			case '&':
				if(expectantResult)
				{
					ret += solveReDp(exp.substring(0, i), true, map)*solveReDp(exp.substring(i+1), true, map);
				}
				else
				{
					ret += solveReDp(exp.substring(0, i), false, map)*solveReDp(exp.substring(i+1), true, map);
					ret += solveReDp(exp.substring(0, i), false, map)*solveReDp(exp.substring(i+1), false, map);
					ret += solveReDp(exp.substring(0, i), true, map)*solveReDp(exp.substring(i+1), false, map);
				}
				break;
			case '|':
				if(expectantResult)
				{
					ret += solveReDp(exp.substring(0, i), false, map)*solveReDp(exp.substring(i+1), true, map);
					ret += solveReDp(exp.substring(0, i), false, map)*solveReDp(exp.substring(i+1), false, map);
					ret += solveReDp(exp.substring(0, i), true, map)*solveReDp(exp.substring(i+1), false, map);
				}
				else
				{
					ret += solveReDp(exp.substring(0, i), false, map)*solveReDp(exp.substring(i+1), false, map);
				}
				break;
			case '^':
				if(expectantResult)
				{
					ret += solveReDp(exp.substring(0, i), true, map)*solveReDp(exp.substring(i+1), false, map);
					ret += solveReDp(exp.substring(0, i), false, map)*solveReDp(exp.substring(i+1), true, map);
				}
				else
				{
					ret += solveReDp(exp.substring(0, i), true, map)*solveReDp(exp.substring(i+1), true, map);
					ret += solveReDp(exp.substring(0, i), false, map)*solveReDp(exp.substring(i+1), false, map);
				}
				break;
			default:
				return -1;
			}
		}
		map.put(exp+expectantResult, ret);
		return ret;
	}
	
	public static void main(String[] args)
	{
		System.out.println(solveReDp("1^0|0|1", false, null));
	}
}
