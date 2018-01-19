
public class MergeSortAlgorithm {

	static void sort(int[] arr, int l, int r ){
		if(l<r){
			int mid = (l+r)/2;
			sort(arr,l,mid);
			sort(arr,mid+1,r);
			
			merge(arr,l, mid, r);
		}
	}
	
	static void merge(int[] arr, int l, int m, int r){
		int len1 = (m-l+1);
		int len2 = (r-m);
		int[] left = new int[len1];
		int[] right = new int[len2];
		
		for(int i=0; i<len1; i++){
			left[i] = arr[i+l];
		}
		
		for(int i=0; i<len2; i++){
			right[i] = arr[i+m+1];
		}
		
		int i=0, j=0; //indexes
		int k = l;
		
		while(i<len1&&j<len2&&k<arr.length){
			if(left[i]<right[j]){
				arr[k++] = left[i++];
			}else {
				arr[k++] = right[j++];
			}
		}
		
		while(i<len1&&k<arr.length){
			arr[k] = left[i];
			i++;
			k++;
		}
		
		while(j<len2&&k<arr.length){
			arr[k++] = right[j++];
		}
		
		
	}
	
	public static void main(String[] args){
		int[] nums = {0,2,17,10,3,5,4};
		sort(nums, 0, nums.length-1);
		for(int n:nums) System.out.println(n);
	}
}
