package linklist;

import java.io.*;

import static linklist.MyLinkList.addHead;

public class TWO{
    static int n;
    static int N = 100010;
    static int head;
    static int[] e = new int[N], ne = new int[N];
    static int idx;

    public static void init(){
        head = -1;
        idx = 0;
    }

    public static void addToHead(int x){
        e[idx] = x;
        ne[idx] = head;
        head = idx;
        idx ++;
    }

    public static void remove(int k){
        ne[k] = ne[ne[k]];
    }

    public static void insert(int k, int x){
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx;
        idx ++;
    }

    public static void main(String[] args) throws IOException{
        init();
//
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        while(n -- != 0){
            int k, x;
            String[] s = br.readLine().split(" ");
            String opt = s[0];
            if(opt.equals("H")){
                x = Integer.parseInt(s[1]);
                addToHead(x);
            }else if(opt.equals("D")){
                k = Integer.parseInt(s[1]);
                if(k == 0) head = ne[head];
                else remove(k - 1);
            }else{
                k = Integer.parseInt(s[1]);
                x = Integer.parseInt(s[2]);
                insert(k - 1, x);
            }
        }

        for(int i = head; i != -1; i = ne[i]){
            System.out.print(e[i] + " ");
        }
//        addToHead(1);
//        addToHead(5);
//        addToHead(3);
//        addToHead(4);
//        insert(0,2);
//        insert(1,3);
//        add(3,4);
//        add(4,3);
//        remove(-1);
//        for (int i = head; i != -1; i = ne[i]){
//            System.out.print(e[i] + " ");
//        }
    }
}
