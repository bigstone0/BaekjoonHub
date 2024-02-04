import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static String[][] zone=new String[5][5];
    static int count=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<5;i++){
            zone[i]=br.readLine().split("");
        }

        comb(new int[7],0,0);

        System.out.println(count);
    }

    static void comb(int[] num,int depth,int index){
        if(depth==7){
            bfs(num);
            return;
        }

        for(int i=index;i<25;i++){
            num[depth]=i;
            comb(num,depth+1,i+1);
        }
    }

    static void bfs(int[] num){
        Queue<Integer> q=new LinkedList<>();
        int yCount=0;
        boolean[] vist=new boolean[7];
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        q.offer(num[0]);
        vist[0]=true;

        while(!q.isEmpty()){
            int zon=q.poll();
            int x=zon/5;
            int y=zon%5;
            if(zone[x][y].equals("Y")) yCount++;

            if(yCount>3) return;

            for(int i=0;i<4;i++){
                int xx=x+dx[i];
                int yy=y+dy[i];

                if(xx<0||xx>4||yy<0||yy>4) continue;

                for(int j=0;j<7;j++){
                    if(vist[j]) continue;
                    if(((xx*5)+yy)==num[j]) {
                        q.offer(num[j]);
                        vist[j]=true;
                    }
                }
            }
        }
        for(int i=0;i<7;i++){
            if(!vist[i]) return;
        }

        count++;
    }
}
