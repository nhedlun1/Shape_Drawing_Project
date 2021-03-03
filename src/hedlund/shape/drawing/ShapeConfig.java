package hedlund.shape.drawing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ShapeConfig {

	static  int DEFAULT_DIMENSION = 1;	
	static  Coord DEFAULT_POSITION = new Coord();

	//Drawing limits
	static  int X_DRAW_MIN = 0;
	static  int Y_DRAW_MIN = 0;
	static  int X_DRAW_MAX = 600;
	static  int Y_DRAW_MAX = 400;
	static  int MAX_SHAPES = 10;



	/**
	 * @return the defaultDimension
	 */
	public static int getDefaultDimension() {
		return DEFAULT_DIMENSION;
	}

	/**
	 * @return the defaultPosition
	 */
	public static Coord getDefaultPosition() {
		return DEFAULT_POSITION;
	}

	/**
	 * @return the xDrawMin
	 */
	public static int getxDrawMin() {
		return X_DRAW_MIN;
	}

	/**
	 * @return the yDrawMin
	 */
	public static int getyDrawMin() {
		return Y_DRAW_MIN;
	}

	/**
	 * @return the xDrawMax
	 */
	public static int getxDrawMax() {
		return X_DRAW_MAX;
	}

	/**
	 * @return the yDrawMax
	 */
	public static int getyDrawMax() {
		return Y_DRAW_MAX;
	}

	/**
	 * @return the maxShapes
	 */
	public static int getMaxShapes() {
		return MAX_SHAPES;
	} 

	/**
	 * This method sets up configuration based on a passed textfile
	 * @param filename a String holding the file to parse
	 */
	public static void handleConfiguration(String filename) {

		try(BufferedReader br = new BufferedReader(new FileReader(filename))){

			while(br.ready()) {

				String configInput = br.readLine();
				configInput = configInput.strip();

				String[] parts = configInput.split("=");
				if(parts.length != 2) {
					throw new IllegalArgumentException("Configuration not possible for " + configInput);
				}


				int value = Integer.parseInt(parts[1]);

				switch(parts[0]) {

				case "DEFAULT_DIMENSION":
					DEFAULT_DIMENSION = value;

					break;

				case "DEFAULT_POSITION": //TODO: IMPLEMENT new coord check on line 92
					DEFAULT_POSITION = new Coord(value,value);

					break;

				case "X_DRAW_MIN":
					X_DRAW_MIN = value;
					break;

				case "X_DRAW_MAX":
					X_DRAW_MAX = value;
					break;


				case "Y_DRAW_MIN":
					Y_DRAW_MIN = value;
					break;


				case "Y_DRAW_MAX":
					Y_DRAW_MAX = value;
					break;

				case "MAX_SHAPES":
					MAX_SHAPES = value;
					break;

				}
			}

		}
		
		catch (java.io.FileNotFoundException e) {
			System.out.println("Config file not found, using default configuration.");
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}


	/**
	 * This method acts as a toString() including all configuration parameters
	 * @return String holding multi-line configuration
	 */
	public static String showConfiguration() {

		StringBuffer sb = new StringBuffer();
		sb.append("DEFAULT_DIMENSION = ");
		sb.append(DEFAULT_DIMENSION);
		sb.append(System.lineSeparator());
		sb.append("DEFAULT_POSITION = ");
		sb.append(DEFAULT_POSITION);
		sb.append(System.lineSeparator());
		sb.append("X_DRAW_MIN = ");
		sb.append(X_DRAW_MIN);
		sb.append(System.lineSeparator());
		sb.append("X_DRAW_MAX = ");
		sb.append(X_DRAW_MAX);
		sb.append(System.lineSeparator());
		sb.append("Y_DRAW_MIN = ");
		sb.append(Y_DRAW_MIN);
		sb.append(System.lineSeparator());
		sb.append("Y_DRAW_MAX = ");
		sb.append(Y_DRAW_MAX);
		sb.append(System.lineSeparator());
		sb.append("MAX_SHAPES = ");
		sb.append(MAX_SHAPES);
		sb.append(System.lineSeparator());

		return sb.toString();
	}







}