import java.util.Scanner;

public class onlineexam
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String username = "";
        String password;
        int choice,a=0;
        boolean isLoggedIn = false;
       
        while(true) {
            System.out.println("--------------------------------------------\n");
            System.out.println("Welcome to the Online Examination");
            System.out.println("--------------------------------------------\n");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            
            System.out.print("Enter your choice: ");
            
            choice = sc.nextInt();
           
            switch(choice) {
                case 1:
                    System.out.print("Enter username: ");
                    username = sc.next();
                    System.out.print("Enter password: ");
                    password = sc.next();
                    System.out.println("--------------------------------------------\n");
                    
                    if(username.equals("jagan") && password.equals("1234")) {
                        isLoggedIn = true;
                        System.out.println("Login successful!");
                        System.out.println("--------------------------------------------\n");
                    } else {
                        System.out.println("Invalid credentials. Please try again.");
                    }
                    break;
                case 2:
                    System.out.println("Exiting the system...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
           
            if(isLoggedIn) {
                System.out.println("Welcome, " + username + "!");
                System.out.println("Please answer the following questions:");
                System.out.println("1. Who Invented Java programming");
                System.out.println("a. James Gosling");
                System.out.println("b. Guido van Rossum");
                System.out.println("c. Dennis Ritchie");
                System.out.print("Enter your choice: ");
                String answer = sc.next();
                if(answer.equals("c")) {
                    System.out.println("Correct!");
                    a+=1;
                     System.out.println("--------------------------------------------\n");
                    } else {
                    System.out.println("Incorrect. The correct answer is Dennis Ritchie.");
                }
               
                System.out.println("2. Is Python Dynamic language?");
                System.out.println("a. Yes");
                System.out.println("b. No");
               
                System.out.print("Enter your choice: ");
                answer = sc.next();
                if(answer.equals("a")) {
                    a+=1;
                    System.out.println("Correct!");
                     System.out.println("--------------------------------------------\n");
                } else {
                    System.out.println("Incorrect. The correct answer is Yes.");
                }
                System.out.println("3. Is Python compiled language?");
                System.out.println("a. Yes");
                System.out.println("b. No");
               
                System.out.print("Enter your choice: ");
                answer = sc.next();
                if(answer.equals("b")) {
                    a+=1;
                    System.out.println("Correct!");
                     System.out.println("--------------------------------------------\n");
                } else {
                    System.out.println("Incorrect. The correct answer is NO because it is Interpreted Language.");
                }
                System.out.println("4. How comments on Java?");
                System.out.println("a. #comment");
                System.out.println("b. //comment");
               
                System.out.print("Enter your choice: ");
                answer = sc.next();
                if(answer.equals("b")) {
                    a+=1;
                    System.out.println("Correct!");
                     System.out.println("--------------------------------------------\n");
                } else {
                    System.out.println("Incorrect. The correct answer is //comment.");
                }
                
                System.out.println("5. How can a variable be created in Python?");
                System.out.println("a. x=5");
                System.out.println("b. x=int(5)");
               
                System.out.print("Enter your choice: ");
                answer = sc.next();
                if(answer.equals("a")) {
                    a+=1;
                    System.out.println("Correct!");
                     System.out.println("--------------------------------------------\n");
                } else {
                    System.out.println("Incorrect. The correct answer is x=5.");
                }
                System.out.println("Your Score Is "+a + "out of 5  ");
                System.out.println("Thank you for taking the exam!");
                System.exit(0);
            }
           
        }
    }
}
