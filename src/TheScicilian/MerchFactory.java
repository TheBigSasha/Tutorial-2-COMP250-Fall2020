package TheScicilian;

import java.util.Random;

public class MerchFactory extends ProductFactory<Pizza>{
    private Random rand;
    public MerchFactory(){
        super();
        rand = new Random();

    }
    @Override
    public Pizza create() {
        if(rand.nextBoolean()) {
            return new Pizza();
        }else{
            return new IllegalPizza();
        }
    }

    @Override
    public long getPrice() {
        return 16;
    }
}
