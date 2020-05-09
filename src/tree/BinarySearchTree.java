package tree;

public class BinarySearchTree {
    private Node tree;

    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (data < p.data) {
                p = p.left;
            } else if (data > p.data) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    public void insert(int data) {
        if(tree == null) {
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while (p != null) {
            if(p.data > data) {
                if(p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            } else if(p.data < data) {
                if(p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            }
        }
    }

    public Node delete(Node root, int data) {
        if(root == null) {
            System.out.println("element not in tree");
            return null;
        }
        if(data < root.data) {
            //data 在左子树
            root.left = delete(root.left, data);
        } else if(data > root.data) {
            //data 在右子树
            root.right = delete(root.right, data);
        } else {
            //找到了
            if(root.left != null && root.right != null) {
                //要删除的节点有左右孩子节点
                Node p = findMin(root.right);
                root.data = p.data;
                root.right = delete(root.right, p.data);
            } else {
                //要删除的节点只有一个孩子节点或者没有孩子节点
                Node tmp = root;
                if(root.left != null) {
                    root = root.left;
                }
                if(root.right != null) {
                    root = root.right;
                }
                tmp = null;
            }
        }

        return root;
    }

    public Node findMin(Node root) {
        if(root == null) return null;
        Node p = root;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    public Node findMin() {
        if(tree == null) return null;
        Node p = tree;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    public Node findMax() {
        if(tree == null) return null;
        Node p = tree;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;
        public Node(int data) {
            this.data = data;
        }
    }
}
