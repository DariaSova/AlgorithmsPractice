
public class QuickSort {
	
	public static int partition(int[] arr, int l, int h){
		int piv = arr[h];
		int i = l;
		
		for(int j=i; j<h; j++){
			if(arr[j]<=piv){
				//swap i and j
				
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
			}
		}
		
		//swap i and high
		int temp = arr[i];
		arr[i] = arr[h];
		arr[h] = temp;
		
		return i;
	}
	
	public static int KthSmallest(int[] arr, int l, int h, int K){
		if(K>=0&&K<=arr.length){
			int pos = partition(arr,l,h);
			
			if(pos==K-1) return arr[pos];
			if(pos<K-1) return KthSmallest(arr, pos+1, h, K); //right
			if(pos>K-1) return KthSmallest(arr, l, pos-1,K); //left
		}
		
		
		return -1;
	}
	
	public static void sort(int[] arr, int l, int h){
		if(l<h){
			int partition_i = partition(arr,l,h);
		
			//sort two subarrays
			sort(arr,l,partition_i-1);
			sort(arr,partition_i+1,h);
		}
		
	}
	
	public static void main(String[] args) {
		int[] arr = {9,8,0,-2,10,400,1,2};
//		int[] arr = {9,-2};
		
		sort(arr,0,arr.length-1);
		
		for(int n: arr) System.out.println(n);
		
		System.out.println(KthSmallest(arr,0,arr.length-1,2));
	}

}
