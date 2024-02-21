import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
                Integer[] ci=new Integer[citations.length];
        for(int i=0;i<ci.length;i++) ci[i]=citations[i];

        Arrays.sort(ci, Collections.reverseOrder());

        for(int i=0;i<ci.length;i++){
            if((i+1)<=ci[i]) {
                answer=i+1;
            }
        }
        
        return answer;
    }
}