import java.util.*;
import java.io.*;

//silver5
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        long S=Long.parseLong(st.nextToken());
        long result=0;
        long sum=0;
        loopOut:
        for(long i=0;i<=S;i++)
        {
            sum+=i;
            if(sum>S)
            {
                sum-=i;
                i--;
                while(true)
                {
                    if((S-sum>i))
                    {
                        result=i+1;
                        break loopOut;
                    }
                    i--;
                    sum-=i;
                }
            }
            else if(sum==S) {
                result=i;
                break loopOut;
            }
        }

        System.out.println(result);
    }
}
