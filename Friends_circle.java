class Solution {
    //ArrayList<Integer,LinkedList<Integer>> arr = new ArrayList<>();
   int[] visit ;
    public int findCircleNum(int[][] M) {
        int n = M.length;
         LinkedList<Integer>[] gr = new LinkedList[n];
        for (int i = 0; i < n; i++){
            gr[i] = new LinkedList<>();
        }
        
        
        for (int i = 0; i < n ; i++){
            for(int j = 0; j <i ;j++){
                if(M[i][j] == 1){
                    gr[i].add(j);
                    gr[j].add(i);
                }
            }
        }
        
        
         visit = new int[n];
        Arrays.fill(visit,-1);
        int ans = 0;
        for(int i = 0; i<n;i++){
            if(visit[i] == -1){
                dfs(gr,i);
                ans++;
            }
        }
        
        return ans;
    }
    
    
    
    public void dfs(LinkedList<Integer>[] gr, int node){
        
        visit[node] = 1;
        Iterator<Integer> it = gr[node].iterator();
        while(it.hasNext()){
            int temp = it.next();
            if(visit[temp] == -1){
                dfs(gr,temp);
            }
        }
        
        
        
        
        
        
        
    }
}