import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    static int N;
    static int count = 0;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        dfs(0);

        System.out.println(count);
    }

    static void dfs(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            nums[row]=i;
            if(check(row)) {
                dfs(row + 1);
            }
        }
    }

    static boolean check(int col){
        for(int i=0;i<col;i++){
            if(nums[i]==nums[col]) return false;
            if(Math.abs(col-i)==Math.abs(nums[col]-nums[i])) return false;
        }
        return true;
    }
}
