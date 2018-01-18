
public class lessThanBSTRank {
	static class Node {
		int x;
		int count;
		Node right;
		Node left;
		
		public Node(int val){
			this.x = val;
			this.count = 0;
			this.right = null;
			this.left = null;
		}
	}
	
	static class Tree{
		Node root;
		
		public Tree(Node n){
			this.root = n;
		}
		
		public Tree(){
			this.root = null;
		}
		
		void insertNode(Node n, Node root){
			if(root==null){
				root = n;
				return;
			}
			inserNewNode(n, root);
		}
		
		void inserNewNode(Node n, Node root2){
			if(root2.x>n.x){
				root2.count++; //one more element goes left
				if(root2.left==null) root2.left = n;
				else insertNode(n, root2.left);
			}
			else
				if(root2.right==null) root2.right = n;
				else insertNode(n, root2.right);
		}
		
		int getRank(int k){
			if(root == null) return -1;
			return getRank(k, root);
		}
		
		int getRank(int k, Node root2){
			
			if(k<root2.x&&root2.left!=null){
				return getRank(k, root2.left);
			}
			else if(k==root2.x){
				return root2.count;
			}
			else if(root2.right!=null) { //k>=root.x
				return root2.count+1+getRank(k,root2.right);
			}
			return Integer.MIN_VALUE; ////should throw error here: node not found
		}
	}
	
	public static void main(String[] args){
		Node root = new Node(20);
		Tree mytree = new Tree(root);
		mytree.insertNode(new Node(15), root);
		mytree.insertNode(new Node(10), root);
		mytree.insertNode(new Node(5), root);
		mytree.insertNode(new Node(13), root);
		mytree.insertNode(new Node(25), root);
		mytree.insertNode(new Node(23), root);
		mytree.insertNode(new Node(24), root);
		
		System.out.println(mytree.getRank(25));
		System.out.println(mytree.getRank(24));
		System.out.println(mytree.getRank(10));
		System.out.println(mytree.getRank(23));
		System.out.println(mytree.getRank(13));
		System.out.println(mytree.getRank(50));
	}

}
