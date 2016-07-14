import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class AssignmentGrid {

	    public static void main(String[] args) throws IOException{ 
	    Scanner scanner = new Scanner(System.in);
	    Random randomNumbers = new Random();
	    int height=0;
	    int width=0;
	    boolean login=false;
	    int num=0;
		int[] anArray= new int [10];
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    
	    for(int n=0; n <3; n++){
	        System.out.println("How many rows would you like in the grid?");
	        height = scanner.nextInt();
	        System.out.println("How many columns would you like in the grid?");
	        width= scanner.nextInt();
	                                
	        if ((height>0) && (height<=3)&&(width>0) && (width<=3)) {
	            System.out.println();
	            System.out.println("Here is your grid!");
	            login = true;
	            // If we succeed, break out of the loop and continue with the rest of the code;
	            break;      
	        }   
	        
	        if (login == false){
	            System.out.println();
	            System.out.println("You have entered an invalid input. There must be greater than zero and less than or equal to three of both columns and rows. Please enter a new input.");
	            // If n == 2, 3 attemps made(n starts at 0) and we should exit
	            if(n >= 2){ // can also say if(n==2)
	                System.out.println("You have entered three invalid inputs. The program is now terminating.");
	                System.exit(0);
	            }
	        }
	    }
	    	String numbers = "";
		    for (int row=0; row<height; row++){
	            for(int column=0; column<width; column++){
	                num=randomNumbers.nextInt(5);
	                //anArray[i++]=num;
	                numbers += String.valueOf(num);
	                System.out.print(num);
	            }
	            System.out.println();
	        }
		    System.out.println();
		    int gridC = 0;
		    for(int a=0;a<numbers.length();a++) {
		    	String anum = String.valueOf(numbers.charAt(a));
		    	//System.out.print(anum);
		    	System.out.print(alphabet.charAt(Integer.valueOf(anum)));
		    	gridC++;
		    	
		    	if(gridC == height) {
		    		gridC = 0;
		    		System.out.println();
		    	}
		    	
		    }

	      

	}
}
