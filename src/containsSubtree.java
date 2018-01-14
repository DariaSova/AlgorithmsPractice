public class containsSubtree {
	static class Node {
		int x;
		Node right;
		Node left;

		
		public Node(int s){
			x = s;
			this.right = null;
			this.left = null;
		}
	}
	
	boolean isSubtree(Node r1, Node r2){
		if(r1==null) return false;
		if(subtreeMatch(r1,r2)) return true;
		return isSubtree(r1.left,r2) || isSubtree(r1.right, r2);
	}
	
	boolean subtreeMatch(Node r1, Node r2) {
		if(r1==null&&r2==null) return true;
		if(r1==null||r2==null) return false;
		if(r1.x!=r2.x) return false;
		else return subtreeMatch(r1.left, r2.left)&&subtreeMatch(r1.right,r2.right);
	}
	
	public static void main(String[] args) {
		containsSubtree myClass = new containsSubtree();
		Node r1 = new Node(10);
		r1.left = new Node(7);
		r1.right = new Node(12);
		r1.right.right = new Node(14);
		
		Node r2 = new Node(12);
		r2.right = new Node(14);
	
		Node r3 = new Node(12);
		r3.right = new Node(15);
		
		System.out.println(myClass.isSubtree(r1, r2));
		System.out.println(myClass.isSubtree(r1, r3));
	}
}
