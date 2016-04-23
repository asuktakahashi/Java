import java.util.Arrays;

class Solution_Permutation{
	public static int solution(int[] A){
		//if the length is out of the range
		if(A.length < 2 || A.length > 1000000000){ return 0; }
		
		Arrays.sort(A);
		
		int diff = 0;
		for(int i = 1; i < A.length; i++){
			//if the elements are out of max number
			if(A[0] < 0 || A[A.length -1] > 100000){ return 0; }	
			
			// get the diff among the permutation
			if(i == 1){ diff = A[i] - A[i-1]; }
			
			if(A[i-1] +diff != A[i]){
				return 0;
			}
		}
		
		return 1;
	}
}


public class Permutation {
	public static void main(String[] args) {
		int A[] = new int[4];
	    A[0] = 4;
	    A[1] = 1;
	    A[2] = 3;
	    A[3] = 2;
		System.out.println(Solution_Permutation.solution(A));
	}
}
