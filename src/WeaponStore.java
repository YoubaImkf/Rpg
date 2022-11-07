public class WeaponStore {
	Weapons hammer = new hammer();
	Weapons stick = new StickOfTruth();
	Weapons sword = new Sword();
	
	public double Price(Weapons w) {
		return w.price;
	}
	
	public double Damage(Weapons w) {
		return w.damage;
	}
	
	public Weapons defaultWeapons() {
		return this.sword;
	}

	
	public void ascii_art() {
	System.out.println(""
			+  "        +---------------[ THE STORE ]-------------+\n"+
			   "        ||                                       \n"+
			   "        || ENTER to access to:                   \n"+
			   "        ||                                       \n"+
			   "        || =>'H' Hammer:" +hammer.price+"$       \n"+
			   "        ||                                       \n"+
			   "        || =>'S' StickOfTruth: " +stick.price+"$ \n"+
			   "        ||                                       \n"+
			   "        ||  =>Quit to Quit                       \n"+			  
			   "        +_________________________________________+\n"	
		);
	}
	
	
}
