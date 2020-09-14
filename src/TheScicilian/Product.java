package TheScicilian;

public abstract class Product {
    private static final long cost = 0;
    private boolean legal;

    public Product(){
    }

    public long getCost(){
        return cost;
    }

    public boolean isLegal(){
        return legal;
    }

    public abstract short getQuality();
}
