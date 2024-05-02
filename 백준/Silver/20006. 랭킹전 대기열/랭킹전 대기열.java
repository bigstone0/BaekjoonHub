import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int people, roomLimit;
    static int roomNum = 0;

    static class player {
        String name;
        int level;

        public player(String name, int level) {
            this.level = level;
            this.name = name;
        }

        public int getLevel() {
            return level;
        }

        public String getName() {
            return name;
        }
    }

    static ArrayList<player>[] list = new ArrayList[300];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        people = Integer.parseInt(st.nextToken(" "));
        roomLimit = Integer.parseInt(st.nextToken(" "));

        for (int i = 0; i < people; i++) {
            st = new StringTokenizer(br.readLine());
            int playerLevel = Integer.parseInt(st.nextToken(" "));
            String playerName = st.nextToken(" ");
            boolean flag = true;
            if (i == 0) {
                list[roomNum] = new ArrayList<>();
                list[roomNum].add(new player(playerName, playerLevel));
                roomNum++;
            } else {
                for (int j = 0; j < roomNum; j++) {
                    if (list[j].size() < roomLimit && list[j].get(0).level + 10 >= playerLevel && list[j].get(0).level - 10 <= playerLevel) {
                        list[j].add(new player(playerName, playerLevel));
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    list[roomNum] = new ArrayList<>();
                    list[roomNum].add(new player(playerName, playerLevel));
                    roomNum++;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < roomNum; i++) {
            if (list[i].size() == roomLimit) bw.write("Started!" + "\n");
            else bw.write("Waiting!" + "\n");
            Collections.sort(list[i], new Comparator<player>() {
                @Override
                public int compare(player player, player t1) {
                    return player.name.compareTo(t1.name);
                }
            });

            for (int j = 0; j < list[i].size(); j++) {
                bw.write(list[i].get(j).level + " " + list[i].get(j).name + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
