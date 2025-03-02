package com.lec.java.j41_01_immutable_class;

// 선행
//  상속, override, equals(), toString(), hashCode()
//  Set<>
//  생성자 delegate


import java.util.Objects;

/**
 *  Record 클래스가 왜 필요한가?
 *
 *    Record 클래스는 Java14에 추가된 기능 (Java14 에서 preview, Java16에서 정식 채택)
 *
 *    Record 가 등장하기 전에는
 *    객체간에 immutable 한 데이터를 전달시 boilerplate field와 메서드가 포함된 클래스를 생성해야 했다.
 *    => 이는, 사소한 실수가 발생하거나, 의도가 혼동되기 쉬웠습니다
 *
 */

// 참조:
// https://colevelup.tistory.com/28
//     https://www.baeldung.com/java-record-keyword
public class Record01Main {

    // immutable 객체 예시  (Record 사용하지 않고..)
    // 아래와 같이 Person 이라는 immutable 객체를 만들어 봅시다
    //   - 모든 필드는 private final
    //   - 생성자는 매개변수를 받아 초기화 하는 생성자만 허용
    //   - getter 제공
    //   - equals, hashCode 제공
    public class Person {
        private final String name;
        private final String address;

        public Person(String name, String address) {
            this.name = name;
            this.address = address;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, address);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            } else if (!(obj instanceof Person)) {
                return false;
            } else {
                Person other = (Person) obj;
                // return name.equals(other.name) && address.equals(other.address);
                return Objects.equals(name, other.name)
                        && Objects.equals(address, other.address);
            }
        }

        @Override
        public String toString() {
            return "Person [name=" + name + ", address=" + address + "]";
        }

        // standard getters

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }
    } // end Person

    /**
     *  ↑ 위와 같은 immutable 객체는 몇가지 문제점들이 있습니다.
     *
     *  1. boilerplate code가 많습니다.
     *      각 데이터 클래스에 대해 동일한 지루한 프로세스를 반복해야 합니다
     *      (equals, hashCode 및 toString 메서드를 생성하고, 각 필드를 받아들이는 생성자를 생성해야 합니다.)
     *
     *      오늘날 IDE는 이러한 많은 클래스를 자동으로 생성할 수 있지만, 새 필드를 추가할 때 클래스를 자동으로 업데이트하지는 못합니다.
     *
     *      ex) 새 필드를 추가하면 이 필드를 통합하기 위해 equals 메서드를 업데이트해야 합니다.
     *
     *  2. 이름과 주소가 있는 사람 데이터를 표현한다는 '데이터 클래스로서의 목적이 모호'해집니다.
     *     추가 코드로 인해 클래스가 단순히 이름과 주소라는 두 개의 String 필드가 있는 데이터 클래스라는 사실이 모호해집니다.
     *
     */

    public static void main(String[] args) {
        System.out.println("immutable class");


        System.out.println("\n프로그램 종료");
    } // end main()

} // end class




























