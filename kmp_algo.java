class kmp_algo{
	public static void main(String[] args){
		String txt = "ABABDABACDABABCABAB"; 
        String pat = "ABABCABAB"; 
        int pat_length = pat.length();

        int lps[] = new int[pat_length];
        calc_lps(lps,pat_length,pat);
        search(txt,pat,lps);
	}

public static void search(String txt,String pat,int lps[]){
		int txt_len = txt.length();
		int i = 0; int j = 0;

		while(i < txt_len){
			if(txt.charAt(i) == pat.charAt(j)){
				i++;
				j++;

			}
			if(j==pat.length()){
				
				System.out.println("pattern found at i = " +(i-j));
				j = lps[j-1];
			}else if(i < txt_len && txt.charAt(i) != pat.charAt(j)){
				if(j !=0){
					j = lps[j-1];
				}else{
					i++;

				}
			}



		}





}

	public static void calc_lps(int lps[],int pat_length,String pat){
		lps[0] =0;

		int i = 1;
		int len = 0;
		while(i < pat_length){
			if(pat.charAt(len) == pat.charAt(i)){
				len++;
				
				lps[i] = len;
				i++;
			}else{
				if(len==0){
					lps[i] =0;
					i++;
				}else{
					len = lps[len-1];
				}
			}

		}






	}
}