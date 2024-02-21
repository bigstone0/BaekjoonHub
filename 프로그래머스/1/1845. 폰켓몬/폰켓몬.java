import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length;
        
        
        
        for(int i=0;i<(nums.length-1);i++){
            if(nums[i]!=0){
                for(int j=i+1;j<nums.length;j++){
                    if(nums[i]==nums[j])
                    {
                        answer=answer-1;
                        nums[j]=0;
                    }
                }
            }
        }
        
        if(answer>(nums.length/2))
            answer=nums.length/2;
        
        return answer;
    }
}