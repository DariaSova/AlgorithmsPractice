
///Note Array may have empty strings in it
//eg {"at","", "", "", "ball", "tt" , u" , "car", "" , "" , "dad", ""} finf: "ball"

public class searchThroughArrayOfStrings {
	
	static int search(String[] words, String s, int left, int right){
		if(left>right) return -1; //did not find any
		
		int mid = (right +left) /2;
		
		//case when middle is empty
		if(words[mid]==""){
			int rp = mid+1;
			int lp = mid -1;
			while(true){
				if(rp>right||lp<left) return -1;
				else if(!words[rp].isEmpty()) {
					mid = rp;
					break;
				}else if(!words[lp].isEmpty()){
					mid = lp;
					break;
				}
				rp++;
				lp--;
			}
			
		}
		
		if(words[mid]==s) return mid;
		else if(s.compareTo(words[mid])>0) return search(words,s,mid+1, right);  //search right
		else return search(words,s,left, mid-1); //search left 
	}
	
	static int search(String[] words, String s){
		if(s==null||s==""||words.length==0) return -1;
		
		return search(words,s,0,words.length-1);
	}
	
	public static void main(String[] args){
		String[] words = {"a","b","","","","","","galla","","zsh",""};
		String s = "galla";
		
		System.out.println(search(words,s));
		System.out.println(search(words,"b"));
		System.out.println(search(words,"zsh"));
		System.out.println(search(words,"molly"));
	}
	

}
