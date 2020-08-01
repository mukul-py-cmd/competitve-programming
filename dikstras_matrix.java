import java.util.*;
public class dijkstras_matrix{
	static int v = 9;
	public static void main(String[] args){
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

      int[] dist = new int[v];
      int[] visit = new int[v];
      Arrays.fill(dist,Integer.MAX_VALUE);
      Arrays.fill(visit,-1);
      dist[0] = 0;
      calculate(graph,dist,visit);
      for(int x:dist){
      	System.out.print(x +" ");
      }

	}

public static void calculate(int graph[][],int[] dist,int[] visit){

			for(int i = 0; i<v-1;i++){
				int u = chose_min(dist,visit);
				visit[u] = 1;
				for(int j = 0;j < v;j++){
					if(visit[j] ==-1 && graph[u][j]!= 0 && dist[u] != Integer.MAX_VALUE  ){
						dist[j] = Math.min(dist[j],dist[u]+graph[u][j]); 
					}
					
				}

			}
}
public static int chose_min(int[] dist,int[] visit){
	int ans = Integer.MAX_VALUE;
	int index = -1;
	for(int i = 0;i <v;i++){
		if(visit[i] == -1 && ans > dist[i]){
			index = i;
			ans = dist[i];
		}
	}
	return index;
}


}