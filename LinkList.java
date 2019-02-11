public class LinkList {
	static class Node {
		int val;
		Node next;
	}

	static void insert(Node root, int val) {
		Node temp = new Node();
		temp.val = val;
		temp.next = null;
		if(root == null) {
		     root = temp;
		} else {
			Node trav = root;
			while(trav.next != null) {
				trav = trav.next;
			}
			trav.next = temp;
		}
	}	

	// Traverse a linklist given with its root
	static void traverse(Node root){
		if(root == null) {
		    System.out.println("Empty Linkedlist");
		    return;
		}
		Node temp = root;
		while(temp != null) {
			System.out.print(temp.val + "->");
			temp = temp.next;
		}
		System.out.print("null");
		System.out.println("\n");
	}

	// Sort a linklist given with its root.
	static Node sort(Node root) {
		Node start = root;
		Node prev_start = null;
		while(start.next != null) {
	                // System.out.println("\n");
	                // System.out.println("start is:" + start.val);
        	        // System.out.println("prev_start is:" + prev_start.val);
			Node curr = start;
			Node min = start;
			Node prev_min = prev_start;
			while(curr.next != null) {
				// System.out.println("curr is:" + curr.val);
				// System.out.println("min is:" + min.val);
				// System.out.println("prev_min is:" + prev_min.val);
				if(curr.next.val < min.val){
					min = curr.next;
					prev_min = curr;
				}
				curr = curr.next;
			}
			if(start == root){
				Node temp = start.next;
				start.next = min.next;
				prev_min.next = start;
				min.next = temp;
				root = min;
				// System.out.println("root changed to :" + root.val);

			} else if(prev_min != start){
				Node temp = start.next;
                                start.next = min.next;
                                prev_min.next = start;
                                min.next = temp;
				prev_start.next = min;
			} else {
				start.next = min.next;
				min.next = start;
				prev_start.next = min;
			}
			prev_start = min;
			start = min.next;
		}
		return root;
	}

	public static void main(String[] args) {
		Node obj = new Node();
		obj.val = 10;
		//insert(obj, 10);
		insert(obj, 7);
		insert(obj, 4);
		insert(obj, 14);
		insert(obj, 65);
		insert(obj, 98);
		insert(obj, 21);
		insert(obj, 148);
		insert(obj, 12);
		insert(obj, 60);
		insert(obj, 84);
		insert(obj, 73);
		insert(obj, 51);
		insert(obj, 202);
		insert(obj, 100);
		
		System.out.println("LinkList before sort is:");
		traverse(obj);
		Node head = sort(obj);
		System.out.println("LinkList after sort is:");
                traverse(head);
	}
}
