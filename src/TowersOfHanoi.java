import java.util.*;

public class TowersOfHanoi {
	
	static class Tower {
		Stack<Integer> discs;
		int index;
		
		public Tower(int i){
			this.index = i;
			this.discs = new Stack<>();
		}
		
		public void addDisc(int x){
			if(!discs.isEmpty()&&discs.peek() <= x) System.out.println("ERROR: Cannot place bigger disc on top of a smaller one.");
			else 
				discs.push(x);
		}
		
	
		public void moveTopTo(Tower t){
			if(!discs.isEmpty()) t.addDisc(this.discs.pop());
		}
		
		public void moveDiscs(int n, Tower destination, Tower buffer){
			if(n>0){
				moveDiscs(n-1, buffer, destination);
				moveTopTo(destination); //moves 1 first not 5
				moveDiscs(n-1, destination, this);
			
				
			}
		}
	}
	

	public static void main(String[] args) {
		int n = 3;
		Tower[] towers = new Tower[n];
		for(int i=0; i<n; i++) towers[i] = new Tower(i);
		int discsNum = 5;
		for(int i=discsNum; i>0; i--){
			towers[0].addDisc(i);
		}
		
		
		towers[0].moveDiscs(discsNum, towers[2], towers[1]);
		while(!towers[2].discs.isEmpty())
			System.out.println(towers[2].discs.pop()+" ");
//		while(!towers[1].discs.isEmpty())
//			System.out.println(towers[1].discs.pop()+" ");
//		while(!towers[0].discs.isEmpty())
//			System.out.println(towers[0].discs.pop()+" ");
	}

}
