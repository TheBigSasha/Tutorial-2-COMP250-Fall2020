package AlCapone;

public class Agent extends Client{
    @Override
    public boolean isCop() {
        return true;
    }

    @Override
    public short getPickyness() {
        return 5;
    }
}
