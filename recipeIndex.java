import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Greg Tarr
 * This recipeIndex will hold a list of various recipes
 * that will search the spirits to see which recipes
 * a user can make with the spirits in their cabinet
 *
 */
public class recipeIndex {
	
	//Recipes stored in an ArrayList
	private ArrayList<CocktailRecipe> recipeList = new ArrayList<CocktailRecipe>();

	/**
	 * Generic constructor
	 */
	public recipeIndex() {
		recipeList = new ArrayList<CocktailRecipe>();
	}

	/**
	 * @param recipeList
	 * This constructor takes a recipe, creates a recipe
	 * list and adds the recipe to the recipeList.
	 */
	public recipeIndex(CocktailRecipe recipe) {
		recipeList = new ArrayList<CocktailRecipe>();
		recipeList.add(recipe);
	}
	
	/**
	 * @param recipe
	 * This method adds a recipe to the index
	 */
	public void addRecipe(CocktailRecipe recipe) {
		recipeList.add(recipe);
	}
	
	/**
	 * @param recipe
	 * This method removes a recipe from the index
	 */
	public void removeRecipe(CocktailRecipe recipe) {
		recipeList.remove(recipe);
	}
	
	/**
	 * method to search through recipes and determine if they hold the 
	 * required ingredients to make them
	 * 
	 * **probably needs to return boolean value.
	 */
	public void searchRecipeIndex() {
		for (CocktailRecipe recipe : recipeList) { //for each recipe in the the index
			recipe.checkIngredients();			   //check to see if all ingredients are in the 
		}										   //liquor cabinet.						
	}
	
	
	

}
