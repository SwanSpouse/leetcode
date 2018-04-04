package detail;

public class HammingDistance {

    /**
    * 考察十进制转换成二进制的问题。
    */
    public String convertIntToBinary(int x) {
        String ret = "";
        while(x != 0) {
            ret = x % 2 + ret;
            x = x / 2;            
        }
        return ret;
    }

    public int hammingDistance(int x, int y) {
        String binnaryX = convertIntToBinary(x);
        String binnaryY = convertIntToBinary(y);

        int ret = 0;
        for(int indexX = binnaryX.length()-1, indexY = binnaryY.length()-1; indexX >=0 || indexY >= 0; indexX -=1, indexY -=1) {
            char curX = indexX >= 0 ? binnaryX.charAt(indexX) : '0' ; 
            char curY = indexY >= 0 ? binnaryY.charAt(indexY) : '0' ;
            if(curX != curY) {
                ret += 1;
            }
        }
        return ret;
    }
}