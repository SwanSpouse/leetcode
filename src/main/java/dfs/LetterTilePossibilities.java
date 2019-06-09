package dfs;

import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilities {
    public void dfs(Set<String> ret, boolean[] visited, String tiles, StringBuffer cur) {
        if (cur.length() >= tiles.length()) {
            return;
        }
        for (int i = 0; i < tiles.length(); i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            cur.append(tiles.charAt(i));
            ret.add(cur.toString());
            dfs(ret, visited, tiles, cur);
            cur.deleteCharAt(cur.length() - 1);
            visited[i] = false;
        }
    }

    public int numTilePossibilities(String tiles) {
        Set<String> ret = new HashSet<>();
        boolean[] visited = new boolean[tiles.length()];
        for (int i = 0; i < tiles.length(); i++) {
            visited[i] = false;
        }
        dfs(ret, visited, tiles, new StringBuffer());
        ret.remove("");
        return ret.size();
    }

    public static void main(String[] args) {
        System.out.println(new LetterTilePossibilities().numTilePossibilities("AAABBC"));
        System.out.println(new LetterTilePossibilities().numTilePossibilities("AAB"));
    }
}
