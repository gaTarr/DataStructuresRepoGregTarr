import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Greg Tarr
 * This class is designed to create cocktail recipes
 * It will hold a list of spirits objects.
 * The Liquor cabinet will search this list comparing contents with 
 * the requirements of the recipe. If all required ingredients in 
 * the recipe list are contained in the liquor cabinet, the boolean
 * hasAllIngredients() will be set to true.  
 *
 */
public class CocktailRecipe {
	
	private String name; //Name of Recipe
	//Using arrayList to store ingredients ***will revisit to check for efficiency
	private ArrayList<Spirits> ingredientsList = new ArrayList<Spirits>();
	
	/**
	 * Default Constructor
	 */
	public CocktailRecipe() {
		name = "";
		ingredientsList = new ArrayList<Spirits>();
	}

	/**
	 * @param name
	 * Constructor created with recipe name
	 */
	public CocktailRecipe(String name) {
		this.name = name;
		ingredientsList = new ArrayList<Spirits>();
		
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	//Still need to test
	public void addIngredients(Spirits spirit) {
		ingredientsList.add(spirit);
	}
	
	//Still need to test
	public void removeIngredients(Spirits spirit) {
		ingredientsList.remove(spirit);
	}
	
	
	//Method to traverse through ingredients, 
	//Checking the liquor cabinet for matches
	//still need to code - Probably boolean
	
	/**
	 * This method displays the recipe name
	 * and each spirit stored in its ingredients
	 * list.
	 */
	public void displayRecipe() {
		System.out.print(name + ": ");
		for (Spirits ingredient : ingredientsList) {
			System.out.print(ingredient.getName() + ", ");
		}
	}


	
	
	
	
	
	

}
