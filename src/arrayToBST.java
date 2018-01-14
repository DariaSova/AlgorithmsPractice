import java.util.*;


public class arrayToBST {
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

	ArrayList<LinkedList<Integer>> allPossibleSequaences(Node node){
		ArrayList<LinkedList<Integer>> res = new ArrayList<LinkedList<Integer>>();
		
		if(node == null) {
			res.add(new LinkedList<Integer>());
			return res;
		}
		
		LinkedList<Integer> prefix = new LinkedList<>();
		prefix.add(node.x);
		
		ArrayList<LinkedList<Integer>> leftseq = allPossibleSequaences(node.left);
		ArrayList<LinkedList<Integer>> rightseq = allPossibleSequaences(node.right);
		for(LinkedList<Integer> r: rightseq){
			for(LinkedList<Integer> l: leftseq){
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
				weaveList(l, r, weaved, prefix);
				res.addAll(weaved);
			}
		}
		return res;
	}
	
	void weaveList(LinkedList<Integer> first,LinkedList<Integer> second,ArrayList<LinkedList<Integer>> res, LinkedList<Integer> prefix ){
		//if one list is empty -> append it
		if(first.size() ==0 || second.size()==0){
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			res.add(result);
			return;
		}
		
		//try adding first
		int firsthead = first.removeFirst();
		prefix.addLast(firsthead);
		weaveList(first,second, res, prefix);
		first.addFirst(prefix.removeLast());
		
		//try adding the second
		int secondthead = second.removeFirst();
		prefix.addLast(secondthead);
		weaveList(first,second, res, prefix);
		second.addFirst(prefix.removeLast());
	}
	
	
	public static void main(String[] args){
		Node root = new Node(2);
		root.right = new Node(5);
		root.left = new Node(1);
		arrayToBST myClass = new arrayToBST();
		ArrayList<LinkedList<Integer>> res = myClass.allPossibleSequaences(root);
		for(LinkedList<Integer> list: res) {
			for(int num: list)	System.out.println(num+" ");
			System.out.println();
		}
	}
}
