package linkedlist;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList(Node<T> head) {
        if (head == null) {
            this.head = null;
            tail = null;
            size = 0;
        } else {
            this.head = head;
            tail = head;
            size = 1;
        }
    }

    public boolean insert(Node<T> n) {
        if (head == null) {
            head = n;
            tail = n;
            size++;
            return true;
        } else if (head.equals(tail)) {
            head.setNext(n);
            if (tail.getNext() == null) {
                tail = n;
            } else {
                tail = n.getLast();
            }
            size++;
            return true;
        } else {
            if (head.insert(n)) {
                size++;
                return true;
            } else{
                return false;
            }
        }
    }

    public boolean delete(T data) {
       if (head.getData().equals(data)) {
           size--;
           if (head.equals(tail)) {
               head = null;
               tail = null;
               size--;
               return true;
           }
           head = head.getNext();
           return true;
       } else {
           Node current = head;
           while (current.getNext() != null) {
               if (current.getNext().getData().equals(data)) {
                   current.setNext(current.getNext().getNext());
                   size--;
                   return true;
               }
               current = current.getNext();
           }
           return false;
       }
    }

    public Node<T> getHead() {
        return head;
    }
    public Node<T> getLast() {
        return tail;
    }
    public int getSize() {
        return size;
    }
    public String toString() {
        if (head == null) {
            return null;
        }
        return head.toString();
    }
}
