
public abstract class Destructible {
	protected String name;
	protected int hp;
	protected int gold;
	
	public Destructible(int hp, int gold) {
		this.hp = hp;
		this.gold = gold;
	}
	
	abstract public String getName();
	
	
	abstract public String ascii_art();
}
