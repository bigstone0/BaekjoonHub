import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int L,C;
    static String[] alpha;
    static boolean[] check;
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        L=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());

        alpha=br.readLine().split(" ");
        check=new boolean[C];

        sort();
        dfs(0,0,new StringBuffer(),0,0);

        bw.flush();
        bw.close();
    }

    static void dfs(int index, int count, StringBuffer sb,int moeum,int jaeum) throws IOException{
        if(count==L){
            if(moeum>0&&jaeum>1) bw.write(sb+"\n");
            return;
        }

        for(int i=index;i<C;i++){
            if(!check[i]){
                check[i]=true;
                if(alpha[i].equals("a")||alpha[i].equals("e")||alpha[i].equals("i")||alpha[i].equals("o")||alpha[i].equals("u")) {
                    dfs(i,count+1,new StringBuffer(sb+""+alpha[i]),moeum+1,jaeum);
                }
                else dfs(i,count+1,new StringBuffer(sb+""+alpha[i]),moeum,jaeum+1);
                check[i]=false;
            }
        }
    }

    static void sort(){
        for(int i=0;i<C;i++){
            for(int j=i+1;j<C;j++){
                if(alpha[i].compareTo(alpha[j])>0){
                    String temp=alpha[i];
                    alpha[i]=alpha[j];
                    alpha[j]=temp;
                }
            }
        }
    }
}
