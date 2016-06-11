class Solution {
    public int solution(int K, int L, int M, int N, int P, int Q, int R, int S) {
        //return -1 when against the precondition
    	if(K > M || L > N || P > R || Q > S){
    		return -1;
    	}
    	
    	// calc the sum of the area
    	int firstRectangle = (M - K) * (N - L);
    	int secondRectangle = (R - P) * (S + Q); 	
    	if ((firstRectangle + secondRectangle) > 2147483647){
    		return -1;
    	}
    	
    	// exclude once if crossed 
    	if(L > P || S > Q){
    		int crossedArea = (S - L ) * (P - M); 
    		return firstRectangle + secondRectangle - crossedArea;
    	}
    	
    	return firstRectangle + secondRectangle;
    }
}
