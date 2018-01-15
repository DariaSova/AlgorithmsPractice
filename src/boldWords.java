
public class boldWords {
	
	public static String markBold(String[] words, String s){
		StringBuilder sb  = new StringBuilder();
		
		boolean[] bold = new boolean[s.length()];

		for(String w: words){
			for(int i=0; i<s.length(); i++){
				if(s.substring(i).startsWith(w)){
					
					for(int j=i; j<i+w.length();j++){
						bold[j] = true;
					}
				}
			}
		}
		
		boolean opentag = false;
		char[] chars = s.toCharArray();
		for(int i=0; i<chars.length;i++){
			if(bold[i]==true){
				sb.append("<b>");
				opentag = true;
				while(i<chars.length&&bold[i]==true) {
					sb.append(chars[i]);
					i++;
				}
			}
			
			if(opentag){
				sb.append("</b>");
				opentag = false;
			}
			
			if(i<chars.length) sb.append(chars[i]);
		}
		
		
		
		return sb.toString();
		
	}
	
	
	public static void main(String[] args){
		String[] words = {"bc","mz","xd", "a"};
		String s = "abcklmzxdxd";
		
		System.out.println(markBold(words, s));
	}

}
