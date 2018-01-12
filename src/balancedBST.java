
public class balancedBST {
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
	
	boolean isBST(Node n) {
		if(n == null) return true;
		
		if(n.right!=null&& n.right.x <= n.x || n.left!=null && n.left.x > n.x){
			return false;
		}
		
		return isBST(n.right) && isBST(n.left);
	}
	
	int checkHeight(Node root) {
	
		if(root==null) return 0;
		
		int right = 1 + checkHeight(root.right);
		int left = 1 + checkHeight(root.left);
		
		if(Math.abs(right-left)>1) return -1;
		else return Math.max(right, left);
	}
	
	boolean isBalanced(Node root){
		return checkHeight(root)!=-1;
	}
	
	public static void main(String[] args){
		balancedBST myTree = new balancedBST();
		Node root = new Node(7);
		root.right = new Node(12);
		root.right.right = new Node(13);
		root.left = new Node(5);
		root.left.right = new Node(2);
		root.left.left = new Node(4);
		root.left.left.left = new Node(0);
		
		System.out.println(myTree.isBalanced(root));
		System.out.println(myTree.isBST(root));
	}
}

