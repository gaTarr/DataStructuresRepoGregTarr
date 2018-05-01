import java.util.ArrayList;

/**
 */

/**
 * @author Greg Tarr  
 * This class is designed to create cocktail recipes
 * It will hold a list of spirits objects.
 * Each recipe object will hold a list of spirits objects ingredients.
 * When called, the recipe will compare its ingredients list to the contents
 * of a liquroCabinet object.  If all required ingredients in 
 * the recipe list are contained in the liquor cabinet, the boolean
 * variable will be set to true.
 *
 */
public class CocktailRecipe {
	
	private String name; 												//Name of Recipe
	private boolean hasAllIngredients; 									//Do we have ingredients to make recipe?
	private ArrayList<Spirits> ingredientsList = new ArrayList<Spirits>(); 
	
	/**
	 * Default Constructor
	 */
	public CocktailRecipe() {
		name = "";
		hasAllIngredients = false;
		ingredientsList = new ArrayList<Spirits>();
	}

	/**
	 * @param name
	 * Constructor created with recipe name
	 */
	public CocktailRecipe(String name) {
		this.name = name;
		hasAllIngredients = false;
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
	
	/**
	 * @return
	 * This 'get()' method returns results of
	 * hasAllIngredients()
	 */
	public boolean getHasAllIngredients() {
		return hasAllIngredients;
	}
	
	/**
	 * @param match
	 * This method sets the hasAllIngredients class
	 * variable.  It is set by the checkIngredients() 
	 * method. 
	 */
	public void setHasAllIngredients(boolean match) {
		this.hasAllIngredients = match;
	}
	
	/**
	 * @param spirit
	 * Method to add spirit to ingredients ArrayList
	 */
	public void addIngredients(Spirits spirit) {
		ingredientsList.add(spirit);
	}
	
	/**
	 * @param spirit
	 * Method to remove spirit from ingredients ArrayList
	 */
	public void removeIngredients(Spirits spirit) {
		ingredientsList.remove(spirit);
	}
	
	/**This method takes an instance of a liquor 
	 * cabinet as a parameter.
	 * @param aCabinet
	 * @return
	 * For each element in the ingredients ArrayList,
	 * the liquor cabinet is searched to see if the required
	 * ingredient is found in the liquorCabinet
	 */
	public boolean checkIngredients(liquorCabinet aCabinet) {
		boolean allMatch = true;					//Set temp variable to true	
		for (Spirits ingredient : ingredientsList) {//For each ingredient in recipe	search the liquor cabinet		
			if(!aCabinet.search(ingredient)) {		//If ingredient doesn't match a spirit in cabinet
				allMatch = false;					//Change variable to false
				break;								//Stop checking for more matches
			}
		}
		setHasAllIngredients(allMatch);				//Set class Variable to match results of search
		return allMatch;							//Return results of search 		
	}	
	
	/**
	 * This method displays the recipe name
	 * and each spirit stored in its ingredients
	 * list.
	 */
	public String displayRecipe() {
		String result = "";
		//System.out.print(name + ": ");
		for (Spirits ingredient : ingredientsList) {
			result += ingredient.getName() + " | " ;			
		}
		return name + ": " + result;
	} 

}
