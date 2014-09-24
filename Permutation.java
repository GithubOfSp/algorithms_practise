import java.util.Arrays;


public class Permutation {
	//http://stackoverflow.com/questions/4240080/generating-all-permutations-of-a-given-string
	public static void permutation(String s)
	{
		permutation("", s);
	}
	private static void permutation(String prefix, String s)
	{
		if(s.length()==0) System.out.println(prefix);
		for(int i=0; i<s.length(); i++)
		{
			permutation(prefix+s.charAt(i), s.substring(0, i)+s.substring(i+1));
		}
	}
	
	//http://stackoverflow.com/questions/2920315/permutation-of-array
	public static void permute(int... a)
	{
		permute(a, 0);
	}
	private static void permute(int[] array, int k)
	{
		if(k==array.length) System.out.println(Arrays.toString(array));
		else
		{
			for(int i=k; i<array.length; i++)
			{
				swap(array, i, k);
				permute(array, k+1);
				swap(array, i, k);
			}
		}
	}
	private static void swap(int[] array, int x, int y)
	{
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
	
	public static int[] nextPermutation(int[] input)
	{
		if(input.length<2) return input;
		for(int i=input.length-1; i>0; i--)
		{
			if(input[i]>input[i-1])
			{
				for(int j=input.length-1; j>i-1; j--)
				{
					if(input[j]>input[i-1])
					{
						swap(input, j, i-1);
						for(int k=0; k<(input.length-i)/2; k++)
						{
							swap(input, i+k, input.length-1-k);
						}
						return input;
					}
				}
			}
		}
		for(int i=0; i<input.length/2; i++)
		{
			swap(input, i, input.length-1-i);
		}
		return input;
	}
	public static void permutation(int... array)
	{
		Arrays.sort(array);
		//include repeated elements, calculate total permutation count n
		int n = 1;
		for(int i=2; i<=array.length; i++) n*=i;
		for(int i=1; i<array.length; i++)
		{
			int repeat = 1;
			while(i<array.length && array[i]==array[i-1])
			{
				n /= ++repeat;
				i++;
			}
		}
		for(int i=0; i<n; i++)
		{
			System.out.println(Arrays.toString(array));
			array = nextPermutation(array);
		}
	}
	public static void main(String[] args)
	{
		permutation(1,2,3,2);
	}
}
