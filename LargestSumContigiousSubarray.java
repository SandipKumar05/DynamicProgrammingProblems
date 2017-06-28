class LargestSumContigiousSubarray {

/*

find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.

*/


	public static void main(String[] args) {
		
		int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                                       LargestSumContigious(a));
	}


	public static int LargestSumContigious(int[] arr)
	{
		int maximum_sum = 0;
		int maximum_ending = 0;

		for (int i=0; i<arr.length; i++) 
		{
			maximum_ending = maximum_ending + arr[i];

			if (maximum_ending < 0)
				maximum_ending = 0;

			if (maximum_ending > maximum_sum) {
				maximum_sum = maximum_ending;
			}
		}

		return maximum_sum;
	}
	
}