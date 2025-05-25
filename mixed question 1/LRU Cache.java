// Node class for doubly linked list
class ddl {
    ddl next = null;  // Points to next node
    ddl prev = null;  // Points to previous node
    int val;          // Stores value of the node
    int index;        // Stores key of the node

    // Constructor to create a node with key and value
    ddl(int index, int val) {
        this.index = index;
        this.val = val;
    }
}

class LRUCache {
    HashMap<Integer, ddl> map;  // Stores key -> node for fast lookup
    int size;                   // Capacity of the cache
    ddl first = null;           // Points to least recently used node
    ddl last = null;            // Points to most recently used node

    // Constructor to initialize cache with a given capacity
    public LRUCache(int capacity) {
        size = capacity;
        map = new HashMap<>();
    }

    // Get the value associated with a key
    public int get(int key) {
        if (map.containsKey(key)) {
            ddl temp = map.get(key);  // Get the node
            // If there's only one element, no need to move
            if (last == first) return temp.val;

            // If it's already the most recently used (at the end), return
            if (temp == last) return temp.val;

            // If it's the least recently used (at the front)
            if (temp == first) {
                first = first.next;     // Move first pointer to next
                first.prev = null;      // Disconnect old first node
                last.next = temp;       // Move old first to the end
                temp.prev = last;
                temp.next = null;
                last = temp;            // Update last
                return temp.val;
            }

            // If it's in the middle, unlink it from current position
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;

            // Move it to the end (most recently used)
            last.next = temp;
            temp.prev = last;
            temp.next = null;
            last = temp;
            return temp.val;
        }
        return -1; // If key doesn't exist
    }

    // Add or update key-value pair
    public void put(int key, int value) {
        // If key already exists, update the value and move to most recently used
        if (map.containsKey(key)) {
            ddl temp = map.get(key);
            temp.val = value;

            // If there's only one element, or it's already at the end
            if (last == first || temp == last) return;

            // If it's at the front, move to end
            if (temp == first) {
                first = first.next;
                first.prev = null;
                last.next = temp;
                temp.prev = last;
                temp.next = null;
                last = temp;
                return;
            }

            // If it's in the middle
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            last.next = temp;
            temp.prev = last;
            temp.next = null;
            last = temp;
            return;
        } else {
            // If it's a new key, create node and add to end
            ddl temp = new ddl(key, value);
            map.put(key, temp);

            // If it's the first node
            if (first == null) {
                first = temp;
                last = temp;
            } else {
                // Add new node to end
                last.next = temp;
                temp.prev = last;
                last = temp;
            }

            // If size exceeds capacity, remove least recently used node
            if (map.size() > size) {
                map.remove(first.index);  // Remove from map
                first = first.next;       // Update first pointer
                if (first != null) {
                    first.prev = null;    // Disconnect old node
                }
            }
        }
    }
}
