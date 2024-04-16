package inventory01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class InventoryController {
    private static long inventoryID = 0;
    private static InventoryController instance = null;
    private static List<Inventory> inventories = new ArrayList<>();

    private InventoryController(){} // 생성자로 생성 막기

    public static InventoryController getInstance() {
        if(instance == null)
            instance = new InventoryController();
        return instance;
    }

    public void createInventory(String itemName, int itemPrice, int itemCount){
        Inventory newInventory = new Inventory(++inventoryID, itemName, itemPrice, itemCount, LocalDateTime.now());
        inventories.add(newInventory); // 새 인벤토리를 리스트에 저장한다.
    }

    public boolean deleteInventory(Inventory inventory){
        return inventories.remove(inventory);
    }

    public Inventory getInventory(int id) throws InputException{
        for(Inventory inventory : inventories){
            if(inventory.getId() == id)
                return inventory; // id가 같은 인벤토리를 찾았다면, 리턴한다.
        }
        // 인벤토리 검색에 실패했다. Exception을 throw
        throw new InputException("Error! ID 오류 존재하지 않는 id : " + id + "\n");
    }

    @Override
    public String toString() {
        String result = "id   name    price   count   time\n";
        for(Inventory inventory : inventories){
            // Inventory의 toString을 호출한다.
            result += inventory.toString() + "\n";
        }
        return result;
    }
}
