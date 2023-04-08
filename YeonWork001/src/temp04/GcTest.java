package temp04;


class CVector2D{
	int x;
	int y;
}

public class GcTest {
	public static void main(String[] args) {

		CVector2D v1 = new CVector2D();
		v1.x = 10;
		System.out.println(v1.x);
		
		v1 = add(10, 20);
		System.out.println(v1.x + " " + v1.y);
		
		int [] arr = new int[Integer.MAX_VALUE];
		//recursive();
	}
	
	public static void recursive()
	{
		recursive();
	}
	
	public static CVector2D add(int x, int y)
	{
		CVector2D v = new CVector2D();
		v.x = x;
		v.y = y;
		return v;
	}
}
