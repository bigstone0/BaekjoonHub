import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken(" "));
        int K = Integer.parseInt(st.nextToken(" "));
        int[][] country = new int[N][4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            country[i][0] = Integer.parseInt(st.nextToken(" "));
            country[i][1] = Integer.parseInt(st.nextToken(" "));
            country[i][2] = Integer.parseInt(st.nextToken(" "));
            country[i][3] = Integer.parseInt(st.nextToken(" "));
        }

        for (int i = 0; i < N - 1; i++) {
            int best = i;
            for (int j = i + 1; j < N; j++) {
                if (country[best][1] < country[j][1]) best = j;
                else if (country[best][1] == country[j][1]) {
                    if (country[best][2] < country[j][2]) best = j;
                    else if (country[best][2] == country[j][2]) {
                        if (country[best][3] < country[j][3]) best = j;
                    }
                }
            }

            if (best == i) continue;

            int[] temp = new int[4];
            temp = country[i];
            country[i] = country[best];
            country[best] = temp;
        }

        int count = 0;
        int grade = 1;
        for (int i = 0; i < N; i++) {
            if (country[i][0] == K) {
                System.out.println(grade);
                break;
            }
            if (i == N - 1) break;
            if (country[i][1] == country[i + 1][1] && country[i][2] == country[i + 1][2] && country[i][3] == country[i + 1][3]) {
                count++;
            } else {
                grade++;
                grade += count;
                count = 0;
            }
        }
    }
}






