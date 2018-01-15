
public class magicNumber {
	
	
	public static int getMagicIndex(int[] arr, int l, int h) {
		if(l>h) return -1;
		int mid = (h+l)/2;
		if(arr[mid]>mid){
			//recurse left
			return getMagicIndex(arr, l, mid-1);
		}else if(arr[mid]<mid){
			return getMagicIndex(arr, mid+1, h);
		}else
			return mid;
		
	}
	
	public static int getMagicIntexUnsorted(int[] arr, int l, int h){
		if(l>=h) return -1;
		int mid = (h+l)/2;
		
		if(mid==arr[mid]) return mid;
		
		//left
		int lindex = Math.min(mid-1, arr[mid]);
		int left = getMagicIndex(arr, l, lindex);
		if(left>-1) return left;
		
		int rindex = Math.max(arr[mid], mid+1);
		int right = getMagicIndex(arr, rindex, h);
		return right;

	}
	
	public static void main(String[] args) {
		int[] arr1 = {-1,0,1,2,3,5,7,10,11};
		int[] arr2 = {-20,-10,-5,0,1,2,3,4,5};
		int[] arr3 = {};
		int[] arr4 = {-1,1,20,30};
		int[] arr5 = {0};
		
		System.out.println(getMagicIndex(arr1,0,arr1.length-1));
		System.out.println(getMagicIndex(arr2,0,arr2.length-1));
		System.out.println(getMagicIndex(arr3,0,arr3.length-1));
		System.out.println(getMagicIndex(arr4,0,arr4.length));
		System.out.println(getMagicIndex(arr5,0,arr5.length));
		
		int[] arr11 = {-1,-1,-1,4,4,6,7,10,11};
		int[] arr22 = {-20,-10,-5,-2,3,3,6,4,5};
		int[] arr33 = {};
		System.out.println();
		System.out.println(getMagicIntexUnsorted(arr11,0,arr11.length-1));
		System.out.println(getMagicIntexUnsorted(arr22,0,arr22.length-1));
		System.out.println(getMagicIntexUnsorted(arr33,0,arr33.length-1));
	}

}
