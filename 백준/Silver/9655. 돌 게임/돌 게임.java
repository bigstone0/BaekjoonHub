import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        String win="";
        int count=1;

        for(int i=1;i<=num;i+=count){
            if(win.equals("SK")) win="CY";
            else win="SK";
            if((num+2)==num) {
                count=1;
            }
        }

        System.out.println(win);
    }
}
