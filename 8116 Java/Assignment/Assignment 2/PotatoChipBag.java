/*
 * Student Name: Yanzhang Wu
 * Lab Professor: Professor Fedor Ilitchev
 * Due Date: July 22, 2022.
 * Modified: July 08, 2022.
 * Description: Assignment02 - part 2 - class PotatoChipBag
 */

import java.lang.Math.*;
import java.security.PublicKey;

/* This class holds properties of bags */
public class PotatoChipBag {

	private int size; // Regular or Large (use constants below)
	private double weight; // oz
	public static final int REGULAR = 1;
	private static final double REGULAR_WEIGHT = 9.25; // oz
	public static final int LARGE = 2;
	private static final double LARGE_WEIGHT = 15.75; // oz
	private static final double EPSILON = 0.01;

	/* Constructor without argument */
	public PotatoChipBag() {
		this(REGULAR, REGULAR_WEIGHT);
	}

	/* Constructor with arguments */
	public PotatoChipBag(int size, double weight) {
		this.size = size;
		this.weight = weight;
	}

	/* getter of size */
	public int getSize() {
		return size;
	}

	/* setter of size */
	public void setSize(int size) {
		this.size = size;
	}

	/* getter of weight */
	public double getWeight() {
		return weight;
	}

	/* setter of weight */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/*
	 * This method is used to check if the difference is within the tolerance
	 * (EPSILON). If the difference is within the tolerance, return true; otherwise, false.
	 */
	public boolean isBagCorrectWeight() {

		/* Set default to be true */
		boolean result = true;

		/* When the size is REGULAR */
		if (size == REGULAR) {
			double difference = Math.abs(weight - REGULAR_WEIGHT);
			/*
			 * If the difference is within the tolerance, the bag is a good bag. 
			 * Return the result without alteration.
			 */
			if (difference <= EPSILON) {
				return result;
				/*
				 * If the difference is not within the tolerance, the bag is a bad bag. 
				 * set result to be false, then return it
				 */
			} else {
				result = false;
				return result;
			}
			/* When the size is LARGE_WEIGHT */
		} else {
			double difference = Math.abs(weight - LARGE_WEIGHT);
			/*
			 * If the difference is within the tolerance, the bag is a good bag. 
			 * Return the result without alteration.
			 */
			if (difference <= EPSILON) {
				return result;
				/*
				 * If the difference is not within the tolerance, the bag is a bad bag. 
				 * set result to be false, then return it
				 */
			} else {
				result = false;
				return result;
			}
		}

	}

}