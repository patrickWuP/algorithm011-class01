import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    
    private DLinkNode head;
    private DLinkNode tail;
    private int size = 0;
    private int capacity;
    Map<Integer,DLinkNode> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (cache.get(key) == null) return -1;
        DLinkNode node = cache.get(key);
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            DLinkNode newNode = new DLinkNode(key, value);
            addToHead(newNode);
            cache.put(key, newNode);
            size++;
            if (size > capacity) {
                DLinkNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
    
    public DLinkNode removeTail() {
        DLinkNode node = tail.prev;
        removeNode(node);
        return node;
    }
    public void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }
    
    public void removeNode(DLinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void addToHead(DLinkNode node) {
        node.next = head.next;
        head.next.prev = node;
        
        head.next = node;
        node.prev = head;
    }
    
    private static class DLinkNode {
        private Integer key;
        private Integer value;
        private DLinkNode prev;
        private DLinkNode next;
        
        public DLinkNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public DLinkNode() {
        }
    }
}