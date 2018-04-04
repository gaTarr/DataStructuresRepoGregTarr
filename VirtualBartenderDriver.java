/**
 * 
 */

/**
 * @author Greg Tarr
 *This is the Tester file for the cocktail recipe
 *final project. II
 */
public class VirtualBartenderDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Create Spirits  **eventually to store in .txt file
		Spirits Bitters = new Spirits("Bitters");
		Spirits Bourbon = new Spirits("Bourbon");
		Spirits CoconutRum = new Spirits("Coconut Rum");
		Spirits Coke = new Spirits("Coke");
		Spirits CranberryJuice = new Spirits("Cranberry Juice");
		Spirits Grenadine = new Spirits("Grenadine");
		Spirits IrishWhiskey = new Spirits("Irish Whiskey");
		Spirits OrangeJuice = new Spirits("Orange Juice");
		Spirits ScotchWhiskey = new Spirits("Scotch");
		Spirits SimpleSyrup = new Spirits("Simple Syrup");
		Spirits SourMix = new Spirits("Sour Mix");
		Spirits SpicedRum = new Spirits("Spiced Rum");
		Spirits Tequila = new Spirits("Tequila");
		Spirits Vodka = new Spirits("Vodka");
		
		//Add to liquor cabinet and test methods
		liquorCabinet myBooze = new liquorCabinet();
		myBooze.add(OrangeJuice);
		myBooze.add(Bitters);
		myBooze.add(Bourbon);
		myBooze.add(SpicedRum);
		myBooze.add(Coke);
		
		myBooze.search(SpicedRum);
		myBooze.search(Bourbon);
		myBooze.search(Bitters);
		myBooze.search(OrangeJuice);
		myBooze.search(Coke);
		myBooze.search(IrishWhiskey);
		myBooze.delete(Coke);
		myBooze.search(Coke);
		
		
		System.out.println("********************************************************************");

		
		
		//Create Recipes and test
		CocktailRecipe Screwdriver = new CocktailRecipe("Screwdriver");
		
		
		Screwdriver.addIngredients(Vodka);
		Screwdriver.addIngredients(OrangeJuice);
		
		Screwdriver.displayRecipe();

	}

}
