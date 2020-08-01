//https://codeforces.com/contest/1374/problem/E1


import java.util.*;

public class reading_books_easy_cf{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		
			int k =sc.nextInt();

			ArrayList<Integer> common = new ArrayList<>();
			ArrayList<Integer> alice = new ArrayList<>();
			ArrayList<Integer> bob = new ArrayList<>();

		for(int i = 0; i < n;i++){
			
				int t = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				if(a == 0 && b!=0){
					
					bob.add(t);
				}else if(a!=0 && b==0){
						alice.add(t);
				}else if(a!= 0 && b!=0){
					common.add(t);
				}


			
		}
				Collections.sort(common);
				Collections.sort(bob);
				Collections.sort(alice);


		int aa = 0;
		int ca  = 0;
		


int ans = 0;


int count= 0;

while(count < k){
	if((aa < Math.min( alice.size(),bob.size()))&&( ca >= common.size()  || (alice.get(aa) +  bob.get(aa) < common.get(ca)))){
		ans += alice.get(aa) +  bob.get(aa);
		aa++;
		
	}else if(ca < common.size() ){
		ans += common.get(ca);
		ca++;
	}else{
		break;
	}
	count++;
}



if(count != k){
	System.out.println("-1");
}else{
	System.out.println(ans);
}




	}}
