import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int x,y;
    static int[][] list;
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        x=Integer.parseInt(st.nextToken());
        y=Integer.parseInt(st.nextToken());
        list=new int[x][x];

        for(int i=0;i<x;i++){
            st=new StringTokenizer(br.readLine());
            int sum=0;
            for(int j=0;j<x;j++){
                list[i][j]=sum+Integer.parseInt(st.nextToken());
                sum=list[i][j];
            }
        }

        for(int i=0;i<y;i++){
            st=new StringTokenizer(br.readLine());
            bw.write(sum(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,
                    Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1)+"\n");
        }

        bw.flush();
        bw.close();
    }

    static int sum(int x1,int y1,int x2,int y2){
        int sum=0;
        for(int i=x1;i<=x2;i++){
            if(y1==0) sum=sum+(list[i][y2]);
            else sum=sum+(list[i][y2]-list[i][y1-1]);
        }
        return sum;
    }
}
