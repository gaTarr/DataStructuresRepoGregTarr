/**
 * 
 */

/**
 * @author Greg Tarr
 *This class creates spirits that 
 *can be used in various cocktail recipes
 */
public class Spirits {
	
	private String name; //name of the spirit
	

	/**
	 * Default Constructor
	 */
	public Spirits() {
		name = "";
	}
	

	/**
	 * @param name
	 * Constructor created with spirit name
	 */
	public Spirits(String name) {
		this.name = name;
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
	
}
