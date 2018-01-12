

public class URLfy {

	public static void urify(char[] input){
		if(input.length>1){
			int i = input.length-1;
			int j = input.length-1;
			while(input[i]==' '&&i>=0)
				i--;
			
			for(i=i; i>=0; i--){
				if(input[i]==' '){
					input[j--] = '0';
					input[j--] = '2';
					input[j--] = '%';
				}else{
					input[j--] = input[i];
			
				}
			}
			
		}
		
	}
	
	static int getCharNumber(char c){
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int ch = Character.getNumericValue(c);
		
		if(ch <= z && ch >= a)	return ch -a;
		
		
		return -1;
	}
	
	public static boolean isPermutationOfAPalindrome(String s){
		char[] chars = s.toCharArray();
		int bitNum = 0;
		
		for(char c: chars){
			//get char's numeric value
			int val = getCharNumber(c);
			int mask = 1 << val;
			
			if((bitNum&mask) == 0) {
				bitNum |= mask;
			} else{
				//override bit
				bitNum &= ~mask;
			}
		}
		
		return (bitNum&(bitNum-1))==0;
	}
	
	public static void roatetMatrix(int[][] arr) {
		int layersnum = arr.length/2;
		int len = arr.length;
		
		//for each layer
		for(int i=0; i<layersnum; i++){
			int first = i;
			int last = len-i-1;
			
			//swap row/columns
			for(int j=first; j<last; j++){
				int temp = arr[first][j];
				int offset = j - first;
				//left to top
				arr[first][j] = arr[last-offset][first];
				//bottom to left
				arr[last-offset][first] = arr[last][last-offset];
				//right to botto
				arr[last][last-offset] = arr[j][last];
				//top to right
				arr[j][last] = temp;
			}
		}
		
	}
	
	public static void main(String[] args) {
		String s = " Ms John Smith      ";
		char [] in = s.toCharArray();
		urify(in);
		System.out.println(in);
		
		String  palindromePerm = "TactCao";
		System.out.println(isPermutationOfAPalindrome(palindromePerm));
		
		int[][] matrix =  {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		roatetMatrix(matrix);
		
		for(int i=0; i<matrix.length;i++){
			for(int n: matrix[i]) System.out.print(n+" ");
			System.out.println();
		}
	}
}
