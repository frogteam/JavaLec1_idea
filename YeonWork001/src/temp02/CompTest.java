package temp02;

public class CompTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}



class MyClass implements Comparable<MyClass>{

	int kor;
	int eng;
	int math;
	
	@Override
	public int compareTo(MyClass o) {
		
		if( (kor + eng + math) / 3   >  (o.eng + o.kor + o.math) / 3){
			return 1;
		}else {
			return -1;	
		}
		
		
	}
	
}