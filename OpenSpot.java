import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;


public class OpenSpot {
	
	
	/**When ran, takes the name of the garage
		*builds an array of ints, where each refers to a floor number
		*builds an array of booleans correlated to parking spots
		*reads from a file into the boolean array
		*Counts how many in the array are true and puts it in the floor
		*@param filename name of garage
		*@param floorOpenSpaces open spaces on a floor
		*finds sum of open spaces in garage
		*@return whether or not the garage is open
		*/
	public static boolean isGarageOpen(String filename, int[] floorOpenSpaces) throws FileNotFoundException, IOException {
		final String[] jenkins = {"jenkins_floor1.txt", "jenkins_floor2.txt", 
				"jenkins_floor3.txt", "jenkins_floor4.txt"};
		
		final String[] union = {"union_floor1.txt", "union_floor2.txt", 
				"union_floor3.txt", "union_floor4.txt"};
		final String[] cross = {"cross_floor1.txt", "cross_floor2.txt", 
				"cross_floor3.txt", "cross_floor4.txt"};
		final String[] asp = {"asp_floor1.txt", "asp_floor2.txt", 
				"asp_floor3.txt", "asp_floor4.txt"};
		
		boolean[] floorIsOpen = new boolean[100];
		int floorCountTemp = 0;
		double maxSpaces;
		if (filename.equalsIgnoreCase("jenkins")) {
			maxSpaces = jenkins.length * floorIsOpen.length;
			for(int count = 0; count < jenkins.length; count++) {
			Scanner fileRead = new Scanner(new File(jenkins[count]));
				
				for(int i = 0; i < 100; i++) {
					floorIsOpen[i] = fileRead.nextBoolean();
				}
			
				for(int i = 0; i< 100; i++) {
					if(floorIsOpen[i]) {
						floorCountTemp ++;
					}
				}
			floorOpenSpaces[count] = floorCountTemp;
			fileRead.close();
			}
		}
		else if(filename.equalsIgnoreCase("union")) {
			maxSpaces = union.length * floorIsOpen.length;
			for(int count = 0; count < union.length; count++) {
				Scanner fileRead = new Scanner(new File(union[count]));
					
					for(int i = 0; i < 100; i++) {
						floorIsOpen[i] = fileRead.nextBoolean();
					}
				
					for(int i = 0; i< 100; i++) {
						if(floorIsOpen[i]) {
							floorCountTemp ++;
						}
					}
				floorOpenSpaces[count] = floorCountTemp;
				fileRead.close();
				}
		}
		else if(filename.equalsIgnoreCase("cross")) {
			maxSpaces = cross.length * floorIsOpen.length;
			for(int count = 0; count < cross.length; count++) {
				Scanner fileRead = new Scanner(new File(cross[count]));
					
					for(int i = 0; i < 100; i++) {
						floorIsOpen[i] = fileRead.nextBoolean();
					}
				
					for(int i = 0; i< 100; i++) {
						if(floorIsOpen[i]) {
							floorCountTemp ++;
						}
					}
				floorOpenSpaces[count] = floorCountTemp;
				fileRead.close();
				}
		}
		
		maxSpaces = asp.length * floorIsOpen.length;
		for(int count = 0; count < asp.length; count++) {
			Scanner fileRead = new Scanner(new File(asp[count]));
					
				for(int i = 0; i < 100; i++) {
					floorIsOpen[i] = fileRead.nextBoolean();
				}
			
				for(int i = 0; i< 100; i++) {
					if(floorIsOpen[i]) {
						floorCountTemp ++;
					}
				}
			floorOpenSpaces[count] = floorCountTemp;
			fileRead.close();
			}
			int sumFloors = 0;
			for(int i = 0; i < floorOpenSpaces.length - 1; i++) {
				sumFloors += floorOpenSpaces[i];
			}
			int calc = (int)Math.ceil(100*sumFloors/maxSpaces);
			if(calc >= 10) {
				return true;
			}
			else {
			return false;
			}
	}
	public static int[] destination(Scanner keyboard, String[] buildingNames) {
		int target = 0;
		System.out.println("Hello!");
		
		while(target == 0) {
			System.out.println("Enter the number of the building which is your destination");
			listOfBuildings(buildingNames, buildingNames.length);
			target = keyboard.nextInt();
			if(target == 1) {
				int[] galloglyDistance = {1, 3, 0, 2};
				return galloglyDistance;
			}
			else if(target == 2) {
				int[] carnegieDistance = {1, 3, 0, 2};
				return carnegieDistance;
			}
			else if(target == 3) {
				int[] kaufmanDistance = {3, 1, 0, 2};
				return kaufmanDistance;
			}
			else if(target == 4) {
				int[] daleDistance = {3, 0, 1, 2};
				return daleDistance;
			}
			else if(target == 5) {
				int[] physDistance = {1, 3, 0, 2};
				return physDistance;
			}
			else if(target == 6) {
				int[] nielsenDistance = {3, 1, 0, 2};
				return nielsenDistance;
			}
			else if(target == 7) {
				int[] headingtonDistance = {0, 3, 2, 1};
				return headingtonDistance;
			}
			else if(target == 8) {
				int[] bizellDistance = {1, 3, 0, 2};
				return bizellDistance;
			}
			else {
				System.out.println("Invalid choice. Please try again.");
				target = 0;
			}
		}
		return null;
		
	}
	
	public static void listOfBuildings(String[] buildingNames, int size) {
		for(int i = 0; i < size; i++) {
			int j = i + 1;
			System.out.print(j);
			System.out.println(": " + buildingNames[i]);
		}
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//primitive constructors
		final int MAX_SPACES = 100;
		int[] floorOpenSpaces = new int[MAX_SPACES];
		Scanner keyboard = new Scanner(System.in);
		
		//array constructors
		String[] buildingNames = {"Gallogly Hall", "Carnegie Building", "Kaufman Hall", 
				"Dale Hall", "Physical Science Center", "Nielson Hall", "Headington College", 
				"Bizell Memorial Library"};
		
		String[] garageNames = {"Jenkins Parking Garage", "Union Parking Garage", 
				"Cross Parking Garage", "Asp Parking Garage"};
		
		//buildings w/ garage order closest to furthest, w/ # referencing place in garageNames
		
		
		//Where are they trying to park?
		int[] distanceChoice = destination(keyboard, buildingNames);
		
		for(int i = 0; i < garageNames.length; i++) {
			boolean open = isGarageOpen(garageNames[distanceChoice[i]], floorOpenSpaces);
			if(open) {
				System.out.print("Go to ");
				System.out.println(garageNames[distanceChoice[i]]);
				i = garageNames.length;
			}
			
		}
		
	}
}
