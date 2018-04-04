package detail;

public class JudgeRouteCircle {
    
    // 简单题，按照坐标系来回移动
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for(int i =0; i < moves.length(); i ++ ) {
            if( moves.charAt(i) == 'U') {
                y += 1;
            } else if (moves.charAt(i) == 'D') {
                y -= 1;
            } else if (moves.charAt(i) == 'L') {
                x -= 1;
            } else if (moves.charAt(i) == 'R') {
                x += 1;
            }
        }
        return x == 0 && y == 0;
    }
}