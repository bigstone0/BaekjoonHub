import java.io.*;
import java.util.stream.Stream;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[][] result=new int[N][2];
        int[][] testCase=new int[N][20];

        for(int i=0;i<N;i++){
            testCase[i]= Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i=0;i<N;i++){
            for(int j=2;j<=20;j++){
                if(testCase[i][j]<testCase[i][j-1]){
                    int count=0;
                    for(int k=j;k>=1;k--){
                        if(k==1||testCase[i][k]>testCase[i][k-1]) break;
                        count++;
                        int temp=testCase[i][k];
                        testCase[i][k]=testCase[i][k-1];
                        testCase[i][k-1]=temp;
                    }
                    result[i][1]+=count;
                }
            }
        }

        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<result.length;i++){
            bw.write(i+1+" "+result[i][1]+"\n");
        }

        bw.flush();
        bw.close();
    }
}
