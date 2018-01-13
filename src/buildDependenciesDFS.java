import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class buildDependenciesDFS {
	HashMap<String,Node> hm;
	
	
	public buildDependenciesDFS(){
		this.hm = new HashMap<>();
	}

	static class Node {
		String x;
		boolean isVisiting;
		boolean visited;
		ArrayList<Node> incoming;
		ArrayList<Node> outgoing;

		
		public Node(String s){
			x = s;
			this.incoming = new ArrayList<>();
			this.outgoing = new ArrayList<>();
			this.isVisiting = false;
			this.visited = false;
		}
	}
	
	Node findOrAddNode(String a) {
		if(hm.containsKey(a)) return hm.get(a);
		Node n = new Node(a);
		hm.put(a,n);
		
		return n;
	}
	
	Stack<Node> orderNodes(){
		Stack<Node> res = new Stack<>();
		
		for(Node n: hm.values()){
			if(n.visited==false){
				if(!canDFS(n, res)) return null;
			}
		}
		
		
		return res;
		
	}
	
	boolean canDFS(Node n, Stack<Node> stack){
		//cycle detection
		if(n.isVisiting) return false;
		
		n.isVisiting = true;
		for(Node next: n.outgoing){
			if(!canDFS(next, stack)) return false;
		}
		n.visited = true;
		stack.push(n);
		return true;
	}
	
	void addDepencency(String x, String z) {
		Node a = findOrAddNode(x);
		Node b = findOrAddNode(z);
		a.outgoing.add(b);
		b.incoming.add(a);
}
	
	public static void main(String[] args){
		buildDependenciesDFS myBuild = new buildDependenciesDFS();
		//add dependencies
		myBuild.addDepencency("a", "b");
		myBuild.addDepencency("a", "d");
		myBuild.addDepencency("b", "z");
		myBuild.addDepencency("d", "x");
		myBuild.addDepencency("x", "m");
		myBuild.addDepencency("s", "k");
		//find order
		Stack<Node> res = myBuild.orderNodes();
		//print
		while(!res.isEmpty()) System.out.println(res.pop().x +" ");
		
	}
}
