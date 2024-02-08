import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static long A,B,C;
    static long result;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        A=Long.parseLong(st.nextToken(" "));
        B=Long.parseLong(st.nextToken(" "));
        C=Long.parseLong(st.nextToken(" "));

        result=pow(A,B)%C;
        System.out.print(result);
    }

    static long pow(long num, long n){
        if(n==1) return num%C;
        else{
            long result=pow(num,n/2);
            if(n%2==0) return (result*result)%C;
            else return (((result*result)%C)*(num%C))%C;
        }
    }
}
