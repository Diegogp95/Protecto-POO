import java.util.ArrayList;

public class Mall {

    public Mall(int floorsNumber){
        floors = floorsNumber;
        shopsInFloor = new ArrayList[floors];
        for(int i = 0; i < floors ; i++){
            shopsInFloor[i] = new ArrayList<Shop>();
        }
        mallView = new MallView(this);
    }

    public void addShop(String name, int floor, int placeInFloor){
        Shop newShop = new Shop(name);
        shopsInFloor[floor].add(newShop);
    }
/*  Codigo vestigial de prueba de adicion de local
    public static void main(String[] args){
        Mall mall = new Mall(3);
        mall.addShop("McDonalds", 1,2);
        mall.addShop("MAUI", 1, 1);
        for (int i = 0; i < mall.floors; i++){
            for (Shop shop : mall.shopsInFloor[i]){
                System.out.println(shop.getShopName()+ ", Id: " + shop.getId());
            }
        }
    } */

    public MallView getView(){
        return mallView;
    }

    public int getFloors() {
        return floors;
    }

    private int floors;
    private final int shopsPerFloor = 16;
    private ArrayList<Shop>[] shopsInFloor;
    private MallView mallView;
}
