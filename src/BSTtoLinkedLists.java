import java.util.*;

public class BSTtoLinkedLists {
	public static class Node {
		int x;
		Node right;
		Node left; 
		public Node(int x){ 
			this.x = x; 
			this.left = null;
			this.right = null;
		}
	}
	
	ArrayList<LinkedList<Node>> lists;
	
	public BSTtoLinkedLists(){
		this.lists = new ArrayList<>();
	}
	
	void traverseTreeBFS(Node root){
	LinkedList<Node> curr = new LinkedList<>();
	if(root!=null) curr.add(root);
	
		while(curr.size()>0){
		LinkedList<Node> next = new LinkedList<>();
		//for each node in the list
		for(Node n: curr) {
			if(n.right!=null) next.add(n.right);
			if(n.left!=null) next.add(n.left);
		}
	
		lists.add(curr);
		curr = next;
		}
	}
	
	//traverse using PreOrder
	void traverseTreePreOrder(Node n, int level){
		if(n==null) return;
		//create new list
		LinkedList<Node> curr;
		if(level == this.lists.size()) {
			curr = new LinkedList<>();
			lists.add(curr);
		}else{
			curr = lists.get(level);
		}
		curr.add(n);
		traverseTreePreOrder(n.right, level+1);
		traverseTreePreOrder(n.left, level+1);
		
	}
	public static void main(String[] args){
		BSTtoLinkedLists myTree = new BSTtoLinkedLists();
		Node root = new Node(7);
		root.right = new Node(12);
		root.left = new Node(5);
		root.left.left = new Node(4);
		root.left.left.left = new Node(0);
		
//		myTree.traverseTreeBFS(root);
		myTree.traverseTreePreOrder(root, 0);
		System.out.println("done");
		
	}
}
