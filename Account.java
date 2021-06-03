import java.text.*;
import java.util.Scanner;

public abstract class Account{
    protected String accNumber;
    private String name;
    protected long balance; 
    protected double mortgage;
    protected double allMortgage;
    protected int allMonths;
    protected int overall;
    protected int years;
    protected int principal;
    

    Scanner scan = new Scanner(System.in);

      // Constructor
    public Account(){

    }

  
    public Account(String accNumber, String name, long balance,
                double mortgage, double allMortgage, int allMonths, 
                int overall, int years, int principal){
        this.accNumber = accNumber;
        this.name = name;
        this.balance = balance;
        this.mortgage = mortgage;
        this.allMortgage = allMortgage;
        this.allMonths = allMonths;
        this.overall = overall;
        this.years = years;
        this.principal = principal;
    }


    // To read the data from the user
    public String getAccountDetails(){

        String details = "";
        System.out.println();
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        details = "Your Account Number: " + accNumber + ". \nYour Name is " + name + ". \nYour Current Balance Is " + formatter.format(balance) + "\nYour Monthly Payment For Loan Is  " + formatter.format(mortgage) + "\nYour Loan Balance Is " + formatter.format(allMortgage) + "\nDuration Of Payment is " +  allMonths + " Months.";
        return details;
    }

    

    // UPDATE #5 - SWITCH FROM acn TO accNumber FOR MORE READABLITY
    public boolean search(String accNumbers){
        if(accNumber.equals(accNumbers)){
            getAccountDetails();
            return (true);
        }
        return (false);
    }




    public abstract void deposit(long amount);

    /**
     * 
     * @param amount value to be withdraw
     */
    public abstract void withdraw(long amount);

    /**
     * 

     * @param Principal The Money You Will Borrow
     */
    
    public abstract void Mortgage(int principal, double interest, int years);

    public abstract void principal(int principal);

    public abstract void years(int years);

    public abstract void mortgageCalcu(int principal, double interest, int years);

    public abstract void payLoan(int amount);
    

 


    // Setter
    
}
