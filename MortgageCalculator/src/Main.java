import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int principal = 0;
        byte years = 0;
        float annualInterest = 0;

        principal = (int) readNumber("Principal: ", 1000, 1000000);

        annualInterest = (float) readNumber("Annual Interest Rate: ", 1 , 30);

        years = (byte) readNumber("Period in Years: ",1,30);


        double mortgage = calculateMortgage(principal,annualInterest,years);

        String result = NumberFormat.getCurrencyInstance().format(mortgage);;
        System.out.println("Mortgage: " +result);

    }

    public static double readNumber(String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        double value;
        while(true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if(value >=min && value <= max)
                break;
            System.out.println("Enter a Value between " +min + "and " + max);
        }
        return value;
    }
    public static double calculateMortgage(int principal, float annualInterest, byte years){
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        float numberOfPayements = years * MONTHS_IN_YEAR;
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        double mortgage = principal * ((monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayements))/(Math.pow(1+monthlyInterest,numberOfPayements) - 1));
        return mortgage;
    }
}