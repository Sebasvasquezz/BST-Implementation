package arep.BST;

import java.util.*;

/**
 * A binary search tree (BST) that implements the List interface. The tree maintains
 * elements in sorted order and supports typical operations like insertion, deletion,
 * and search. It also provides several traversal methods.
 * 
 * @param T the type of elements in this binary search tree, which must implement Comparable.
 */
public class BinarySearchTree<T extends Comparable<T>> implements List<T> {
    
    // Inner class representing a node in the binary search tree
    class Node {
        T value;
        Node left, right;
            
        // Constructor for creating a new node with a specific value
        Node(T value) {
            this.value = value;
            left = right = null;
        }
    }

    private Node root;
    private int size;

    /**
     * Constructor that initializes an empty binary search tree.
     */    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    /**
     * Returns the number of elements in the tree.
     * 
     * @return the size of the tree
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the tree is empty.
     * 
     * @return true if the tree is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the tree contains a specific element.
     * 
     * @param o the element to check
     * @return true if the tree contains the element, false otherwise
     */
    @Override
    public boolean contains(Object o) {
        return containsRec(root, (T) o);
    }

    private boolean containsRec(Node node, T value) {
        if (node == null) return false;
        int cmp = value.compareTo(node.value);
        if (cmp < 0) return containsRec(node.left, value);
        if (cmp > 0) return containsRec(node.right, value);
        return true;
    }

    /**
     * Adds an element to the tree if it doesn't already exist.
     * 
     * @param value the element to add
     * @return true if the element was added, false otherwise
     */
    @Override
    public boolean add(T value) {
        if (!contains(value)) {
            root = insertRec(root, value);
            size++;
            return true;
        }
        return false;
    }

    /**
     * Recursively inserts a new value into the binary search tree.
     * 
     * @param node  the current node in the recursion
     * @param value the value to insert into the tree
     * @return the node after the insertion has been performed
     */
    private Node insertRec(Node node, T value) {
        if (node == null) return new Node(value);
        int cmp = value.compareTo(node.value);
        if (cmp < 0) {
            node.left = insertRec(node.left, value);
        } else if (cmp > 0) {
            node.right = insertRec(node.right, value);
        }
        return node;
    }

    /**
     * Removes an element from the tree.
     * 
     * @param o the element to remove
     * @return true if the element was removed, false otherwise
     */
    @Override
    public boolean remove(Object o) {
        if (contains(o)) {
            root = deleteRec(root, (T) o);
            size--;
            return true;
        }
        return false;
    }

