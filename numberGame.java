import java.util.Scanner;
class NumberGame{
    public static void main(String[] args) {
      Scanner scanner=new Scanner(System.in);
      System.out.println("Computer Generating a Number you have to Guess the that number. If you won get Score Points");
      int minNumber=1;
      int maxNumber=100;
      
      // generating the random number range between 1-100
      int computerGenNum=(int)((Math.random()*(maxNumber-minNumber))+minNumber);
      //user can attempts only 10
      int noOfAttempts=10;
      int itarate=1;
       System.out.println("Enter the number to guess the Computer Generated");
        System.out.println("You have 10 chances");
       System.out.println("NOTE:  COMPUTER GENERATE RANGE BETWEEN 1 - 100");
       
      int score=0;
      int totalScore=0;
      while(itarate <= noOfAttempts){
          
           // increament the itarate variable
            itarate++;
          // user entering number
          int userNumber=scanner.nextInt();
           
           // comparing user number and  computer generated number if same increament the score totalScore
           //And generate new number 
           if(computerGenNum==userNumber){
               score++;
               totalScore++;
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
       
        //final round will true for addition attemps
        if(itarate==noOfAttempts){
            System.out.println("All attempts have completed");
            System.out.println("Are you enjoyed if you want  continue this game enter the '1' other wise enter any key");
            int entryTheGameKey=scanner.nextInt();
            //continue the game 
            if(entryTheGameKey==1){
                score=0; //score become zero for further rounds 
                System.out.println("Computer Generated new number, You have 10 more chances");
                //again System generate the number
                computerGenNum=(int)((Math.random()*(maxNumber-minNumber))+minNumber);
                 noOfAttempts+=10;
            }
            else itarate++;
            
        }
      }
      //out of loop
      //score updating
      System.out.println("Number of Attempts: "+noOfAttempts);
      System.out.println("you won rounds: "+totalScore);
      System.out.println("Thank you for playing");
     
    }
}