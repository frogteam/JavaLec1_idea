package inventory01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class InventoryModel {
	private int id;
	private String itemName;
	private int price;
	private int count;
	private LocalDateTime regDate;
	
	
	
	public InventoryModel() {
		super();
	}

	public InventoryModel(int id, String itemName, int price, int count, LocalDateTime regDate) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.price = price;
		this.count = count;
		this.regDate = regDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime time) {
		this.regDate = time;
	}



	@Override
	public String toString() {
		String msg = String.format("%-5d | %-20s | %-5d | %-5d | %s", 
				id, itemName, price, count, 
				regDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm")));
		return msg;
	}
}
