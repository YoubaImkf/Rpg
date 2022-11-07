

public class StickOfTruth extends Weapons {
	private static final int DAMAGE = 100;
	private static final int PRICE  = 2000;
	private String name="StickOfTruth";
	
	public StickOfTruth() {
		super(DAMAGE, PRICE);
	}
	
	@Override
	public String ascii_art() {
		return  "         \n"+
				"   ||    \n"+
				"   ||/   \n"+
				"   ||    \n"+ 
				"   ||    \n";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
}
