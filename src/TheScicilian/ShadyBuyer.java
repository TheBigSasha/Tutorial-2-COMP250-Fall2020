package TheScicilian;

public class ShadyBuyer extends Client{
    @Override
    public boolean isCop() {
        return false;
    }

    @Override
    public short getPickyness() {
        return 0;
    }
}
