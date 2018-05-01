import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

public class CocktailCreator2 extends JFrame {

	private JList spiritsList;
	private JLabel resultsLabel;
	private JButton selectButton;
	private JTextArea displayOutput;

	private liquorCabinet myCabinet;
	private CocktailRecipe Screwdriver;
	private CocktailRecipe RumAndCoke;
	private CocktailRecipe OldFashioned;
	private CocktailRecipe RobRoy;
	private recipeIndex DrinkMenu;

	final Spirits Bitters = new Spirits("Bitters");
	final Spirits Bourbon = new Spirits("Bourbon");
	final Spirits CoconutRum = new Spirits("Coconut Rum");
	final Spirits Coke = new Spirits("Coke");
	final Spirits CranberryJuice = new Spirits("Cranberry Juice");
	final Spirits Grenadine = new Spirits("Grenadine");
	final Spirits IrishWhiskey = new Spirits("Irish Whiskey");
	final Spirits OrangeJuice = new Spirits("Orange Juice");
	final Spirits ScotchWhiskey = new Spirits("Scotch");
	final Spirits SimpleSyrup = new Spirits("Simple Syrup");
	final Spirits SourMix = new Spirits("Sour Mix");
	final Spirits SpicedRum = new Spirits("Spiced Rum");
	final Spirits SweetVermouth = new Spirits("Sweet Vermouth");
	final Spirits Tequila = new Spirits("Tequila");
	final Spirits Vodka = new Spirits("Vodka");

	private static String[] names = { "Bitters", "Bourbon", "Coconut Rum", "Coke", "Cranberry Juice", "Grenadine",
			"Irish Whiskey", "Orange Juice", "Scotch Whiskey", "Simple Syrup", "Sour Mix", "SpicedRum",
			"Sweet Vermouth", "Tequila", "Vodka" };
	final Spirits[] spiritsArray = { Bitters, Bourbon, CoconutRum, Coke, CranberryJuice, Grenadine, IrishWhiskey,
			OrangeJuice, ScotchWhiskey, SimpleSyrup, SourMix, SpicedRum, SweetVermouth, Tequila, Vodka };
	private int[] selIndices;

	public CocktailCreator2() {
		super("Select Cocktails"); //Name Window
		setLayout(new FlowLayout());
		
		//instantiate objects to be used in the frame
		myCabinet = new liquorCabinet();
		Screwdriver = new CocktailRecipe("Screwdriver");
		RumAndCoke = new CocktailRecipe("Rum and Coke");
		OldFashioned = new CocktailRecipe("Old Fashioned");
		RobRoy = new CocktailRecipe("Rob Roy");
		DrinkMenu = new recipeIndex();

		spiritsList = new JList(names);
		spiritsList.setVisibleRowCount(6);
		spiritsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		add(new JScrollPane(spiritsList));

		selectButton = new JButton("Select Spirits");
		selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//myCabinet = new liquorCabinet();
				//myCabinet.reset();
				recipeSetup();
				
				selIndices = spiritsList.getSelectedIndices();
				for (int i = 0; i < selIndices.length; i++) {
					myCabinet.add(spiritsArray[selIndices[i]]);
				}
				DrinkMenu.searchRecipeIndex(myCabinet);

				displayOutput.insert(DrinkMenu.recipesAvailable(), 0);
				System.out.println(DrinkMenu.recipesAvailable());
			}
		});
		add(selectButton);
		resultsLabel = new JLabel("These are the recipes you can make: ");
		add(resultsLabel);

		displayOutput = new JTextArea(6, 20);
		add(displayOutput);
		displayOutput.setEditable(false);

	}

	/**
	 * This method is designed to aid in code readability. All recipes constructed
	 * here and added to the recipe index.
	 */
	public void recipeSetup() {

		// Add ingredients to recipes
		Screwdriver.addIngredients(Vodka);
		Screwdriver.addIngredients(OrangeJuice);

		RumAndCoke.addIngredients(SpicedRum);
		RumAndCoke.addIngredients(Coke);
		RumAndCoke.addIngredients(Tequila);
		RumAndCoke.removeIngredients(Tequila);

		OldFashioned.addIngredients(Bourbon);
		OldFashioned.addIngredients(SimpleSyrup);
		OldFashioned.addIngredients(Bitters);

		RobRoy.addIngredients(ScotchWhiskey);
		RobRoy.addIngredients(SweetVermouth);
		RobRoy.addIngredients(Bitters);

		// Add created recipes to recipe index
		DrinkMenu.addRecipe(Screwdriver);
		DrinkMenu.addRecipe(RumAndCoke);
		DrinkMenu.addRecipe(OldFashioned);
		DrinkMenu.addRecipe(RobRoy);

	}

	/**
	 * This method is called in the Driver class to start the application.
	 */
	public void start() {
		this.setSize(350, 350);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
