import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(7);
        root.right = new Node(5);

        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(11);

        root.right.right = new Node(9);
        root.right.right.left = new Node(4);
        // function call
        int data = 11;
        boolean exists = isPresent(root,data);
        System.out.println("Node "+ data + " Present "+ exists);
    }

    public static boolean isPresent(Node root, int x){
        if(root == null){
            return false;
        }
        //Level Order Traversal
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()){
            Node temp = nodeQueue.poll();
            if(temp.data == x){
                return true;
            }
            if(temp.left != null){
                nodeQueue.add(temp.left);
            }
            if(temp.right != null){
                nodeQueue.add(temp.right);
            }
        }
        return false;

    }

}

class Node{
    int data ;
    Node left, right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
