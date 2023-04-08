package temp07;

public class Triangle extends Shape {    
    String color;

    public Triangle() {
    	//super("홍길동");
    	this("빨강색");
        System.out.println("---> Triangle의 기본 생성자 호출");
    }


    public Triangle(String color) {
    	super("홍길동");
        this.color = color;
        System.out.println("Triangle(" + color + ") 호출");
    }

    public void setColor(String c) {
        this.color = c;
    }

    public String getColor() {
        return color;
    }

    public void draw() {
        System.out.println(color + "의 삼각형을 그린다.");
    }
}