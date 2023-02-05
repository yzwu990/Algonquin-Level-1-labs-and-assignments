/*
 * Author Name: Stanley Pieda
 * Lab Professor: Professor Stanley Pieda
 * Due Date: The due date
 * Description: Exemplar solution lab exam 2 (22W)
 */

/*
 * This class abstracts a Tuna Fish with fields for proteinPerOunce, and
 * ounces of meat. There is one worker method that calculates the grams
 * of protein based on the ounces of meat.
 */
public class TunaFish {
	private double proteinPerOunce; // grams per 1 ounce meat
	private double ounces; // ounces of meat
	
	/*
	 * no-argument constructor, assigns zero to each field.
	 * Not specified on test, could have had body left blank.
	 */
	public TunaFish() {
		proteinPerOunce = 0.0;
		ounces = 0.0;
	}

	/*
	 * accessor for proteinPerOunce (grams of protein per ounce)
	 */
	public double getProteinPerOunce() {
		return proteinPerOunce;
	}

	/*
	 * mutator for proteinPerOunce (grams of protein per ounce)
	 */
	public void setProteinPerOunce(double proteinPerOunce) {
		this.proteinPerOunce = proteinPerOunce;
	}

	/*
	 * accessor for ounces
	 */
	public double getOunces() {
		return ounces;
	}

	/*
	 * mutator for ounces
	 */
	public void setOunces(double ounces) {
		this.ounces = ounces;
	}
	
	/*
	 * calculates the grams of protein, given the ounces of meat, and
	 * proteinPerOunce in grams.
	 */
	public double calculateGramsProtein() {
		double gramsProtein;
		gramsProtein = ounces * proteinPerOunce;
		return gramsProtein;
	}
	
	
	/*
	 * displays the ounces, proteinPerOunces and total protein for the Tuna Fish object
	 */
	public String printReport() {
		//Tuna Fish: Ounces = 100.0000, Protein per ounce = 0.4600, Total protein = 46.0000 grams
		
		double totalProtein = this.calculateGramsProtein();
		String msg = "Tuna Fish: Ounces = " + ounces + ", Protein per ounce = " + proteinPerOunce + " Total Protein = " + totalProtein;

		return msg;
	}
}
