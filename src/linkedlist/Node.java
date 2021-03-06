package linkedlist;

public class Node<T> {
   private T data;
   private Node next;

   public Node(T data) {
        this.data = data;
   }

   public boolean insert(Node n) {
       Node next = this;
       while (next.next != null) {
           next = next.next;
       }
       next.next = n;
       return true;
   }

   public T getData() {
       return data;
   }
   public void setData(T data) {
       this.data = data;
   }
   public Node getNext() {
       return next;
   }
   public void setNext(Node next) {
       this.next = next;
   }
   public Node getLast() {
       if (next == null) {
           return this;
       } else {
           return next.getLast();
       }
   }
   public String toString() {
       if (this.next == null) {
           return this.data + " -> " + null;
       } else {
           return this.data + " -> " + this.next.toString();
       }
   }
}
