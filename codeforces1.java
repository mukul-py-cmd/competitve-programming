public class codeforces1 {
	public static void main(String[] args) {
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t-- >0){
			int n = sc.nextInt();
			
			int a = sc.nextInt();
			
			int b = sc.nextInt();
			
			String ans = "";
			for(int i = 0; i < n; i++){
				ans += (char)('a' + i%b);
			}
			System.out.println(ans);
		}
	}
	}