package practice.bookmanager;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;

// 필요한 클래스 추가 가능
// 이 패키지 외의 패키지에는 클래스 만들지 마세요.

// by 이동희동희동희동희동희동희동희동희동희동희동희동희동희동희동희동희동희동희동희동희동희동희동희
public class BookManagerMain {
    private static final String DATA_PATH = "./data/book.dat";
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Book> bookList = new ArrayList<>();
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-M-d");

    public static void main(String[] args) {
        loadBooksFromFile();
        while (true) {
            showMenu();
            String input = sc.nextLine().trim();
            switch (input) {
                case "1":
                    addBook();
                    break;
                case "2":
                    displayBooks("default");
                    break;
                case "21":
                    displayBooks("noAsc");
                    break;
                case "22":
                    displayBooks("noDesc");
                    break;
                case "23":
                    displayBooks("titleAsc");
                    break;
                case "24":
                    displayBooks("titleDesc");
                    break;
                case "25":
                    displayBooks("priceAsc");
                    break;
                case "26":
                    displayBooks("priceDesc");
                    break;
                case "27":
                    displayBooks("dateAsc");
                    break;
                case "28":
                    displayBooks("dateDesc");
                    break;
                case "3":
                    modifyBook();
                    break;
                case "4":
                    deleteBook();
                    break;
                case "0":
                    saveBooksToFile();
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 메뉴 선택입니다. 다시 입력하세요.");
            }
        }
    }

    private static void showMenu() {
        System.out.print("""
                \n도서관리 v1.0
                ------------------
                [1] 입력
                [2] 목록 [21]번호↓ [22]번호↑ [23]제목↓ [24]제목↑ [25]가격↓ [26]가격↑ [27]출판일↓ [28]출판일↑
                [3] 수정
                [4] 삭제
                [0] 종료
                ------------------
                """
        );
        System.out.print("선택: ");

    }

    private static void addBook() {
        System.out.println("책 정보를 입력합니다");

        String bookNo = inputBookNo();
        if (bookNo == null) return;

        String title = inputTitle();
        if (title == null) return;

        Integer price = inputPrice();
        if (price == null) return;

        LocalDate publishedAt = inputPublishedDate();
        if (publishedAt == null) return;

        bookList.add(new Book(bookNo, title, price, publishedAt));
        System.out.println("데이터가 입력되었습니다.");
    }

    private static String inputBookNo() {
        while (true) {
            System.out.print("책 번호 입력 (알파벳1자리 + 숫자4자리 형식): ");
            String bookNo = sc.nextLine().trim().toUpperCase();
            if (bookNo.isEmpty()) {
                System.out.println("번호는 반드시 입력해야 합니다.");
                continue;
            }
            if (!Pattern.matches("^[A-Z]{1}\\d{4}$", bookNo)) {
                System.out.println("책 번호 형식이 아닙니다!");
                continue;
            }
            if (bookExists(bookNo)) {
                System.out.println("이미 존재하는 책 번호입니다.");
                return null;
            }
            return bookNo;
        }
    }

    private static String inputTitle() {
        while (true) {
            System.out.print("책 제목 입력: ");
            String title = sc.nextLine().trim();
            if (title.isEmpty()) {
                System.out.println("책 제목은 반드시 입력해야 합니다.");
                continue;
            }
            return title;
        }
    }

    private static Integer inputPrice() {
        while (true) {
            System.out.print("가격 입력(0이상 정수): ");
            String input = sc.nextLine().trim();
            try {
                int price = Integer.parseInt(input);
                if (price < 0) {
                    throw new NumberFormatException();
                }
                return price;
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private static LocalDate inputPublishedDate() {
        while (true) {
            System.out.print("출판일입력(yyyy-MM-dd): ");
            String dateInput = sc.nextLine().trim();
            try {
                LocalDate publishedDate = LocalDate.parse(dateInput, DATE_FORMAT);
                return publishedDate;
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private static boolean bookExists(String bookNo) {
        return bookList.stream().anyMatch(book -> book.getNo().equals(bookNo));
    }

    private static void displayBooks(String sortBy) {
        if (bookList.isEmpty()) {
            System.out.println("출력할 데이터가 없습니다.");
            return;
        }

        List<Book> sortedList = new ArrayList<>(bookList);
        switch (sortBy) {
            case "noDesc":
                sortedList.sort(Comparator.comparing(Book::getNo).reversed());
                break;
            case "noAsc":
                sortedList.sort(Comparator.comparing(Book::getNo));
                break;
            case "titleDesc":
                sortedList.sort(Comparator.comparing(Book::getTitle).reversed());
                break;
            case "titleAsc":
                sortedList.sort(Comparator.comparing(Book::getTitle));
                break;
            case "priceDesc":
                sortedList.sort(Comparator.comparing(Book::getPrice).reversed());
                break;
            case "priceAsc":
                sortedList.sort(Comparator.comparing(Book::getPrice));
                break;
            case "dateDesc":
                sortedList.sort(Comparator.comparing(Book::getPublishedAt).reversed());
                break;
            case "dateAsc":
                sortedList.sort(Comparator.comparing(Book::getPublishedAt));
                break;
            case "default":
                break;
        }

        System.out.println("책 목록 출력");
        System.out.printf("%4s | %-20s | %10s | %s\n", "Uid", "Title", "Price", "Publication");
        System.out.println("-----------------------------------------------------------");

        for (Book book : sortedList) {
            System.out.printf("%4s | %-20s | %10s | %s\n", book.getNo(), book.getTitle(),
                    String.format("%,d", book.getPrice()), book.getPublishedAt().format(DATE_FORMAT));
        }
    }

    private static void modifyBook() {
        System.out.println("책 정보 수정");
        System.out.print("수정할 책번호를 입력하세요: ");
        String bookNo = sc.nextLine().trim().toUpperCase();
        Book book = findBookByNo(bookNo);
        if (book == null) {
            System.out.println("해당 책 번호를 찾을 수 없습니다.");
            return;
        }

        String title = inputTitle();
        if (title == null) return;

        Integer price = inputPrice();
        if (price == null) return;

        LocalDate publishedAt = inputPublishedDate();
        if (publishedAt == null) return;

        book.setTitle(title);
        book.setPrice(price);
        book.setPublishedAt(publishedAt);
        System.out.println("수정되었습니다.");
    }

    private static void deleteBook() {
        System.out.print("삭제할 책번호를 입력하세요: ");
        String bookNo = sc.nextLine().trim().toUpperCase();
        Book book = findBookByNo(bookNo);
        if (book == null) {
            System.out.println("해당 책 번호를 찾을 수 없습니다.");
            return;
        }

        bookList.remove(book);
        System.out.println("삭제하였습니다.");
    }

    private static Book findBookByNo(String bookNo) {
        return bookList.stream()
                .filter(book -> book.getNo().equals(bookNo))
                .findFirst()
                .orElse(null);
    }

    private static void loadBooksFromFile() {
        File file = new File(DATA_PATH);
        if (!file.exists()) {
            File dir = new File(file.getParent());
            if (!dir.exists()) {
                dir.mkdirs();
            }
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                bookList.addAll((List<Book>) obj);
                System.out.println("파일로부터 데이터를 읽어왔습니다.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("파일을 읽는 중 오류가 발생했습니다.");
        }
    }

    private static void saveBooksToFile() {
        File file = new File(DATA_PATH);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(bookList);
            System.out.println("데이터를 파일에 저장합니다.");
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류가 발생했습니다.");
        }
    }
}
