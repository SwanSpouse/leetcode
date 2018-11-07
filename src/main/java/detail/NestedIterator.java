package detail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    private List<Integer> list;
    private int index;

    public void dfs(List<Integer> list, NestedInteger node) {
        if (node == null) {
            return;
        }
        if (node.isInteger()) {
            list.add(node.getInteger());
        } else {
            for (NestedInteger child : node.getList()) {
                dfs(list, child);
            }
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = new ArrayList<>();
        this.index = 0;

        for (NestedInteger child : nestedList) {
            dfs(this.list, child);
        }
    }

    @Override
    public Integer next() {
        return this.list.get(this.index++);
    }

    @Override
    public boolean hasNext() {
        return this.index < this.list.size();
    }
}
