package cracking_coding_int_moderate;
import java.util.*;

public class KDivingBoard {
	
	static void getAllLengths(HashSet<Integer> res, int K, int curr, int longer, int shorter, HashSet<String> seen) {
		if(K==0){
			res.add(curr);
			return;
		}
		
		String key = K+""+curr;
		if(seen.contains(key))
			return;
		
		getAllLengths(res, K-1, curr+longer, longer, shorter, seen);
		getAllLengths(res, K-1, curr+shorter, longer, shorter, seen);
		seen.add(key);
		
	}
	
	static void getLengths(HashSet<Integer> res, int longer, int shorter, int K){
		
		int nShort = 0;
		
		for(nShort=0; nShort<=K; nShort++){
			int nLong = K -nShort;
			int total = nShort*shorter + nLong*longer;
			res.add(total);
		}
	}
	
	public static void main(String[] args) {
		int longer = 2;
		int shorter = 1;
		HashSet<Integer> lengths = new HashSet<>();
		HashSet<String> seenbefore = new HashSet<>();
		
		
		getAllLengths(lengths, 200, 0, longer, shorter, seenbefore);
		System.out.println(lengths);
		
	}

}
