import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String,ArrayList<String>> a=new HashMap<String,ArrayList<String>>();

        for(int i=0;i<clothes.length;i++)
        {
            if(!a.containsKey(clothes[i][1]))
                a.put(clothes[i][1],new ArrayList<String>());
                
            a.get(clothes[i][1]).add(clothes[i][0]);
        }
        
        for(String key : a.keySet()){
            answer=answer*(1+a.get(key).size());
        }
        
        answer=answer-1;
        
        return answer;
    }
}