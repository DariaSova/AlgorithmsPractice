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
	
	//index starts at 0
	public static ArrayList<ArrayList<Integer>> anotherPowerSet(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> res;
		if(set.size()==index){ //base case
			res = new ArrayList<ArrayList<Integer>>();
			res.add(new ArrayList<Integer>()); //add empty list
		} else{
			res = anotherPowerSet(set, index+1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> morelists = new ArrayList<ArrayList<Integer>>(); 
			for(ArrayList<Integer> list: res){
				ArrayList<Integer> newlist = new ArrayList<Integer>();
				newlist.addAll(list);
				newlist.add(item);
				morelists.add(newlist);
			}
			res.addAll(morelists);
		}
		
		return res;
	}
	
	public static ArrayList<ArrayList<Integer>> powerSetBinary(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size();
		
		for(int k=0; k<max; k++){
			ArrayList<Integer> newlist = getList(set, k);
			res.add(newlist);
		}
		
		return res;
	}
	
	public static ArrayList<Integer> getList(ArrayList<Integer> set, int k){
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		for(int i=0; i<k; i<<=1){
			if((i&k)==1){
				res.add(set.get(i));
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(1);
		nums.add(3);
		nums.add(5);
		
		ArrayList<ArrayList<Integer>> res = getSets(nums, 0);
		System.out.println(res.toString());
		ArrayList<ArrayList<Integer>> res2 = getSets2(nums, nums.size()-1);
		System.out.println(res2.toString());
		ArrayList<ArrayList<Integer>> res3 = anotherPowerSet(nums, 0);
		System.out.println(res3.toString());
		
		ArrayList<ArrayList<Integer>> res4 = powerSetBinary(nums);
		System.out.println(res4.toString());

	}
}
