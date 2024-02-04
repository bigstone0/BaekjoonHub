import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);

        int people_num=0;
        int[] people;
        people_num=scan.nextInt();
        people=new int[people_num];
        int total;

        for(int i=0;i<people_num;i++){
            people[i]=scan.nextInt();
        }

        Arrays.sort(people);

        total=people[0];

        for(int i=1;i<people_num;i++)
        {
            total=total+factorial(i,people);
        }
        System.out.println(total);
    }

    public static int factorial(int num,int[] people){
        if(num==0)
            return people[0];
        return people[num]+factorial(num-1,people);
    }

}
