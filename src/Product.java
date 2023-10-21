import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Product extends Menu{


    static Scanner scan = new Scanner(System.in);

    HashMap<Integer, Menu> menuMap = new HashMap<>();
    HashMap<Integer, Menu> productMap = new HashMap<>();
    void menuInit() {
        menuMap.put(1,new Menu("Burgers","주문 즉시 바로 조리해 더욱 맛있는, 맥도날드의 다양한 버거를 소개합니다."));
        menuMap.put(2,new Menu("Muffin","갓 구워낸 신선한 머핀으로 따뜻한 아침 식사를 챙겨 드세요!"));
        menuMap.put(3,new Menu("Drinks","언제나 즐겁게, 다양한 음료를 부담없이 즐기세요!"));
    }

    void productInit() {
        productMap.put(1, new Menu("Burgers","BigMac", "100% 순 쇠고기 패티 두 장에 빅맥만의 특별한 소스 전 세계인의 입맛을 사로 잡은 버거의 대명사",5000));
        productMap.put(2, new Menu("Burgers","Hamburger", "순 쇠고기 패티 한 장이 들어간 기본 햄버거",3500));
        productMap.put(3, new Menu("Burgers","McCrispyBurger", "100% 통닭다리살 겉바속촉 케이준 치킨 패티! 치킨 버거 본연의 맛에 충실한 클래식 버거",5500));
        productMap.put(4, new Menu("Burgers","1955Burger", "특별한 1955 소스에 깊은 풍미의 그릴드 어니언까지 맥도날드가 처음 생긴 1955년의 맛을 담은 1955버거",6500));
        productMap.put(5, new Menu("Muffin","Chicken'n Cheese Muffin", "바삭한 치킨 패티와 고소한 치즈로 아침에도 든든하게!",4500));
        productMap.put(6, new Menu("Muffin","Sausage Egg McMuffin", "잉글리쉬 머핀 위에 먹음직스럽게 올려진 치즈와 계란, 그리고 촉촉한 소시지 패티의 맛있는 조화!",4500));
        productMap.put(7, new Menu("Muffin","BLT EGG Muffin", "갓 구워내 따뜻하고 신선한 베이컨 토마토 에그 머핀",3500));
        productMap.put(8, new Menu("Muffin","Bacon Egg Mcffin", "부드러운 계란, 바삭바삭한 베이컨과 고소한 치즈가 갓 구워진 따뜻한 맥머핀",4000));
        productMap.put(9, new Menu("Drinks","Cafe Latte", "바로 내린 100% 친환경 커피가 신선한 우유를 만나 더 신선하고 부드럽게!",4500));
        productMap.put(10, new Menu("Drinks","Americano", "바로 내린 100% 친환경 커피로 더 신선하게! 더 풍부하게!",4500));
        productMap.put(11, new Menu("Drinks","Cappuccino", "바로 내린 100% 친환경 커피로 추출한 에스프레소 위에 갓 만든 우유 거품으로 더 부드럽게!",3500));
        productMap.put(12, new Menu("Drinks","Drip Coffee", "100% 아바비카 원두를 드립 커피의 부드러움으로 만나보세요",3000));
    }

    void showMenu() {
        Order order = new Order();
        menuInit();
        productInit();
        while (true) {
            int cnt = 1;
            System.out.println("MCDONALS 에 오신걸 환영합니다.");
            System.out.println("아래 메뉴판에서 메뉴를 골라주세요\n");
            System.out.println("[ MCDONALS MENU ]");
            for (Menu menu:menuMap.values()) {
                System.out.println(cnt++ + ". " + menu.menuName + "\t| " + menu.menuExplanation);
            }
            System.out.println();
            System.out.println("[ ORDER MENU ]");
            System.out.println("4. Order     | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. Cancel    | 진행중인 주문을 취소합니다.");
            System.out.print(": ");
            int choice = scan.nextInt();
            for (int num:menuMap.keySet()) {
                if(num == choice) {
                    showProduct(num);
                    break;
                }
            }
            if (choice == 4) {
                order.getOrder();
            } else if (choice == 5) {
                order.orderCancel();
            } else if (choice == 0) {
                order.checkTotalPrice();
            }
            System.out.println("번호를 다시 입력해주세요.");
        }
    }

    void showProduct(int key) {
        Menu choiceMenu = menuMap.get(key);
        while(true) {
            int cnt = 1;
            System.out.println("[ " + choiceMenu.menuName + " MENU ]");
            for (Menu menu:productMap.values()) {
                if(choiceMenu.menuName.equals(menu.menuName)) {
                    System.out.println(cnt++ + ". " + menu.productName + " \t| " + menu.productPrice + "원 | " + menu.productExplanation);
                }
            }
            System.out.print(": ");
            int choice = scan.nextInt();
            int num = 1;

            if(choiceMenu.menuName.equals("Muffin")) {
                choice += 4;
            }
            else if(choiceMenu.menuName.equals("Drinks")) {

                choice += 8;
            }
            for (Menu menu : productMap.values()) {
                if(num == choice) {
                    System.out.println(menu.productName + " \t| " + menu.productPrice + "원 | " + menu.productExplanation);
                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인\t2. 취소 ");
                    int check = scan.nextInt();
                    if (check == 1) {
                        Order order = new Order();
                        order.shoppingBasket(menu);
                    } else if (check == 2) {
                        showMenu();
                    } else {
                        System.out.println("번호를 다시 선택해주세요");
                        System.out.println("==============================");
                        showProduct(key);
                    }
                }
                num++;
            }



        }
    }

}
