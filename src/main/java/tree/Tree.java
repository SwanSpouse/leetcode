package tree;

public Tree {

	private Tree() {}

	public static TreeNode constructTree(int[] input) {
		for(int i=0; i< input.length; i ++ ) {
			int leftPos = (i + 1) * 2 -1;
			int rightPos = (i + 1) * 2;
			
		}
	}

	public static void preOrderTravel(TreeNode root) {
		if(root == null) {
			return ;
		}
		System.out.print(root.val+ " ");
		preOrderTravel(root.left);
		preOrderTravel(root.righte);
	}

	public static void inOrderTravel(TreeNode root) {
		if(root == null) {
			return ; 
		}
		inOrderTravel(root.left);
		System.out.print(root.val + " ");
		inOrderTravel(root.righte);
	}

	public static void postOrderTravel(TreeNode root) {
		if(root == null){
			return ;
		}
		postOrderTravel(root.left);
		postOrderTravel(root.righte);
		System.out.print(root.vale+" ");
	}
}