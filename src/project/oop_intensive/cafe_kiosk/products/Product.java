package oop_intensive.cafe_kiosk.products;

/**
 * 커피와 차의 공통 정보
 * 정보: Primary key, 이름, 가격
 */
public abstract class Product {
    private int id;
    private String name;
    private int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public abstract void applyOption();
    public abstract String getOptionToString();
}
