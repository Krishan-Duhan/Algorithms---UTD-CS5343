public class Bin_Search_Tree {
	Node root;
	class Node {
		int val;
		Node left;
		Node right;
	}

	Bin_Search_Tree() {
		root = null;
	}

	void insert(int value) {
		Node temp = new Node();
		temp.val = value;
		if(root == null) {
			root = temp;
			return;
		}
		insert_rec(root, value);
	}

	void insert_rec(Node nd, int value) {
		Node temp = new Node();
                temp.val = value;
                if(nd.val > value) {
			if(nd.left == null) {
				nd.left = temp;
				return;
			}
                        insert_rec(nd.left, value);
                } else {
			if(nd.right == null) {
				nd.right = temp;
				return;
			}
                        insert_rec(nd.right, value);
                }
	}

	void inorder_traverse(Node nd) {
		if(nd == null) {
			return;
		}
		inorder_traverse(nd.left);
		System.out.print(nd.val + " ");
		inorder_traverse(nd.right);
	}

	void delete(int value) {
		root = delete_rec(root, value);
	}

	int find_successor(Node nd) {
		int suc = nd.val;
		while(nd.left != null) {
			suc = nd.left.val;
			nd = nd.left;
		}
		return suc;
	}

	Node delete_rec(Node nd, int value) {
		if(nd == null) {
			return null;
		}
		if(nd.val > value) {
			nd.left = delete_rec(nd.left, value);
		} else if(nd.val < value) {
			nd.right = delete_rec(nd.right, value);
		} else {
			if(nd.left == null) {
				return nd.right;
			} else if(nd.right == null) {
				return nd.left;
			}
			nd.val = find_successor(nd.right);
			nd.right = delete_rec(nd.right, nd.val);
		}
		return nd;
	}

	public static void main(String[] args) {
		Bin_Search_Tree tree1 = new Bin_Search_Tree();
		tree1.insert(65);
		tree1.insert(28);
		tree1.insert(83);
		tree1.insert(22);
		tree1.insert(46);
		tree1.insert(78);
		tree1.insert(89);
		tree1.insert(35);
		tree1.insert(48);
		tree1.insert(85);
		tree1.insert(91);
		tree1.insert(32);
		tree1.insert(40);
		tree1.insert(47);
		tree1.insert(55);
		tree1.insert(86);
		tree1.insert(93);

		System.out.println("Inorder traversal of BST before deletion is:");
		tree1.inorder_traverse(tree1.root);
		System.out.println("\n");

		tree1.delete(40);
		System.out.println("Inorder traversal of BST after deletion of 40(leaf-node) is:");
                tree1.inorder_traverse(tree1.root);
                System.out.println("\n");

		tree1.delete(83);
		System.out.println("Inorder traversal of BST after deletion of 83(non-leaf node) is:");
                tree1.inorder_traverse(tree1.root);
                System.out.println("\n");
	}
}
