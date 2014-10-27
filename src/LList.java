/**
 * Created by Mario on 10/19/2014.
 */
public class LList {

    private Node first;
    private int size;
    private String last;



    private class Node {
        public String value;
        public Node next;
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        first = null;
        size = 0;
    }

    public void add(String s) {
        if (first == null) {
            first = new Node();
            first.value = s;
            size++;
        }
        else {
            Node oldFirst = first;
            first = new Node();
            first.value = s;
            first.next = oldFirst;
            size++;
        }
    }

    public void addFirst(String s) {
        add(s);
    }

    public void addLast(String s) {
        if (size == 0) add(s);
        else {
            Node n = first;
            while(n.next != null) {
                n = n.next;
            }
            Node oldLast = n;
            n = new Node();
            n.value = s;
            oldLast.next = n;
            size++;
        }
    }

    public String get() {
        if(size == 0) return null;
        else return first.value;
    }

    public String getFirst() {
        return get();
    }

    public String getLast() {
        if (size == 0) return null;
        else {
            Node n = first;
            while (n.next != null) {
                n = n.next;
            }
            return n.value;
        }
    }

    public void addIndex(String s, int index) {
        Node n = first;
        for (int i = 0; i < index; i++) {
           n = n.next;
        }
        n.value = s;
    }
    public String getIndex(int index) {
        Node n = first;
        for (int l = 0; l < index; l++) {
            n = n.next;
        }
        return n.value;
    }


}
