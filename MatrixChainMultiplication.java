
/*
GiveGiven an array p[] which represents the chain of matrices such that the ith 
matrix Ai is of dimension p[i-1] x p[i]. We need to write a function MatrixChainOrder() 
that should return the minimum number of multiplications needed to multiply the chain.n 
an array p[] which represents the chain of matrices such that the ith matrix Ai is of 
dimension p[i-1] x p[i]. We need to write a function MatrixChainOrder() that should 
return the minimum number of multiplications needed to multiply the chain.

*/




class MatrixChainMultiplication {

	public static void main(String[] args) {

		int arr[] = new int[] {10, 20, 30};
        int size = arr.length;
 
        System.out.println("Minimum number of multiplications is "+
                           MinimumCost(arr, 0, size-1));
		
	}
	
	public static int MinimumCost(int[] arr,int start, int end)
	{
		if ((end-start)==1) {
			return 0;
		}

		int minCost = 100000000;
		for (int i=start+1; i<end; i++) {

			minCost = min(minCost, MinimumCost(arr,start,i)+MinimumCost(arr,i,end)+arr[start]*arr[i]*arr[end]);
		}

		return minCost;
	}

	public static int min(int a, int b)
	{
		return a<b?a:b;
	}
}