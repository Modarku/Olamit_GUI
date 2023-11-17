import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalc extends JFrame{
    private JTextField tfNumber1;
    private JTextField tfNumber2;
    private JComboBox cbOperations;
    private JLabel lblNumber1;
    private JLabel lblNumber2;
    private JButton btnComplete;
    private JLabel lblRes;
    private JPanel jpanel;
    private JTextField lblResult;

    public SimpleCalc() {
        btnComplete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                try {
                    int num1 = Integer.parseInt(tfNumber1.getText());
                    int num2 = Integer.parseInt(tfNumber2.getText());
                    int res = -1;
                    switch (cbOperations.getSelectedIndex()) {
                        case 0:
                            res = num1 + num2;
                            break;
                        case 1:
                            res = num1 - num2;
                            break;
                        case 2:
                            res = num1 * num2;
                            break;
                        case 3:
                            res = num1 / num2;
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "invalid operation");
                    }
                    System.out.println(res);
                    lblResult.setText(Integer.toString(res));
                }catch (ArithmeticException e){
                    JOptionPane.showMessageDialog(null, "ERROR: Cannot divide by zero!");
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "ERROR: " + e);
                }
            }
        });
    }

    public static void main(String[] args) {
        SimpleCalc app = new SimpleCalc();
        app.setContentPane(app.jpanel);
        app.setSize(700, 300);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
        app.setTitle("Simple Calculator");
    }
}
