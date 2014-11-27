package dp;

//calculate total ways from 0,0 to x,y
public class MatrixWays {
	public static int solveRe(int x, int y)
	{
		if(x<0 || y<0) return 0;
		if(x==0 && y==0) return 1;
		return solveRe(x-1, y)+solveRe(x, y-1);
	}
	
	public static int solveDp(int x, int y)
	{
		int[][] dp = new int[x+1][y+1];
		for(int i=0; i<=x; i++) dp[i][0] = 1;
		for(int i=0; i<=y; i++) dp[0][i] = 1;
		for(int i=1; i<=x; i++)
		{
			for(int j=1; j<=y; j++)
			{
				dp[i][j] = dp[i-1][j]+dp[i][j-1];
			}
		}
		return dp[x][y];
	}
	
	public static void main(String[] args)
	{
		System.out.println(solveDp(5,2));
	}
}
