import java.util.*;

public class AllStringPermutations {
	
	public static HashSet<String> findPermutations(String s){
		if(s.length()==0) return null;
//		if(s.length()==1) can make it a special case
		return getPermutations(s.toCharArray(), 0);
	}
	
	public static HashSet<String> getPermutations(char[] in, int index){
		HashSet<String> result;
		if(index == in.length-1) {
			 result =  new HashSet<String>();
			 result.add(String.valueOf(in[index]));
		}else{
			result = getPermutations(in, index+1);
			char curr = in[index];
			
			HashSet<String> new_result = new HashSet<String>();
			//try having array list of string builders
			for(String s: result){
				for(int i=0; i<=s.length(); i++){
					//check last index
					String newstr = s.substring(0,i) + curr + s.substring(i);
					new_result.add(newstr);
				}
			}
			result = new_result;
		}
		return result;
	}
	
	public static void main(String[] args) {
		String s1 = "ABC";
		String s2 = "ABCD";
		HashSet<String> res1 = findPermutations(s1);
		System.out.println(res1.toString());
		HashSet<String> res2 = findPermutations(s2);
		System.out.println(res2.toString());
	}
}


