package dp;

import java.util.LinkedList;
import java.util.List;

public class NQueens {
	public static List<int[]> solveRe(int[] onBoard, int n)
	{
		List<int[]> ret = new LinkedList<int[]>();
		if(onBoard.length==n) 
		{
			ret.add(onBoard);
			return ret;
		}
		for(int i=0; i<n; i++)
		{
			boolean conflict = false;
			for(int j=0; j<onBoard.length; j++)
			{
				if(onBoard[j]==i || onBoard.length-j==Math.abs(i-onBoard[j]))
				{
					conflict = true;
					break;
				}
			}
			if(!conflict)
			{
				int[] newOnBoard = new int[onBoard.length+1];
				System.arraycopy(onBoard, 0, newOnBoard, 0, onBoard.length);
				newOnBoard[onBoard.length] = i;
				ret.addAll(solveRe(newOnBoard, n));
			}
		}
		return ret;
	}
	
	public static void main(String[] args)
	{
		System.out.println(solveRe(new int[0], 4).size());
	}
}
