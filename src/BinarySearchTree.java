public class BinarySearchTree<T extends Comparable<T>> {

    private class Node {
        T item;
        Node left;
        Node right;

        Node(T item) {
            this.item = item;
        }
    }

    private Node root;

    public boolean isEmpty() {
        return root == null;
    }

   
    public void insert(T val) {
        if (val == null) return;

        Node newNode = new Node(val);

        if (isEmpty()) {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent = null;

        while (current != null) {
            parent = current;

            if (current.item.compareTo(val) == 0) {
                System.out.println("You Can't Duplicate");
                return;
            } else if (current.item.compareTo(val) < 0) {
                current = current.right;
            } else {
                current = current.left;
            }
        }

        if (parent.item.compareTo(val) < 0)
            parent.right = newNode;
        else
            parent.left = newNode;
    }

   
    public boolean search(T val) {
        if (isEmpty() || val == null) return false;

        Node current = root;

        while (current != null) {
            int cmp = current.item.compareTo(val);

            if (cmp == 0)
                return true;
            else if (cmp < 0)
                current = current.right;
            else
                current = current.left;
        }

        return false;
    }

   
    public boolean searchRec(T val) {
        return searchRec(root, val);
    }

    private boolean searchRec(Node p, T val) {
        if (p == null || val == null) return false;

        int cmp = p.item.compareTo(val);

        if (cmp == 0) return true;
        if (cmp > 0)
            return searchRec(p.left, val);
        else
            return searchRec(p.right, val);
    }

  
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node p) {
        if (p != null) {
            inorder(p.left);
            System.out.print(p.item + " ");
            inorder(p.right);
        }
    }

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(Node p) {
        if (p != null) {
            System.out.print(p.item + " ");
            preorder(p.left);
            preorder(p.right);
        }
    }

    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(Node p) {
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.item + " ");
        }
    }

    
    public int height() {
        return height(root);
    }

    private int height(Node p) {
        if (p == null) return 0;
        return 1 + Math.max(height(p.left), height(p.right));
    }

   
    public int nodeCount() {
        return nodeCount(root);
    }

    private int nodeCount(Node p) {
        if (p == null) return 0;
        return 1 + nodeCount(p.left) + nodeCount(p.right);
    }

    public int leavesCount() {
        return leavesCount(root);
    }

    private int leavesCount(Node p) {
        if (p == null) return 0;
        if (p.left == null && p.right == null) return 1;
        return leavesCount(p.left) + leavesCount(p.right);
    }

   
    public T min() {
        if (isEmpty()) return null;

        Node current = root;
        while (current.left != null)
            current = current.left;

        return current.item;
    }

    public T max() {
        if (isEmpty()) return null;

        Node current = root;
        while (current.right != null)
            current = current.right;

        return current.item;
    }

    
    public void delete(T val) {
        if (val == null) return;

        Node current = root;
        Node parent = null;

        while (current != null && current.item.compareTo(val) != 0) {
            parent = current;
            if (current.item.compareTo(val) < 0)
                current = current.right;
            else
                current = current.left;
        }

        if (current == null) return;

        // Case 2 children
        if (current.left != null && current.right != null) {
            Node succ = current.right;
            Node succParent = current;

            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }

            current.item = succ.item;
            current = succ;
            parent = succParent;
        }

        // One or zero child
        Node child = (current.left != null) ? current.left : current.right;

        if (parent == null)
            root = child;
        else if (parent.left == current)
            parent.left = child;
        else
            parent.right = child;
    }

    private int getLevel(T x , Node p){
        if(x == p.item || p == null)                       return 0 ;
        if(p.right.item == x || p.left.item == x)     return 1 ;

        if(x.compareTo(p.item) > 0)              return 1 + getLevel(x, p.right) ;
        else                                     return 1 + getLevel(x, p.left) ;
    }

    public int level(T x){
        return getLevel(x , root) ;
    }
    
    public void clear() {
        root = null;
    }
}
