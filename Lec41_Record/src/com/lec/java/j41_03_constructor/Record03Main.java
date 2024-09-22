package com.lec.java.j41_03_constructor;

import java.util.Objects;


public class Record03Main {
    public static void main(String[] args) {
        System.out.println("Compact Constructor");

        /**
         * 레코드 의 생성자가
         *   단순히 private field 를 초기화 하는 것 이상을 수행하기 위해
         *   직접 생성자를 작성하여 제공해줄수 있습니다.
         *
         *   그러나! 일반 클래스 생성자와는 달리
         *   레코드 생성자는 일반적인 매개변수 리스트가 없습니다.
         *   이를 Compact Constructor 라 함
         *
         *   이 사용자 정의는 validation에 사용하기 위한 것이며 가능한 한 간단하게 유지해야 합니다
         */
        {
            //
            // Person 레코드에 제공된 이름과 주소가 null 인지 아닌지 확인(validation) 할수 있다
            record Person(String name, String address) {
                public Person {  // 매개변수 리스트가 없다!  Compact Constructor
                    Objects.requireNonNull(name);
                    Objects.requireNonNull(address);
                }
            }

            Person p1 = new Person("John", "Doe"); // OK
//            Person p2 = new Person("Jane", null);  // NPE 발생
        }

        // 다른 argument 목록을 제공하여 다른 argument를 가진 새로운 생성자를 생성할 수도 있습니다
        {
            record Person(String name, String address) {
                public Person(String name) {
                    this(name, "Unknown");
                    // ↑ non-canonical record constructor 는 반드시 다른 생성자를 delegate 해야 한다

                    // 만약 위의 this() 대신 아래 코드로 작성하면 에러
//                    this.name = name;
//                    this.address = "Unknown";
                }
            }

            System.out.println(new Person("John"));  // 가능
        }

        // 클래스 생성자와 마찬가지로 필드를 참조할 수 있습니다.
        // 생성된 public 생성자와 동일한 argument를 사용하여 생성자를 생성하는 것도 유효하지만
        //  각 필드를 수동으로 초기화해야 합니다.
        {
            record Person(String name, String address) {
                public Person(String name, String address) {
                    // 각 필드를 수동으로 초기화 해야 한다.  하나라도 빠지면 에러!
                    this.name = name;
                    this.address = address;
                }
            }
        }

        // Compact Constructor 와 생성된 생성자와 일치하는 인수 목록을 가진 생성자를 선언하면 컴파일 오류가 발생.
        {
            record Person(String name, int age){

                public Person {  // compact constructor
                }

                public Person(String name){ // 가능
                    this(name, 0);
                }

                public Person(int a, int b){ // 가능
                    this("John", a + b);
                }

//                public Person(String name, int age){  // 에러
//                    this(name, age);  // Canonical constructor cannot delegate to another constructor
//                }
            }
        }

        //----------------------------------------------------
        // static 필드 포함 가능
        {
            record Person(String name, String address) {
                public static String UNKNOWN_ADDRESS = "Unknown";

                public static Person unnamed(String address) {
                    return new Person("Unnamed", address);
                }
            }

            Person p1 = new Person("John", "서울");
            System.out.println(p1);  // toString 에 찍히진 않는다.

            // 레코드 이름을 사용하여 접근 가능
            System.out.println(Person.UNKNOWN_ADDRESS);
            System.out.println(Person.unnamed("서울"));
        }


        System.out.println("\n프로그램 종료");
    } // end main
} // end class





