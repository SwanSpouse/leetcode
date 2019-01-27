package detail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmployeeImportance {
    private class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            map.put(employees.get(i).id, employees.get(i));
        }
        int sum = 0;
        List<Employee> cur;
        List<Employee> next = new ArrayList<>();
        next.add(map.get(id));
        while (!next.isEmpty()) {
            cur = new ArrayList<>(next);
            next.clear();
            for (int i = 0; i < cur.size(); i++) {
                if (cur.get(i) == null) {
                    continue;
                }
                sum += cur.get(i).importance;
                for (int index = 0; index < cur.get(i).subordinates.size(); index++) {
                    next.add(map.get(cur.get(i).subordinates.get(index)));
                }
            }
        }
        return sum;
    }
}
