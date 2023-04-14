package ds.lab8_1.bintree.leveorder;

import java.util.ArrayList;

public class LevelOrderMain {

	public static void main(String[] args) {
		//Queue<BTNode> q;
		
		// 샘플 Binary Tree 만들기
		BTNode btRoot = new BTNode(1);
		btRoot.setLeft(new BTNode(2)).setRight(new BTNode(3));
		btRoot.getLeft().setLeft(new BTNode(4)).setRight(new BTNode(5));
		btRoot.getRight().setRight(new BTNode(6));
		
		ArrayList<Integer> list;
		int [] inOrderArr, preOrderArr;
		
		System.out.println("level order print");
		BTNode.level_order_print(btRoot);
		
		System.out.println();
		System.out.println("inorder print");
		list = BTNode.inorder_print(btRoot);
		inOrderArr = BTNode.convToIntArr(list);
		
//		System.out.println("size:" + list.size());
//		for(Integer i : list) {
//			System.out.println(i);
//		}
		
		// 배열 전환 테스트
//		arr = BTNode.convToIntArr(list);
//		System.out.println("length:" + arr.length);
//		for(int i : arr) {
//			System.out.println(i);
//		}

		System.out.println();
		System.out.println("preorder print");
		list = BTNode.preorder_print(btRoot);
		preOrderArr = BTNode.convToIntArr(list);

		System.out.println("--- RECONSTRUCTING ---");
		BTNode newRoot = BTNode.reconstruct_tree(inOrderArr, preOrderArr);
		
		System.out.println("--- VERIFICATION --- ");
		System.out.println("level order print");
		BTNode.level_order_print(newRoot);
		System.out.println("inorder print");
		BTNode.inorder_print(btRoot);
		System.out.println("preorder print");
		BTNode.preorder_print(btRoot);
		
		
		
	} // end main()

} // end class
