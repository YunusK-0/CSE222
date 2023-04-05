import java.util.Iterator;
import java.util.List;
import java.util.AbstractList;

/**
 * This is custom double linkedlist(LL) but it is different from casual LL because this has lazy delation which is simply for first time it marks which one is gonna be deleted
 * then after second one it deletes both of them. 
 */
public class LDLinkedList<E> extends AbstractList<E> implements List<E>, Iterable<E>
{
    /**
     * head of linked list
     */
    private Node<E> head;
    /**
     * tail of linkedlist
     */
    private Node<E> tail;
    private int size;
    /**
     * counts number of deletion. when it becomes 2 or 2-4-6-8... then it triggers move method.
     */
    private int deleted;
    
    /**
     * consturcter for LDLL.
     */
    public LDLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.deleted = 0;
    }
    /**
     * this is generic node class which includes next prev,value
     */
    private static class Node<T>
    {
        private T value;
        private Node<T> next;
        private Node<T> prev;
        /**
         * it marks the which is going to be deleted 
         * if it is true then it is going to with another node.
         */
        private boolean lazydelation;

        public Node(final T value) {
            this.lazydelation = false;
            this.value = value;
            this.next = null;
        }
    }
    /**
     * generic custom iterator class it is private because as a designer i didn't want it to be called from outside.
     */
    private class my_iterator<W> implements Iterator<W>
    {
        private Node<W> current;
        
        /**
         * it produces iterator
         * @param current iterator which is pointing head.
         */
        public my_iterator(Node<W> current) {
            this.current = current;
        }
        
        @Override
        public boolean hasNext() {
            return this.current != null;
        }
        /**
         * when it goes next node then returns the just previous one.
         */
        @Override
        public W next() {
            final Node<W> current = this.current;
            this.current = this.current.next;
            return current.value;
        }
    }
    /**
     * it returns data which is in the spesific position at LL. It requires an integer. 
     */
    @Override
    public E get(final int n) {
        Node<E> node = this.head;
        if (n < this.size) {
            for (int n2 = 0; node != null && n2 < n; node = node.next, ++n2) {}
        }
        if (node != null && n < this.size) {
            return (E)node.value;
        }
        return null;
    }
    
    @Override
    public int size() {
        return this.size;
    }
    /**
     * as a designer it adds to the tail if size greater than zero. otherwise it adds on head then makes head and tail to the same position.
     */
    @Override
    public boolean add(final E e) {
        if (this.size > 0) {
            this.tail.next = new Node<E>(e);
            this.tail.next.prev = this.tail;
            this.tail = this.tail.next;
        }
        else {
            this.head = new Node<E>(e);
        }
        if (this.size == 0) {
            this.tail = this.head;
            this.head.prev = null;
            this.tail.prev = null;
        }
        ++this.size;
        return true;
    }
    /**
     * creating new iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new my_iterator<E>(head);
    }
    /**
     * first part marks the given object.
     * second part checks what is number if is even then it is going to delete the marked ones.
     */
    @Override
    public boolean remove(final Object o) {
        for (Node<E> node = this.head; node != null; node = node.next) {
            if (o.equals(node.value) && !node.lazydelation) {
                node.lazydelation = true;
                ++this.deleted;
            }
        }
        if (this.deleted %2 ==0) {
            for (Node<E> node2 = this.head; node2 != null; node2 = node2.next) {
                if (node2.lazydelation) {
                    this.unlink(node2);
                }
            }
        }
        return true;
    }
    /**
     * it makes prev one to poing next one so garbage collector handle it.
     * @param node it takes a node that is going to be deleted.
     * @return value of the deleted node. Node.value
     */
    public E unlink(Node<E> node) {
        Node<E> next = node.next;
        Node<E> prev = node.prev;
        if (prev == null) {
            this.head = next;
        }
        else {
            prev.next = next;
        }
        if (next == null) {
            this.tail = prev;
        }
        else {
            next.prev = prev;
        }
        node.value = null;
        --this.size;
        return node.value;
    }
}