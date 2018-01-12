import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	
	public static class Node{
		int val;
		Node right;
		Node left;
		
		public Node(int x){
			this.val = x;
			this.right = null;
			this.left = null;
		}
	}
	
	Node root;
	
	public BinaryTree(){
		this.root = null;
	}
	
	
	public static void preOrder(Node root){
		System.out.print(root.val+" ");
		if(root.left!=null) preOrder(root.left);
		if(root.right!=null) preOrder(root.right);
	}
	
	public static void postOrder(Node root){
		if(root.left!=null) postOrder(root.left);
		if(root.right!=null) postOrder(root.right);
		System.out.print(root.val+" ");
	}
	
	
	public static void inOrder(Node root){
		if(root.left!=null) inOrder(root.left);
		System.out.print(root.val+" ");
		if(root.right!=null) inOrder(root.right);
	}
	
//	public static void DFS(Node root){
//		if(root==null) return;
//		DFS(root.left);
//	}
	
	public static void BFS(Node root){
		if(root==null) return;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()){
			Node curr = q.remove();
			System.out.print(curr.val+" ");
			if(curr.left!=null) q.add(curr.left);
			if(curr.right!=null) q.add(curr.right);
			//print current
			//add all children of curr
			
			//check for visited? maybe not
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        
        preOrder(tree.root);
        System.out.println();
        postOrder(tree.root);
        System.out.println();
        inOrder(tree.root);
        System.out.println();
        BFS(tree.root);
	}

}
