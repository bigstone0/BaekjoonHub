import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        int N=Integer.parseInt(st.nextToken());
        int[][] taste=new int[N][2];
        int min=Integer.MAX_VALUE;

        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            taste[i][0]=Integer.parseInt(st.nextToken());
            taste[i][1]=Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<(1<<N);i++){
            int sin=1;
            int sseun=0;
            for(int j=0;j<N;j++){
                if((i&(1<<j))!=0){
                    sin=sin*taste[j][0];
                    sseun=sseun+taste[j][1];
                }
            }
            if(min>Math.abs(sseun-sin)) min=Math.abs(sseun-sin);

        }

        System.out.println(min);
    }
}
