
public class NumbersProduct {
	
	public static int computeProduct(int a, int b){
		int smaller = a < b ? a : b;
		int bigger = a >= b ? a : b;		
		int res = multiply(a, b);

		return res;
	}

	public static int multiply(int s, int b) {
		if(s==0) return 0;
		if(s==1) return b;
		if(s==-1) return b-b-b;
		
		int smaller = s >> 1; //divide by two
		int res1 = multiply(smaller,b);
		
		if(s % 2 ==0) { //if even
			return res1+res1;
		} else {
			return res1+res1 + b;
		}
		
	}
	
	
	public static void main(String[] args){
		System.out.println(computeProduct(0,1));
		System.out.println(computeProduct(5,1));
		System.out.println(computeProduct(3,2));
		System.out.println(computeProduct(10,20));
		System.out.println(computeProduct(-1, 4));
		System.out.println(computeProduct(-1, -4));
	}
}
