import java.util.*;
import java.io.*;

//silver3
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        int N=Integer.parseInt(st.nextToken());
        boolean[] check=new boolean[N+1];
        Queue<Integer> q=new LinkedList<Integer>();
        q.offer(1);
        check[1]=true;

        st=new StringTokenizer(bf.readLine());
        int M=Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] com=new ArrayList[N+1];
        for(int i=1;i<N+1;i++)
        {
            com[i]=new ArrayList<Integer>();
        }

        for(int i=0;i<M;i++)
        {
            st=new StringTokenizer(bf.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            com[x].add(y);
            com[y].add(x);
        }

        while(!q.isEmpty())
        {
            int index=q.poll();
            for(int i=0;i<com[index].size();i++)
            {
                if(!check[com[index].get(i)])
                {
                    check[com[index].get(i)]=true;
                    q.offer(com[index].get(i));
                }
            }
        }
        int count=0;

        for(int i=0;i<check.length;i++)
        {
            if(check[i]) count++;
        }
        System.out.println(count-1);
    }
}

