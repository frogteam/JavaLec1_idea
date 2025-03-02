package practice.bookmanager;

import java.io.Serializable;
import java.time.LocalDate;

// by 이동희동희동희동희동희동희동희동희동희동희동희동희동희동희동희동희동희동희동희동희동희동희동희
public class Book implements Serializable {

    private String no; // 도서번호. 알파벳대문자1자리+ 숫자4자리 형식.  고유한 값
    private String title; // 최소 한글자 이상!
    private int price; // 0 이상의 정수
    private LocalDate publishedAt; // 날짜.

    public Book(String no, String title, int price, LocalDate publishedAt) {
        this.no = no;
        this.title = title;
        this.price = price;
        this.publishedAt = publishedAt;
    }

    public String getNo() {
        return no;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getPublishedAt() {
        return publishedAt;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPublishedAt(LocalDate publishedAt) {
        this.publishedAt = publishedAt;
    }
}
