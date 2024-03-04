import java.io.*;
import java.util.ArrayList;

public class Main {
    static class node {
        int index;
        int left;
        int right;

        node(int index, int left, int right) {
            this.index = index;
            this.left = left;
            this.right = right;
        }
    }

    static node[] tree = new node[10000000];
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int top = Integer.parseInt(br.readLine());
        tree[top] = (new node(top, -1, -1));
        String str = "";

        while (true) {
            str=br.readLine();
            if(str==null||str.equals("")) break;
            insert(top, Integer.parseInt(str));
        }

        circuit(top);

        bw.flush();
        bw.close();
    }

    static void insert(int index, int num) {
        node n = tree[index];
        if (num < n.index) {
            if (n.left == -1) {
                n.left = num;
                tree[num] = (new node(num, -1, -1));
            } else {
                insert(n.left, num);
            }
        } else if (num > n.index) {
            if (n.right == -1) {
                n.right = num;
                tree[num] = (new node(num, -1, -1));
            } else {
                insert(n.right, num);
            }
        }
    }

    static void circuit(int index) throws IOException{
        if(tree[index].left!=-1){
            circuit(tree[index].left);
        }
        if(tree[index].right!=-1) {
            circuit(tree[index].right);
        }
        bw.write(tree[index].index+"\n");
    }
}
