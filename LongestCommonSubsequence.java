
/*
Given two sequences, find the length of longest subsequence present 
in both of them. A subsequence is a sequence that appears in the same 
relative order, but not necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc 
are subsequences of “abcdefg”. So a string of length n has 2^n different possible subsequences.
*/


public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String str1 = "abcdaf";
		String str2 = "acbcf";

		int[][] trackMatrix = new int[str1.length()][str2.length()];
                
                LongestCommonSubsequence lcm = new LongestCommonSubsequence();

		System.out.println( lcm.longestCommonSubsequence(trackMatrix,str1,str2,str1.length()-1,str2.length()-1) );
		lcm.printSubsequence(trackMatrix,str1,str1.length()-1,str2.length()-1 );
		System.out.println("");
	}
	
	private int longestCommonSubsequence(int[][] trackMatrix, String str1, String str2, int str1Len, int str2Len)
	{
		if (str1Len==-1 || str2Len==-1)
			return 0;

		if (str1.charAt(str1Len) == str2.charAt(str2Len)){
			trackMatrix[str1Len][str2Len] = 0;
			return 1 + longestCommonSubsequence(trackMatrix,str1,str2,str1Len-1,str2Len-1);
		}
		else{
			int len1 = longestCommonSubsequence(trackMatrix,str1,str2,str1Len-1,str2Len);
			int len2 = longestCommonSubsequence(trackMatrix,str1,str2,str1Len,str2Len-1);

			if (len1 > len2) {
				trackMatrix[str1Len][str2Len] = -1;
				return len1;
			}
			else{
				trackMatrix[str1Len][str2Len]=1;
				return len2;
			}
		}
	}

	private void printSubsequence(int[][] trackMatrix, String str1, int len1, int len2)
	{
		if (len1==-1 || len2==-1) {
			return;
		}

            switch (trackMatrix[len1][len2]) {
                case 0:
                    printSubsequence(trackMatrix, str1, len1-1,len2-1);
                    System.out.print(str1.charAt(len1));
                    break;
                case -1:
                    printSubsequence(trackMatrix,str1,len1-1,len2);
                    break;
                default:
                    printSubsequence(trackMatrix,str1,len1,len2-1);
                    break;
            }
	}
}
