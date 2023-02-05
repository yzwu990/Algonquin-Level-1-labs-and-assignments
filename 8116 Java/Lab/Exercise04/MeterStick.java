/*
 * Student Name: Yanzhang Wu
 * Lab Professor: Professor Fedor Ilitchev
 * Due Date: July 22, 2022.
 * Modified: July 11, 2022.
 * Description: Exercise04 - part 2 - class MeterStick
 */

import java.lang.Math.*;

/*
 * This class is used to hold properties of sticks
 * This class will be tested by class Exercise04 
 */
public class MeterStick {
	public static final double EXPECTED_LENGTH = 1.0; // meters
	public static final double EPSILON = 0.0001;
	private double length;

	/* This is constructor without arguments */
	public MeterStick() {
		this(EXPECTED_LENGTH);
	}

	/* This is constructor with arguments */
	public MeterStick(double length) {
		this.length = length;
	}

	/* getter of length */
	public double getLength() {
		return length;
	}

	/* setter of length */
	public void setLength(double length) {
		this.length = length;
	}

	/*
	 * Convert length to centimeters centimeters = meters * 100
	 */
	public double toCentimeters() {
		double centimeters;
		centimeters = length * 100;
		return centimeters;
	}

	/*
	 * Convert length to centimeters millimeters = meters * 100
	 */
	public double toMillimeters() {
		double millimeters;
		millimeters = length * 1000;
		return millimeters;
	}

	/*
	 * Return the formatted String report. Numbers are formatted to 5 decimal
	 * places.
	 */
	public String toString() {
		String report = "MeterStick length " + String.format("adjacent %.5f, ", length);
		return report;
	}

	/*
	 * Verify if the difference is within the tolerance
	 */

	public void verify(double length) {

		/* absolute value of the difference between input length and expected length */
		double difference = Math.abs(length - EXPECTED_LENGTH);

		if (difference <= EPSILON) {// if the difference is within the tolerance
			/* format and output information */
			System.out.printf("Meter stick is within tolerance of %.5f\n", EPSILON);
		} else {// if the difference is not within the tolerance
			/* format and output information */
			System.out.printf("Meter stick is not within tolerance of %.5f\n", EPSILON);
		}

	}

}
