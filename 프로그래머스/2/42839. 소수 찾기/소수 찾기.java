import java.util.*;

class Solution {
    
    static Stack<Integer> s=new Stack<>();
    public int solution(String numbers) {
        int answer = 0;
        
        
        String[] str=new String[numbers.length()];
        boolean[] check=new boolean[str.length];

        StringTokenizer st=new StringTokenizer(numbers);
        str=numbers.split("");

        for(int i=1;i<str.length+1;i++){
            perm(check,str,"",0,i);
        }

        int count=s.size();
        for(int i=0;i<count;i++){
            if(sosu(s.pop())) answer++;
        }


        return answer;
    }
    
        static void perm(boolean[] vist, String[] str, String ans,int depth,int r){
        if(depth==r){
            if(!s.contains(Integer.parseInt(ans))) {
                s.push(Integer.parseInt(ans));
            }
            return;
        }

        for(int i=0;i<str.length;i++){
            if(!vist[i]){
                vist[i]=true;
                perm(vist,str,ans+str[i],depth+1,r);
                vist[i]=false;
            }
        }
    }
    
        static boolean sosu(int number){
        if(number==0||number==1) return false;
        else if (number==2||number==3) {
            return true;
        }
        else{
            for(int i=2;i<number;i++){
                if((number%i)==0) return false;
            }
        }
        return true;
    }
}