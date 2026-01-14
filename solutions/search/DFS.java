class DFS {

    public void inOrderDFS(Node node) {
        if (node == null) return;

        inOrderDFS(node.left);
        System.out.print(node.data+ " ");
        inOrderDFS(node.right);
    }
    public void preOrderDFS(Node node) {
        if (node == null) return;
        System.out.print(node.data+ " ");
        preOrderDFS(node.left);
        preOrderDFS(node.right);
    }
    public void postOrderDFS(Node node) {
        if (node == null) return;
        postOrderDFS(node.left);
        postOrderDFS(node.right);
        System.out.print(node.data+ " ");
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);

        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.left.left.left = new Node(1);
        System.out.println(root.toString());
        DFS dfs = new DFS();
        System.out.println("IN ORDER");
        dfs.inOrderDFS(root);
        System.out.println("PRE ORDER");
        dfs.preOrderDFS(root);
        System.out.println("POST ORDER");
        dfs.postOrderDFS(root);
    }
}
class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
    }
}
