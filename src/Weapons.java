

public abstract class Weapons  {
	protected int damage;
	protected int price;
	protected String name;
	
	public Weapons(int damage, int price) {
		this.damage = damage;
		this.price = price;
	}

	public void attack(Destructible m) {
		m.hp -= this.damage ;
		if(m.hp <= 0) {
			System.out.println("YOU KILLED HIM");
		}else {
		System.out.println(m.hp);
		}
	
	}
	
	abstract public String getName();
	
	abstract public String ascii_art();//class a definir dans chaque arme
}
