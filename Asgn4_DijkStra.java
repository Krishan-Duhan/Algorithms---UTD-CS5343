
public class Asgn4_DijkStra {
	static int shortest_path(int[] dist, boolean[] visited) {
		int vertex = -1;
		int shortest_dist = Integer.MAX_VALUE;
	       	for(int i = 0; i < dist.length; i++) {
		    if(dist[i] <= shortest_dist && visited[i] == false) {
			    vertex = i;
			    shortest_dist = dist[i];
		    }
		}
		return vertex;
	}

	static void dijkstra(int [][] graph, int source) {
		int[] distance = new int[graph.length];			//distance[i] stores distance of vertex i from source vertex
		boolean[] visited = new boolean[graph.length];

		for(int i = 0; i < graph.length; i++) {
		    distance[i] = Integer.MAX_VALUE;
		}

		distance[source] = 0;

		// Visit all the vertices
		for(int j = 0; j < graph.length - 1; j++) {
		    int curr = shortest_path(distance, visited);	//finding vertex with shortest distance among un-visited vertices  
		    visited[curr] = true;
			
		    if(distance[curr] == Integer.MAX_VALUE) {
			continue;
		    }

		    // update the distance of neighbours(adjacent vertices) of curr vertex
		    for(int k = 0; k < graph.length; k++) {
			if(graph[curr][k] > 0) { 
				if(!visited[k] && (distance[curr] + graph[curr][k] < distance[k])) {
				    distance[k] = distance[curr] + graph[curr][k];
				}
			}
		    }
		}
		
		System.out.println("Distance of all vertices in sequence(0 to number_of_vertices) from source vertex(" + source + ") is:");
		for(int i = 0; i < distance.length; i++) {
		    System.out.println(distance[i]);
		}
	}

	public static void main(String[] args) {
		// Forming a graph with adjacency-matrix representation	
		int[][] graph =	new int[][] {
			{0, 2, 0, 0, 0, 0, 0, 0, 0, 3},
			{2, 0, 4, 0, 0, 0, 8, 0, 0, 0},
			{0, 4, 0, 5, 0, 0, 0, 6, 0, 0},
			{0, 0, 5, 0, 2, 0, 0, 0, 10, 0},
			{0, 0, 0, 2, 0, 7, 0, 9, 0, 0},
			{0, 0, 0, 0, 7, 0, 1, 0, 0, 11},
			{0, 8, 0, 0, 0, 1, 0, 3, 0, 0},
			{0, 0, 6, 0, 9, 0, 3, 0, 4, 0},
			{0, 0, 0, 10, 0, 0, 0, 4, 0, 5},
			{3, 0, 0, 0, 0, 11, 0, 0, 5, 0}
		};
		//System.out.println("graph.length is:" + graph.length);
		//System.out.println("Integer.MAX_VALUE is: " + Integer.MAX_VALUE);
		dijkstra(graph, 2);	
	}	
}
