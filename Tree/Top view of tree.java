class Pair {
    Node root;
    int pos;

    Pair(Node root, int pos) {
        this.root = root;
        this.pos = pos;
    }
}

class Solution {
    static ArrayList<Integer> topView(Node root) {
        Queue<Pair> qu = new LinkedList<>();
        qu.offer(new Pair(root, 0));
        
        TreeMap<Integer, Node> map = new TreeMap<>();
        
        while (!qu.isEmpty()) {
            Pair p = qu.poll();
            Node temp = p.root;
            int pos = p.pos;

            if (!map.containsKey(pos)) {
                map.put(pos, temp);
            }

            if (temp.left != null) {
                qu.offer(new Pair(temp.left, pos - 1));
            }
            if (temp.right != null) {
                qu.offer(new Pair(temp.right, pos + 1));
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (Node n : map.values()) {
            result.add(n.data);
        }

        return result;
    }
}
