/**
 *
 * @author Bayu Aji Firmansyah
 */
public class BinarySearchTree {

    class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int id) {
        Node newNode = new Node(id);
        if (root == null) {
            root = newNode;
            return;
        }
        Node pointer = root;
        Node parent = null;
        while (true) {
            parent = pointer;
            if (id > pointer.data) {
                pointer = pointer.right;
                if (pointer == null) {
                    parent.right = newNode;
                    return;
                }
            } else {
                pointer = pointer.left;
                if (pointer == null) {
                    parent.left = newNode;
                    return;
                }
            }
        }
    }

    public boolean find(int id) {
        Node pointer = root;
        while (pointer != null) {
            if (pointer.data == id) {
                return true;
            } else if (pointer.data > id) {
                pointer = pointer.left;
            } else {
                pointer = pointer.right;
            }
        }
        return false;
    }

    public Node getSuccessor(Node deleteNode) {
        Node successsor = null;
        Node successsorParent = null;
        Node pointer = deleteNode.right;
        while (pointer != null) {
            successsorParent = successsor;
            successsor = pointer;
            pointer = pointer.left;
        }
        if (successsor != deleteNode.right) {
            successsorParent.left = successsor.right;
            successsor.right = deleteNode.right;
        }
        return successsor;
    }

    public boolean delete(int id) {
        Node parent = root;
        Node pointer = root;
        boolean isLeftChild = false;
        while (pointer.data != id) {
            parent = pointer;
            if (pointer.data > id) {
                isLeftChild = true;
                pointer = pointer.left;
            } else {
                isLeftChild = false;
                pointer = pointer.right;
            }
            if (pointer == null) {
                return false;
            }
        }
        if (pointer.right == null && pointer.left == null) {
            if (pointer == root) {
                root = null;
            }
            if (isLeftChild == true) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (pointer.right == null) {
            if (pointer == root) {
                root = pointer.left;
            } else if (isLeftChild) {
                parent.left = pointer.left;
            } else {
                parent.right = pointer.left;
            }
        } else if (pointer.left == null) {
            if (pointer == root) {
                root = pointer.right;
            } else if (isLeftChild) {
                parent.left = pointer.right;
            } else {
                parent.right = pointer.right;
            }
        } else if (pointer.left != null && pointer.right != null) {
            Node successor = getSuccessor(pointer);
            if (pointer == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = pointer.left;
        }
        return true;
    }

    void printPostorder(Node node) {
        if (node == null) {
            return;
        }
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + " ");
    }

    void printPostorder() {
        printPostorder(root);
    }

    void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    void printInorder() {
        printInorder(root);
    }

    void printPreorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    void printPreorder() {
        printPreorder(root);
    }

}
