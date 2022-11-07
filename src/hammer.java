

public class hammer extends Weapons{
	private static final int DAMAGE = 50;
	private static final int PRICE = 1000;
	private String name = "Hammer";
	
	public hammer() {
		super(DAMAGE, PRICE);
	}
	
	@Override
	public String ascii_art() {
		return  "       \n"+
				"  _ _  \n"+
				"| _ _ |\n"+
				"   |   \n"+ 
				"   |   \n";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
}
