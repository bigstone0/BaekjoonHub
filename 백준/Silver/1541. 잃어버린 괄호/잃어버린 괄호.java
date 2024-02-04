import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[])throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String s=bf.readLine();
        List<String> a=new ArrayList<>();
        int flag=0;

        StringTokenizer st=new StringTokenizer(s,"+-",true);
        while(st.hasMoreTokens())
        {
            a.add(st.nextToken());
        }

        while(a.contains("+")){
            for(int i=0;i<a.size()-1;i++){
                if(a.get(i).equals("+")){
                    int m = Integer.parseInt(a.get(i-1))+Integer.parseInt(a.get(i+1));
                    String n=Integer.toString(m);
                    a.set(i,n);
                    a.remove(i-1);
                    a.remove(i);
                    break;
                }
            }
        }

        while(a.contains("-")){
            int m = Integer.parseInt(a.get(0))-Integer.parseInt(a.get(2));
            String n=Integer.toString(m);
            a.set(0,n);
            a.remove(1);
            a.remove(1);
        }

        System.out.println(a.get(0));
    }
}
