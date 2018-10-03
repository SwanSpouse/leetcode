package detail;

public class BinaryWatch {

    public void dfs(Set<String> ret, String cur, int curOneCount, int curZeroCount, int num) {
        if(curOneCount == num && curOneCount + curZeroCount == 10) {
            ret.add(cur);
            return;
        }
        if(curOneCount + curZeroCount >= 10) {
            return;
        }
        if(curOneCount < num) {
            dfs(ret, cur + "1", curOneCount + 1, curZeroCount, num);
        }
        if(curZeroCount < 10 - num) {
            dfs(ret, cur +"0", curOneCount, curZeroCount+1, num);
        }
    }

    public Set<String> generate(int num) {
        Set<String> ret = new HashSet<String>();
        dfs(ret, "", 0, 0, num);
        return ret;
    }

    public String read(String input) {
        int hour = 0;
        for(int i =0; i < 4; i ++) {
            hour = hour * 2 + (input.charAt(i) - '0');
        }
        if(hour >= 12) {
            return "";
        }
        int minute = 0;
        for(int i=4; i < input.length(); i ++) {
            minute = minute * 2 + (input.charAt(i) - '0');
        }
        if(minute >= 60) {
            return "";
        }
        return minute < 10 ? hour +":0" + minute : hour + ":" + minute;
    }

    public List<String> readBinaryWatch(int num) {
        Set<String> set = generate(num);
        List<String> ret = new ArrayList<String>();
        for(String cur : set) {
            cur = read(cur);
            if(cur.length() == 0) {
                continue ;
            }
            ret.add(cur);
        }
        return ret;
    }
}
