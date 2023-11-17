import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrderingSys extends JFrame{
    private JCheckBox cPizza;
    private JRadioButton rbNone;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSundae;
    private JPanel jpanel;
    private JCheckBox cSoftDrinks;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    private JButton btnOrder;
    private JCheckBox cTea;

    JRadioButton[] rbDiscount = {rbNone, rb5, rb10, rb15};
    JCheckBox[] cFoods = {cPizza, cBurger, cFries, cSoftDrinks, cTea, cSundae};
    public FoodOrderingSys() {
        for(Component o: jpanel.getComponents()){
            o.setFont(new Font("", Font.PLAIN, 16));
        }
        rbNone.setSelected(true);

        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean selected = false;
                double baseAmt = 0;
                double trueAmt = 0;
                for(JCheckBox o : cFoods){
                    if(o.isSelected()) {
                        selected = true;
                        System.out.println(o.getText());
                        if (o.equals(cPizza)) {
                            baseAmt += 100;
                        }
                        if (o.equals(cBurger)) {
                            baseAmt += 80;
                        }
                        if (o.equals(cFries)) {
                            baseAmt += 65;
                        }
                        if (o.equals(cSoftDrinks)) {
                            baseAmt += 55;
                        }
                        if (o.equals(cTea)) {
                            baseAmt += 50;
                        }
                        if (o.equals(cSundae)) {
                            baseAmt += 40;
                        }
                    }
                }
                if(!selected){
                    JOptionPane.showMessageDialog(null, "Error: Select a meal/beverage");
                }
                System.out.println(baseAmt);
                for(JRadioButton o : rbDiscount){
                    if(o.isSelected()){
                        if(o.equals(rbNone)){
                            trueAmt = baseAmt;
                        }
                        if(o.equals(rb5)){
                            trueAmt = baseAmt * .95;
                        }
                        if(o.equals(rb10)){
                            trueAmt = baseAmt * .9;
                        }
                        if(o.equals(rb15)){
                            trueAmt = baseAmt * .85;
                        }
                    }
                }
                System.out.println(trueAmt);
                if(selected){
                    JOptionPane.showMessageDialog(null, "The total price is Php " + trueAmt);
                }
            }
        });
    }

    public static void main(String[] args) {
        FoodOrderingSys app = new FoodOrderingSys();
        app.setContentPane(app.jpanel);
        app.setSize(500, 450);
        app.setVisible(true);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setTitle("Food Ordering System");
    }
}
