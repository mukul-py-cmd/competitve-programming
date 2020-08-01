import java.util.*;

public class dijkstra_adjancency{
	static int V = 9;
	public static void main(String[] args){
		Graph gr = new Graph(V);
		gr.addEdge( 0, 1, 4); 
	    gr.addEdge( 0, 7, 8); 
	    gr.addEdge( 1, 2, 8); 
	    gr.addEdge( 1, 7, 11); 
	    gr.addEdge(2, 3, 7); 
	    gr.addEdge( 2, 8, 2); 
	    gr.addEdge( 2, 5, 4); 
	    gr.addEdge( 3, 4, 9); 
	    gr.addEdge( 3, 5, 14); 
	    gr.addEdge( 4, 5, 10); 
	    gr.addEdge( 5, 6, 2); 
	    gr.addEdge( 6, 7, 1); 
	    gr.addEdge( 6, 8, 6); 
	    gr.addEdge( 7, 8, 7); 

	    int[] dist = new int[V];
	    int[] visit = new int[V];
	    Arrays.fill(dist,Integer.MAX_VALUE);
	    Arrays.fill(visit,-1);
      calculate(gr,dist,visit,0);

for(int x: dist){
	System.out.print(x +" ");
}


}

public static void calculate(Graph gr,int[] dist,int[] visit,int source){

		Queue<Node> q = new PriorityQueue<Node>(new Comparator<Node>(){
		public int compare(Node a , Node b){
			return a.w-b.w;
		}
		});

		q.add(new Node(source,0));
				for(int i =0;i < V;i++){

					Node temp = q.poll();
					int u = temp.v;
					int w = temp.w;
					while(visit[u] ==1){
						 temp = q.poll();
					u = temp.v;
					w = temp.w;
					}
					
					
					dist[u] = w;
					visit[u]=1;
					Iterator<Node> it = gr.adj[u].iterator();
					while(it.hasNext()){
						Node target = it.next();
						int v = target.v;
						if(visit[v] ==-1 && dist[v] > dist[u] + target.w){
							q.add(new Node(v,dist[u] + target.w));
						}
					}
				}

}





}

class Graph{
	int V;
	LinkedList<Node>[] adj;
	Graph(int x){
		V = x;
		adj = new LinkedList[V];
		for(int i = 0;i <V;i++){
			adj[i] = new LinkedList<>();
		}
	}
    

    void addEdge(int u, int v,int w){
    	adj[u].add(new Node(v,w));
    	adj[v].add(new Node(u,w));
    }
}

class Node{
	int v;
	int w;
	Node(int x,int y){
		v = x;
		w = y;
	}
}