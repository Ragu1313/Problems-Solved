// import java.util.*;

class Node {
    int freq;
    Node prev;
    Node next;
    Set<String> set;

    public Node(int freq) {
        this.freq = freq;
        set = new HashSet<>();
        prev = null;
        next = null;
    }

    public void add(String key) {
        set.add(key);
    }

    public void remove(String key) {
        set.remove(key);
    }
}

class AllOne {
    Node head = new Node(-1);
    Node tail = new Node(-1);
    Map<String, Node> map = new HashMap<>();

    public AllOne() {
        head.next = tail;
        tail.prev = head;
    }

    // Insert a key into a new node with exact freq after `node`
    public void insertNext(Node node, int freq, String key) {
        if (node.next.freq == freq) {
            node.next.add(key);
            map.put(key, node.next);
            return;
        }

        Node newNode = new Node(freq);
        newNode.add(key);
        newNode.next = node.next;
        newNode.prev = node;
        node.next.prev = newNode;
        node.next = newNode;
        map.put(key, newNode);
    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            int newFreq = cur.freq + 1;
            cur.remove(key);

            if (cur.set.isEmpty()) {
                Node prev = cur.prev;
                Node next = cur.next;
                prev.next = next;
                next.prev = prev;
                insertNext(prev, newFreq, key);
            } else {
                insertNext(cur, newFreq, key);
            }
        } else {
            insertNext(head, 1, key);
        }
    }

    public void dec(String key) {
        if (!map.containsKey(key)) return;

        Node node = map.get(key);
        int freq = node.freq;
        node.remove(key);

        if (freq == 1) {
            map.remove(key);
        } else {
            int newFreq = freq - 1;
            if (node.prev.freq == newFreq) {
                node.prev.add(key);
                map.put(key, node.prev);
            } else {
                insertNext(node.prev, newFreq, key);
            }
        }

        if (node.set.isEmpty()) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public String getMaxKey() {
        return tail.prev.freq != -1 ? tail.prev.set.iterator().next() : "";
    }

    public String getMinKey() {
        return head.next.freq != -1 ? head.next.set.iterator().next() : "";
    }
}
