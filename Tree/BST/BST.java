package Tree.BST;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*不使用泛型的写发*/
public class BST {
    //    二叉树 节点 的定义
    private class Node {
        private Integer e;
        private Node left; // 左孩子
        private Node right; // 右孩子

        // 构造函数。
        public Node(Integer e) {
            this.e = e;
            left = null;
            right = null;
        }

        public Integer getE() {
            return e;
        }
    }

    // 根节点的定义
    private Node root;
    private int size;

    public BST(Node root, int size) {
        this.root = root;
        this.size = size;
    }

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public void add(Integer e) {
        root = add(root, e);
    }

    private Node add(Node root, Integer e) {
        if (root == null) {
            size++;
            return new Node(e);
        }
        if (e < root.e) {
            root.left = add(root.left, e);
        } else
            root.right = add(root.right, e);
        return root;
    }

    public boolean contains(Node root, Integer e) {
        if (root == null){
            return false;
        }
        if (root.e.equals(e)) {
            return true;
        } else if (root.e.compareTo(e) < 0) {
            // 去 遍历右子树 遍历到底没找到  节点为空 返回false  左子树相同情况
            return contains(root.right, e);
        } else
            return contains(root.left, e);
        // 递归遍历完了 让然没有找到 就返回false.
    }
    // @param : 指定对哪一棵树 进行遍历
    public void preOrder(Node node){
        if (node == null){
            // 递归终止条件
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }
    /*
    * 非递归实现
    * 要用栈模拟
    * */
    public void preOrder1(Node node){
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null)
            stack.push(cur.right);
            if (cur.left != null)
            stack.push(cur.left);
        }
    }
    public void bfs(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            // 循环不变性 队列不为空的条件下循环进行
            Node remove = queue.remove();
            System.out.println(remove.e);
            if (null != node.left)
             bfs(node.left);
            if (null != node.right)
            bfs(node.right);
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBstToString(root , 0 , sb);
        return sb.toString();
    }

    private void generateBstToString(Node root, int depth, StringBuilder sb) {
        if (root == null){
            // 这个深度的是null值
            sb.append(generateDepth(depth) + "null" + "\n");
        return;
        }
        sb.append(generateDepth(depth) + root.e + "\n");
        generateBstToString(root.left,depth + 1 ,sb);
        generateBstToString(root.right,depth + 1, sb);

    }

    private String generateDepth(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
    public Node removeMinNode(Node node){
        /*递归终止 传过来的 root 肯定在系统栈顶的最顶端  直接返回node 即可*/
        //        root = node;
        if (null == node.left) {
            // 当前节点没有左子树了 就是 最小节点
            /*
             最小节点课能有右子树 拿到最小节点的右子树*/
            Node rightNode = node.right;
            node.right = null ;  // 让当前节点与树脱离关系 此时右节点 为 改树的最小值
            size --;
            return  rightNode; // 返回一层层调用的的 rightNode
        }
        // 递归一层一层 最后结束的这层 终止条件 是 已经找到最小的节点  上一层节点 为 node 栈的第二层
        node.left = removeMinNode(node.left);
        return node;
    }
        /* 删除最大 结点的操作*/
        public Node removeMaxNode(){
         return removeMaxNode(root);
        }
        private Node removeMaxNode(Node node){
            if (null == node.right){
                Node scncondMax = node.left;
                node.left  = null; // 让该节点脱离树
                size -- ; // 树的节点减一操作
                return scncondMax;
            }
            node.right = removeMaxNode(node.right);
            return node;
        }
    public void infixOrder(){
        infixOrder(root);
    }
    private void infixOrder(Node node){
        if (node == null) return;
        infixOrder(node.left);
        System.out.println(node.e);
        infixOrder(node.right);
    }
    public Node getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }
    public Integer getRoote(){
        return root.e;
    }
}