import java.util.*;
import java.io.*;
import java.util.stream.Stream;

//silver1
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        int N=Integer.parseInt(st.nextToken());
        int[][] person=new int[N][N];
        int min=Integer.MAX_VALUE;

        for(int i=0;i<N;i++){
            person[i]= Stream.of(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i=1;i<Math.pow(2,N)/2;i++){
            ArrayList<Integer> start=new ArrayList<>();
            ArrayList<Integer> link=new ArrayList<>();
            for(int j=0;j<N;j++){
                if((i&(1<<j))==0) link.add(j);
                else start.add(j);
            }

            int startAbil=0;
            int linkAbil=0;

            for(int j=0;j<start.size();j++){
                for(int k=j;k<start.size();k++){
                    if(j!=k) startAbil=startAbil+person[start.get(k)][start.get(j)]+person[start.get(j)][start.get(k)];
                }
            }

            for(int j=0;j<link.size();j++){
                for(int k=j;k<link.size();k++){
                    if(j!=k) linkAbil=linkAbil+person[link.get(j)][link.get(k)]+person[link.get(k)][link.get(j)];
                }
            }

            if(min>Math.abs(startAbil-linkAbil)) min=Math.abs(startAbil-linkAbil);
        }

        System.out.println(min);
    }
}
