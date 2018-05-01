import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Greg Tarr
 * This recipeIndex will hold a list of various recipes
 * that can be made based upon spirits in the liquor cabinet 
 * class. 
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
	 * required ingredients to make them.
	 */
	public void searchRecipeIndex(liquorCabinet aCabinet) {
		for (CocktailRecipe recipe : recipeList) { 	
			recipe.checkIngredients(aCabinet);	   	 
		}										   							
	}
	
	/**
	 * This method returns all available recipes that
	 * can be made with the spirits in the liquor cabinet
	 */
	public String recipesAvailable() {
		String displayStrings = "";
		System.out.println("These are the recipes you can make: ");
		for (CocktailRecipe recipe : recipeList) {
			if(recipe.getHasAllIngredients()) {
				displayStrings += recipe.displayRecipe() + "\n";
			}
		} return displayStrings;
	}
	
	/**
	 * This method displays any recipe that exists, 
	 * not necessarily ones that a user has supplies 
	 * to make.
	 */
	public void displayAllRecipes() {
		System.out.println("All Possible Recipes: ");
		for (CocktailRecipe recipe : recipeList) {
			recipe.displayRecipe();			
		}
	}
	
	
	

}
