import java.util.ArrayList;

public class ValidBracketsPermutations {
	
	public static ArrayList<String> findPermutations(int n) {
		ArrayList<String> res = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		getPermutation(0,0,n,sb,res);
		return res;
	}
	
	public static void getPermutation(int left, int right, int n, StringBuilder sb, 	ArrayList<String> res){
		
		if(left==right&&left==n){
			res.add(sb.toString());
		}
		
		if(left<n) {
			sb.append('(');
			getPermutation(left+1, right, n,sb,res);
			sb.deleteCharAt(sb.length()-1);
		}
		
		if(right<left&&right<n){
			sb.append(')');
			getPermutation(left, right+1, n,sb,res);
			sb.deleteCharAt(sb.length()-1);
		}
		
	}
	
	public static void main(String[] args){
		ArrayList<String> res = findPermutations(4);
		System.out.println(res.toString());
	}

}
