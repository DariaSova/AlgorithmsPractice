import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.HashMap;

public class buildDependencies {
	PriorityQueue<Node> pq;
	HashMap<String,Node> hm;
	static class Node implements Comparable<Node>{
		String x;
		ArrayList<Node> incoming;
		ArrayList<Node> outgoing;
		public Node(String x) {
			this.x = x;
			this.incoming = new ArrayList<>();
			this.outgoing = new ArrayList<>();
}
	@Override
	public int compareTo(Node b) {
		if(this.incoming.size() < b.incoming.size()) return -1;
	    return 1;
	}
	}
	
	
	public buildDependencies(){
		pq = new PriorityQueue<Node>();
		hm = new HashMap<>();
	}
	
	Node findOrAddNode(String a) {
		if(hm.containsKey(a)) return hm.get(a);
		Node n = new Node(a);
		hm.put(a, n);
		
		return n;
	}
	
	void addDepencency(String x, String z) {
			Node a = findOrAddNode(x);
			Node b = findOrAddNode(z);
			a.outgoing.add(b);
			b.incoming.add(a);
	}
	
	void removeDependency(Node a){
		for(Node n: a.outgoing){
			n.incoming.remove(a);
			//reinsert
			pq.remove(n);
			pq.add(n);
	}
}

	ArrayList<String> findOrder() {
		for(Node n: hm.values()){
			//add to PQ as well
			pq.add(n);
		}
		
		if(pq.size()==0) return null;
		ArrayList<String> result = new ArrayList<>();
		while(!pq.isEmpty()){
			Node curr = pq.poll();
			if(curr.incoming.size()>0) return null; //no independent nodes!!
			result.add(curr.x);
			removeDependency(curr);
		}
		return result;	
	}
	
	public static void main(String[] args) {
	buildDependencies myBuild = new buildDependencies();
	//add all dependencies (a,b)
	myBuild.addDepencency("a", "d");
	myBuild.addDepencency("f", "b");
	myBuild.addDepencency("b", "d");
	myBuild.addDepencency("f", "a");
	myBuild.addDepencency("d", "c");
	ArrayList<String> res = myBuild.findOrder();
	
	for(String s: res) System.out.println(s + "");
}
	
}
