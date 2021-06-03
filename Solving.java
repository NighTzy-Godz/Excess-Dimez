import java.text.NumberFormat;
public class Solving  extends Account {
    NumberFormat formatter = NumberFormat.getCurrencyInstance();

    public Solving()throws InterruptedException{
        super();
    }

    public Solving(String accNumber, String name,
                long balance, double mortgage,
                double allMortgage, int allMonths, 
                int overall, int years, int principal){
        super(accNumber,name, balance, mortgage, allMortgage, allMonths, overall, years, principal);
    }


    

    public void deposit(long amount){    
        long max = 2_000_000;
        if( amount > 0){
            if(amount > max){
                System.out.println("The Maximum Deposit Is Only P2, 000, 000. Magnanakaw Ka Siguro?");
                System.out.println(); 
            }else{ 
                balance += amount;
                System.out.println("You Added With An Amount Of " + formatter.format(amount));
                System.out.println("Your New Balance Is " + formatter.format(balance));
                System.out.println(); 
                // System.out.print("Enter Any Numbers To Continue: ");
            }
        }else{
            System.out.println("Negative Amount is Prohibited");
            System.out.println(); 
        }
    }

   
    public void withdraw(long amount){
        int maxWithdraw = 200_000;

        // UPDATE #4 - ADDED YUNG VALIDATION ABOUT LETTERS FOR WITHDRAWALS

            
        if( amount > 0){
            // UPDATE #5 - 200_000 ANG MAXIMUM WITHDRAWAL ANG THERE WILL BE AN ERROR IF IT IS GREATER THAN THAT.
            if((amount) > balance || amount > maxWithdraw){
                System.out.println("You Cannot Withdraw Because You Reach the Maximum Withdrawal Per Day Or Insufficient Balance Kasi Poor Ka");
                System.out.println(); 
                // UPDATE #2 - CANNOT WITHDRAW IF BALANCE IS INSUFFICIENT
            }else{
                System.out.println("You Withdraw With an Amount of " +  formatter.format(balance));
                balance -= amount;
                System.out.println("Your Current Balance is " +  formatter.format(balance));
                System.out.println(); 
  
                
            }
        }else{
            System.out.println("Withdrawal Should Be Greater than 0");
            System.out.println(); 
        }

    }

    @Override
    public void principal(int principal){}

    @Override
    public void years(int years){}


    public void Mortgage(int principal, double interest, int years){
        
        
    
        mortgage =  principal * ((interest * Math.pow(1 + interest, years)
        / (Math.pow(1 + interest, years) -1 )));

        allMortgage = mortgage * years;
        allMonths = years;
        overall = principal * years;

        System.out.println("Please Check Your Account Information");
        System.out.println(); 
        

    }

    public void mortgageCalcu(int principal, double interest, int years){
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        mortgage =  principal * ((interest * Math.pow(1 + interest, years)
        / (Math.pow(1 + interest, years) -1 )));

        System.out.println("Your Monthly Payment Is " + formatter.format(mortgage));
        System.out.println(); 

    }

    public void payLoan(int amount){
        
        
        double maxPay = mortgage;
       
    
        if( amount > 0){
            // UPDATE #5 - 200_000 ANG MAXIMUM WITHDRAWAL ANG THERE WILL BE AN ERROR IF IT IS GREATER THAN THAT.
            if((amount < maxPay)){
                
                System.out.println("You Cannot Pay Less Than Your Monthly Basis");
                System.out.println("Make Another Payment: P");
            // UPDATE #2 - CANNOT WITHDRAW IF BALANCE IS INSUFFICIENT
            }else{
                System.out.println("You Pay With an Amount of " +  formatter.format(amount));
                allMortgage -= amount;
                
                System.out.println("Your Current Balance is " +  formatter.format(allMortgage));
                System.out.println(); 
    
                

                
            }
        }else{
            System.out.println("Payment Should Be Greater than 0");
            System.out.println(); 
        }


    }
}

    


