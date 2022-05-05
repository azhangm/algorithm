package Tree.BST;

public class TestTree {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.add(10);
        bst.add(6);
        bst.add(11);
        bst.add(7);
        bst.add(5);
        bst.add(12);
        bst.add(14);
        System.out.println(bst.getRoote());
        System.out.println("==============前序遍历");
        bst.preOrder1(bst.getRoot());
        // 二叉搜索树 移除最小节点
        bst.removeMinNode(bst.getRoot());
        System.out.println("删除最小节点的前序遍历");
        bst.preOrder(bst.getRoot());
        System.out.println("删除最大节点");
        bst.removeMaxNode();
        System.out.println("------------------");
        bst.infixOrder();

    }
}
