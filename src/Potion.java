
public abstract class Potion {
	protected String name;
	protected int price;
	protected int value;
	
	public Potion(int value,int price) {
		this.value = value;
		this.price = price;
	}
	
	abstract public String getName();
	abstract String ascci_art();
}
