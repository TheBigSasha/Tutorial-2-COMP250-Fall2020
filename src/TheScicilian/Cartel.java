package TheScicilian;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Cartel {
    private String name;

    private ProductFactory supplier;
    private ArrayList<Client> blacklist = new ArrayList<>();
    private long money = 0;

    public Cartel(){
        this.supplier = new MerchFactory();
    }

    public static void main(String args[]){
        Cartel c = new Cartel();
        Scanner s = new Scanner(System.in);
        System.out.println(Client.testFields());
        String name;
        long money;
        System.out.println("What's your name?");
        name = s.nextLine();
        System.out.println("How much money are you starting with?");
        money = s.nextLong();
        //================ Here we can change to a different version of Client ================
        Client user = new Client(name, money);
        //=======================================================================================
        System.out.println("Welcome! You are " + user);
        s.reset();
        s = new Scanner(System.in);
        while(!user.isDead()){
            System.out.println("Do you want to buy [b] or sell [s]?");
            String choice = s.nextLine();
            if(choice.equalsIgnoreCase("b")){
                if(!c.sell(user)) System.out.println("Failed to buy!");
               System.out.println(user);
            }else if(choice.equalsIgnoreCase("s")){
                user.sell();
                System.out.println(user);
            }else{
                System.out.println("Invalid input");
            }
        }
        System.out.println("WasteD");

    }

    /**
     * Try to sell merchandise to the buyer, blacklist them if they do not have the money!
     * @param c the client buying
     * @return true if the sale succeeded
     */
    public boolean sell(Client c){
        Product toSell = supplier.create();
        if(blacklist.contains(c)){
            c.injureSelf((int) toSell.getCost());
            return false;
        }
        try {
            money += c.buy(toSell);
            return true;
        }catch(NotEnoughMoneyException ex){
            blacklist.add(c);
            c.injureSelf((int) toSell.getCost());
            return false;
        }
    }

}
