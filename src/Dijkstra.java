import java.util.*;

public class Dijkstra {
	int size;
	HashMap<Integer,Node> hm;
	
	static class Node implements Comparable<Node>{
		int x;
		ArrayList<Edge> neighbours;
		int costsofar;
		boolean visited;
		
		public Node(int val){
			x = val;
			neighbours = new ArrayList<Edge>();
			costsofar = Integer.MAX_VALUE;
			visited = false;
		}
		@Override
		public int compareTo(Node b){
			return this.costsofar -b.costsofar;
		}
	}
	
	static class Edge {
		Node dest;
		int weight;
		
		public Edge(Node n, int w){
			dest = n;
			weight = w;
		}
		

	}
	
	public Dijkstra(){
		hm = new HashMap<>();
	}

	void addNode(int x){
		if(!hm.containsKey(x)){
			Node n = new Node(x);
			hm.put(x, n);
			size++;
		}
	}
	
	Node getNode(int x){
		if(hm.containsKey(x)) return hm.get(x);
		return null;
	}
	
	void addEdge(int a, int b, int weight){
		Node na = this.getNode(a);
		Node nb = this.getNode(b);
		
		Edge e = new Edge(nb,weight);
		na.neighbours.add(e);
		nb.neighbours.add(new Edge(na, weight));
		
	}
	
	int computePaths(int start, int l){
		if(hm.size()==0) return -1;
		PriorityQueue<Node> pq = new PriorityQueue<Node>();

		Node s = hm.get(start);
		s.costsofar = 0;
		//start
		pq.add(s);
		
		while(!pq.isEmpty()){
			Node curr = pq.poll();
			curr.visited = true;
			
			for(Edge e: curr.neighbours){
				Node to = e.dest;

				if(to.costsofar>curr.costsofar+e.weight){//update
					//remove from pq
					to.costsofar = curr.costsofar+e.weight;
					if(pq.contains(to)) pq.remove(to);
					//add to pq
					if(!to.visited&&!pq.contains(to)) {
						pq.add(to);
					}
				}
			}
		}
		
		
		
		
	
		
		return hm.get(l).costsofar;
	}
	
	
	///using matrix
	public static int DejkstraMatrix(int[][] graph, int s, int k){
		int len = graph.length;
		boolean[] visited = new boolean[len];
		
		visited[s] = true;
		
		for(int j=0; j<len-1; j++){
			int next = findMin(graph[s], visited);
			visited[next] = true;
			
			int cost = graph[s][next];
			
			for(int i=0; i<len; i++){
				if(graph[next][i] <Integer.MAX_VALUE && cost+graph[next][i]<graph[s][i]){
					graph[s][i] = cost+graph[next][i];
				}
			}
		}
		
		return graph[s][k];
	}
	
	public static int findMin(int[] row, boolean[] visited){
		int min = -1;
		
		for(int i=0; i<row.length; i++){
			if(!visited[i]){
				min = i;
			}
		}
		//not found
		if(min==-1) return min;
		
		for(int i=0; i<row.length; i++){
			if(!visited[i]&&row[i]<row[min]) min = i;
		}
		
		return min;
	}

	public static void main(String[] args){
		Dijkstra graph = new Dijkstra();
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		
		graph.addEdge(1, 2, 5);
		graph.addEdge(1, 3, 3);
		graph.addEdge(3, 2, 1);
		graph.addEdge(2, 4, 2);
		graph.addEdge(3, 4, 5);
		
		System.out.println(graph.computePaths(1, 4));
		System.out.println(graph.computePaths(1, 3));
		System.out.println(graph.computePaths(1, 2));
		System.out.println(graph.computePaths(2, 4));
		
		
		//graph
		int[][] matrix = {{0,5,3,Integer.MAX_VALUE},{5,0,1,3},{3,1,0,5},{Integer.MAX_VALUE,3,5,0}};
		System.out.println(DejkstraMatrix(matrix, 0, 3));
		System.out.println(DejkstraMatrix(matrix, 1, 2));
	}
}
