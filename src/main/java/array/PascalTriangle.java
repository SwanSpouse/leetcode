package array;

import java.util.*;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		for(int i=1; i <= numRows; i ++ ) {
			ArrayList<Integer> cur = new ArrayList<Integer> ();
			for(int index = 0; index < i; index ++ ) {
				if(index == 0 || index == i-1) {
					cur.add(1);
				} else {
					cur.add(ret.get(i-2).get(index) + ret.get(i-2).get(index-1));
				}
			}
			ret.add(cur);
		}
		return ret;
	}
}
