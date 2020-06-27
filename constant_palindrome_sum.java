//https://codeforces.com/contest/1343/problem/D

import java.util.*;
public class Main{
    
    public static void main(String[] args    ) {
        Scanner sc = new Scanner(System.in);
        
        int t =sc.nextInt();
        while(t-->0){
            int n=  sc.nextInt();
            int k = sc.nextInt();
            int[] arr =new int[n];
            for(int i = 0; i < n;i++){
                arr[i] = sc.nextInt();
            }
            
           int[] count = new int[(2*k)+1];
           int[] pre = new int[(2*k)+1];

           int i = 0; int j = n-1;
           while(i<j){
           	int a1 = arr[i]; int a2 = arr[j];
           	count[a1+a2]++;
           	int min_sum = Math.min(a1,a2)+1;
           	int max_sum = Math.max(a1,a2)+k;
           	pre[min_sum]++;
           	if(max_sum < 2*k){
           		pre[max_sum+1] -=1;
           	}
           	i++;
           	j--;

           }
			int ans = Integer.MAX_VALUE ;
            for(int x = 1; x<=2*k; x++){
            		pre[x] += pre[x-1];
            		int temp_ans = (pre[x]-count[x]) + ((n/2)-pre[x])*2;
            		ans  =Math.min(ans,temp_ans);
            }

            	System.out.println(ans);
        }}
    
}