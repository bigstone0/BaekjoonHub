import java.io.*;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder st = new StringBuilder(br.readLine());
        StringBuilder boom = new StringBuilder(br.readLine());
        Stack<String> s=new Stack<>();

        int index=0;

        for(int j=0;j<st.length();j++){
            s.push(String.valueOf(st.charAt(j)));
            index++;
            if(index<boom.length()) continue;

            StringBuilder str=new StringBuilder();
            for(int i=index-boom.length();i<index;i++){
                str.append(s.get(i));
            }
            if(str.compareTo(boom)==0){
                for(int i=index-boom.length();i<index;i++){
                    s.pop();
                }
                index=index-boom.length();
            }
        }

        if(s.size()==0) System.out.println("FRULA");
        else{
            for(int i=0;i<s.size();i++) bw.write(s.get(i)+"");
            bw.flush();
            bw.close();
        }
    }
}
