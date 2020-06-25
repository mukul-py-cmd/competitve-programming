//Link:   https://leetcode.com/problems/maximal-rectangle/

class Solution {
    public int maximalRectangle(char[][] mat) {
        int m = mat.length;
        if(m == 0){
            return 0;
        }
        int n = mat[0].length;
        if(n ==0){
            return 0;
        }
       int ans = 0;
        for(int up = 0; up < m; up++){
             int[] temp = new int[n];
            for(int down = up; down < m; down++){
                int ret = kadane(mat,temp,down,down-up+1);
                ans = Math.max(ans,ret);
                
            }
        }
        
        return ans;
        
    }
    
    
    public int kadane(char[][] mat,int[] temp,int down, int val){
        int max_length = 0;
        int curr_length = 0;
        for(int i = 0; i < mat[0].length; i++){
            temp[i] += mat[down][i]-'0';
         
            if(temp[i] != val ){
                curr_length = 0;
            }else{
                curr_length++;
                max_length = Math.max(curr_length,max_length);
            }
        }
        
        
        return max_length*val;
        
        
    }
    
    
}