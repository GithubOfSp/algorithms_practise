package dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//split n cents into several 25cent, 10cent, 5cent and 1cent
public class CentsCombination {
	enum Cent
	{
		cent1, cent5, cent10, cent25;
	}
	public static List<int[]> solveRe(Cent maxCent, int n)
	{
		List<int[]> ret = new LinkedList<int[]>();
		if(maxCent==Cent.cent1)
		{
			int[] temp = new int[4];
			temp[3] = n;
			ret.add(temp);
		}
		else if(maxCent==Cent.cent5)
		{
			for(int i=0; 5*i<=n; i++)
			{
				for(int[] array:solveRe(Cent.cent1, n-5*i))
				{
					array[2] = i;
					ret.add(array);
				}
			}
		}
		else if(maxCent==Cent.cent10)
		{
			for(int i=0; 10*i<=n; i++)
			{
				for(int[] array:solveRe(Cent.cent5, n-10*i))
				{
					array[1] = i;
					ret.add(array);
				}
			}
		}
		else
		{
			for(int i=0; 25*i<=n; i++)
			{
				for(int[] array:solveRe(Cent.cent10, n-25*i))
				{
					array[0] = i;
					ret.add(array);
				}
			}
		}
		return ret;
	}
	
	public static int solveRe(int value, int n)
	{
		int nextValue = 0;
		switch(value)
		{
			case 25:
				nextValue = 10;
				break;
			case 10:
				nextValue = 5;
				break;
			case 5:
				nextValue = 1;
				break;
			case 1:
				return 1;
			default:
				return 0;
		}
		int ret = 0;
		for(int i=0; i*value<=n; i++)
		{
			ret += solveRe(nextValue, n-i*value);
		}
		return ret;
	}
	
	public static void main(String[] args)
	{
		for(int[] array:solveRe(Cent.cent25, 26))
			System.out.println(Arrays.toString(array));
		System.out.println(solveRe(25, 26));
	}
}
