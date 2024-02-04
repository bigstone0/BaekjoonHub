import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    static int n;
    static StringBuilder stringBuilder=new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min=new PriorityQueue<>();
        max.offer(Integer.parseInt(bf.readLine()));
        stringBuilder.append(max.peek()+"\n");

        for(int i=0;i<n-1;i++){
            Integer num=Integer.parseInt(bf.readLine());

            if(max.size()==min.size()) {
                if(num>min.peek()){
                    max.offer(min.poll());
                    min.offer(num);
                }
                else max.offer(num);
            }
            else if (max.size() > min.size()) {
                if(num<max.peek()){
                    min.offer(max.poll());
                    max.offer(num);
                }
                else min.offer(num);
            }
            stringBuilder.append(max.peek()+"\n");
        }
        System.out.println(stringBuilder);
    }
}
