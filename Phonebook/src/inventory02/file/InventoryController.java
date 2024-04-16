package inventory02.file;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class InventoryController {
    private static long inventoryID = 0;
    private static InventoryController instance = null;
    private static List<Inventory> inventories = new ArrayList<>();

    // 저장할 파일에 대한 변수
    private static final String DATA_DIR = "data";
    private static final String DATA_FILE = "inventory.dat";

    private InventoryController(){} // 생성자로 생성 막기

    public static InventoryController getInstance() {
        if(instance == null)
            instance = new InventoryController();
        return instance;
    }

    //----------------------------------------------------------------
    public void init() {
        File dataDir = new File(DATA_DIR);
        if(!dataDir.exists()) {
            // 저장될 디렉토리가 없으면 새로 생성
            if (dataDir.mkdir()) {
                System.out.println("폴더 생성 성공");
            } else {
                System.out.println("폴더 생성 실패");
            }

        } else {
            System.out.println("폴더 존재: " + dataDir.getAbsolutePath());
        }

        // 2. 데이터 저장 파일 생성 (없었다면)
        File dataFile = new File(dataDir, DATA_FILE);
        if (dataFile.exists()) {
            System.out.println("데이터 파일 존재: " + dataFile.getAbsolutePath());
            // 기존에 저장된 파일이 있는 경우
            // 파일에 있는 내용을 메모리(ArrayList)로 올림
            try (InputStream in = new FileInputStream(dataFile);
                 ObjectInputStream oin = new ObjectInputStream(in)) {

                inventoryID = oin.readLong();
                inventories = (ArrayList<Inventory>) oin.readObject();

            } catch (FileNotFoundException e) {
                System.out.println("파일이 업습니다");
//                e.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void close() {
        try (OutputStream out = new FileOutputStream(new File(DATA_DIR, DATA_FILE));
             ObjectOutputStream oout = new ObjectOutputStream(out);) {

            oout.writeLong(inventoryID);
            oout.writeObject(inventories);

            System.out.println("파일을 저장하셨습니다.");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    //-------------------------------------------------------------
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
