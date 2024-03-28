import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int city,bus,startCity,endCity;
    static long[][] map;
    static boolean[] vist;
    static long[] min;
    static int[] preCity;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        city=Integer.parseInt(br.readLine());
        map=new long[city+1][city+1];
        for(int i=0;i<city+1;i++) {
            Arrays.fill(map[i],city*100000L+1L);
            map[i][i]=0;
        }
        vist=new boolean[city+1];
        min=new long[city+1];
        Arrays.fill(min,city*100000L+1L);
        preCity=new int[city+1];
        bus=Integer.parseInt(br.readLine());

        for(int i=0;i<bus;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int value=Integer.parseInt(st.nextToken());
            map[start][end]=Math.min(map[start][end],value);
        }

        st=new StringTokenizer(br.readLine());
        startCity=Integer.parseInt(st.nextToken());
        endCity=Integer.parseInt(st.nextToken());

        for(int i=1;i<min.length;i++) {
            if(map[startCity][i]!=-1) min[i]=map[startCity][i];
        }
        vist[startCity]=true;

        while(true){
            long m=city*100000L+1L;
            int index=-1;
            for(int i=1;i<min.length;i++){
                if(!vist[i]&&min[i]<m) {
                    index=i;
                    m=min[i];
                }
            }
            if(m==city*100000L+1L) break;
            dijk(index);
            vist[index]=true;
        }

        bw.write(min[endCity]+"\n");
        StringBuffer sb=new StringBuffer();
        sb.append(startCity).append(" ");
        int[] route=new int[city+1];
        int count=1;
        if(startCity==endCity){
            bw.write(count+"\n"+sb);
        } else{
            route[0]=endCity;
            while(true){
                endCity=preCity[endCity];
                if(endCity==0) break;
                route[count]=endCity;
                count++;
            }

            for(int i=count-1;i>=0;i--) sb.append(route[i]).append(" ");
            bw.write((count+1)+"\n"+sb);
        }

        bw.flush();
        bw.close();
    }

    static void dijk(int index){
        for(int i=1;i<map.length;i++){
            if(min[i]>min[index]+map[index][i]) {
                min[i]=min[index]+map[index][i];
                preCity[i]=index;
            }
        }
    }
}
