import java.util.*;

class knight_tour_backtracking{
      static int n = 8;
      static int[][] ans = new int[8][8];
      static int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
      static  int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1}; 
      public static void main(String[] args){
        //int[][] ans = new int[8][8];
            for(int i = 0; i<8;i++){
                  Arrays.fill(ans[i],-1);
            }

            ans[0][0] = 0;
            backtrack(0,0,1);
            for(int[] data : ans){
                  for(int val: data){
                        System.out.print(val +" ");
                  }

                  System.out.println();
            }

      }

public static boolean backtrack(int i, int j,int count){
if(count ==64){
      
      return true;
}


for(int k = 0;k<8;k++){
      int x = i + xMove[k];
       int y = j + yMove[k];

       if(isvalid(x,y)){
            ans[x][y] = count;
           
            if(backtrack(x,y,count+1)){
                  return true;
            }else{
                  ans[x][y] = -1;
            }
       }
}

return false;


}

public static boolean isvalid(int i, int j){
      if(i >=0 && j >=0 && i <8 && j<8 && ans[i][j] == -1){
            return true;
      }
      return false;
}
}