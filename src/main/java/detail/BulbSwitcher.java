package detail;

public class BulbSwitcher {
//    public int bulbSwitch(int n) {
//        boolean[] switches = new boolean[n + 1];
//        for(int i =1; i <= n ; i ++ ) {
//            for(int j =1; i * j <= n; j ++ ) {
//                int cur =i * j;
//                switches[cur] = !switches[cur];
//            }
//        }
//        int count  = 0;
//        for(int i=1; i <=n; i ++) {
//            count = switches[i] ? count + 1: count;
//        }
//        return count;
//    }

    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }

    public static void main(String[] args) {
//        System.out.println(new BulbSwitcher().bulbSwitch(3));
//        System.out.println(new BulbSwitcher().bulbSwitch(0));
//        System.out.println(new BulbSwitcher().bulbSwitch(99999999));
        for(int i =3; i <= 100; i ++ ) {
            System.out.println(i + ":" + new BulbSwitcher().bulbSwitch(i));
        }
    }
}
