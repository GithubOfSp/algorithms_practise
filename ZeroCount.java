import java.util.Arrays;

//count the zeroes appeared in numbers from 0-N
public class ZeroCount {
	public static int[] zeroCountOfNDigit(int n)
	{
		int[] ret = new int[n];
		ret[0] = 1;
		for(int i=1; i<n; i++)
		{
			for(int j=0; j<i; j++)
			{
				ret[i] += ret[j];
				ret[i] += (i-j-1)*(int)Math.pow(10, j+1);
			}
			ret[i] *= 9;
		}
		return ret;
	}
	
	//unfinished
	
	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(zeroCountOfNDigit(10)));
	}
}
