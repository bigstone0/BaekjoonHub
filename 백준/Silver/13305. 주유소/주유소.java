import java.util.*;
import java.io.*;
import java.util.stream.Stream;

//silver 3
public class Main {
    public static void main(String[] args) throws IOException{
        long result=0;
        int city_position=0;

        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        int city_num=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(bf.readLine());
        ArrayList<Long> city_length=new ArrayList<>(city_num-1);
        for(int i=0;i<city_num-1;i++)
        {
            city_length.add(Long.parseLong(st.nextToken()));
        }

        st=new StringTokenizer(bf.readLine());
        ArrayList<Long> oil_price=new ArrayList<Long>(city_num);
        for(int i=0;i<city_num;i++)
        {
            oil_price.add(Long.parseLong(st.nextToken()));
        }

        while(city_position<city_num-1)
        {
            int min_position=city_num-1;
            for(int i=(city_position+1);i<city_num-1;i++)
            {
                if(oil_price.get(city_position)>oil_price.get(i))
                {
                    min_position=i;
                    break;
                }
            }
            for(int i=city_position;i<min_position;i++)
            {
                result=result+(oil_price.get(city_position)*city_length.get(i));
            }
            city_position=min_position;
        }

        System.out.println(result);
    }
}
