
public class CommonSubstring {
	public static String common(String a, String b)
	{
		if(a.length()==0) return "";
		int[][] matrix = new int[a.length()][b.length()];
		int maxI = 0;
		int maxLength = 0;
		for(int i=0; i<a.length(); i++)
		{
			for(int j=0; j<b.length(); j++)
			{
				if(a.charAt(i)==b.charAt(j))
				{
					matrix[i][j] = (i>0&&j>0)?matrix[i-1][j-1]+1:1;
					if(matrix[i][j]>maxLength)
					{
						 maxLength = matrix[i][j];
						 maxI = i;
					}
				}
			}
		}
		return a.substring(maxI-maxLength+1, maxI+1);
	}
	public static int common2(String a, String b)
	{
		int[][] matrix = new int[a.length()][b.length()];
		int maxLength = 0;
		for(int i=0; i<a.length(); i++)
		{
			for(int j=0; j<b.length(); j++)
			{
				if(a.charAt(i)==b.charAt(j))
				{
					matrix[i][j] = (i>0&&j>0)?matrix[i-1][j-1]+1:1;
				}
				else
				{
					if(i==0 && j==0) matrix[i][j] = 0;
					else if(i==0) matrix[i][j] = matrix[i][j-1];
					else if(j==0) matrix[i][j] = matrix[i-1][j];
					else matrix[i][j] = matrix[i][j-1]>matrix[i-1][j]?matrix[i][j-1]:matrix[i-1][j];
				}
				if(matrix[i][j]>maxLength)
				{
					maxLength = matrix[i][j];
				}
			}
		}
		return maxLength;
	}
	public static void main(String[] args)
	{
		String a = "abbcedf";
		String b = "bbbbdfeedf";
		System.out.println(common2(a, b));
	}
}
