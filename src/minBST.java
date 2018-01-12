
public class minBST {
	public class Node {
		int x;
		Node right;
		Node left; 
		public Node(int x){ 
			this.x = x; 
			this.left = null;
			this.right = null;
		}
	}
	
	Node root;
	public minBST () {
		this.root = null;
}
	
	Node insertArray(int [] arr, int start, int end) {
		if(end<start) return null;
		int mid = (end+start)/2;
		Node n = new Node(arr[mid]);
		n.right = insertArray(arr, mid+1, end);
		n.left = insertArray(arr, start, mid-1);
		return n;
	}
	
	void createBST(int[] arr) {
		this.root = insertArray(arr, 0, arr.length-1); 
	}
	
	public static void main(String[] args){
		int[] myarr = {1,2,3,4,5,6,7,8,9,10,11};
		minBST myBST = new minBST();
		myBST.createBST(myarr);
		System.out.println("done");
	}
}
