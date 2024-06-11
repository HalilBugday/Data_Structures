package MainModule;

public class Tree<T extends Comparable<T>> {
    private Node<T> root;

    public void add(T data) {
        root = addRecursive(root, data);
    }

    private Node<T> addRecursive(Node<T> current, T data) {
        if (current == null) {
            return new Node<>(data);
        }

        if (data.compareTo(current.getData()) < 0) {
            current.setLeft(addRecursive(current.getLeft(), data));
        } else if (data.compareTo(current.getData()) > 0) {
            current.setRight(addRecursive(current.getRight(), data));
        }

        return current;
    }

    public boolean containsNode(T data) {
        return containsNodeRecursive(root, data);
    }

    private boolean containsNodeRecursive(Node<T> current, T data) {
        if (current == null) {
            return false;
        }
        if (data.equals(current.getData())) {
            return true;
        }
        if (data.compareTo(current.getData()) < 0) {
            return containsNodeRecursive(current.getLeft(), data);
        } else {
            return containsNodeRecursive(current.getRight(), data);
        }
    }

    public ArrayList<T> inOrderTraversal() {
        ArrayList<T> nodes = new ArrayList<>();
        inOrderTraversalRecursive(root, nodes);
        return nodes;
    }

    private void inOrderTraversalRecursive(Node<T> node, ArrayList<T> nodes) {
        if (node != null) {
            inOrderTraversalRecursive(node.getLeft(), nodes);
            nodes.add(node.getData());
            inOrderTraversalRecursive(node.getRight(), nodes);
        }
    }
}