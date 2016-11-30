package ua.training;

import java.util.*;

/**
 * Created by andrii on 25.11.16.
 */
public class MyTreeSet<T extends Comparable> implements Set<T>, NavigableSet<T> {

    // Collection variables
    private Node<T> rootNode = new Node<>();
    private int collectionSize = 0;

    /**
     * Main Node element for creation of MyTreeSet collection structure
     * @param <T> type of Objects to contain.
     */
    private class Node<T>{
        // Variables
        Node<T> parentNode;
        Node<T> leftNode;
        Node<T> rightNode;
        T dataObject;

        public Node() {
        }

        public Node(T dataObject) {
            this.dataObject = dataObject;
        }

        public Node(Node<T> parentNode, Node<T> leftNode, Node<T> rightNode, T dataObject) {
            this.parentNode = parentNode;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            this.dataObject = dataObject;
        }

        public Node<T> getParentNode() {
            return parentNode;
        }

        public void setParentNode(Node<T> parentNode) {
            this.parentNode = parentNode;
        }

        public Node<T> getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node<T> leftNode) {
            this.leftNode = leftNode;
        }

        public Node<T> getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node<T> rightNode) {
            this.rightNode = rightNode;
        }

        public T getDataObject() {
            return dataObject;
        }

        public void setDataObject(T dataObject) {
            this.dataObject = dataObject;
        }
    }

    // Implemented methods

    /**
     * Method adds a new Object to collection and returns an operation result.
     *
     * @param newDataObject Object to add
     * @return boolean result of operation
     */
    @Override
    public boolean add(T newDataObject) {
        Objects.requireNonNull(newDataObject, "MyTreeSet class: add(): method parameter shouldn't be 'null'!");
        if (rootNode.dataObject == null){
            rootNode.dataObject = newDataObject;
            collectionSize++;
        } else {
            Node<T> currentNode = rootNode;
            //while (current != null) {
            while (true) {
                int compareResult = newDataObject.compareTo(currentNode.dataObject);
                if (compareResult == 0) {
                    return false;
                } else if (compareResult < 0) {
                    if (currentNode.leftNode != null) {
                        currentNode = currentNode.leftNode;
                    } else {
                        currentNode.leftNode = new Node<>(newDataObject);
                        currentNode.leftNode.parentNode = currentNode;
                        collectionSize++;
                        return true;
                    }
                } else {
                    if (currentNode.rightNode != null) {
                        currentNode = currentNode.rightNode;
                    } else {
                        currentNode.rightNode = new Node<>(newDataObject);
                        currentNode.rightNode.parentNode = currentNode;
                        collectionSize++;
                        return true;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }


    /**
     * Method returns size of the collection.
     *
     * @return number of containing objects
     */
    @Override
    public int size() {
        return collectionSize;
    }

    /**
     * Method returns bolean value if the collection is Empty.
     *
     * @return boolean operation result
     */
    @Override
    public boolean isEmpty() {
        return collectionSize == 0;
    }

    /**
     * Method checks if the collection contains passed as a parameter
     * Object and returns a checking result.
     *
     * @param dataObject Object to check
     * @return boolean operation result
     */
    @Override
    public boolean contains(Object dataObject) {
        Objects.requireNonNull(dataObject, "MyTreeSet class: contains(): method parameter shouldn't be 'null'!");
        T searchObject = (T) dataObject;
        Node<T> currentNode = rootNode;
        while (currentNode != null) {
            int compareResult = searchObject.compareTo(currentNode.dataObject);
            if (compareResult == 0) {
                return true;
            } else if (compareResult < 0) {
                currentNode = currentNode.leftNode;
            } else {
                currentNode = currentNode.rightNode;
            }
        }
        return false;
    }

    @Override
    public T lower(T t) {
        return null;
    }

    @Override
    public T floor(T t) {
        return null;
    }

    @Override
    public T ceiling(T t) {
        return null;
    }

    @Override
    public T higher(T t) {
        return null;
    }

    @Override
    public T pollFirst() {
        return null;
    }

    @Override
    public T pollLast() {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public NavigableSet<T> descendingSet() {
        return null;
    }

    @Override
    public Iterator<T> descendingIterator() {
        return null;
    }

    @Override
    public NavigableSet<T> subSet(T fromElement, boolean fromInclusive, T toElement, boolean toInclusive) {
        return null;
    }

    @Override
    public NavigableSet<T> headSet(T toElement, boolean inclusive) {
        return null;
    }

    @Override
    public NavigableSet<T> tailSet(T fromElement, boolean inclusive) {
        return null;
    }

    @Override
    public Comparator<? super T> comparator() {
        return null;
    }

    @Override
    public SortedSet<T> subSet(T fromElement, T toElement) {
        return null;
    }

    @Override
    public SortedSet<T> headSet(T toElement) {
        return null;
    }

    @Override
    public SortedSet<T> tailSet(T fromElement) {
        return null;
    }

    @Override
    public T first() {
        return null;
    }


    @Override
    public T last() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
