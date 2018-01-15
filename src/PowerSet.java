import java.util.ArrayList;

public class PowerSet {

	public static ArrayList<ArrayList<Integer>> getSets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allsets; 
		
		if(set.size()==index) {
			allsets = new ArrayList<ArrayList<Integer>>();
			allsets.add(new ArrayList<Integer>()); //add empty
		}else {
			allsets = getSets(set, index+1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresets = new ArrayList<ArrayList<Integer>>();
			
			for(ArrayList<Integer> list: allsets){
				ArrayList<Integer> newset = new ArrayList<Integer>();
				newset.addAll(list);
				newset.add(item);
				moresets.add(newset);
			}
			allsets.addAll(moresets);
		}
		
		return allsets;
	}
	
	public static ArrayList<ArrayList<Integer>> getSets2(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allsets; 
		
		if(index==0) {
			allsets = new ArrayList<ArrayList<Integer>>();
			allsets.add(new ArrayList<Integer>()); //add empty
		}else {
			allsets = getSets(set, index-1);
			int item = set.get(set.size()-1-index);
			ArrayList<ArrayList<Integer>> moresets = new ArrayList<ArrayList<Integer>>();
			
			for(ArrayList<Integer> list: allsets){
				ArrayList<Integer> newset = new ArrayList<Integer>();
				newset.addAll(list);
				newset.add(item);
				moresets.add(newset);
			}
			allsets.addAll(moresets);
		}
		
		return allsets;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		
		ArrayList<ArrayList<Integer>> res = getSets(nums, 0);
		System.out.println(res.toString());
		ArrayList<ArrayList<Integer>> res2 = getSets2(nums, nums.size()-1);
		System.out.println(res2.toString());

	}
}
