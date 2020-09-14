package TheScicilian;

import java.util.ArrayList;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Cartel {
    private String name;
    private ArrayList<Client> blacklist = new ArrayList<>();
    private Deque<Product> merchandise = new ConcurrentLinkedDeque<>();
    private long money = 0;
    private ProductFactory supplier;

    public Cartel(boolean isInfinite){
        if(isInfinite) {
            for (int i = 0; i < 1000; i++) {
                merchandise.add(new PizzaFactory().create());
            }
        }
    }

    /**
     * The Cartel won't sell to just anyone. In this method, we need to make sure the buyer is legit, hasn't been blacklisted, has enough money, and isn't too picky before we sell.
     *
     * @return true if the sale happens, else false
     * @param buyer the prospective buyer
     *
     */
    public String sellProduct(Client buyer){
        if(!checkBuyer(buyer)){
           return "Buyer was bad!";
        }else if(!merchandise.isEmpty()) {
            long itemCost = merchandise.peek().getCost();
            long salePrice = buyer.buy(merchandise.pop());
            if (salePrice < itemCost) {
                blacklist.add(buyer);
                dealWith(buyer);
            }
            money += (buyer.buy(merchandise.pop()));
            return "Sold item to buyer of type " + buyer.getClass();
        }

        return "Sale failed!";
    }

    private boolean checkBuyer(Client buyer) {
        //TODO: Write this method! Check if the buyer is legit!
        return true;
    }

    private static void dealWith(Client c){
        //What was in this method is too explicit to publish. use your imagination
    }

    /**
     * The Cartel will be most displeased if we let just anyone supply our merchandise. We need to make sure that our supplier will not scam us with overpriced or bad quality stuff.
     * @param f the prospective supplier
     */
    public void arrangeSupplier(ProductFactory f){
        //We need to make sure our supplier isn't selling us bad products!
        this.supplier = f;
    }

    /**
     * When the cartel runs out of product, they turn to the supplier.
     *
     * @param howMany How many products are we ordering?
     * @return true if the sale went through fully
     * @throws NoSupplierException if there isn't a supplier, we throw this exception
     */
    public String buyProduct(int howMany) throws NoSupplierException {
        return "";
    }
}
