import java.util.*;

public class gridPath {
		static class Point{
			int x;
			int y;
			
			public Point(int x, int y){
				this.x = x;
				this.y = y;
			}
		}
	
		public static ArrayList<Point> findPathRecursive(int[][] matrix) {
			ArrayList<Point> res = new ArrayList<Point>();
			if(findPath(matrix, res, 0, 0)) return res;
			//better return null and check in main
			return new ArrayList<Point>();
		}
		
		
		//TODO: write another method that will return all possible paths
		public static boolean findPath(int[][] matrix, ArrayList<Point> res, int r, int c) {
			if(r==matrix.length||c==matrix[0].length) return false;
			Point curr = new Point(r,c);
			if(r==matrix.length-1&&c==matrix[0].length-1){
				res.add(curr);
				return true;
			}
			
			if(matrix[r][c]==-1) return false;
			
			
			res.add(curr);
			
			return findPath(matrix, res, r, c+1)||findPath(matrix, res, r+1, c);
		}
		
		public static void main(String[] args) {
			int[][] grid = {{0,-1,-1,-1},{0,-1,-1,0},{0,0,0,-1},{-1,-1,0,0}};
			for(Point p: findPathRecursive(grid))
					System.out.println(p.x +" "+p.y+"\n");
		}
}

