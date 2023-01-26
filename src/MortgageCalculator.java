import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;
public class MortgageCalculator implements ActionListener{
    private static JLabel homeLabel, downPaymentLabel, interestRateLabel, loanTermLabel, monthlyPaymentLabel, monthlyPaymentField, annualPaymentLabel, annualPaymentField;
    private static JTextField homePriceField, downPaymentField, interestRateField, loanTermField;
    private static JButton button;
    public static void main(String [] args){
        JPanel panel = new JPanel();

        JFrame frame = new JFrame("Mortgage Calculator"); //creates  a frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //allows user to exit out of frame
        frame.setResizable(true); //prevent window from being resized
        frame.setSize(300,300); //sets the width and height of frame
        ImageIcon image = new ImageIcon("calculatorIcon.png"); //create an imageIcon
        frame.setIconImage(image.getImage()); //change icon of frame
        frame.add(panel);

        panel.setLayout(null);
        //----------------- Home Price Label and text Field ----------------------
        homeLabel = new JLabel("Home Price:");
        homeLabel.setBounds(10, 20, 80, 25);
        panel.add(homeLabel);

        homePriceField = new JTextField(12);
        homePriceField.setBounds(100, 20, 165, 25);
        panel.add(homePriceField);

        //---------------------- Down Payment Label and text field----------------------
        downPaymentLabel = new JLabel("Down Payment:");
        downPaymentLabel.setBounds(10, 50, 100, 25);
        panel.add(downPaymentLabel);

        downPaymentField = new JTextField(12);
        downPaymentField.setBounds(100, 50, 165, 25);
        panel.add(downPaymentField);

        //----------------- Interest rate Label and text Field ----------------------
        interestRateLabel = new JLabel("Interest Rate:");
        interestRateLabel.setBounds(10, 80, 100, 25);
        panel.add(interestRateLabel);

        interestRateField = new JTextField(12);
        interestRateField.setBounds(100, 80, 165, 25);
        panel.add(interestRateField);

        //----------------- Loan Term Label and text Field ----------------------
        loanTermLabel = new JLabel("Loan Term:");
        loanTermLabel.setBounds(10, 110, 100, 25);
        panel.add(loanTermLabel);

        loanTermField = new JTextField(12);
        loanTermField.setBounds(100, 110, 165, 25);
        panel.add(loanTermField);

        //-------------------- Calculate Button -----------------------------------
        button = new JButton("Calculate");
        button.setBounds(65, 150, 165, 25);
        button.addActionListener( new MortgageCalculator());
        panel.add(button);

        //----------------------- Monthly Payment Result ---------------------------
        monthlyPaymentLabel = new JLabel("Monthly Payment:");
        monthlyPaymentLabel.setBounds(10, 190, 165, 25);
        panel.add(monthlyPaymentLabel);

        monthlyPaymentField = new JLabel("");
        monthlyPaymentField.setBounds(120, 190, 165, 25);
        panel.add(monthlyPaymentField);

        //--------------------- Annual Payment Result --------------------------------
        annualPaymentLabel = new JLabel("Annual Payment:");
        annualPaymentLabel.setBounds(10, 210, 165, 25);
        panel.add(annualPaymentLabel);

        annualPaymentField = new JLabel("");
        annualPaymentField.setBounds(120, 210, 165, 25);
        panel.add(annualPaymentField);

        frame.setVisible(true); // allows frame to be visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int homePrice, downPayment, loanTerm;
        double interestRate, monthlyPayment, annualPayment;

        //Home Price
        homePrice = Integer.parseInt(homePriceField.getText());

        //Down Payment
        downPayment= Integer.parseInt(downPaymentField.getText());

        //Interest Rate
        interestRate= Double.parseDouble(interestRateField.getText())/100;

        //Loan Term
        loanTerm= Integer.parseInt(loanTermField.getText());

        monthlyPayment = ((homePrice-downPayment) * (interestRate/12)) / (1 - Math.pow(1 + interestRate/12, -12*loanTerm) );
        annualPayment = monthlyPayment * 12;

        monthlyPaymentField.setText(String.format("%.2f", monthlyPayment));
        annualPaymentField.setText(String.format("%.2f", annualPayment));

    }
}
