import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int num;
    static String[] muls;
    static int[] nums;
    static int max=Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(bf.readLine());
        String[] st = bf.readLine().split("");
        nums = new int[(num / 2) + 1];
        muls = new String[num / 2];
        boolean[] check = new boolean[num / 2];

        for (int i = 0; i < num; i++) {
            if (i % 2 == 0) nums[i / 2] = Integer.parseInt(st[i]);
            else muls[i / 2] = st[i];
        }
        dfs(0, nums[0]);

        System.out.println(max);
    }

    static void dfs(int index, int sum) {
        if(index>=muls.length){
            max=Math.max(max,sum);
            return;
        }

        int sum1=calc(sum,nums[index+1],muls[index]);
        dfs(index+1,sum1);

        if(index+1<muls.length){
            int sum2=calc(nums[index+1],nums[index+2],muls[index+1]);
            dfs(index+2,calc(sum,sum2,muls[index]));
        }
    }

    static int calc(int a,int b,String op){
        if(op.equals("+")) return a+b;
        else if(op.equals("-")) return a-b;
        else return a*b;
    }
}
