//https://codeforces.com/contest/1343/problem/C

import java.util.*;

public class alternating_subsequence{
	static long[][] dp2;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
			int n = sc.nextInt();

		int[] arr = new int[n];
		for(int i = 0; i < n;i++){
			arr[i] = sc.nextInt();
		}
		
		int[] dp = new int[n];

		dp[0] = 1;


		for(int i = 1;i<n;i++){
			int j = i-1;
			int temp = 0;
			while(j >=0 ){
				 if((arr[i] >0 && arr[j]<0) || (arr[i] <0 && arr[j]>0)){
				 	temp = dp[j];
				 	break;
				 }
				 j--;
			}
			dp[i] = Math.max(temp+1,dp[i-1]);
		}
		//int max_n = 2 *(int)10e5;
		dp2 = new long[n+1][dp[n-1]+1];

		for(int i = 0;i <=n;i++){
			Arrays.fill(dp2[i],-1);
		}


		long ans = find_max(dp,n-1,dp[n-1],arr);
		for(int i = 0; i<n;i++){
			System.out.print(dp[i] +" ");
		}
		System.out.println(ans);



				}

	}

public static long find_max(int[] dp, int i, int val,int[] arr){
			if(i == -1 || val == 0){
				return 0;
			}
			if(dp2[i][val] != -1){
				return dp2[i][val];
			}
			long ans = (long)-10e9;
			while(i >= 0 && dp[i] >= val){
				if(dp[i] == val){
					ans = Math.max(ans,(long)arr[i] + find_max(dp,i-1,val-1,arr));
				}
				i--;
			}

			if(i>=0){
				return dp2[i][val] = ans;
			}
			return ans;
}


}