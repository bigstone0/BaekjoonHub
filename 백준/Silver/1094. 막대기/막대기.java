import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        int X=Integer.parseInt(st.nextToken());
        int count=0;

        while(X!=1){
            if(X%2==1) count++;
            X=X/2;
        }
        count++;

        System.out.println(count);
    }
}