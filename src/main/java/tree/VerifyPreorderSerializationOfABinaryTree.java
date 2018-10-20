package tree;

import java.util.ArrayList;

public class VerifyPreorderSerializationOfABinaryTree {

    public boolean isValidSerialization(String preorder) {
        String[] fields = preorder.split(",");
        ArrayList<String> next = new ArrayList<>();
        for(String item : fields) {
            next.add(item);
        }
        ArrayList<String> cur = new ArrayList<>();

        while(cur.size() != next.size()) {
            cur = new ArrayList<>(next);
            next.clear();
            for(int i =0 ; i < cur.size();) {
                if( i < cur.size() - 2 && !cur.get(i).equals("#") && cur.get(i + 1).equals("#") && cur.get(i + 2).equals("#")) {
                    next.add("#");
                    i += 3;
                } else {
                    next.add(cur.get(i));
                    i += 1;
                }
            }
        }
        return cur.size() == 1 && cur.get(0).equals("#");
    }

    public static void main(String[] args) {
//        System.out.println(new VerifyPreorderSerializationOfABinaryTree().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
//        System.out.println(new VerifyPreorderSerializationOfABinaryTree().isValidSerialization("9,#,#,#,#"));
        System.out.println(new VerifyPreorderSerializationOfABinaryTree().isValidSerialization("9,9,91,#,#,9,#,49,#,#,#"));
    }
}
