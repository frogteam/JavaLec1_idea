package inventory02.file;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class InventoryModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4947422338542980389L;
	private int id;
	private String itemName;
	private int price;
	private int count;
	private LocalDateTime time;

	public InventoryModel() {
		super();
	}

	public InventoryModel(int id, String itemName, int price, int count, LocalDateTime time) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.price = price;
		this.count = count;
		this.time = time;
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

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "------------------------------\n" + id + " | " + itemName + " | " + price + "원" + " | " + count + "개"
				+ " | " + time;
	}
}
