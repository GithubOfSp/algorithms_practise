package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

//calculate the max height of different stack of several boxes. an upper box has smaller height, length and width than a lower box in a stack
public class BoxStack {
	static class Box
	{
		int length;
		int width;
		int height;
	}
	static boolean stackable(Box upper, Box lower)
	{
		return lower.length>upper.length&&lower.width>upper.width&&lower.height>upper.height;
	}
	
	static int maxHeightWhenBoxNAsBottom(Box[] boxes, int n)
	{
		int maxHeight = 0;
		for(int i=0; i<boxes.length; i++)
		{
			if(stackable(boxes[i], boxes[n]))
			{
				int height = maxHeightWhenBoxNAsBottom(boxes, i);
				if(height>maxHeight) maxHeight = height;
			}
		}
		return maxHeight+boxes[n].height;
	}
	public static int solveRe(Box[] boxes)
	{
		int ret = 0;
		for(int i=0; i<boxes.length; i++)
		{
			int height = maxHeightWhenBoxNAsBottom(boxes, i);
			if(height>ret) ret = height;
		}
		return ret;
	}
	
	//a dp solution with a map to store intermediate value
	static int maxHeightWhenBoxNAsBottom(Box[] boxes, int n, HashMap<Integer, Integer> map)
	{
		if(map.containsKey(n)) return map.get(n);
		int maxHeight = 0;
		for(int i=0; i<boxes.length; i++)
		{
			if(stackable(boxes[i], boxes[n]))
			{
				int height = maxHeightWhenBoxNAsBottom(boxes, i, map);
				if(height>maxHeight) maxHeight = height;
			}
		}
		map.put(n, maxHeight+boxes[n].height);
		return maxHeight+boxes[n].height;
	}
	public static int solveReDp(Box[] boxes)
	{
		int ret = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<boxes.length; i++)
		{
			int height = maxHeightWhenBoxNAsBottom(boxes, i, map);
			if(height>ret) ret = height;
		}
		return ret;
	}
	
	public static void main(String[] args)
	{
		Box[] boxes = new Box[5];
		Random ran = new Random();
		for(int i=0; i<boxes.length; i++)
		{
			boxes[i] = new Box();
			boxes[i].height = 1+ran.nextInt(5);
			boxes[i].length = 1+ran.nextInt(5);
			boxes[i].width = 1+ran.nextInt(5);
			System.out.println(boxes[i].height+" "+boxes[i].length+" "+boxes[i].width);
		}
		System.out.println(solveReDp(boxes));
	}
}
