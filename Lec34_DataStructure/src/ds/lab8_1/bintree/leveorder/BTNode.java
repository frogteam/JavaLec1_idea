package ds.lab8_1.bintree.leveorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
   Binary Tree Node
   level order traversing 하기
 
      포인트 ! Queue 사용!
 	
 	[참고]
 	inorder: (left, node, right)
	Revserse inorder : (right, node, left)

	Preorder: (node, left, right) 
	Reverse preorder: (node, right, left) 
	Postorder: (left, right, node) 
	Reverse postorder: (right, left, node)

 */
public class BTNode {
	int data;
	BTNode left;
	BTNode right;
	
	// 생성자나 메소드들 필요한 만큼 추가해도 됨
	public BTNode() {}
	public BTNode(int data) {
		super();
		this.data = data;
	}
	
	// getter , setter
	public int getData() {return data;}
	public BTNode setData(int data) {
		this.data = data;
		return this;
	}
	public BTNode getLeft() {return left;}
	public BTNode setLeft(BTNode left) {
		this.left = left;
		return this;
	}
	public BTNode getRight() {return right;}
	public BTNode setRight(BTNode right) {
		this.right = right;
		return this;
	}
	
	//----------------------------------------------
	// Problem 1: Level-order printing
	//
	// 1. 비어있는 Queue 준비, root 를 Quque 에 추가
	// 2. Queue 가 완전히 비어질때까지 반복
	//    a. Queue 에서 하나 poll()
	//    b. left 가 있다면 를 Queue에 offer()
	//    c. right 가 있다면 Queue에 offer()
	
	// 과연 depth 까지 출력하려면 어떻게 해야 할까?  priority ?
	
	public static void level_order_print(BTNode root) {
		
		if(root == null) return;
	
		Queue<BTNode> queue = new LinkedList<BTNode>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i = 0; i < size; i++) {				
				BTNode tempNode = queue.poll();
				System.out.print(tempNode.data + " ");
				
				if(tempNode.left != null) {
					queue.offer(tempNode.left);
				}
				
				if(tempNode.right != null) {
					queue.offer(tempNode.right);
				}
			} // end for
			System.out.println();
			
		}// end while
		
	} // end level_order_print
	
	
	/*
	public static void level_order_print(BTNode root) {
		
		if(root == null) return;
		
		Queue<BTNode> queue = new LinkedList<BTNode>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			BTNode tempNode = queue.poll();
			System.out.println(tempNode.data);
			
			if(tempNode.left != null)
				queue.offer(tempNode.left);
			
			if(tempNode.right != null)
				queue.offer(tempNode.right);
		}// end while
		
	} // end level_order_print
	*/
	


	
	
	public static ArrayList<Integer> inorder_print(BTNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		if(root != null) {
			list.addAll(inorder_print(root.left));
			
			System.out.println(root.data);
			list.add(root.data);
			
			list.addAll(inorder_print(root.right));
		}
		
		return list;
	} //
	
	public static ArrayList<Integer> preorder_print(BTNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		if(root != null) {
			System.out.println(root.data);
			list.add(root.data);

			list.addAll(preorder_print(root.left));
			
			list.addAll(preorder_print(root.right));
		}
		
		return list;
	} // 
	
	
	//----------------------------------------------
	// Problem 2: Reconstructing a Tree
	// 
	// step1 : preorder 결과의 '첫번째 요소' 가 root 가 되어야 한다.
	// step2 : 위 root 의 요소를 inorder 에서 찾는다.
	// step3 : inorder 에서 찾은 root의 왼쪽이  'left sub tree' 이고  '오른쪽이 right sub tree' 가 된다.
	public static BTNode reconstruct_tree(int [] inOrder, int[] preOrder) {
		
		System.out.println("■reconstruct_tree(inOrder:" + Arrays.toString(inOrder) + ", preOrder:" + Arrays.toString(preOrder) + ")");
	
		// inOrder 에 한개만 남았다면?  그걸로 Node 생성해서 리턴하면 된다
		if(inOrder.length == 1) {
			return new BTNode(inOrder[0]);
		}
		
		// preorder 결과의 '첫번째 요소' 가 root 가 되어야 한다. Node 객체 생성
		BTNode root = new BTNode(preOrder[0]);
		
		// inOrder 내에서 preOrder[0] 의 인덱스 번호 추출
		int inOrderIndex = Arrays.asList(inOrder).indexOf(preOrder[0]);    
		for(inOrderIndex = 0; inOrderIndex < inOrder.length; inOrderIndex++) {
			if(inOrder[inOrderIndex] == preOrder[0]) break;
		}
		
		
		System.out.println("inOrderIndex:" + inOrderIndex);
		
		// left 쪽의 inOrder[] 와 preOrder[] 생성
		int[] inOrderLeft = Arrays.copyOfRange(inOrder, 0, inOrderIndex);
		System.out.println("inOrderLeft:" + Arrays.toString(inOrderLeft));
		int[] preOrderLeft = Arrays.copyOfRange(preOrder, 1, inOrderIndex + 1);
		System.out.println("preOrderLeft:" + Arrays.toString(preOrderLeft));

		// right 쪽의 inOrder[] 와 preOrder[] 생성
		int[] inOrderRight = Arrays.copyOfRange(inOrder, inOrderIndex + 1, inOrder.length);
		System.out.println("inOrderRight:" + Arrays.toString(inOrderRight));
		int[] preOrderRight = Arrays.copyOfRange(inOrder, inOrderIndex + 1, inOrder.length);
		System.out.println("preOrderRight:" + Arrays.toString(preOrderRight));
		
		// left 와 right 의 재귀호출
		if(inOrderLeft.length > 0) root.setLeft(reconstruct_tree(inOrderLeft, preOrderLeft));
		if(inOrderRight.length > 0) root.setRight(reconstruct_tree(inOrderRight, preOrderRight));
		
		return root;
	}

	
	// 도우미 메소드
	// List<Integer> -->  int[] 로
	public static int[] convToIntArr(List<Integer> list)
	{
	    int[] arr = new int[list.size()];
	    for (int i=0; i < arr.length; i++)
	    {
	        arr[i] = list.get(i).intValue();
	    }
	    return arr;
	}

} // end class

