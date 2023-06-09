package project.booksearch;

import java.io.Serializable;

import javax.swing.ImageIcon;

/*
 * 검색결과의 '책 한권' 에 대한 정보
 */
public class InfoBook implements Serializable{

	private static final long serialVersionUID = -689003746122804096L;
	
	private String bookTitle;  // 책이름
	private double price;     // 책 가격
	private String url;       // 상세페이지 링크 url
	//private BufferedImage img;  // 썸네일 이미지
	private String imgUrl;       // 썸네일 url
	transient private ImageIcon thumbnail;  // 썸네일 이미지, 파일 저장은 안한다	
	
	// 기본생성자
	public InfoBook() {}
	// 매개변수 생성자
	public InfoBook(String bookTitle, double price, String url, String imgUrl) {
		super();
		this.bookTitle = bookTitle;
		this.price = price;
		this.url = url;
		this.imgUrl = imgUrl;
	}
	// getter&setter
	public String getBookTitle() {return bookTitle;}
	public void setBookTitle(String bookTitle) {this.bookTitle = bookTitle;}
	public double getPrice() {return price;}
	public void setPrice(double price) {this.price = price;}
	public String getUrl() {return url;}
	public void setUrl(String url) {this.url = url;}
	public String getImgUrl() {return imgUrl;}
	public void setImgUrl(String imgUrl) {this.imgUrl = imgUrl;}
	
	public ImageIcon getThumbnail() {return thumbnail;}
	public void setThumbnail(ImageIcon thumbnail) {this.thumbnail = thumbnail;}
	
	@Override
	public String toString() {
		return bookTitle + ":" + price +"원, URL: " +  url + ", img: " + imgUrl;
	}
	
	
}







