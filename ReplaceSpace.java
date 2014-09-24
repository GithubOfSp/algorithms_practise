import java.util.Arrays;


public class ReplaceSpace {
	public static void replaceSpace(char[] array)
	{
		int tail= array.length-1;
		while(tail>=0 && (array[tail]==' '||array[tail]==0)) tail--;
		int count = 0;
		System.out.println(tail);
		for(int i=0; i<tail; i++)
		{
			if(array[i]==' ') count++;
		}
		System.out.println(count);
		int newTail = tail + count*2;
		while(newTail>=0 && tail!=newTail)
		{
			if(array[tail]==' ')
			{
				newTail -= 2;
				array[newTail] = '%';
				array[newTail+1] = '2';
				array[newTail+2] = '0';
			}
			else
			{
				array[newTail] = array[tail];
			}
			tail--;
			newTail--;
		}
	}
	public static void main(String[] args)
	{
		String test = "  aabc  drfr fdr   ";
		char[] array = new char[test.length()+100];
		System.arraycopy(test.toCharArray(), 0, array, 0, test.length());
		System.out.println(Arrays.toString(array).replace(", ", ""));
		replaceSpace(array);
		System.out.println(Arrays.toString(array).replace(", ", ""));
	}
}
