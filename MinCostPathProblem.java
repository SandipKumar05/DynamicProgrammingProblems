class MinCostPathProblem {
/*

Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that 
returns cost of minimum cost path to reach (m, n) from (0, 0). Each cell of the matrix 
represents a cost to traverse through that cell. Total cost of a path to reach (m, n) is 
sum of all the costs on that path (including both source and destination). You can only 
traverse down, right and diagonally lower cells from a given cell, i.e., from a given cell (i, j), 
cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed.


*/
	public static void main(String[] args) {

		int cost[][]= {{1, 2, 3},
                       {4, 8, 2},
                       {1, 5, 3}};
        System.out.println("minimum cost to reach (2,2) = " +
                                         minCost(cost,2,2));
	}

	public static int min(int a, int b)
	{
		return a<b?a:b;
	}

	public static int minCost(int[][] matrix, int m, int n)
	{
		if (m==0 && n==0)
			return matrix[0][0];

		if(m-1>=0 && n-1>=0)
			return matrix[m][n] + min(minCost(matrix,m-1,n-1),min(minCost(matrix,m-1,n),minCost(matrix,m,n-1)));
		else if (n-1>=0)
			return matrix[m][n] + minCost(matrix,m,n-1);
		else
			return matrix[m][n] + minCost(matrix,m-1,n);
	}
	
}