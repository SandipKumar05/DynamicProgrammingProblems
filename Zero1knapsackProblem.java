import java.util.*;

/*

Given weights and values of n items, put these items in a knapsack of capacity W to get the 
maximum total value in the knapsack. In other words, given two integer arrays val[0..n-1] 
and wt[0..n-1] which represent values and weights associated with n items respectively. 
Also given an integer W which represents knapsack capacity, find out the maximum value subset 
of val[] such that sum of the weights of this subset is smaller than or equal to W. 

*/

class Zero1knapsackProblem {

	public static void main(String[] args) {

		int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
    	int  W = 50;
    	int n = val.length;
    	System.out.println(knapSack(W, wt, val, n));
	}

	public static int knapSack(int Weight, int[] wt, int[] val, int n)
	{

		int[][] solutionMatrix = new int[n][Weight+1];


		for (int j=0; j<=Weight; j++) {

			if (j<wt[0]) {
				solutionMatrix[0][j] = 0;
			}
			else{
				solutionMatrix[0][j] = val[0];
			}
		}

		for (int i=1; i<n; i++) {

			for (int j=0; j<=Weight; j++) {

				if (j < wt[i]) {

					solutionMatrix[i][j] = solutionMatrix[i-1][j];
				}
				else{
					solutionMatrix[i][j] = max(val[i] + solutionMatrix[i-1][j-wt[i]], solutionMatrix[i-1][j]);
				}
			}			
		}
		return solutionMatrix[n-1][Weight];	
	}

	public static int max(int a, int b)
	{
		return a>b?a:b;
	}
}