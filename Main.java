// Bank Account
//   Acc Number
//   Name
 

// Extension means Inherticance
// Without Inheritance, Kokopyahin natin lahat ng attributes ng bank account
// Re using the similar code



// User extend Bank Account
    //   Check Balance
    //   Withdraw  
    //   Deposit


import java.util.*;
import java.text.NumberFormat;

public class Main{
    public static void main(String[] args) throws InterruptedException{
        Scanner scan = new Scanner(System.in);
        // UPDATE #5 - CHANGE FROM acn TO accNumber
        
        String accNumber = "";
        String name;
        long balance = 0;
        double mortgage = 0;
        double allMortgage = 0;

        boolean found;
        boolean isNumber;

        int chance = 0;
        boolean unlocked = false;

        int principal = 0;
        double interest = 0;
        int years = 0;

        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        //create initial accounts

   
        System.out.println("Welcome to Excess Dime. Please Create an Account");
        // UPDATE #5 - THERE IS A 1 SECOND DELAY
        Thread.sleep(1000);

        
        
        // -------------------------------------------------------------------------------------------------
        
        
        
        // Update #3 - Validation About Letters - Account Number
        System.out.print("Enter Account Number: ");

        do{
            if(scan.hasNextInt()){
                accNumber = scan.next();
                // UPDATE #5 - RESTRICTING TO MAKE A 4 DIGIT CODE INSTEAD OF WHAT YOU JUST LIKE **MEDYO BUGGY PA. PERO MAAYOS NAMAN**
                if(accNumber.length() != 4){
                    System.out.print("Please Make A 4 Digit Number Code: ");
                    isNumber = false;
                }else{
                    isNumber = true;
                }
          
            }else{
                System.out.println("There May be A Letter or Invalid Character In Your Account Number");
                System.out.print("Make Another Pin. : ");
                isNumber = false;
                scan.next();
            }
        }while(!(isNumber));


        // UPDATE #5 - THERE IS A 1 SECOND DELAY
        Thread.sleep(1000);
        System.out.print("Enter Your Name: ");
        name = scan.next();
 
        // UPDATE #5 - THERE IS A 1 SECOND DELAY
        Thread.sleep(1000);
        // Update #3 - Validation About Letters - Down Payment
        System.out.print("Enter Your Down Payment: P");
        do{
            if(scan.hasNextInt()){
                // Update #4 - Removed This Line
                // System.out.print("Enter Your Down Payment: P");
                balance = scan.nextLong();
                isNumber = true;
            }else{
                System.out.println("There is a Non-Number Character");
                System.out.print("Please Make Another Down Payment: ");
                isNumber = false;
                scan.next();
                
            }
        }while(!(isNumber));

        Solving accounts = new Solving(accNumber, name, balance, 
                                        mortgage, allMortgage, 
                                        years, principal);

        



        
    // ---------------------------------------------------------------------------------------------------
        int choice = 0;
        
        do {
            // UPDATE #5 - MUCH CLEANER MAIN MENU
            // System.out.println(years);
            // System.out.println("Please Remember To Just Pay With The Amount Of " + mortgage);
            System.out.println(); 
            System.out.println("Welcome To Excess Dime. Please Choose What You Want From Our Main Menu");
            System.out.println("1. Display Your Account Information");
            System.out.println("2. Deposit");
            System.out.println("3. Withdrawal");
            System.out.println("4. Loans");
            System.out.println("5. Try Our Mortgage Calculator");
            System.out.println("6. Pay Your Loan");
            System.out.println("7. Exit");
            System.out.print("Your Choice: "); 

            
            
            do{
            // UPDATE #5 - RESTRICTIONS ABOUT TYPING LETTERS IN THE CHOICE.
            
                if(scan.hasNextInt()){
                    choice = scan.nextInt();
                    isNumber = true;
                    // UPDATE #5 - THERE IS A 1 SECOND DELAY
                    Thread.sleep(1000);
                }else{
                    System.out.println("There is a Non-Number Character");
                    System.out.print("Make Another Choice: ");
                    isNumber = false;
                    scan.next();
                    // UPDATE #5 - THERE IS A 1 SECOND DELAY
                    Thread.sleep(1000);
                }
            }while(!(isNumber));

            // UPDATE #5 - CHANGE FROM "SWITCH STATEMENT" TO "IF STATEMENT" AND ADD MORE RESTRICTIONS
            if(choice == 1){

                System.out.println(accounts.getAccountDetails());

                // UPDATE #5 - THERE IS A 1 SECOND DELAY

                Thread.sleep(1000);


            }else if (choice == 2){
                
                String accNumbers;
                System.out.print("Enter Account No: "); 
                accNumbers = scan.next();
                // 2003

                long amount;
                found = accounts.search(accNumbers);
                // found = True;

                if (found) {
                    System.out.print("Enter Amount You Want to Deposit: P");
                    do{
                        if(scan.hasNextInt()){
                            // CHECK AMOUNT
                            amount = scan.nextLong();
                            accounts.deposit(amount);
                            
                            // UPDATE #5 - THERE IS A 1 SECOND DELAY
                            Thread.sleep(1000);
                            isNumber = true;                    
                            
                        }else{
                            System.out.println("There is a Non-Number Character");
                            System.out.print("Please Make Another Deposit: ");
                            isNumber = false;
                            scan.next();
                        }
                    }while(!(isNumber));

                }
                
                if (!found) {
                    System.out.println("Search Failed That Account Number Do Not Exist");
                    // UPDATE #5 - THERE IS A 1 SECOND DELAY
                    Thread.sleep(1000);
                }

            }else if (choice == 3){
                String accNumbers;
                System.out.print("Enter Account No: "); 
                accNumbers = scan.next();
                found = true;
                
                long amount;
                found = accounts.search(accNumbers);
                if (found) {
                    System.out.print("Enter Amount You Want to Withdraw: P");
                    do{
                        if(scan.hasNextInt()){
                            // CHECK AMOUNT
                            amount = scan.nextLong();
                            accounts.withdraw(amount);
                            // UPDATE #5 - THERE IS A 1 SECOND DELAY
                            Thread.sleep(1000);
                            isNumber = true;                    
                            
                        }else{
                            System.out.println("There is a Non-Number Character");
                            System.out.print("Make Another Deposit: ");
                            isNumber = false;
                            scan.next();
                        }
                    }while(!(isNumber));


                }

                if (!found) {
                    System.out.println("Search Failed That Account Number Do Not Exist");
                    // UPDATE #5 - THERE IS A 1 SECOND DELAY
                    Thread.sleep(1000);
                }

            }else if (choice == 4){

                if(chance != 1){
                    String accNumbers;
                    System.out.print("Enter Account No: "); 
                    accNumbers = scan.next();

                    found = accounts.search(accNumbers); 
                    if(found){

                        // --------PRINCIPAL----------
                        System.out.print("Enter Your Principal: P");
                        do{     
                            while(true){
                                
                                if(scan.hasNextInt()){
                                    principal = scan.nextInt();
                                    if(principal > 0){
                                        accounts.principal(principal);
                                        isNumber = true;
                                        break;
                                            
                                    }else{
                                        System.out.println("Principal Should Be Greater than 0");
                                        System.out.print("Make Another Principal: P");
                                    }
                                }else{
                                    System.out.println("There is a Non-Number Character");
                                    System.out.print("Please Make Another Principal.");
                                    isNumber = false;
                                    scan.next();
                                }
                               
                            }
                        }while(!(isNumber));

                       
                         // ------------INTEREST----------------
                        System.out.print("Enter Your Interest: ");
                        do{
                            // CHECK AMOUNT
                            byte maxInterest = 15;
                            while(true){
                                if(scan.hasNextInt()){
                                    interest = scan.nextDouble();
                                    if(interest > 0){
                                        if((interest) > maxInterest){
                                            System.out.print("Less Than 15 and Greater Than 0 For Interest");
                                        }else{
                                            interest = interest / 100 / 12;
                                        
                                            // UPDATE #5 - THERE IS A 1 SECOND DELAY
                                            Thread.sleep(1000);
                                            isNumber = true;    
                                            break;
                                        }
                                    }else{
                                        System.out.println("Interest Should Be Greater than 0");
                                        System.out.print("Make Another Interest: ");
                                    }
                                    
                                }else{
                                    System.out.println("There is a Non-Number Character");
                                    System.out.print("Please Make Another Interest: ");
                                    isNumber = false;
                                    scan.next();
                                }               
                            }   
                            
                        }while(!(isNumber));



                        // ----------DURATION--------------
                        System.out.print("Enter The Years: ");
                        do{
                            // CHECK AMOUNT
                            byte maxYears = 25;
                            while(true){
                                if(scan.hasNextInt()){
                                    years = scan.nextInt();
                                    if(years > 0){   
                                        if((years) > maxYears){
                                            System.out.println("Less Than 25 Years Only");
                                            System.out.print("Make Another Years Of Payment: ");
                                        }else{
                                            years += years * 12;
                                            accounts.years(years);
                                            Thread.sleep(1000);
                                            isNumber = true;  

                                            System.out.println(years);
                                            break;
                                        }
                                    
                                    }else{
                                        System.out.println("Years Of Payment Should Be Greater than 0");
                                        System.out.print("Make Another Years Of Payment: ");

                                    }
                                }else{
                                    System.out.println("There is a Non-Number Character");
                                    System.out.print("Please Make Another Years Of Payment. ");
                                    isNumber = false;
                                    scan.next();
                                } 
                            }            
                        }while(!(isNumber));                     
                        accounts.Mortgage(principal, interest, years);
                        unlocked = true;
                        chance += 1; 
              
                    }
                
                    if (!found) {
                        System.out.println("Search Failed That Account Number Do Not Exist");
                        // UPDATE #5 - THERE IS A 1 SECOND DELAY
                        Thread.sleep(1000);
                    }
                }else{
                    System.out.println("Please Pay Your Current Loan Before Applying For Another Loan. Thank You");
                    Thread.sleep(1000);
                }

            }else if(choice == 5){
                
                 // --------PRINCIPAL----------
                        System.out.print("Enter Your Principal: P");
                        do{     
                            while(true){
                                
                                if(scan.hasNextInt()){
                                    principal = scan.nextInt();
                                    if(principal > 0){
                                        principal += 0;
                                        isNumber = true;
                                        break;
                                            
                                    }else{
                                        System.out.println("Principal Should Be Greater than 0");
                                        System.out.print("Please Make Another Principal: ");
                                    }
                                }else{
                                    System.out.println("OOOPS There is a non-number character");
                                    System.out.print("Please Make Another Principal: P");
                                    isNumber = false;
                                    scan.next();
                                }
                               
                            }
                        }while(!(isNumber));

                       
                         // ------------INTEREST----------------
                        System.out.print("Enter Your Interest: ");
                        do{
                            // CHECK AMOUNT
                            byte maxInterest = 15;
                            while(true){
                                if(scan.hasNextInt()){
                                    interest = scan.nextDouble();
                                    if(interest > 0){
                                        if((interest) > maxInterest){
                                            System.out.println("Less Than 15 and Greater Than 0");
                                        }else{
                                            interest = interest / 100 / 12;

                                            // UPDATE #5 - THERE IS A 1 SECOND DELAY
                                            Thread.sleep(1000);
                                            isNumber = true;    
                                            break;
                                        }
                                    }else{
                                        System.out.println("Interest Should Be Greater than 0");
                                        System.out.print("Make Another Interest: ");
                                    }
                                    
                                }else{
                                    System.out.println("Non-Numbers Are Not Allowed");
                                    System.out.print("Please Make Another Interest: ");
                                    isNumber = false;
                                    scan.next();
                                }               
                            }   
                            
                        }while(!(isNumber));



                        // ----------DURATION--------------
                        System.out.print("Enter The Years: ");
                        do{
                            // CHECK AMOUNT
                            byte maxYears = 25;
                            while(true){
                                if(scan.hasNextInt()){
                                    years = scan.nextInt();
                                    if(years > 0){   
                                        if((years) > maxYears){
                                            System.out.println("Less Than 25 Years Only");
                                            System.out.print("Make Another Years Of Payment: ");
                                        }else{
                                            years += years * 12;
                                            years += 0;
                                            Thread.sleep(1000);
                                            isNumber = true;  
                                            break;
                                        }
                                    
                                    }else{
                                        System.out.println("Years Of Payment Should Be Greater than 0");
                                        System.out.print("Make Another Years Of Payment: ");

                                    }
                                }else{
                                    System.out.println("Seems Like That There is a Invalid Characters");
                                    System.out.print("Please Make Another Years Of Payment: ");
                                    isNumber = false;
                                    scan.next();
                                } 

                            }            
                        }while(!(isNumber));

                        double mortgages = principal * ((interest * Math.pow(1 + interest, years)
                        / (Math.pow(1 + interest, years) -1 )));

                        System.out.println("The Monthly Payment For Your Calculated Loan is " + formatter.format(mortgages));

                        Thread.sleep(1000);




                        
            }else if(choice == 6){

                if(unlocked){
                    String accNumbers;
                    System.out.print("Enter Account No: "); 
                    accNumbers = scan.next();
                    found = true;
                    
                    int amount;
                    found = accounts.search(accNumbers);
                    if (found) {
                        System.out.println("Dont Forget To Pay WIth An Amount Of " + formatter.format(accounts.mortgage));
                        do{
                            // CHECK AMOUNT
                            System.out.print("Enter Desired Amount: P");
                            
                            if(scan.hasNextInt()){
                                amount = scan.nextInt();
                                accounts.payLoan(amount);
                                isNumber = true;
                            }else{
                                System.out.println("Letters Are Not Allowed ");
                                System.out.print("Please Make Another Payment, THank You: ");
                                isNumber = false;
                                scan.next();
                            } 

                                
                        }while(!(isNumber));

                    }

                    if (!found) {
                        System.out.println("Search Failed That Account Number Do Not Exist");
                        // UPDATE #5 - THERE IS A 1 SECOND DELAY
                        Thread.sleep(1000);
                    }
                }else{
                    System.out.println("You Dont Have Any Existing Loans");
                    Thread.sleep(1000);
                }  
                 
                
            }else if(choice == 7){
                System.out.println("THANK YOU FOR USING EXCESS DIME. WE HOPE TO SEE YOU AGAIN");
                break;

            }         
            else{
                System.out.println("It Looks Like That We Dont Have That In Our Choices. Please Make Another One: ");
                Thread.sleep(1000);
            }             
        }while (choice != 7);

        // -----------------------   
    }
}
// -------------------------------- END ----------------------