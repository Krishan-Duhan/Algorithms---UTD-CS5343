import java.util.*;

public class Topological_sort {
	static class Node {
	    int val;
	    boolean visited;
	    List<Node> adj;

	    public Node(int val) {
	        this.val = val;
		this.adj = new ArrayList<Node>();
	    }

	    void adjacent(Node adjacent) {
	        this.adj.add(adjacent);
	    }
	}

        static Stack<Node> st = new Stack<>();
	static List<Node> set = new ArrayList<>();

	// Recursive function for DFS topological sort
	static void DFS_topSort(Node start) {
            List<Node> adjacents = start.adj;

	    for(int i = 0; i < adjacents.size(); i++) {
		Node curr = adjacents.get(i);
		if(curr != null && curr.visited == false) {
		    if(set.contains(curr)) {
			System.out.println("Cycle found !!");
			int k = 0;
			while(set.get(k) != curr) {
				k++;
			}
			for(int p = k; p < set.size(); p++) {
			    Node n = set.get(p);
			    System.out.print(n.val);
                            System.out.print(" ");
			}
			System.out.print(curr.val);
			System.out.println();
			System.exit(0);
		    }
		    set.add(curr);
	            DFS_topSort(curr);
		    set.remove(curr);
		    System.out.println("Visited edge: " + start.val + "->" + curr.val);
		    curr.visited = true;
		}
	    }
	    st.push(start);
	}

	public static void main(String[] args) {
	    List<Node> vertices = new ArrayList<>();
	    Node n1 = new Node(10);
	    Node n2 = new Node(15);
	    Node n3 = new Node(7);
	    Node n4 = new Node(20);
	    Node n5 = new Node(50);
	    Node n6 = new Node(90);
	    Node n7 = new Node(42);
	    Node n8 = new Node(30);
	    Node n9 = new Node(65);
	    Node n10 = new Node(73);
	    
	    vertices.add(n10);
	    vertices.add(n1);
	    vertices.add(n2);
	    vertices.add(n3);
	    vertices.add(n4);
	    vertices.add(n5);
	    vertices.add(n6);
	    vertices.add(n7);
	    vertices.add(n8);
	    vertices.add(n9);

	    n1.adjacent(n2);
	    n1.adjacent(n7);
	    n2.adjacent(n3);
	    n3.adjacent(n9);
	    n4.adjacent(n3);
	    n5.adjacent(n4);
	    n5.adjacent(n6);

	    n7.adjacent(n6);				//Comment this line to make cycle
	    //n6.adjacent(n7);				// Uncomment this line to make cycle
	    
	    n7.adjacent(n8);
	    n8.adjacent(n9);
	    n8.adjacent(n4);
	    n9.adjacent(n6);
	    n10.adjacent(n1);
            n10.adjacent(n9);
	    n10.adjacent(n5);

	    for(int j = 0; j < vertices.size(); j++) {
		Node temp = vertices.get(j); 
		if(temp.visited == false) {
	            DFS_topSort(temp);
		}
	    }

	    System.out.print("Topologically sorted oder of vertices is: ");
	    while(!st.empty()) {
	        System.out.print(st.pop().val);
		System.out.print(" ");
	    }
	    System.out.println();
	}
}
