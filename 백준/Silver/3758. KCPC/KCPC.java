import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int dataNum, teamNum, questionNum, myTeamId, logEntry;
    static int[][] board;
    static int[][] lastTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dataNum = Integer.parseInt(br.readLine());
        for (int o = 0; o < dataNum; o++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            teamNum = Integer.parseInt(st.nextToken(" "));
            questionNum = Integer.parseInt(st.nextToken(" "));
            myTeamId = Integer.parseInt(st.nextToken(" "));
            logEntry = Integer.parseInt(st.nextToken(" "));
            board = new int[teamNum + 1][questionNum + 1];
            lastTime = new int[teamNum + 1][2];

            for (int i = 0; i < logEntry; i++) {
                st = new StringTokenizer(br.readLine());
                int team = Integer.parseInt(st.nextToken(" "));
                int question = Integer.parseInt(st.nextToken(" "));
                int grade = Integer.parseInt(st.nextToken(" "));
                lastTime[team][1]++;
                lastTime[team][0] = i;
                if (board[team][question] < grade) {
                    board[team][0] -= board[team][question];
                    board[team][question] = Math.max(board[team][question], grade);
                    board[team][0] += grade;
                }
            }

            bw.write(sort() + "\n");
        }
        bw.flush();
        bw.close();
    }

    static int sort() {
        int result = 1;
        for (int i = 1; i < teamNum + 1; i++) {
            if (i == myTeamId) continue;
            if (board[myTeamId][0] < board[i][0]) result++;
            else if (board[myTeamId][0] == board[i][0]) {
                if (lastTime[myTeamId][1] > lastTime[i][1]) result++;
                else if (lastTime[myTeamId][1] == lastTime[i][1]) {
                    if (lastTime[myTeamId][0] > lastTime[i][0]) result++;
                }
            }
        }
        return result;
    }
}
