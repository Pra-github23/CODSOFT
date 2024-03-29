import java.util.Scanner;
import java.util.InputMismatchException;

class NumberGame{
 
  
    void beginTheGame(){
          int minNumber=1;
          int maxNumber=100;
 // generating the random number range between 1-100
      int computerGenNum=(int)((Math.random()*(maxNumber-minNumber))+minNumber);
      //user can attempts only 10
      int noOfAttempts=10;
      int itarate=1;
          int score=0;
          //exception occurs catch block will execute if user will enter different characters
           try{
                Scanner scanner=new Scanner(System.in);
           while(itarate <= noOfAttempts){
          
          // user entering number
          int userNumber=scanner.nextInt();
           
           //giving guidence to user range between 1- 100( both include)
           if(userNumber > 100 || userNumber < 1){
               System.out.println("enter range between 1-100(both include)");
               itarate++;
               continue;
           }
           // comparing user number and  computer generated number if same increament the score totalScore
           //And generate new number 
           if(computerGenNum==userNumber){
               score++;
               if(score==1)
               System.out.println("Congratulation..! your guess is correct" );
               else if(score > 1 && score < 3)
               System.out.println("Again Congrats..! your guess is awesome");
               else
               System.out.println("Amazing it's unpredictible  ");
                System.out.println("Computer Generated new number");
              computerGenNum=(int)((Math.random()*(maxNumber-minNumber))+minNumber);
               System.out.println("you have "+(noOfAttempts-itarate )+ " attempts availble");
           }
           else if(userNumber > computerGenNum){
               // if userNum is greater  than computerGenNum print too high
               System.out.println("too High "+userNumber);
           }
           else
             System.out.println("too Low "+userNumber);
          
       
           // increament the itarate variable
            itarate++;
            
        }
        //out of loop
      //score updating
         System.out.println("Number of Attempts: "+noOfAttempts);
      System.out.println("you won rounds: "+score);
           }
           catch(InputMismatchException e){
               System.out.println(" You entered different Character, Please enter Natural Numbers upto 100");
              
           }
       
      }
     
    public static void main(String[] args)throws Exception {
     
      System.out.println("Computer Generated a Number you have to Guess the that number. If you won get Score Points");
     
       Scanner scannerMain=new Scanner(System.in);
     
       System.out.println("Enter the number to guess the Computer Generated");
        System.out.println("You have 10 chances");
       System.out.println("NOTE:  COMPUTER GENERATE RANGE BETWEEN 1 - 100 (both include)");
      NumberGame numGame=new NumberGame();
       while(true){ 
           // creating object
        
  
        numGame.beginTheGame();
       
       System.out.println("play again...!  Then enter '1',  otherwise enter any key");
       int playAgain=scannerMain.nextInt();
       //checking for break the while loop if playAgain variable not equals to '1'
       if(playAgain != 1)
           break;
        System.out.println("Enter the number to guess the Computer Generated");
}
 scannerMain.close();

  System.out.println("Thank you for playing");


    }
}