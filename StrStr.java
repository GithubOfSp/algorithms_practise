import java.util.Arrays;

public class StrStr {
	public static void KMP(String haystack, String needle){}
	
	public static void BF(String haystack, String needle){}
	
	public static void BM(String haystack, String needle){}
	
	public static void KR(String haystack, String needle){}
	
	public static void Horspool(String haystack, String needle){}
	
	public static int Sunday(String haystack, String needle)
	{
		int capacity = (int)Math.pow(2, Byte.SIZE); //2^8=256
		int[] next = new int[capacity];
		Arrays.fill(next, needle.length()+1);
		for(int i=0; i<needle.length(); i++)
		{
			next[needle.charAt(i)] = needle.length()-i;
		}
		int startPoint = 0;
		while(startPoint+needle.length()<=haystack.length())
		{
			int i;
			for(i=0; i<needle.length(); i++)
			{
				if(haystack.charAt(i+startPoint)!=needle.charAt(i))
				{
					if(startPoint+needle.length()>=haystack.length()) return -1;
					startPoint += next[haystack.charAt(startPoint+needle.length())];
					break;
				}
			}
			if(i==needle.length()) return startPoint;
		}
		return -1;
	}
	public static void main(String[] args)
	{
		System.out.println(Sunday("sdfjsdf", "fjss"));
	}
}
