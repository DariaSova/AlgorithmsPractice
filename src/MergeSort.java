
public class MergeSort {
	
	
	public static void MergeS(int[] arr){
		int[] temp = new int[arr.length];
		sort(arr, temp, 0, arr.length-1);
	}
	
	public static void sort(int[] arr, int[] temp, int l, int r){
		if(r>l){
			int middle = (r+l)/2;
			sort(arr, temp, l, middle);
			sort(arr, temp, middle+1, r);
			merge(arr, temp, l, middle, r);
		}
		
	}
	
	public static void merge(int[] arr, int[] temp, int l, int m, int end){
		int s = l;
		int right = m+1;
		int n = end-l;
		
		while(l<=m&&end>=right){
			if(arr[l]>arr[right]){
				temp[s++] = arr[right++];
			}else{
				temp[s++] = arr[l++];
			}
			
		}
			while(l<=m){
				temp[s++] = arr[l++];
			}
			
			while(right<=end){
				temp[s++] = arr[right++];
			}
			
			//copy over
			for(int i=0; i<=n; i++, end--){
				arr[end] = temp[end];
			}
		
		
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		int[] myArray = {-2, -10, 200, -15, 2, 3, 0, 150, 199, 1 };
//		int[] myArray = {-10, -200, 0,5, 3 };
//		int[] myArray = {2};
		
		MergeS(myArray);	
		for(int num: myArray) System.out.println(num);
		
	}
}
