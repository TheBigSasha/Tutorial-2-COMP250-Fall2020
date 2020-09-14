package TheScicilian;

import java.util.ArrayList;

public abstract class Client {
    private ArrayList<Product> inventory = new ArrayList<>();
    private long money;

    public Client(){

    }

    public long buy(Product merchandise) {
        inventory.add(merchandise);
        money -= merchandise.getCost();
        return merchandise.getCost();
    }

    public  abstract boolean isCop();

    public abstract short getPickyness();
}
