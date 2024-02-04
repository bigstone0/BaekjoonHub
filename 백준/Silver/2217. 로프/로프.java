import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 로프 길이 정보를 배열에 담기
        int[] len = new int[n];
        for(int i = 0; i < n; i++){
            len[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(len);

        // 각 로프가 버틸 수 있는 최대 중량
        int[] weight = new int[n];
        for(int i = 0; i < n; i++){
            weight[i] = len[i]*(n-i);
        }
        Arrays.sort(weight);

        // 최대 중량 출력하기
        System.out.println(weight[n - 1]);
    }
}
