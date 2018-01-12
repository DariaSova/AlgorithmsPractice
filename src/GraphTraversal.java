import java.util.*;

public class GraphTraversal {
	
	public static class Node {
		int val;
		ArrayList<Node> neighbours;
		
		public Node(int v){
			this.val = v;
			this.neighbours = new ArrayList<>();
		}
	}
	
	 static int findLIS(int[] s) {
	        if(s.length==1) return 1;
	        
	        int[] res = new int[s.length];
	        res[0] = 1;
	        int max = 1;
	            
	        for(int i=1; i<s.length; i++){
	            int temp = 1; //res[i-1];
	            for(int j=0; j<i; j++) {
	                if(s[j]<s[i]){
	                    temp = Math.max(temp, res[j]+1);
	                }
	                
	            }
	            res[i] = temp;
	            max = Math.max(max, temp);
	        }

	        return max;
	    }
	
	
	public static void main(String[] args) {
//		Node root = new Node()
		int[] nums = {0,1,-2,4,5,-1,0,1,2, -1, -2};
		System.out.println(findLIS(nums));
	}
}
