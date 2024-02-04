import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static class Coor{
        int x;
        int y;
        Coor(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        int N=Integer.parseInt(st.nextToken());

        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        ArrayList<Integer> ap_num=new ArrayList<Integer>();
        Queue<Coor> q=new LinkedList<Coor>();

        int[][] map=new int[N][N];
        for(int i=0;i<N;i++)
        {
            map[i]= Stream.of(bf.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++)
            {
                if(map[i][j]==1)
                {
                    int count=0;
                    q.offer(new Coor(i,j));
                    map[i][j]=0;
                    while(!q.isEmpty())
                    {
                        Coor coor=q.poll();
                        count++;
                        int x=coor.x;
                        int y=coor.y;
                        for(int k=0;k<4;k++)
                        {
                            if((x+dr[k]>-1)&&(x+dr[k]<N)&&(y+dc[k]>-1)&&(y+dc[k]<N))
                            {
                                if(map[x+dr[k]][y+dc[k]]==1){
                                    q.offer(new Coor(x+dr[k],y+dc[k]));
                                    map[x+dr[k]][y+dc[k]]=0;
                                }
                            }
                        }
                    }
                    ap_num.add(count);
                }
            }
        }
        Collections.sort(ap_num);
        System.out.println(ap_num.size());
        for(int i=0;i< ap_num.size();i++)
        {
            System.out.println(ap_num.get(i));
        }
    }
}
