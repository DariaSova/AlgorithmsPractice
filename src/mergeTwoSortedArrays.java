
public class mergeTwoSortedArrays {
	
	public static void merge(int[]a, int[]b){
		int pointer = a.length-1;
		//will start filling from the end
		int p1 = 0;
		
		for(int i=0; i<a.length; i++){
			if(a[i]==0){
				p1 = i-1;
				break;
			}
		}
		int p2 = b.length-1;
		
		while(p1>=0&&p2>=0){
			if(a[p1]>=b[p2]){
				a[pointer--] = a[p1--];
			}else{
				a[pointer--] = b[p2--];
			}
		}
		
		while(p2>=0) a[pointer--] = b[p2--];
	}
	
	
	public static void main(String[] args){
		int[] a = new int[8];
		a[0] = 1;
		a[1] = 5;
		a[2] = 8;
		int[] b = {2,2,3,6,7};
		merge(a,b);
		
		for(int num: a)
			System.out.println(num);
	}
}
