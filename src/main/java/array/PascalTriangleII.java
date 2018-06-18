package array;

import java.util.*;

public class PascalTriangleII {
	public List<Integer> getRow(int rowIndex) {
		ArrayList<Integer> curLine = new ArrayList<Integer>();
		ArrayList<Integer> lastLine = null;
		for(int i=0; i <= rowIndex; i ++ ) {
			lastLine = new ArrayList(curLine);
            curLine.clear();
			for(int index = 0; index < i+1; index ++ ) {
				if(index == 0 || index == i) {
					curLine.add(1);
				} else {
					curLine.add(lastLine.get(index-1) + lastLine.get(index));
				}
			}
		}
		return curLine;
	}
}
