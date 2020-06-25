//https://codeforces.com/contest/1367/problem/E

import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k =sc.nextInt();
            
            String s = sc.next();
            int[] ch = new int[26];
            for(int i =0; i < n ;i++){
                ch[s.charAt(i)-'a']++;
            }
            
                int ans = 0;
                for(int i = 1; i <= n;i++){
                    int rep = solve(k,i);
                   
                    int temp = 0;
                    for(int j = 0;j < 26; j++){
                        int x = (ch[j]/rep);
                        temp += x*rep;
                    }
                    if(temp < i){
                        temp =0;
                    }else{
                        temp =Math.min(i,temp);
                    }
                    
                    ans = Math.max(temp,ans);
                }
                System.out.println(ans);
            
        }
	}
	
	public static int solve(int k, int m){
	    
	    int ans = 0 ;
	    int turn =1;
	    int rem = 0;
	    while(rem != 0 || turn ==1){
	        rem = (rem+k)%m;
	        turn--;
	        ans++;
	    }
	    
	    return ans;
	    
	    
	}
	
}