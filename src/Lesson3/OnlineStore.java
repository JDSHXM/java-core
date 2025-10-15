package Lesson3;

import java.util.ArrayList;

public class OnlineStore {
    private static final ArrayList<OnlineStore> goods = new ArrayList<OnlineStore>();

    private String code;
    private String name;
    private Double price;
    private Integer count;


    public OnlineStore(String code, String name, Double price, Integer count) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.count = count;
    }

    private void addProduct(String code, String name, Double price, Integer count) {
        goods.add(new OnlineStore(code,name,price,count));
    }


    public void buyProduct(String code,String money) {
        for (OnlineStore good : goods) {
            if (good.code.equals(code) && good.price.equals(money)) {
                System.out.println("Вы купили товар под номером №" +good.code + "\n За сумму:" +good.price);
            }else {
                System.out.println("Не удалось купить товар");
            }
        }
    }


    public void getProductInfo(String code) {
        for (OnlineStore good : goods) {
            if (good.code.equals(code)) {
                System.out.println(good.name);
                System.out.println(good.price);
                System.out.println(good.count);
                System.out.println(good.code);
            }else {
                System.out.println("Ну удалось найти товар!");
            }
        }
    }


    public String getProducts() {
        for (OnlineStore good : goods) {
            return "Name:" + good.name + "\n"
                    + "Price:" + good.price + "\n"
                    + "Count:" + good.count + "\n"
                    + "Code:" + good.code;
        }
        return null;
    }
}
