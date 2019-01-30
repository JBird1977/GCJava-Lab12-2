import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CopyofCarApppt2 {
    

    // ask the user how many cars they want to enter
    // take details for each car
    // print table of cars at the end

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Car> carList = new ArrayList<>();
        int menuChoice = -1;
        int numCars = 0;

        populateList(carList);
        do { // repeat this loop until the user wants to quit
            do { // repeat this loop until we have a valid response
                numCars = carCount(carList);
                printList(carList, numCars);
                menuChoice = queryUser(scan, carList, numCars);
            } while (menuChoice == -1); // repeat if user input is invalid
            purchaseCar(scan, carList, menuChoice, numCars);
        } while (menuChoice != numCars); //repeat so long as user chooses to keep going

        System.out.println("Have a great day!");

        scan.close();
    } // end main

    // populate car listing
    private static void populateList(List<Car> carList) {
        carList.add(new Car("Ford", "Fiesta ST", 2016, 25000.00));
        carList.add(new Car("Ford", "Focus RS", 2017, 40000.00));
        carList.add(new Car("Ariel", "Atom", 2018, 65000.00));
        carList.add(new UsedCar("Ford", "Pinto", 1985, 1.00, 500.1));
        carList.add(new UsedCar("DMC", "DeLorean", 1985, 20000.00, 50.0));
        carList.add(new UsedCar("Lamborghini", "Spyder", 2006, 95995.00, 42.4));
    } // end populateList

    // prints out the data stored in our carList
    private static void printList(List<Car> carList, int numCars) {
        int i = 0; // set i to 0. I tried setting carList.get to count but it didn't like that I
                   // didn't have an int in there. Hence this int :).

        for (Car count : carList) { // run though all the cars stored in the arraylist
            
            System.out.printf("%-5d", (i + 1), ")");
            System.out.printf("%-10s \t", carList.get(i).makeGet());
            System.out.printf("%-10s \t", carList.get(i).modelGet());
            System.out.printf("%-7d \t", carList.get(i).yearGet());
            System.out.printf("$%-6.2f \n", carList.get(i).priceGet());
            
            i++; // I'd like to learn if there's a way to get the object at the specified index
                 // without having to resort to creating an int just for this purpose....
        } // end for

        System.out.println((numCars + 1) + ")   Quit");

    } // end printList

    private static int queryUser(Scanner scan, List<Car> carList, int numCars) {
        int in = 0;

        System.out.println("Which car would you like? ");
        try { // take input and check for validity
            in = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number from 1 to " + (numCars + 1));
            scan.nextLine(); //consume the carriage return
            return -1; // if the entry is invalid then return 0 to flag as invalid
        }
        if ((in >= 1) && in <= numCars + 1) { // if we find a valid entry then return the input -1 to main. -1 is done to accommodate for the list
            return in - 1;
        } else { // catch for if the user enters a number that is out of bounds
            System.out.println("Please enter a valid number.");
            return -1;
        }
    } // end queryUser

    // counts the number of cars currently in the list
    private static int carCount(List<Car> carList) {
        int i = 0;
        for (Car count : carList) {
            i++;
        }
        return i; // returns i+1 to accommodate for list starting at zero
    }

    // purchases the selected car and removes it from the list of available cars
    private static void purchaseCar(Scanner scan, List<Car> carList, int menuChoice, int numCars) {
        String input = "";

        if (menuChoice == numCars) { // if user chooses to quit then jump out of the loop. this ensures we won't get
                                     // an out of bounds exception
            return;
        }
        do { // prints menu choice and queries user + code for validiation of input
            System.out.println(carList.get(menuChoice));
            scan.nextLine(); //consume the carriage return
            System.out.println("Would you like to buy this car?");
            input = scan.nextLine();

            if (!(input.equalsIgnoreCase("y")) && (!(input.equalsIgnoreCase("n")))) {
                System.out.println("Invalid input. Please enter y or n");
            }
        } while (!(input.equalsIgnoreCase("y")) && (!(input.equalsIgnoreCase("n"))));

        if (input.equalsIgnoreCase("y")) {
            System.out.println("Excellent! Our finance department will be in touch shortly.");
            carList.remove(menuChoice);
        }
    } // end purchaseCar

} // end class
