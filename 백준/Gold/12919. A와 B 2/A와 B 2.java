import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static String S;
    static String T;
    static int result = 0;
    static Set<String> s = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        search(T);

        System.out.println(result);
    }

    static void search(String str) {
        if (result == 1) return;

        if (str.substring(str.length() - 1, str.length()).equals("A")) {
            String str1 = str.substring(0, str.length() - 1);
            if (str1.equals(S)) result = 1;
            if (s.add(str1) && str1.length() != S.length()) search(str1);
        }

        if (str.substring(0, 1).equals("B")) {
            StringBuffer sb = new StringBuffer(str);
            String str2 = sb.reverse().toString();
            str2 = str2.substring(0, str.length() - 1);
            if (str2.equals(S)) result = 1;
            if (s.add(str2) && str2.length() != S.length()) search(str2);
        }
    }
}
