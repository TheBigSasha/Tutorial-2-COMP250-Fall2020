package TheScicilian;

import javax.swing.*;

public class StingOperation {
    private JTextArea operationTitle;
    private JPanel panel1;

    public static void main(String[] args) {
      StingOperation SO = new StingOperation();
    }

    public StingOperation(){
        JFrame frame = new JFrame("StingOperation");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void noCops(){
        //TODO: Here we see if the cartel can even buy and sell products at all.
    }

    public void openInvestigation(){
        //TODO: Here, we send in the cops!
    }

    public void undercoverInvestigaion(){
        //TODO: Here, we send in the undercover cops!
    }

    public void gangWar(){
        //TODO: Here, we test to see if mafiosos from another cartel can buy from our cartel.
    }

}
