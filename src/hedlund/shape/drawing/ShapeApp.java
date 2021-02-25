/**
 * JavaBasic
 * Chapter 4 - Inheritance and Interfaces
 * 2014-04-28
 * 
 * Copyright Affix Byte Coders AB
 * Modified by Niklas Hedlund 2021-02-10
 * 
 */

package hedlund.shape.drawing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ShapeApp {

	public enum MainMenu{
		Main,
		AddShapes,
		RemoveShapes,
		Move,
		PrintShapes,
		Exit
	}



	public static void main(String[] args) {
		Drawing myDrawing = new Drawing();
		MainMenu mainMenu = MainMenu.Main;
		boolean exit = false;

		while(!exit) {

			switch(mainMenu) {

			case Main:			
				System.out.println("\nMain menu:");
				System.out.println("1: Add shapes");
				System.out.println("2: Remove shapes");
				System.out.println("3: Move shapes");
				System.out.println("4: Print shapes");
				System.out.println("5: Exit program");
				mainMenu = getUserInput();
				break;

			case AddShapes:
				addShapes(myDrawing);
				mainMenu = MainMenu.Main;
				break;

			case RemoveShapes:
				removeShapes(myDrawing);
				mainMenu = MainMenu.Main;
				break;

			case Move:
				moveShapes(myDrawing);
				mainMenu = MainMenu.Main;
				break;

			case PrintShapes:
				myDrawing.printShapes();
				mainMenu = MainMenu.Main;
				break;

			case Exit:
				System.out.println("Terminating program...");
				exit = true;
				break;

			default:
				break;

			}
		}

	}



	public static boolean addShapes(Drawing theDrawing) {
		int tempHeight=0, tempWidth=0, tempRadius=0, tempBase=0, tempLength=0;
		Shape.ShapeType tempType = null;
		boolean ok = false;

//		if(theDrawing.isFull()) {
//			System.out.println("Cannot add another shape, drawing is full!"); //TODO: Clean this out if tests are successful
//			return false;
//		}

		do {
			try {
				tempType = getUserInputShape();
			} catch (InputMismatchException e) {
				System.out.println("		Invalid menu choice, only digits 1-5 allowed!");
			}

			if(tempType==null) {return false;}

			switch(tempType) {
			case Circle:
				try {
					tempRadius = getUserInputInt("Input a radius (int)");
					Coord tempCoord = getUserInputCoord();
					Circle circle = new Circle(tempRadius,tempCoord);
					ok = true;
					if(!theDrawing.addShape(circle)) {
						System.out.println("COULD NOT ADD SHAPE!");}
				}
				catch (Exception e) {
					System.out.format("Error, no circle created due to %s\n",e.getMessage());
				}
				break;

			case Rectangle:
				try {
					tempHeight = getUserInputInt("Input a height (int)");
					tempWidth = getUserInputInt("Input a width (int)");
					Coord tempCoord = getUserInputCoord();						
					Rectangle rect = new Rectangle(tempHeight, tempWidth, tempCoord);
					theDrawing.addShape(rect);
					ok = true;
				}
				catch (Exception e) {
					System.out.format("Error, no rectangle created due to %s\n",e.getMessage());
				}
				break;


			case Triangle:
				try {
					tempBase = getUserInputInt("Input a Base length (int)");
					tempHeight = getUserInputInt("Input a height (int)");
					Coord tempCoord = getUserInputCoord();
					Triangle triangle = new Triangle(tempHeight, tempBase, tempCoord);
					theDrawing.addShape(triangle);
					ok = true;
				}
				catch (Exception e) {
					System.out.format("Error, no Triangle created due to %s\n",e.getMessage());
				}
				break;

			case Line:
				try {
					tempLength = getUserInputInt("Input a length (int)");
					Coord tempCoord = getUserInputCoord();
					Line line = new Line(tempLength,tempCoord);
					theDrawing.addShape(line);
					ok = true;
				} 
				catch (Exception e) {
					System.out.format("Error, no Line created due to %s\n",e.getMessage());
				}
				break;
			case None:
				return false;
			default:
				return false;	
			}
		}while(!ok);

		return true;
	}



	public static boolean removeShapes(Drawing theDrawing) {
		theDrawing.printShapes();
		int idToDel = -1;
		try {
			idToDel = getUserInputInt("Enter the id of the shape you want to remove or enter X to go back");
			if(!theDrawing.removeShape(idToDel)) {
				System.out.println("Error: Id does not excist!");
				return false;
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage()); 
			return false;
		}
		System.out.format("Removed shape with id:%d",idToDel);
		return true;
	}



	public static boolean moveShapes(Drawing theDrawing) {
		theDrawing.printShapes();
		int idToMov = -1;
		try {
			idToMov = getUserInputInt("Enter the id of the shape you want to move or enter X to go back");
			System.out.println("Where do you want to move it to?");
			Coord newCoord = getUserInputCoord();
			if(!theDrawing.moveShape(idToMov, newCoord)) {
				System.out.println("Error: Could not move the shape!");
				return false;
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage()); 
			return false;
		}
		System.out.format("Moved shape with id:%d",idToMov);
		return true;

	}



	public static MainMenu getUserInput() {
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		int tempInt = 0;

		try {
			tempInt = keyboard.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Invalid menu choice, only digits 1-5 allowed!");
		}
		if(tempInt <=0 || tempInt >5) {
			System.out.println("Invalid menu choice, only digits 1-5 allowed!"); //TODO: Push exceptions further up the call chain
		}
		switch(tempInt) {
		case 1:
			return MainMenu.AddShapes;
		case 2:
			return MainMenu.RemoveShapes;
		case 3:
			return MainMenu.Move;
		case 4:
			return MainMenu.PrintShapes;
		case 5:
			return MainMenu.Exit;
		default:
			return MainMenu.Main; 
		}
	}



	public static Shape.ShapeType getUserInputShape() throws InputMismatchException {
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		int tempInt = 0;
		System.out.println("	Choose shape to add:");
		System.out.println("	1:Circle:");
		System.out.println("	2:Rectangle:");
		System.out.println("	3:Triangle:");
		System.out.println("	4:Line:");
		System.out.println("	5:Back to main menu");

		tempInt = keyboard.nextInt();

		switch(tempInt) {
		case 1:
			return Shape.ShapeType.Circle;
		case 2:
			return Shape.ShapeType.Rectangle;
		case 3:
			return Shape.ShapeType.Triangle;
		case 4:
			return Shape.ShapeType.Line;
		case 5:
			return Shape.ShapeType.None;
		default:
			return null; 
		}
	}



	private static int getUserInputInt(String message) throws Exception{
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		String tempStr="-1";
		boolean inputOk = false;
		String regex = "[0-9]+"; 

		while(!inputOk) {
			System.out.println(message);
			tempStr = keyboard.next();
			
			if(tempStr.matches(regex)){
				inputOk = true;
				return Integer.parseInt(tempStr);
			}else if(tempStr.equalsIgnoreCase("x")) {
				throw new Exception("Aborted by user");
			}else {
				System.out.println(tempStr+" is not valid input");
			}
		}
		return Integer.parseInt(tempStr);
	}



	private static Coord getUserInputCoord() throws Exception{
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		String tempStr = "";
		int tempX = 0, tempY = 0;
		boolean inputOk = false;

		while(!inputOk) {
			System.out.println("Input a Coord X,Y");
			tempStr = keyboard.next();
			if(tempStr.equalsIgnoreCase("X")){
				throw new Exception("Aborted by user");
			}
			try {
			String coordParts[]=tempStr.split(",");
			tempX = Integer.parseInt(coordParts[0]);
			tempY = Integer.parseInt(coordParts[1]);
			inputOk = true;
			}
			catch (ArrayIndexOutOfBoundsException e) {
				inputOk = false;
				System.out.println(tempStr + " is not valid input");
			}
			catch (IllegalArgumentException e) {
				System.out.println(tempStr + " is not valid input");
			}
		}
		return new Coord(tempX,tempY);
	}





}	
