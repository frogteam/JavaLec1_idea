package inventory01;

import java.time.LocalDateTime;
import java.util.List;

public interface Controller {
	public abstract int insert(String itemName, String price, String count);
	public abstract List<InventoryModel> selectAll();
	public abstract int delete(int id);
	public abstract InventoryModel selectOneById(int id);
	public abstract int update(int id, String itemName, String price, String count);
	
	
	
}
