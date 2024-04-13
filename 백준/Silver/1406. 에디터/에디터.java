import java.io.*;

public class Main {
    static class Node {
        Node pre;
        Node next;
        String value;

        Node(Node pre, Node next, String value) {
            this.pre = pre;
            this.next = next;
            this.value = value;
        }
    }
    static Node head = null;
    static Node tail = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int num = Integer.parseInt(br.readLine());

        String[] strList = str.split("");
        Node node = new Node(null, null, "");
        for (int i = 0; i < strList.length; i++) {
            if (head==null) {
                head = new Node(null, null, strList[i]);
            } else {
                head.next = new Node(node, null, strList[i]);
                head.next.pre = head;
                head = head.next;
            }
        }
        tail = new Node(head, null, null);
        head.next = tail;
        head = tail;

        for (int i = 0; i < num; i++) {
            str = br.readLine();
            act(str);
        }

        while (head.pre != null) {
            act("L");
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            bw.write(head.value + "");
            head = head.next;
            if(head.next==null) break;
        }

        bw.flush();
        bw.close();
    }

    static void act(String inputStr) {
        if (inputStr.equals("L")) {
            if (head.pre != null) {
                head = head.pre;
            }
        } else if (inputStr.equals("D")) {
            if (head.next != null) {
                head = head.next;
            }
        } else if (inputStr.equals("B")) {
            if (head.pre != null) {
                if (head.pre.pre == null) head.pre = null;
                else {
                    head.pre = head.pre.pre;
                    head.pre.next = head;
                }
            }
        } else {
            String[] str = inputStr.split(" ");
            if (head.pre == null) {
                Node node = new Node(null, head, str[1]);
                head.pre = node;
            } else {
                Node node = new Node(head.pre, head, str[1]);
                head.pre.next = node;
                head.pre = node;
            }
        }
    }
}
