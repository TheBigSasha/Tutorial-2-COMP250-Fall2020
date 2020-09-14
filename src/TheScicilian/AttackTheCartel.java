package TheScicilian;

import java.util.ArrayList;

public class AttackTheCartel {
    public static void main(String args[]){
        Client user = new ShadyBuyer();
        Cartel c = new Cartel(true);


        //Rob all the cartels money
        user.setMoney(user.getMoney() + c.money);
        c.money = 0;
        //Destroy their products
        c.merchandise = null;
        //Clear their blacklist
        c.blacklist = new ArrayList<>();
        //Cut off their supplier
        c.supplier = null;
        //And send in the cops!
        Agent police = new Agent();
        c.sellProduct(police);

    }
}
