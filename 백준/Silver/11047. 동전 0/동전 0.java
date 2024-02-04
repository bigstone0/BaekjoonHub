import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        int count=0;
        int N=scan.nextInt();
        int K=scan.nextInt();
        int[] A=new int[N];
        for(int i=0;i<N;i++)
            A[i]= scan.nextInt();

        while(K!=0){
            for(int i=A.length-1;i>=0;i--)
            {
                if(K>=A[i])
                {
                    count=count+(K/A[i]);
                    K=K%A[i];
                    if(K==0)
                        break;
                }
            }
        }
        System.out.println(count);
    }
}
