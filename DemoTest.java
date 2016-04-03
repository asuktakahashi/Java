//from codelity

public class PlayGround {
	public int solution(int[] A) {
	    if(0 > A.length ||100000 < A.length){ return -1; }
	       
	    int sumArry = 0;
	    for(int k = 0; k < A.length - 1; k++){
	    	sumArry += A[k];
	        if(sumArry == 0){
	            return A.length;
	        }
	    }
	    
    	for(int i = 0; i < A.length; i++){	
    		for(int j = 0; j < A.length; j++){
    			if(A[i] == A[A.length - j]);
    		}
    		return i;
    	}	
    	
  	return -1;
  }
	
	int equi(int A[]) {
		//return -1 if array length is beyond the expectation
	    if (A.length == 0 || A.length > 100000){ return -1; }
	    
	    //calculate the sum of array
	    int sum = 0;
	    for(int i=0; i < A.length; i++){
	    	sum+= A[i]; 
	    }

	    //the process
	    int sum_left = 0;    
	    for(int i = 0; i < A.length; i++) {
	        int sum_right = sum - sum_left - A[i];
	        if (sum_left == sum_right){
	        	return i;
	        }
	        sum_left += A[i];
	    } 
	    return -1; 
	}
	
  //for test
  public static void main(String args[]){
    int[] A = {-1, 3, -4, 5, 1, -6, 2, 1};
    System.out.println(new PlayGround().solution(A));
  }
}
