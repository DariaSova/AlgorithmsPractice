import java.util.Arrays;

public class SmallestArraysDifference {
	
	static int findDifference(int[] a1, int[] a2){
		if(a1.length==0||a2.length==0) return -1;
		int min = Integer.MAX_VALUE;
		Arrays.sort(a1);
		Arrays.sort(a2);
		
		int p1=0, p2=0;
		
		while(p1<a1.length&&p2< a2.length){
			min = Math.min(min, Math.abs(a1[p1]-a2[p2]));
			if(a1[p1]<=a2[p2]){
				p1++;
			}else{
				p2++;
			}
		}
		
		return min;
	}

	public static void main(String[] args) {
		int[] a1 = {1, 3, 15, 11, 2};
		int[] a2 = {23, 127, 235, 19, 8, 1};
		
		System.out.println(findDifference(a1,a2));
		
	}
}