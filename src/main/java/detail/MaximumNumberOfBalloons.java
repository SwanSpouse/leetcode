package detail;

class MaximumNumberOfBalloons {
    // balloon
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        for(int i =0; i < text.length(); i ++) {
            count[text.charAt(i) - 'a'] += 1;
        }
        int b = 'b'-'a', a = 'a' -'a', l = 'l'-'a', o= 'o'-'a', n ='n' -'a';

        int ret =  0;
        while(true) {
            if(count[b] < 1 || count[a] < 1 || count[l] < 2 || count[o] < 2 || count[n] < 1) {
                return ret;
            }
            count[a] -=1;
            count[l] -=2;
            count[o] -=2;
            count[n] -=1;
            count[b] -=1;
            ret += 1;
        }
    }
}