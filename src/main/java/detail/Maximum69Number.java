package detail;

class Maximum69Number {
    public int maximum69Number (int num) {
        StringBuffer sb = new StringBuffer(""+num);
        for(int i =0; i < sb.length(); i ++) {
            if(sb.charAt(i) == '6') {
                sb.replace(i, i+1, "9");
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }
}