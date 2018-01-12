
public class sample {
//	public static String solution(String S, int K) {
//        StringBuilder sb=new StringBuilder("");
//        char[] input = S.replace("-","").toCharArray();
//        int n = input.length;
//        int rem = n%K;
//        int i=0;
//        if(rem!=0){
//            for(i=0;i<rem; i++)  sb.append(input[i]) ;
//            if(Character.isLetter(input[i])) Character.to input[i]
//            	sb.append("-");
//        }
//        
//        while(i<n){
//	        for(int j=0; j<K; j++){
//	        	sb.append(input[i++]);
//	        }
//	        if(i!=n) sb.append("-");
//        }
//        return sb.toString();
//    }
	
	public static String reverse(String str) {
	    if ((null == str) || (str.length() <= 1)) {
	        return str;
	    }
	    return reverse(str.substring(1)) + str.charAt(0);
	}
	
	   public static String solution(String S) {
	        if(S.length()<5) return "";
	        // write your code in Java SE 8
	        String[] in = S.split(":");
	        int h = Integer.valueOf(in[0]);
	        int m = Integer.valueOf(in[1]);
	        
	        int[] digits = new int[4];
	        digits[0] = (Integer.valueOf(in[0])-Integer.valueOf(in[0])%10)/10;
	        digits[1] = Integer.valueOf(in[0])%10;
	        digits[2] = (Integer.valueOf(in[1])-Integer.valueOf(in[1])%10)/10;
	        digits[3] = Integer.valueOf(in[1])%10;
	        int min = 24;
	        boolean[] taken = new boolean[4];
	        int pri=-1, prj=-1;
	        
	        for(int i=0; i<4;i++){
	            for(int j=0; j<4; j++){
	                if(j!=i){
	                    int cur = digits[i]*10+digits[j];
	                    if(cur<min&&cur>=h||cur==0) {
	                        min = cur;
	                        if(cur==0) cur=24;
	                        if(pri!=-1) taken[pri] =false;
	                        if(prj!=-1) taken[prj] =false;
	                        taken[i]=true;
	                        taken[j]=true;
	                        pri=i;
	                        prj=j;
	                    }
	                }
	            }
	        }
	        
	        String newH="";
	        if(min==24) newH = "00";
	       
	        else newH=String.valueOf(min);
	        
	        int m1=0,m2=0;
	        int i=0;
	        for(i=0; i<4; i++){
	            if(taken[i]!=true){
	                m1=digits[i];
	                taken[i]=true;
	                break;
	            }
	        }
	        
	        for(i=i; i<4; i++){
	            if(taken[i]!=true){
	                m2=digits[i];
	                taken[i]=true;
	            }
	        }
	        
	        int mm = m1*10+m2;
	        String newM="";
	        if(mm==0) newM = "00";
	        else if(mm<=m2*10+m1) {
	        	if(mm<10)newM=Integer.toString(mm)+"0";
	        	else newM=Integer.toString(mm);
	        }
	        else {
	        	if(m2*10+m1<10) newM=Integer.toString(m2*10+m1)+"0";
	        	else newM=Integer.toString(m2*10+m1);
	        }
	        
	        return newH+":"+newM;
	        
	        //try swapping
	      //  if(m<24)
//	            return in[1]+":"+in[0];
	        //check bounds
	  //      else return in[0]+":"+in[1];
	        
	        
	        //one digit perm??
	    }
	
	public static void main(String[] args) {
//		String s = "";
		System.out.println(reverse("Hello!?"));
	}
}
