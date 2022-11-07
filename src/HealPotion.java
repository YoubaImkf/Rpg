
public class HealPotion extends Potion {
	private String name = "Heal Potion";
	private final static int PRICE = 500;
	private final static int VALUE = 10;
	
	public HealPotion() {
		super(VALUE,PRICE);
	}

	@Override
	public String getName() {	
		return this.name;
	}

	@Override
	String ascci_art() {
		return "    _______\r\n"
				+ "|       |\r\n"
				+ "|       |\r\n"
				+ "|:::::::|\r\n"
				+ "|:::::::|\r\n"
				+ "|:::::::|\r\n"
				+ "\\_____/\r\n"
				+ " |_   _|\r\n"
				+ "   ) (\r\n"
				+ "   `-'  "
				+ "\r\n";
	}

}
