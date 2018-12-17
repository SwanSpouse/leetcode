package tree;

public class QuadTreeIntersection {
    private static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

    public Node intersect(Node quadTree1, boolean val1, Node quadTree2, boolean val2) {
        Node newNode = new Node();
        if (quadTree1 == null && quadTree2 == null) {
            newNode.val = val1 || val2;
            newNode.isLeaf = true;
            return newNode;
        } else if (quadTree1 == null) {
            newNode.val = val1 || quadTree2.val;

            newNode.topLeft = intersect(null, val1, quadTree2.topLeft, quadTree2.val);
            newNode.topRight = intersect(null, val1, quadTree2.topRight, quadTree2.val);
            newNode.bottomLeft = intersect(null, val1, quadTree2.bottomLeft, quadTree2.val);
            newNode.bottomRight = intersect(null, val1, quadTree2.bottomRight, quadTree2.val);
        } else if (quadTree2 == null) {
            newNode.val = val2 || quadTree1.val;

            newNode.topLeft = intersect(null, val2, quadTree1.topLeft, quadTree1.val);
            newNode.topRight = intersect(null, val2, quadTree1.topRight, quadTree1.val);
            newNode.bottomLeft = intersect(null, val2, quadTree1.bottomLeft, quadTree1.val);
            newNode.bottomRight = intersect(null, val2, quadTree1.bottomRight, quadTree1.val);
        } else {
            newNode.val = quadTree1.val || quadTree2.val;

            newNode.topLeft = intersect(quadTree1.topLeft, val1, quadTree2.topLeft, quadTree2.val);
            newNode.topRight = intersect(quadTree1.topRight, val1, quadTree2.topRight, quadTree2.val);
            newNode.bottomLeft = intersect(quadTree1.bottomLeft, val1, quadTree2.bottomLeft, quadTree2.val);
            newNode.bottomRight = intersect(quadTree1.bottomRight, val1, quadTree2.bottomRight, quadTree2.val);
        }
        newNode.isLeaf = newNode.topLeft == null && newNode.topRight == null && newNode.bottomLeft == null && newNode.bottomRight == null;

        return newNode;
    }

    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1 == null) {
            return quadTree2;
        } else if (quadTree2 == null) {
            return quadTree1;
        }
        Node newNode = new Node();
        if ((quadTree1.isLeaf && quadTree1.val) || (quadTree2.isLeaf && quadTree2.val)) {
            newNode.isLeaf = true;
            newNode.val = true;
            return newNode;
        } else if (quadTree1.isLeaf && !quadTree1.val && quadTree2.isLeaf && !quadTree2.val) {
            newNode.isLeaf = true;
            newNode.val = false;
            return newNode;
        }

        newNode.topLeft = intersect(quadTree1.topLeft, quadTree1.val, quadTree2.topLeft, quadTree2.val);
        newNode.topRight = intersect(quadTree1.topRight, quadTree1.val, quadTree2.topRight, quadTree2.val);
        newNode.bottomLeft = intersect(quadTree1.bottomLeft, quadTree1.val, quadTree2.bottomLeft, quadTree2.val);
        newNode.bottomRight = intersect(quadTree1.bottomRight, quadTree1.val, quadTree2.bottomRight, quadTree2.val);

        newNode.isLeaf = newNode.topLeft == null && newNode.topRight == null && newNode.bottomLeft == null && newNode.bottomRight == null;
        return newNode;
    }
}
