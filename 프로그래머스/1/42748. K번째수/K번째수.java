class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] divide;
        for(int i=0;i<commands.length;i++){
            divide=new int[commands[i][1]-commands[i][0]+1];
            int count=0;
            for(int j=commands[i][0]-1;j<commands[i][1];j++){
                divide[count]=array[j];
                count++;
            }
            divide=sort(divide);
            answer[i]=divide[commands[i][2]-1];
        }
        
        return answer;
    }
    
    public int[] sort(int[] array){
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    int temp=array[j];
                    array[j]=array[i];
                    array[i]=temp;
                }
            }
        }
        
        return array;
    }
}