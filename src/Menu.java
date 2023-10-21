import java.util.HashMap;

public class Menu {
    String menuName;
    String menuExplanation;
    String productName;
    String productExplanation;
    int productPrice;

    public Menu() {}

    public Menu(String menuName, String menuExplanation) {
        this.menuName = menuName;
        this.menuExplanation = menuExplanation;
    }

    public Menu(String menuName, String productName, String productExplanation, int productPrice) {
        this.menuName = menuName;
        this.productName = productName;
        this.productExplanation = productExplanation;
        this.productPrice = productPrice;
    }




}
