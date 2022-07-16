public class Shop {

    {
        id=nextId++;
    }

    public Shop(String shopName) {
        this.shopName = shopName;
    }

    public String getShopName() {
        return shopName;
    }

    public int getId() {
        return id;
    }

    private final int id;
    private static int nextId=0;
    private String shopName;
}
