
public class QuickSortAlgorithm {
	
	
	int sort(int[] arr, int l, int h){
		int piv = arr[h];
		
		int i = l;
		int j =h-1;
		
		while(i<j){
			while(arr[i]<piv){
				i++;
			}
			
			while(arr[j]>piv) j++;
			
			if(i<j){
				swap(arr[i],arr[j]);
				i++;
				j--;
			}
		}
		swap(arr[i], arr[h]);
		return i;
		
	}
	
	void swap()
	
	void QuickSortnums(int[] arr, int l, int h){
		if(l<h){
			int piv = sort(arr,l,h);
			
			QuickSortnums(arr,l,piv-1);
			QuickSortnums(arr,piv+1,h);
		}
		
	}

}
