import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class LeapYearChecker extends JFrame{
    private JTextField tfYear;
    private JButton btnCheckYear;
    private JPanel jpanel;


    public LeapYearChecker() {
        btnCheckYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String year = tfYear.getText();
                try{
                    int yr = Integer.parseInt(year);
                    System.out.println(year);
                    if(yr % 4 == 0){
                        if(yr % 100 == 0){
                            if(yr % 400 == 0){
                                JOptionPane.showMessageDialog(null, "Leap year");
                            }else{
                                JOptionPane.showMessageDialog(null, "Not a leap year");
                            }
                        }else {
                            JOptionPane.showMessageDialog(null, "Not a leap year");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Leap year");
                    }
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Error: Enter a year!");
                }
            }
        });
    }

    public static void main(String[] args) {
        LeapYearChecker app = new LeapYearChecker();
        app.setContentPane(app.jpanel);
        app.setSize(400, 200);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setTitle("Leap Year Checker");
        app.setVisible(true);
    }
}
