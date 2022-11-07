import java.util.ArrayList;

public class Monster extends Destructible{
	private static final int HP = 25;
	private static final int GOLD = 500;
	private String name = "Chernabog";
	private int x;
	private int y;

	public Monster() {
		super(HP,GOLD);
	}

	@Override
	public String getName() {
		return this.name;
	}
	
	public String ascii_art() {
		return  " (\\     (\\\r\n"
				+ " (\"\\  _ (\"\\ _\r\n"
				+ "((/ \\(o\\---/o)\r\n"
				+ "((/  \\( . . )  /|\r\n"
				+ "((/  _( (T) )-/-l_\r\n"
				+ " (/ (  \\__ (_/_(__)\r\n"
				+ "  \\/ \\    `-|   |\r\n"
				+ "  (   `---.__)--+--|>\r\n"
				+ "   \\    \\  \\ \\  |\r\n"
				+ "    )    )  ) \\_|\r\n"
				+ "   (    (  (    \r\n"
				+ "    \\    )  )`  \r\n"
				+ "     `--^`--^";
	}


}
