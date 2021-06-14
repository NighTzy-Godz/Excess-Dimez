import java.text.*;
import java.util.Scanner; 

public abstract class Account{
    private String accNumber;
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
    // PARAMETERS = REQUIREMNTS
    // ARGUMENTS = ANSWER


  
    public Account(String accNumber, String name, long balance,
                double mortgage, double allMortgage, 
                int years, int principal){
        this.accNumber = accNumber;
        this.name = name;
        this.balance = balance;
        this.mortgage = mortgage;
        this.allMortgage = allMortgage;
        this.years = years;
        this.principal = principal;
    }


    // To read the data from the user
    public String getAccountDetails(){

        String details = "";
        System.out.println();
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        details = "Your Account Number: " + accNumber + ". \nYour Name is " + name + ". \nYour Current Balance Is " + formatter.format(balance) +  "\nYour Loan Balance Is " + formatter.format(allMortgage);
        return details;
    }

    

    // UPDATE #5 - SWITCH FROM acn TO accNumber FOR MORE READABLITY
    // 2003
    public boolean search(String accNumbers){
        if(accNumber.equals(accNumbers)){
            // getAccountDetails();
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