    /**
     * Recursive helper function to delete a value from a subtree.
     * 
     * @param root the root of the subtree
     * @param value the value to delete
     * @return the root of the modified subtree
     */
    private Node deleteRec(Node node, T value) {
        if (node == null) return null;
        int cmp = value.compareTo(node.value);
        if (cmp < 0) node.left = deleteRec(node.left, value);
        else if (cmp > 0) node.right = deleteRec(node.right, value);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node minNode = findMinRec(node.right);
            node.value = minNode.value;
            node.right = deleteRec(node.right, minNode.value);
        }
        return node;
    }

    /**
     * Finds the minimum value node in the binary search tree starting from a given node.
     * 
     * @param T the starting node to search for the minimum value
     * @return the value of node with the smallest value in the subtree
     */
    public T findMin() {
        if (root == null) throw new NoSuchElementException("El árbol está vacío");
        return findMinRec(root).value;
    }


    /**
     * Recursively finds the node with the minimun value in the tree.
     * 
     * @param node the current node being examined
     * @return the node with the minimun value
     */
    private Node findMinRec(Node node) {
        if (node.right == null) {
            return node;
        }
        return findMaxRec(node.left);
    }

    /**
     * Returns the element at a specific index in the tree when viewed in sorted order.
     * 
     * @param index the index of the element
     * @return the element at the given index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        List<T> sortedElements = new ArrayList<>();
        inOrderTraversalRec(root, sortedElements);
        return sortedElements.get(index);
    }



    /**
     * Returns the index of the specified element in the tree, or -1 if this tree does not contain the element.
     * 
     * @param o the element to search for in the tree
     * @return the index of the element if found, otherwise -1
     */
    @Override
    public int indexOf(Object o) {
        List<T> sortedElements = new ArrayList<>();
        inOrderTraversalRec(root, sortedElements);
        return sortedElements.indexOf(o);
    }

    /**
     * Returns an array containing all of the elements in the tree in sorted (in-order) sequence.
     * 
     * @return an array containing all of the elements in this tree
     */
    @Override
    public Object[] toArray() {
        List<T> sortedElements = new ArrayList<>();
        inOrderTraversalRec(root, sortedElements);
        return sortedElements.toArray();
    }

    /**
     * Returns an array containing all of the elements in the tree in sorted (in-order) sequence; the runtime type of the returned array is that of the specified array.
     * 
     * @param <T1> the component type of the array to contain the tree's elements
     * @param a the array into which the elements of the tree are to be stored
     * @return an array containing the elements of the tree
     */
    @Override
    public <T1> T1[] toArray(T1[] a) {
        List<T> sortedElements = new ArrayList<>();
        inOrderTraversalRec(root, sortedElements);
        return sortedElements.toArray(a);
    }

    /**
     * Checks if the tree contains all elements from the specified collection.
     * 
     * @param c the collection to check for containment
     * @return true if the tree contains all elements in the specified collection, false otherwise
     * @throws NullPointerException if the specified collection is null
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object elem : c) {
            if (!contains(elem)) return false;
        }
        return true;
    }

    /**
     * Adds all elements from the specified collection to the tree.
     * 
     * @param c the collection containing elements to be added
     * @return true if the tree was modified as a result of the operation, false otherwise
     * @throws NullPointerException if the specified collection is null
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        for (T elem : c) {
            if (add(elem)) modified = true;
        }
        return modified;
    }

    /**
     * Removes all elements from the tree that are also contained in the specified collection.
     * 
     * @param c the collection containing elements to be removed from the tree
     * @return true if the tree was modified as a result of the operation, false otherwise
     * @throws NullPointerException if the specified collection is null
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object elem : c) {
            if (remove(elem)) modified = true;
        }
        return modified;
    }

    /**
     * Retains only the elements in the tree that are contained in the specified collection.
     * 
     * @param c the collection containing elements to retain in the tree
     * @return true if the tree was modified as a result of the operation, false otherwise
     * @throws NullPointerException if the specified collection is null
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (T elem : this) {
            if (!c.contains(elem)) {
                remove(elem);
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Removes all elements from the tree, leaving it empty.
     */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }


    /**
     * Searches for a specific element in the tree.
     * 
     * @param value the element to search for
     * @return the element if found, null otherwise
     */
    public T search(T value) {
        Node result = searchRec(root, value);
        return result == null ? null : result.value;
    }

    /**
     * Recursively searches for a node with the specified value in the tree.
     * 
     * @param node the current node to compare the value with
     * @param value the value to search for in the tree
     * @return the node containing the specified value, or null if the value is not found
     * @throws NullPointerException if the specified value is null
     */
    private Node searchRec(Node node, T value) {
        if (node == null || node.value.equals(value)) {
            return node;
        }
        int cmp = value.compareTo(node.value);
        if (cmp < 0) {
            return searchRec(node.left, value);
        } else {
            return searchRec(node.right, value);
        }
    }

    /**
     * Returns a list of elements in the tree in ascending order (in-order traversal).
     * 
     * @return the list of elements in ascending order
     */
    public List<T> inOrderTraversal() {
        List<T> result = new ArrayList<>();
        inOrderTraversalRec(root, result);
        return result;
    }

    /**
     * Performs an in-order traversal of the tree, recursively visiting nodes in left-root-right order.
     * 
     * @param node the current node being visited
     * @param result the list where node values will be stored
     */
    private void inOrderTraversalRec(Node node, List<T> result) {
        if (node != null) {
            inOrderTraversalRec(node.left, result);
            result.add(node.value);
            inOrderTraversalRec(node.right, result);
        }
    }


    /**
     * Returns a list of the tree elements in pre-order (root-left-right) traversal.
     * 
     * @return a list containing the tree elements in pre-order
     */
    public List<T> preOrderTraversal() {
        List<T> result = new ArrayList<>();
        preOrderTraversalRec(root, result);
        return result;
    }


    /**
     * Performs a pre-order traversal of the tree, recursively visiting nodes in root-left-right order.
     * 
     * @param node the current node being visited
     * @param result the list where node values will be stored
     */
    private void preOrderTraversalRec(Node node, List<T> result) {
        if (node != null) {
            result.add(node.value);
            preOrderTraversalRec(node.left, result);
            preOrderTraversalRec(node.right, result);
        }
    }


    /**
     * Returns a list of the tree elements in post-order (left-right-root) traversal.
     * 
     * @return a list containing the tree elements in post-order
     */
    public List<T> postOrderTraversal() {
        List<T> result = new ArrayList<>();
        postOrderTraversalRec(root, result);
        return result;
    }


    /**
     * Performs a post-order traversal of the tree, recursively visiting nodes in left-right-root order.
     * 
     * @param node the current node being visited
     * @param result the list where node values will be stored
     */
    private void postOrderTraversalRec(Node node, List<T> result) {
        if (node != null) {
            postOrderTraversalRec(node.left, result);
            postOrderTraversalRec(node.right, result);
            result.add(node.value);
        }
    }


    /**
     * Finds and returns the maximum value in the tree.
     * 
     * @return the maximum value in the tree
     * @throws NoSuchElementException if the tree is empty
     */
    public T findMax() {
        if (root == null) throw new NoSuchElementException("El árbol está vacío");
        return findMaxRec(root).value;
    }


    /**
     * Recursively finds the node with the maximum value in the tree.
     * 
     * @param node the current node being examined
     * @return the node with the maximum value
     */
    private Node findMaxRec(Node node) {
        if (node.right == null) {
            return node;
        }
        return findMaxRec(node.right);
    }


    /**
     * Calculates and returns the height of the tree.
     * 
     * @return the height of the tree, or -1 if the tree is empty
     */
    public int height() {
        return heightRec(root);
    }


    /**
     * Recursively calculates the height of the tree.
     * 
     * @param node the current node being examined
     * @return the height of the current subtree
     */
    private int heightRec(Node node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = heightRec(node.left);
        int rightHeight = heightRec(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }


    /**
     * Checks if the tree is balanced. A balanced tree is defined as one where the height difference 
     * between the left and right subtrees of every node is no more than one.
     * 
     * @return true if the tree is balanced, false otherwise
     */
    public boolean isBalanced() {
        return isBalancedRec(root);
    }


    /**
     * Recursively checks if a subtree is balanced.
     * 
     * @param node the current node being examined
     * @return true if the subtree is balanced, false otherwise
     */
    private boolean isBalancedRec(Node node) {
        if (node == null) return true;

        int leftHeight = heightRec(node.left);
        int rightHeight = heightRec(node.right);

        if (Math.abs(leftHeight - rightHeight) > 1) return false;

        return isBalancedRec(node.left) && isBalancedRec(node.right);
    }

    /**
     * Performs a level-order (breadth-first) traversal of the tree.
     * 
     * @return a list of elements in level-order traversal
     */
    public List<T> levelOrderTraversal() {
        List<T> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            result.add(current.value);

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }

        return result;
    }

    /**
     * Returns an iterator over the elements of the tree, traversing them in in-order.
     * 
     * @return an iterator over the elements of the tree
     */
    @Override
    public Iterator<T> iterator() {
        List<T> sortedElements = new ArrayList<>();
        inOrderTraversalRec(root, sortedElements);
        return sortedElements.iterator();
    }

    /**
     * Returns a view of the portion of the tree elements in in-order traversal between the specified
     * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive.
     * 
     * @param fromIndex the starting index, inclusive
     * @param toIndex the ending index, exclusive
     * @return a list containing the specified range of elements
     * @throws IndexOutOfBoundsException if an index is out of range
     */
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        List<T> sortedElements = new ArrayList<>();
        inOrderTraversalRec(root, sortedElements);
        return sortedElements.subList(fromIndex, toIndex);
    }

    // The following List interface methods are not supported by the Binary Search Tree
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException("Adding all by index is not supported in a BST");
    }
    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("ListIterator is not supported in a BST");
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("ListIterator by index is not supported in a BST");
    }

    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException("Setting by index is not supported in a BST");
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException("Adding by index is not supported in a BST");
    }
    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Unimplemented method 'lastIndexOf'");
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
}
