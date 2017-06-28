import java.util.*;

/*

Given two sequences, find the length of longest subsequence present 
in both of them. A subsequence is a sequence that appears in the same 
relative order, but not necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc 
are subsequences of “abcdefg”. So a string of length n has 2^n different possible subsequences.

*/


class LongestCommonSubsequence {

	public static void main(String[] args) {
		String a = "abcdaf";
		String b = "acbcf";

		char[] str1 = a.toCharArray();
		char[] str2 = b.toCharArray();

		int[][] trackMatrix = new int[str1.length][str2.length];

		System.out.println(LCM(trackMatrix,str1,str2,str1.length-1,str2.length-1));
		printSubsequence(trackMatrix,str1,str1.length-1,str2.length-1);
		System.out.println("");


	}
	

	public static int LCM(int[][] trackMatrix, char [] str1, char[] str2, int i, int j)
	{
		if (i==-1 || j==-1)
			return 0;

		if (str1[i]==str2[j]){
			trackMatrix[i][j] = 0;
			return 1 + LCM(trackMatrix,str1,str2,i-1,j-1);
		}
		else{
			int a = LCM(trackMatrix,str1,str2,i-1,j);
			int b = LCM(trackMatrix,str1,str2,i,j-1);

			if (a>b) {
				trackMatrix[i][j] = -1;
				return a;
			}
			else{
				trackMatrix[i][j]=1;
				return b;
			}
		}
	}

	public static void printSubsequence(int[][] trackMatrix, char[] str1, int i, int j)
	{
		if (i==-1 || j==-1) {
			return;
		}

		if (trackMatrix[i][j]==0) {
			printSubsequence(trackMatrix, str1, i-1,j-1);
			System.out.print(str1[i]);
		}
		else if (trackMatrix[i][j]==-1) {
			printSubsequence(trackMatrix,str1,i-1,j);
			
		}
		else
			printSubsequence(trackMatrix,str1,i,j-1);
	}

	// public static int max(int a, int b)
	// {
	// 	return a>b?a:b;
	// }
}