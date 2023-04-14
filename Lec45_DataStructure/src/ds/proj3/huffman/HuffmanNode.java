package ds.proj3.huffman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
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
public class HuffmanNode {
	Byte data;  // 8bit 단위로 저장하기?    <-- 이 값이 null 이면 leaf node 인 셈
	Integer freq;   // 발생빈도
	HuffmanNode left;
	HuffmanNode right;
	
	// 생성자나 메소드들 필요한 만큼 추가해도 됨
	public HuffmanNode() {}
	public HuffmanNode(Integer freq) {
		super();
		this.freq = freq;
	}
	public HuffmanNode(Byte data, Integer freq) {
		super();
		this.data = data;
		this.freq = freq;
	}
	
	
	// getter , setter
	public Byte getData() {return data;}
	public HuffmanNode setData(Byte data) {
		this.data = data;
		return this;
	}
	
	public Integer getFreq() {return freq;}
	public HuffmanNode setFreq(Integer freq) {
		this.freq = freq;
		return this;
	}
	
	public HuffmanNode getLeft() {return left;}
	public HuffmanNode setLeft(HuffmanNode left) {
		this.left = left;
		return this;
	}
	public HuffmanNode getRight() {return right;}
	public HuffmanNode setRight(HuffmanNode right) {
		this.right = right;
		return this;
	}
	
	// Huffman Tree 에서 leaf 는 left, right 둘다 없어야 한다
	public boolean isLeaf() {
		
		if(left == null && right == null) return true;
		
		return false;
		
		//return (data == null)? false : true;
	}
	
	//----------------------------------------------
	// Problem 1: Level-order printing
	
	public static void level_order_print(HuffmanNode root) {
		
		if(root == null) return;
	
		int curLevelCount = 0;
		int nextLevelCount = 0;
		
		Queue<HuffmanNode> queue = new LinkedList<HuffmanNode>();
		queue.offer(root);
		curLevelCount++;
		
		while(!queue.isEmpty()) {
			HuffmanNode tempNode = queue.poll();
			System.out.print(tempNode.data + " ");
			curLevelCount--;
			
			if(tempNode.left != null) {
				queue.offer(tempNode.left);
				nextLevelCount++;
			}
			
			if(tempNode.right != null) {
				queue.offer(tempNode.right);
				nextLevelCount++;
			}
			
			if(curLevelCount <= 0) {
				System.out.println();   // 줄바꿈
				curLevelCount = nextLevelCount;
				nextLevelCount = 0;
			}
		}// end while
		
	} // end level_order_print
	

	
	public static ArrayList<Byte> inorder_print(HuffmanNode root) {
		ArrayList<Byte> list = new ArrayList<Byte>();
		
		if(root != null) {
			list.addAll(inorder_print(root.left));
			System.out.println(root.data);
			list.add(root.data);
			list.addAll(inorder_print(root.right));
		}
		return list;
	} //
	
	public static ArrayList<Byte> preorder_print(HuffmanNode root) {
		ArrayList<Byte> list = new ArrayList<Byte>();
		
		if(root != null) {
			System.out.println(root.data);
			list.add(root.data);
			list.addAll(preorder_print(root.left));
			list.addAll(preorder_print(root.right));
		}
		return list;
	} // 
	
	
	// 도우미 메소드
	// List<Byte> -->  byte[] 로
	public static byte[] convToIntArr(List<Byte> list)
	{
	    byte[] arr = new byte[list.size()];
	    for (int i=0; i < arr.length; i++)
	    {
	        arr[i] = list.get(i).byteValue();
	    }
	    return arr;
	} // end convToIntArr()
	
	//
	public static void printCode(HuffmanNode root, String s)
	{
		if(root == null) return;
		
		if(root.isLeaf()) {
			System.out.println(root.data + ":" + s);
			return;
		}
		
		if(root.left != null) printCode(root.left, s + "0");
		if(root.right != null) printCode(root.right, s + "1");
		
	} // end printCode()
	
	
	public static void getHuffman(
			HashMap<Byte, String> hashMap, 
			HuffmanNode root, String s){
		if(root == null || root == null) return;
		
		if(root.isLeaf()) {
			hashMap.put(root.data.byteValue(), s);   // byteValue() 를 해주자.
			return;
		}
		if(root.left != null) getHuffman(hashMap, root.left, s + "0");
		if(root.right != null) getHuffman(hashMap, root.right, s + "1");

	} // end getHuffman()
	
} // end class

