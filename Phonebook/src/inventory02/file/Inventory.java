package inventory02.file;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Inventory implements Serializable {

    // ★ 필드는 수정하지 마세요 ★
    private Long id;  // 상품고유 일련번호 (숫자, 필수, 중복불가)
    private String name;  // 상품 이름 (문자열, 필수)
    private Integer price; // 상품 가격  (숫자, 필수)

    private Integer count; // 상품 재고  (숫자, 기본 0)
    private LocalDateTime createdDate;  // 상품 등록일  (등록날짜 )

    public Long getId() { return id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(Integer price) { this.price = price; }
    public void setCount(Integer count) { this.count = count; }

    public Inventory(Long id, String name, Integer price, Integer count, LocalDateTime createdDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        String result = "-".repeat(50) + "\n";
        result += String.format("%d | %5s | %5d원 | %2d개 | %s", id, name, price, count, createdDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))) ;
        return result;
    }
} // end Model
















