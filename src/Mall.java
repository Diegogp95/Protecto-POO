import java.util.ArrayList;

public class Mall {

    public Mall(int floorsNumber, BottomPane bottomPane){
        floors = floorsNumber;
        shopsInFloor = new ArrayList[floors];
        for(int i = 0; i < floors ; i++){
            shopsInFloor[i] = new ArrayList<Shop>();
        }
        mallView = new MallView(this, bottomPane);
    }

    public int addShop(String name, int floor, int id){
        Shop newShop = new Shop(name, id);
        shopsInFloor[floor].add(newShop);
        return newShop.getId();
    }


    public void flooUp(){
        if (mallView.getActualFloor()+1 < floors){
            mallView.changeFloorUp();
        }
    }

    public void floorDown(){
        if (mallView.getActualFloor()-1 >= 0){
            mallView.changeFloorDown();
        }
    }

    public MallView getView(){
        return mallView;
    }

    public int getFloors() {
        return floors;
    }

    public Shop searchForShop(int floor, int id){
        for (Shop sh : shopsInFloor[floor]) {
            if (sh.getId() == id) {
                return sh;
            }
        }
        return null;
    }

    public void deleteShop(int floor, int id){
        Shop shop = searchForShop(floor, id);
        shopsInFloor[floor].remove(shop);
    }

    public String printShopArray(){
        String printString = new String("");
        for (int i = 0; i < floors; i++){
            for (Shop shop : shopsInFloor[i]){
                printString += shop.toString() + "\n";
            }
        }
        return printString;
    }

    public void resetAndDeleteAllShops(){
        for (int i = 0; i < floors; i++){
            if (!shopsInFloor[i].isEmpty()) {
                for (Shop shop : shopsInFloor[i]) {
                    ShopView shopView = getView().getShopView(shop.getViewId(), i);
                    shopView.setRenterId(-1);
                    shopView.setState(ShopView.ShopState.ONRENT);
                    shopView.setStatePane(ShopView.ShopState.ONRENT, "");
                }
                shopsInFloor[i].removeAll(shopsInFloor[i]);
            }
        }
        Shop.resetId();
    }

    public void importShop(int viewId, String[] shopInformation){
        if (shopInformation != null) {
            Shop shop = new Shop(shopInformation[0], viewId);

            shop.setNormaRecepcion(shopInformation[1]);
            shop.setNormaDominio(shopInformation[2]);
            shop.setArrendatario(shopInformation[3]);
            shop.setPrecioArriendo(shopInformation[4]);
            shop.setMontoGarantia(shopInformation[5]);
            shop.setFechaInicio(shopInformation[6]);
            shop.setFechaTermino(shopInformation[7]);
            shop.setGiroloLocal(shopInformation[8]);
            shop.setNormaGiro(shopInformation[9]);
            shop.setFechaTransferencia(shopInformation[10]);
            shop.setNormaTransferencia(shopInformation[11]);
            shop.setFechaConsumoLuz(shopInformation[12]);
            shop.setNormaLuz(shopInformation[13]);
            shop.setNumeroClienteLuz(shopInformation[14]);
            shop.setFechaConsumoAgua(shopInformation[15]);
            shop.setNormaAgua(shopInformation[16]);
            shop.setNumeroClienteAgua(shopInformation[17]);
            shop.setFechaConsumoGas(shopInformation[18]);
            shop.setNormaGas(shopInformation[19]);
            shop.setNumeroClienteGas(shopInformation[20]);
            for (int j = 0; j < floors; j++){
                ShopView shopView = getView().getShopView(viewId, j);

                if(shopView != null){
                    shopView.setRenterId(shop.getId());
                    shopView.setState(ShopView.ShopState.RENTED);
                    shopView.setStatePane(ShopView.ShopState.RENTED, shop.getShopName());
                    shopsInFloor[shopView.getInFloor()].add(shop);
                    return;
                }
            }

        }
    }

    public void printShopsInfo(){
        for (int i = 0; i < floors; i++){
            if (!shopsInFloor[i].isEmpty()){
                for (Shop shop : shopsInFloor[i]){
                    int id = shop.getId();
                    System.out.println(""+id + shop.toString());
                }
            }
        }
    }

    private int floors;
    private ArrayList<Shop>[] shopsInFloor;
    private MallView mallView;
}
