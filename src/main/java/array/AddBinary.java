package array;

/**
 *	 和各种Add系列题目如出一辙。
 */ 
class AddBinary {
    public String addBinary(String a, String b) {
    	int index1 = a.length() -1;
    	int index2 = b.length() -1;
    	String ret = "";
    	int carry = 0;
    	while( index1 >=0 || index2 >= 0) {
    		int value1 = index1 >= 0 ? a.charAt(index1)-'0': 0;
    		int value2 = index2 >= 0 ? b.charAt(index2)-'0': 0;
    		ret = (value1 + value2 + carry) % 2 + ret;
    		carry = (value1 + value2 + carry) / 2;
    		index1 -= 1;
    		index2 -= 1;
    	}
    	return carry == 1 ? carry + ret : ret;
    }
}
