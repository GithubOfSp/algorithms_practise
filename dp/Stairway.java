package dp;

//finish n steps with 1, 2 or 3 steps everytime. calculate total ways
public class Stairway {
	public static int solveRe(int n)
	{
		if(n<0) return 0;
		if(n==0) return 1;
		return solveRe(n-1)+solveRe(n-2)+solveRe(n-3);
	}
	
	public static int solveDp(int n)
	{
		int[] dp = new int[3];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3; i<=n; i++)
		{
			dp[i%3] = dp[(i-1)%3]+dp[(i-2)%3]+dp[(i-3)%3];
		}
		return dp[n%3];
	}
	public static void main(String[] args)
	{
		System.out.println(solveDp(5));
	}
}
