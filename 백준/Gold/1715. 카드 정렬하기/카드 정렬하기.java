import java.util.*;
import java.io.*;

//gold4
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        int N=Integer.parseInt(st.nextToken());
        long result=0;

        PriorityQueue<Integer> card=new PriorityQueue<Integer>(N);

        for(int i=0;i<N;i++)
        {
            card.offer(Integer.parseInt(bf.readLine()));
        }

        for(int i=1;i<N;i++)
        {
            int card_result=0;
            card_result+=card.poll();
            card_result+=card.poll();
            result+=Long.valueOf(card_result);

            card.offer(card_result);
        }
        System.out.println(result);
    }
}
