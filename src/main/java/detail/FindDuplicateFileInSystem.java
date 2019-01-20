package detail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String item : paths) {
            String[] fields = item.split(" ");
            String path = fields[0];

            for (int i = 1; i < fields.length; i++) {
                String[] nameContents = fields[i].split("\\(");
                String fileName = nameContents[0];
                String content = nameContents[1].substring(0, nameContents[1].length() - 1);

                if (!map.containsKey(content)) {
                    map.put(content, new ArrayList<>());
                }
                map.get(content).add(path + "/" + fileName);
            }
        }

        ArrayList<List<String>> ret = new ArrayList<>();
        for (String content : map.keySet()) {
            if (map.get(content).size() > 1) {
                ret.add(map.get(content));
            }
        }
        return ret;
    }
}
