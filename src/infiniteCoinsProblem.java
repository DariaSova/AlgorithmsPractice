import java.util.Arrays;

public class infiniteCoinsProblem {

	public static int numWays(int[] coins, int sum){
		if(sum == 0) return 1;
		if(sum <0 ) return 0; //or error
		
		int res = 0;
		for(int c: coins){
			res += numWays(coins, sum-c);
		}
		
		return res;
	}
	
	public static int numWaysDP(int[] coins, int[][] dp, int sum){
		if(sum==0) return 1;
		if(sum<0) return 0;
		
		int res = 0;
		for(int i=0; i<coins.length;i++){
			int c = coins[i];
			if(sum>=0&&dp[sum][i]>0) {
				res+= dp[sum][i];
			}
			else {
				int rem = sum-c;
				res += numWays(coins, rem);
//				dp[sum] = res;
			}
			dp[sum][i] = res;
		}
		return res;
	}
	
	public static int makeChange(int amount, int[] denoms, int index, int[][] map){
		if(map[amount][index] > 0){
			return map[amount][index];
		}
		
		if(index> denoms.length) return 1;
		int denom = denoms[index];
		int ways = 0;
		
		for(int i=0; i*denom <= amount; i++){
			//go to next denom
			int rem = amount - i*denom;
			ways+=makeChange(rem,denoms,index+1,map);
		}
		map[amount][index] = ways;
		return ways;
	}
	
	
	public static void main(String[] args){
		int[] coins = {5,10,25};
		int sum = 25;
		System.out.println(numWays(coins, sum));
		int[][] dp = new int[sum+1][coins.length];
//		for(int[] arr: dp) Arrays.fill(arr, -1);
//		Arrays.fill(dp[0],0);
		System.out.println(numWaysDP(coins, dp, sum));
		System.out.println(makeChange(sum,coins,0,dp));
	}
}
