//https://codeforces.com/contest/1367/problem/C

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
            Set<Integer> st = new HashSet<>();
            String arr[] = s.split("");
            for(int i = 0; i < n; i++){
                if(arr[i].equals("1")){
                    st.add(i);
                    for(int j = Math.max(i-k,0); j <= Math.min(i+k,n-1)   ;j++  ){
                        st.add(j);
                    }
                }
            }
            int ans = 0;
            
               
           int i = 0;
            while(i < n){
                if(!st.contains(i)){
                    ans++;
                    i = i+k;
                }
                i++;
            }
            System.out.println(ans);
        }
	}
}