import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        StringTokenizer st;
        String str="";
        int num;
        int[] nums=new int[21];
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            str=st.nextToken();
            switch (str){
                case "add":
                    num=Integer.parseInt(st.nextToken());
                    nums[num]=1;
                    break;
                case "remove":
                    num=Integer.parseInt(st.nextToken());
                    nums[num]=0;
                    break;
                case "check":
                    num=Integer.parseInt(st.nextToken());
                    bw.write(nums[num]+"\n");
                    break;
                case "toggle":
                    num=Integer.parseInt(st.nextToken());
                    if(nums[num]==1) nums[num]=0;
                    else if(nums[num]==0) nums[num]=1;
                    break;
                case "all":
                    Arrays.fill(nums,1);
                    break;
                case "empty":
                    nums=new int[21];
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
