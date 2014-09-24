
public class findNextNumberWithSameCountOf1InBinary {
	public static int findNext(int number)
	{
		assert(number!=-1);
		if(number==-1 || number==0) return number;
		int temp = number;
		int count0 = 0;
		int count1 = 0;
		while((temp&1)==0) 
		{
			temp>>>=1;
			count0++;
		}
		while((temp&1)==1)
		{
			temp>>>=1;
			count1++;
		}
		if(number>0)
		{
			assert(count0+count1<31);
			if(count0+count1>=31) return number;
		}
		number += 1<<count0;
		number += (1<<count1-1)-1;
		return number;
	}
	public static int findPrevious(int number)
	{
		if(number==0 || number==1 || number==Integer.MIN_VALUE) return number;
		int temp = ~Integer.MIN_VALUE&number;
		int count1 = 0;
		int count0 = 0;
		while((temp&1)==1)
		{
			temp>>>=1;
			count1++;
		}
		if(temp==0) return number;
		while((temp&1)==0)
		{
			temp>>>=1;
			count0++;
		}
		number -= (1<<count1)-1+(1<<count0+count1);
		number += (1<<count1+1)-1<<count0-1;
		return number;
	}
	public static void main(String[] args)
	{
		assert false;
		System.out.println(findNext(0x70));
		System.out.println(findPrevious(131));
	}
}
