package TheScicilian;

public class Pizza extends Product{
    private static final long cost = 15;

    public Pizza() {
    }

    @Override
    public short getQuality() {
        return 10;
    }
}