package TheScicilian;

public class PizzaFactory extends ProductFactory<Pizza>{
    @Override
    public Pizza create() {
        return new Pizza();
    }

    @Override
    public long getPrice() {
        return 16;
    }
}
