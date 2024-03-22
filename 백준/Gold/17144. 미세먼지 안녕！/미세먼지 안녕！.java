import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int X, Y, Time;
    static int[][] Room;
    static int[][] spread;
    static int[][] next;
    static int air1 = -1;
    static int air2 = -1;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean flag=false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        Room = new int[X][Y];
        spread = new int[X][Y];
        next=new int[X][Y];
        Time = Integer.parseInt(st.nextToken());

        for (int i = 0; i < X; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < Y; j++) {
                Room[i][j] = Integer.parseInt(st.nextToken());
                if (Room[i][j] == -1) {
                    if (air1 == -1) air1 = i;
                    else air2 = i;
                    continue;
                }
                spread[i][j] = Room[i][j] / 5;
            }
        }

        for (int i = 0; i < Time; i++) {
            for (int j = 0; j < X; j++) {
                for (int k = 0; k < Y; k++) {
                    if (spread[j][k] == 0) continue;
                    for(int o=0;o<4;o++){
                        int x=j+dx[o];
                        int y=k+dy[o];
                        if(x==-1||x==X||y==-1||y==Y||Room[x][y]==-1) continue;
                        Room[x][y]=Room[x][y]+spread[j][k];
                        Room[j][k]=Room[j][k]-spread[j][k];
                        next[x][y]=Room[x][y]/5;
                    }
                    next[j][k]=Room[j][k]/5;
                }
            }
            flag=false;
            airC(air1,0,true);
            airC(air2,0,false);
            if(!flag) break;
            for(int p=0;p<X;p++){
                for(int l=0;l<Y;l++) spread[p][l]=next[p][l];
            }
        }

        int result=0;
        for(int i=0;i<X;i++){
            for(int j=0;j<Y;j++) {
                if(Room[i][j]!=-1) result=result+Room[i][j];
            }
        }

        System.out.println(result);
    }

    static void airC(int x,int y,boolean direct){
        int dxx=x;
        int dyy=y+1;
        int value=Room[dxx][dyy];
        int sValue=next[dxx][dyy];
        Room[dxx][dyy]=0;
        next[dxx][dyy]=0;
        int nextDir=2;
        while(true){
            if(value!=0) flag=true;
            if(dyy==y&&dxx==x) {
                Room[x][y]=0;
                next[x][y]=0;
                break;
            }

            if(dyy+dy[nextDir]==Y){
                if(x==0||x==X-1) nextDir=3;
                else {
                    if(direct) nextDir=1;
                    else nextDir=0;
                }
            } else if (dyy+dy[nextDir]==-1) {
                if(direct) nextDir=0;
                else nextDir=1;
            }

            if(dxx+dx[nextDir]==-1||dxx+dx[nextDir]==X) nextDir=3;

            dxx=dx[nextDir]+dxx;
            dyy=dy[nextDir]+dyy;
            int temp = Room[dxx][dyy];
            int sTemp=next[dxx][dyy];
            Room[dxx][dyy]=value;
            next[dxx][dyy]=sValue;
            value=temp;
            sValue=sTemp;
        }
    }
}
