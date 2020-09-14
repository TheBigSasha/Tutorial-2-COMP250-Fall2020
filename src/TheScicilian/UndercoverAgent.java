package TheScicilian;

public class UndercoverAgent extends Client{
    @Override
    public boolean isCop() {
        return false;
    }

    @Override
    public short getPickyness() {
        return 5;
    }
}
