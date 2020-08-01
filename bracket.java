import java.util.*;
 
public class bracket{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = 1;
		while(t-- > 0){
			int n =4;
		long k = 3;
		long[] arr = new long[]{1,2,1,3};
		Map<Long,Integer> mp = new HashMap<>();
		for(int i = 0;i <n;i++){
		    long temp = arr[i];
		    long rem = temp%k;
		    if(rem !=0){
		    	 rem = k-rem;
		    }
		   

		    //System.out.println( temp +"-"+ rem);
		    mp.put(rem,mp.getOrDefault(rem,0)+1);
		}
			int ans = 0;
			long fin = 0;
			for(long key : mp.keySet()){
			    if(key !=0){
			        int key_temp = mp.get(key);
			        //System.out.println( key +"-"+key_temp);
			        if(key_temp >= ans){
			            ans = Math.max(key_temp,ans);
			            fin = Math.max(key,fin);
			            System.out.println( fin);
			        }
			         
			    }
			   
			}
			System.out.println( ans +"-"+fin);
			if(ans == 0){
				System.out.println( ans );
			}else{
				System.out.println((long)(ans-1)*(k) + (k-fin) );
			}
			
		}}
		
		
		
}
