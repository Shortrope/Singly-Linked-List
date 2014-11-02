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
    public boolean addIndex(String s, int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        if (index == 0){
            addFirst(s);
        }
        else {
            Node newNode = new Node();
            newNode.value = s;
            Node n = first;
            for (int i = 0; i < index-1; i++) {
                n = n.next;
            }
            newNode.next = n.next;
            n.next = newNode;
        }
        size++;
        return true;
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
    public String getIndex(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node n = first;
        for (int l = 0; l < index; l++) {
            n = n.next;
        }
        return n.value;
    }

    public boolean set(int index, String s){
        if (index < 0 || index >= size) {
            return false;
        }
        else {
            Node n = first;
            for (int i = 0; i < index; i++) {
                n = n.next;
            }
            n.value = s;
            return true;
        }
    }

    public String remove() {
        String s = first.value;
        first = first.next;
        size--;
        return s;
    }
    public String removeFirst() {
        return remove();
    }
    public String removeLast() {
        Node n = first;
        for (int i = 1; i < size -1; i++) {
            n = n.next;
        }
        String s = n.next.value;
        n.next = null;
        size--;
        return s;
    }
    public String removeIndex(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        String s = "";
        if (index == 0) {
            s = first.value;
            removeFirst();
        }
        else {
            Node n = first;
            Node previous = n;
            for (int i = 0; i < index; i++) {
                previous = n;
                n = n.next;
            }
            s = n.value;
            previous.next = n.next;
        }
        size--;
        return s;
    }


}
