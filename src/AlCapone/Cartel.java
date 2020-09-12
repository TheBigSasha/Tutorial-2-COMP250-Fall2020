package AlCapone;

import java.util.ArrayList;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Cartel {
    private String name;
    private ArrayList<Client> blacklist = new ArrayList<>();
    private Deque<Product> merchandise = new ConcurrentLinkedDeque<>();
    private long money = 0;
    private ProductFactory supplier;

    /**
     * The Cartel won't sell to just anyone. In this method, we need to make sure the buyer is legit, hasn't been blacklisted, has enough money, and isn't too picky before we sell.
     *
     * @return true if the sale happens, else false
     * @param buyer the prospective buyer
     */
    public boolean sellProduct(Client buyer){
        if(blacklist.contains(buyer) || buyer.isCop() || buyer instanceof UndercoverAgent || buyer instanceof Mafioso || buyer.getPickyness() > supplier.getQuality()){
           return false;
        }else if(!merchandise.isEmpty()) {
            long itemCost = merchandise.peek().getCost();
            long salePrice = buyer.buy(merchandise.pop());
            if (salePrice < itemCost) {
                blacklist.add(buyer);
                dealWith(buyer);
            }
            money += (buyer.buy(merchandise.pop()));
            return true;
        }

        return false;
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
    public boolean buyProduct(int howMany) throws NoSupplierException {
        if(supplier == null){
            throw new NoSupplierException();
        }
        if (money > supplier.getPrice() * howMany) {
            for (int i = 0; i < howMany; i++) {
                Product p = supplier.create();
                if (money - (p != null ? p.getCost() : 0) > 0) {
                    merchandise.push(p);
                    money -= p.getCost();
                } else {
                    return false;
                }

            }
            return true;
        }else{return false;}
    }
}
