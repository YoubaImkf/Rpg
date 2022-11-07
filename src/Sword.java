
public class Sword extends Weapons{
	private static final int DAMAGE = 10;
	private static final int PRICE = 10;
	private String name = "Sword";
	
	public Sword() {
		super(DAMAGE, PRICE);
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String ascii_art() {
		return   "     /|\r\n"
				+ "   |\\|\r\n"
				+ "   |||\r\n"
				+ "   |||\r\n"
				+ "   |||\r\n"
				+ "   |||\r\n"
				+ "   |||\r\n"
				+ "   |||\r\n"
			   + "~-=[{o}]=-~\r\n"
				+ "   |/|\r\n"
				+ "   |/|\r\n"
				+ "   `0'";
	}

}
