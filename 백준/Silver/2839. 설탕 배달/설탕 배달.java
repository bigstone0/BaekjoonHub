import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int sugar = scan.nextInt();
        int count=0;
        ArrayList<Integer> count1=new ArrayList<>();

        while(sugar>0)
        {
            if((sugar%3)==0)
            {
                count1.add((sugar/3)+count);
            }
            sugar-=5;
            count+=1;
        }
        if(sugar==0)
            count1.add(count);

        if(sugar<0) {
            if (count1.size() == 0)
                System.out.println(-1);
            else
                System.out.println(Collections.min(count1));
        }
        else
            System.out.println(Collections.min(count1));
    }
}