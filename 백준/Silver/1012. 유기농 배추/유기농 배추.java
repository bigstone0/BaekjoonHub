import java.util.*;
import java.io.*;

//silver2
public class Main {
    static class coor{
        private int x;
        private int y;
        public coor(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        int T=Integer.parseInt(st.nextToken());
        ArrayList<Integer> result=new ArrayList<Integer>();

        for(int i=0;i<T;i++){
            st=new StringTokenizer(bf.readLine());
            int M=Integer.parseInt(st.nextToken());
            int N=Integer.parseInt(st.nextToken());
            int K=Integer.parseInt(st.nextToken());
            int[][] field=new int[N][M];
            ArrayList<coor> list=new ArrayList<coor>();

            for(int j=0;j<K;j++){
                st=new StringTokenizer(bf.readLine());
                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());
                field[y][x]=1;
            }

            result.add(bfs(field));
        }

        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }

    public static int bfs(int[][] field){
        int count=0;
        int[] dr={0,0,-1,1};
        int[] dc={-1,1,0,0};
        while(true){
            Queue<coor> q=new LinkedList<coor>();
            loopOut:
            for(int i=0;i<field.length;i++){
                for(int j=0;j<field[0].length;j++){
                    if(field[i][j]==1){
                        q.offer(new coor(i,j));
                        field[i][j]=0;
                        break loopOut;
                    }
                }
            }

            if(q.isEmpty()) break;

            while(!q.isEmpty()){
                coor c=q.poll();
                int x=c.x;
                int y=c.y;

                for(int i=0;i<4;i++){
                    if((x+dr[i])>-1&&(x+dr[i])<field.length&&(y+dc[i])>-1&&(y+dc[i])<field[0].length){
                        if(field[x+dr[i]][y+dc[i]]==1){
                            q.offer(new coor(x+dr[i],y+dc[i]));
                            field[x+dr[i]][y+dc[i]]=0;
                        }
                    }
                }
            }
            count++;
        }
        return count;
    }
}
