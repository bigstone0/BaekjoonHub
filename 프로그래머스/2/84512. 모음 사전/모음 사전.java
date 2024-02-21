class Solution {
    public int solution(String word) {
        int answer=0;
        String[] dict={"A","E","I","O","U"};
        String[] w=new String[word.length()];
        w=word.split("");
        int[][] num={{1,782,1563,2344,3125},{1,157,313,469,625},{1,32,63,94,125},{1,7,13,19,25},{1,2,3,4,5}};

        for(int i=0;i<w.length;i++){
            for(int j=0;j<dict.length;j++){
                if(w[i].equals(dict[j])){
                    answer+=num[i][j];
                    break;
                }
            }
        }

        return answer;
    }
}