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

    private int floors;
    private ArrayList<Shop>[] shopsInFloor;
    private MallView mallView;
}
