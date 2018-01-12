
public class IntersectingLinkedLists {
	public static class Node {
		int x;
		Node next;
		
		public Node(int x){
			this.x = x;
			this.next = null;
		}
	}
	
	
	public static boolean doesIntersect(Node r1, Node r2){
		
		Node cur1 = r1;
		Node cur2 = r2;
		
		//traverse the lists
		while(cur1!=null&&cur1.next!=null) cur1 = cur1.next;
		Node tail1 = cur1;
		while(cur2!=null&&cur2.next!=null) cur2 = cur2.next;
		Node tail2 = cur2;
		
		if(tail1!=tail2) return false;
		
		int len1 = getLength(r1);
		int len2 = getLength(r2);
		
		if(len1>len2){
			int diff = len1-len2;
			for(int i=0; i<diff; i++){
				r1 = r1.next;
			}
		}else if(len2>len1){
			int diff = len2-len1;
			for(int i=0; i<diff; i++){
				r2 = r2.next;
			}
		}
		
		//equal length
		while(r1.next!=null){
			if(r1==r2) return true;
			r1=r1.next;
			r2=r2.next;
		}
		
		return false;
	}
	
	
	public static int getLength(Node root){
		int len =0;
		while(root != null && root.next!=null){
			root = root.next;
			len++;
		}
		
		return len;
	}
	
	public static Node detectLoop(Node root){
		Node slow = root;
		Node fast = root;
		
		while(fast!=null&&fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast) break;
		}
		
		if(fast==slow) {
			slow = root;
			while(slow!=fast){
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		}
		
		return null;
	}
	
	
	public static void main(String[] args) {
		Node r1 = new Node(3);
		r1.next = new Node(1);
		r1.next.next = new Node(5);
		Node r2 = new Node(4);
		r2.next = new Node(6);
		
		Node tail = new Node(7);
		tail.next = new Node(11);
		tail.next.next = new Node(12);
		//with a loop
		tail.next.next.next = tail;
		
		r1.next.next.next = tail;
		r2.next.next = tail;
		
		//System.out.println(doesIntersect(r1,r2));
		Node res = detectLoop(r1);
		System.out.println("Loop starts at: " + (res==null ? "none" : res.x));
	}
	
}
