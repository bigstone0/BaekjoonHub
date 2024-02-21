class Solution {
    public int solution(int[][] sizes) {
        int aMax=Integer.MIN_VALUE;
        int bMax=Integer.MIN_VALUE;

        for(int i=0;i<sizes.length;i++){
            if(sizes[i][0]<sizes[i][1]){
                int temp=sizes[i][0];
                sizes[i][0]=sizes[i][1];
                sizes[i][1]=temp;
            }
        }

        for(int i=0;i<sizes.length;i++){
            aMax=Math.max(aMax,sizes[i][0]);
            bMax=Math.max(bMax,sizes[i][1]);
        }

        return aMax*bMax;
    }
}