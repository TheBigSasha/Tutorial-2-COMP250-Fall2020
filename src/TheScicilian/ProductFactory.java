package TheScicilian;

public abstract  class ProductFactory<E extends Product> {
    public abstract E create();

    public long getPrice(){ return create().getCost();}

    public short getQuality() {
        return create().getQuality();
    }
}
