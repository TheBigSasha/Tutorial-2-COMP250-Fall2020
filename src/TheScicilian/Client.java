package TheScicilian;

import java.lang.reflect.Field;

public class Client {
    //TODO: Comeup with fields

    public Client(){

    }

    public Client(String name, long money) {
        //TODO: Instantiate fields
    }

    public long getMoney(){
        return 0;
        //TODO: Create this method
    }

    public boolean isDead(){
        return false;
        //TODO: Create this method
    }

    public void injureSelf(int damage){
        //TODO: Make the user take damage corresponding to the int damage
    }

    /**
     * Tries to buy a product.
     *
     * If succeeded, adds product to inventory. If failed, throws exception.
     *
     * @return  The amount of money the sale was for
     * @throws NotEnoughMoneyException if the buyer does not have the required money
     */
    public long buy(Product p) throws NotEnoughMoneyException{
        //TODO: You can get the price of the product with p.getCost();
        return 0;
    }

    public void sell(){
        //TODO: Remove the product from inventory and add 80% of it cost to money
    }

    public String toString(){
        //TODO: This method!
        return "";
    }

    public static String testFields(){
        Client c = new Client();
        Field[] fields = Client.class.getFields();
        StringBuilder sb = new StringBuilder();
        for (Field f : fields){
            System.out.println(f.getName() + " " + f.getType() + " is a field that can be accessed externally.");
        }
        return sb.toString();
    }
}