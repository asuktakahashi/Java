/**
 * @param N
 * @return maxGapLength
 */
class Solution {
    public int solution(int N) {
        if(N < 1) { return -1; } // return -1 if parameter is negative
        
        // change N from int to binary char Array
        char[] targetCharArray = Integer.toBinaryString(N).toCharArray();

        int counter = 0;
        int maxGapLength = 0;
        for(char tca : targetCharArray){
            if('1' == tca){    
                if(counter > maxGapLength){
                    maxGapLength = counter;
                }
                counter = 0; //reset
                continue;            
            } else if('0' == tca){
                counter++;
                if(counter > maxGapLength){
                    maxGapLength = counter;
                }
            }
        }
        return maxGapLength;
    }
}
