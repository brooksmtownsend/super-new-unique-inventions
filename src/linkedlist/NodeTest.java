package linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void insert() {
        int iterations = 10000;
        int[] values = new int[iterations];
        values[0] = 0;
        Node head = new Node(values[0]);
        for (int i = 1; i < iterations; i++) {
            values[i] = (int) (Math.random() * 100000);
        }
        for (int i = 1; i < iterations; i++) {
            int data = values[i];
            head.insert(new Node<>(data));
        }
        for (int i = 0; i < iterations-1; i++) {
            assertNotNull(head.getNext());
            assertEquals(values[i], head.getData());
            head = head.getNext();
        }
        assertEquals(values[iterations-1], head.getData());
        assertNull(head.getNext());
    }

    @Test
    void getData() {
        int data = (int) (Math.random() * Math.random() * Math.random() * 10000);
        Node n = new Node(data);
        assertEquals(data, n.getData());
    }

    @Test
    void setData() {
        int init = (int) (Math.random() * Math.random() * Math.random() * 10000);
        int data = (int) (Math.random() * Math.random() * Math.random() * 10000);
        Node n = new Node(init);
        assertEquals(init, n.getData());
        assertNotEquals(data, n.getData());
        n.setData(data);
        assertNotEquals(init, n.getData());
        assertEquals(data, n.getData());
    }

    @Test
    void getNext() {
        Node f = new Node(0);
        Node m = new Node(1);
        Node l = new Node(2);
        f.insert(m);
        f.insert(l);
        assertNotNull(f.getNext());
        assertEquals(m, f.getNext());
        assertNotNull(f.getNext().getNext());
        assertEquals(l, f.getNext().getNext());
        assertNotNull(m.getNext());
        assertEquals(l, m.getNext());
    }

    @Test
    void toStringTest() {
        Node f = new Node(0);
        Node m = new Node(1);
        Node l = new Node(2);
        f.insert(m);
        f.insert(l);

        assertEquals("0 -> 1 -> 2 -> null", f.toString());
    }
}