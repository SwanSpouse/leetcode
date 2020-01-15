package detail;

class MinimumTimeVisitingAllPoints {

    public int move(int curX, int curY, int targetX, int targetY) {
        int step = 0; 
        while(curX != targetX || curY != targetY) {
            if (curX < targetX) {
                curX += 1;
            } else if (curX > targetX) {
                curX -= 1;
            }
            if (curY < targetY) {
                curY += 1;
            } else if (curY > targetY) {
                curY -= 1;
            }
            step += 1;
        }
        return step;
    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int step = 0;
        if(points.length == 0) {
            return step;
        }
        int curX = points[0][0], curY = points[0][1];
        for (int i =1; i < points.length; i ++) {
            step += move(curX, curY, points[i][0], points[i][1]);
            curX = points[i][0];
            curY = points[i][1];
        }
        return step;
    }
}