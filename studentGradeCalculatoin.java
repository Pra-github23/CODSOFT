

import java.util.Scanner;

 class Result {
	
	public static void main(String []args){
	
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter marks obtained in each subject (out of 100):");
		
		int numOfSubjects = 6;
                String[] subjectNames = {"Telugu", "English","Hindi", "Maths","Science",  "Social"};
                int[] subjectMarks = new int[numOfSubjects];

                for (int i = 0; i < numOfSubjects; i++) {
                   System.out.print(subjectNames[i] + ": ");
                   subjectMarks[i] = sc.nextInt();
                }
                System.out.println();
		int totalMarks=0;
		for(int marks : subjectMarks){
		
			totalMarks +=marks;
			
		}
		
		double Percentage = (double) totalMarks / numOfSubjects ;
		
		
		char grade;
		
		if(Percentage >=90){
		
			grade ='A';
		}
		else if(Percentage >= 80){
		
			grade ='B';
		}
		else if(Percentage >=60)
		{
			grade = 'c';
		}
		else if(Percentage >=55)
		{
			grade = 'D';
		}
		else {
			grade = 'F';
		}
		
		System.out.println(" Results:");
		
		for (int i=0; i<numOfSubjects ;i++)
		{
            System.out.println(subjectNames[i] + ": " + subjectMarks[i]);

		}
		
		System.out.println("Total Marks : " +totalMarks);
		
		System.out.println("Percentage : "+Percentage +"%");
		
		System.out.println("Grade : "+grade);
		
		sc.close();
	}

}