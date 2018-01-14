public class gridPath {
	
		public static boolean findPathRecursive(int[][] matrix) {
			return 	findPath(matrix, 0, 0);
		}
		
		public static boolean findPath(int[][] matrix, int r, int c) {
			if(r>=matrix.length||c>=matrix[0].length) return false;
			if(r==matrix.length-1&&c==matrix[0].length-1)
				return true;
			if(matrix[r][c]==-1) return false;
			
			return findPath(matrix, r, c+1) || findPath(matrix, r+1, c);
		}
		
		public static void main(String[] args) {
			int[][] grid = {{0,0,-1,-1},{0,0,-1,0},{-1,0,-1,-1},{-1,-1,-1,0}};
			System.out.println(findPathRecursive(grid));
		}
}

