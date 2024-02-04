import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//silver4
public class Main {
    public static void main(String[] args) throws IOException{
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();

        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        String str=bf.readLine();
        String a_str=bf.readLine();
        String b_str=bf.readLine();
        StringTokenizer st= new StringTokenizer(str," ");
        int num=Integer.parseInt(st.nextToken());

        st= new StringTokenizer(a_str," ");
        for(int i=0;i<num;i++){
            a.add(Integer.parseInt(st.nextToken()));
        }

        st= new StringTokenizer(b_str," ");
        for(int i=0;i<num;i++){
            b.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(a);
        a=sor(num,a,b);
        int sum=result(num,a,b);

        System.out.print(sum);

    }
    public static int result(Integer num,ArrayList<Integer> a,ArrayList<Integer> b){
        int sum=0;
        for(int i=0;i<num;i++){
            sum=sum+(a.get(i)*b.get(i));
        }
        return sum;
    }

    public static ArrayList<Integer> sor(Integer num, ArrayList<Integer> a, ArrayList<Integer> b){
        boolean[] check=new boolean[num];
        ArrayList<Integer> a_sort=new ArrayList<Integer>();
        a_sort.addAll(b);

        for(int i=0;i<num;i++){
                int max=-1;
                int max_index=-1;
                for(int j=0;j<num;j++){
                    if(!check[j]){
                        if(max<b.get(j)){
                            max=b.get(j);
                            max_index=j;
                        }
                    }
                }
                check[max_index]=true;
                a_sort.set(max_index,a.get(i));
        }
        return a_sort;
    }
}
