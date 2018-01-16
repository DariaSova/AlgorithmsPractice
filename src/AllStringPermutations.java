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
	
	public static ArrayList<String> findPermutationsWithDups(String s){
		HashMap<Character, Integer> hm = buildFreqTable(s);
		ArrayList<String> res = new ArrayList<String>();
		getPermutationsWithDubplicates(hm, "", s.length(), res);
		
		return res;
		
	}
	
	private static HashMap<Character, Integer> buildFreqTable(String s){
		char[] in = s.toCharArray();
		HashMap<Character, Integer> hm = new HashMap<>();
		for(char c: in){
			if(hm.containsKey(c)) hm.put(c, hm.get(c)+1);
			else hm.put(c, 0);
		}
		return hm;
	}
	
	public static void getPermutationsWithDubplicates(HashMap<Character, Integer> hm, String prefix, int suffix, ArrayList<String> res){
	
		if(suffix==0){
			res.add(prefix);
			return;
		}
		
		for(Character c: hm.keySet()){
			int count = hm.get(c);
			if(count>=0) { //more than one occurrence
				hm.put(c, count-1);
				getPermutationsWithDubplicates(hm, prefix+c,suffix-1,res);
				hm.put(c, count);
			}
		}
	}
	public static void main(String[] args) {
//		String s1 = "ABC";
//		String s2 = "ABCD";
//		HashSet<String> res1 = findPermutations(s1);
//		System.out.println(res1.toString());
//		HashSet<String> res2 = findPermutations(s2);
//		System.out.println(res2.toString());
		
		
		String s3 = "aaab";
		ArrayList<String> res3 = findPermutationsWithDups(s3);
		System.out.println(res3.toString());
	}
}


