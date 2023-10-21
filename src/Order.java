import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {

    static ArrayList<Menu> orderMenuList = new ArrayList<>();
    Product product = new Product();
    Scanner scan = new Scanner(System.in);
    static int waitingNum = 1;
    static int checkTotalPrice = 0;
    void shoppingBasket(Menu menu) {
        System.out.println(menu.productName + " 가 장바구니에 추가되었습니다.\n");
        orderMenuList.add(new Menu(menu.menuName, menu.productName, menu.productExplanation, menu.productPrice));
        product.showMenu();
    }

    void getOrder()  {
        if(orderMenuList.size() == 0) {
            System.out.println("현재 장바구니에 담긴 상품이 없습니다.");
            product.showMenu();
        } else {
            int totalPrice = 0;
            System.out.println("아래와 같이 주문 하시겠습니까?\n\n");
            System.out.println("[ Orders ]");
            for (Menu orderList:orderMenuList) {
                totalPrice += orderList.productPrice;
                System.out.println(orderList.productName + " \t| " + orderList.productPrice + "원 | " + orderList.productExplanation);
            }
            System.out.println("[ Total ]");
            System.out.println(totalPrice + "원");
            System.out.println("1. 주문\t2. 메뉴판");
            int choice = scan.nextInt();
            if(choice == 1) {
                checkTotalPrice += totalPrice;
                System.out.println("주문이 완료되었습니다!\n");
                System.out.println("대기번호는 " + waitingNum + " 번 입니다.");
                System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
                orderMenuList.clear();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                waitingNum++;
                product.showMenu();
            } else {
                System.out.println("메뉴판으로 이동합니다");
                product.showMenu();
            }
        }
    }

    void orderCancel() {
        if(orderMenuList.size() == 0) {
            System.out.println("현재 장바구니에 담긴 상품이 없습니다.");
            product.showMenu();
        } else {
            orderMenuList.clear();
            System.out.println("진행하던 주문이 취소되었습니다.\n");
            product.showMenu();
        }
    }

    void checkTotalPrice() {
        System.out.println("[ 총 판매금액 현황 ]");
        System.out.println("현재까지 총 판매된 금액은 [ " + checkTotalPrice + "원 ] 입니다.");
        System.out.println("1. 돌아가기");
        int back = scan.nextInt();
        if(back == 1) product.showMenu();
    }

}
