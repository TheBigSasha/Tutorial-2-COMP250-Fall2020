package TheScicilian;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyAndSell {
    private JTextArea operationTitle;
    private JPanel panel1;
    private JButton buyButton;
    private JRadioButton copRadioButton;
    private JRadioButton undercoverCopRadioButton;
    private JLabel BuyResult;
    private Cartel c;
    private Client user;

    public static void main(String[] args) {
      BuyAndSell SO = new BuyAndSell();
    }

    public BuyAndSell(){
        JFrame frame = new JFrame("BuyAndSell");
        c = new Cartel(true);
        c.arrangeSupplier(new PizzaFactory());
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        undercoverCopRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(undercoverCopRadioButton.isSelected()) copRadioButton.setSelected(false);
                regenUser();
            }
        });
        copRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(copRadioButton.isSelected()) undercoverCopRadioButton.setSelected(false);
                regenUser();
            }
        });
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regenUser();
                BuyResult.setText(c.sellProduct(user));
            }
        });
        frame.setVisible(true);
    }

    private void regenUser(){
        if(user == null){
            user = new Client() {
                @Override
                public boolean isCop() {
                    return false;
                }

                @Override
                public short getPickyness() {
                    return 0;
                }
            };
        }
        {
            if(undercoverCopRadioButton.isSelected()){
                long dollars = user.getMoney();
                user = new UndercoverAgent();
                user.setMoney(dollars);
            }else{
                if(copRadioButton.isSelected()){
                    long dollars = user.getMoney();
                    user = new Agent();
                    user.setMoney(dollars);
                }else{
                    long dollars = user.getMoney();
                    user = new ShadyBuyer();
                    user.setMoney(dollars);
                }
            }
        }
    }



}
