import java.util.*;

public class sortByAnagrams implements Comparator<String> {
	
	public static String sortChars(String s1) {
		char[] s = s1.toCharArray();
		Arrays.sort(s);
		return String.valueOf(s);
	}
	
	@Override
	public int compare(String s1, String s2){
		return sortChars(s1).compareTo(sortChars(s2));
	}
	
	public static  Collection<ArrayList<String>> sortStrings(String[] words){
		HashMap<String, ArrayList<String>> hm = new HashMap<>();
		
		for(String s: words){
			String reverse = sortChars(s);
			if(!hm.containsKey(reverse)){
				hm.put(reverse, (new ArrayList<String>()));
			}
			ArrayList<String> l = hm.get(reverse);
			l.add(s);
			hm.put(reverse, l);
		}
		
		return hm.values();
	}
	
	
	public static void main(String[] args){
		String[] words = {"dbca", "klmnbb", "klm", "cdba", "mkzzz","klm", "abdc", "klm", "zzzmk"};
//		Arrays.sort(words, new sortByAnagrams());
		Collection<ArrayList<String>> res = sortStrings(words);

		
		for(ArrayList<String> s: res)	System.out.println(s.toString()+ "\n");
	}

}
