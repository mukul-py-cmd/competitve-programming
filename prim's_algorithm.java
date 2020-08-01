//prim's algo

import java.util.*;

class timepass{
	static graph gr;
	static List<List<Integer>> ans = new ArrayList<>();
	public static void main(String[] args){

		int[][] g  = new int[][]{{0, 1, 1, 100, 0, 0}, 
                               {1, 0, 1, 0, 0, 0}, 
                               {1, 1, 0, 0, 0, 0},    
                               {100, 0, 0, 0, 2, 2}, 
                               {0, 0, 0, 2, 0, 2},   
                               {0, 0, 0, 2, 2, 0}}; 

       int v =6;

prim(v,g);





	}

public static void prim(int v, int[][] g){
	boolean mst[] = new boolean[v];
	int[] dist= new int[v];

	Arrays.fill(mst,false);
	Arrays.fill(dist,Integer.MAX_VALUE);
	dist[0] = 0;

int min_cost_ans = 0;

for(int i =0; i < v;i++){
	int u = min(dist,mst);
	mst[u] = true;
	min_cost_ans += dist[u];

	for(int j = 0; j  < v;j++){
		if(g[i][j] != 0 && !mst[j]  ){
			dist[j] = Math.min(dist[j],g[i][j]);
		}
	}

}
System.out.println(min_cost_ans);
}


public static int min(int[] dist, boolean mst[]){
		int min = Integer.MAX_VALUE;
		int index =0;
		for(int i = 0; i < dist.length;i++){
			if(!mst[i] && dist[i]<min ){
				min = dist[i];
				index = i;
			}
		}
		return index;

}

}

class graph{
	int V;
	LinkedList<Integer>[] adj ;
	int[] inc ;
	graph(int v){
		V = v;
		adj = new LinkedList[v];
		inc = new int[v];
		for(int i = 0; i < v; i++){
			adj[i] = new LinkedList<>();
		}
	}

	void add(int u, int v){
			adj[u].add(v);
			inc[v]++;
		}




	
}