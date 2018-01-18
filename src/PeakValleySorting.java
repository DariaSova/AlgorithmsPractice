//valley peak valley sequence
public class PeakValleySorting {
	
	
	static void sortNumbers(int[] arr){
		int len = arr.length;
		if(len<=1) return;
		if(len==2){
			if(arr[0]>arr[1]){
				swap(arr, 0,1);
				return;
			}
		}
		//windows of 3 elements at a time
		for(int i=0; i+2<len;i+=2){
			int mid = i+1;
			//for peak-valley-peak seq swap comparison here to <
			int max = (arr[i]>arr[i+1]) ? i : (i+1);
			//and here < *also for the case of two elements
			max = (arr[max]<arr[i+2]) ? (i+2) : max;
			if(max!=mid) swap(arr,max,mid);
		}
		
	}
	
	
	static void swap(int[]arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void main(String[] args){
		int[] arr = {9,8,7,10,11,12};
		sortNumbers(arr);
		
		for(int n: arr)
			System.out.println(n+" ");
		
	}

}
