import java.util.*;
import java.io.*;

import static java.lang.Math.abs;


//silver1
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count=1;
        int[] check=new int[100001];
        Queue<Integer> q=new LinkedList<>();
        q.offer(N);
        check[N]=count;

        while(N!=K){
            N=q.poll();
            count=check[N];
            count++;
            if((N+1)==K||(N-1)==K||2*N==K) {
                break;
            }
            if(N-1>=0) {
                if(check[N-1]==0){
                    q.offer(N-1);
                    check[N-1]=count;
                }
            }
            if(N+1<=100000) {
                if(check[N+1]==0) {
                    q.offer(N + 1);
                    check[N + 1] = count;
                }
            }
            if(2*N<=100000) {
                if(check[2*N]==0) {
                    q.offer(2 * N);
                    check[2 * N] = count;
                }
            }
        }
        System.out.println(count-1);

    }
}

