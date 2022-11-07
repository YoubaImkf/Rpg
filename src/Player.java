import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Player {
	private String name;
	private Weapons w;
	private int wallet = 60000;
	private int x=4;
	private int y=0;
	private int hp = 100;
	ArrayList<Weapons> myWeapons = new ArrayList<Weapons>();
	ArrayList<Potion> myPotions = new ArrayList<Potion>();
	
    public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_ENTER = "\u001B[1;38;5;226m";
	public static final String ANSI_KILL = "\u001B[38;5;196m";
	public static final String ANSI_INF = "\u001B[38;5;208m";
	
	public Player(String name, Weapons w) {
		this.name = name;
		this.w = w;

	}
	
	public void LootItem() {
		//next step random item(...)
        Potion potion = new HealPotion();
        this.myPotions.add(potion);
        System.out.println("You looted " + potion.getName()+"\n");
	}

	public String getName() {
		return this.name;
	}
	
	//position
    public int getX() {      
        return this.x;
    }   
    public int getY() {
    	return this.y;
    }
    
    public int getHp() {      
        return this.hp;
    } 
    
    
	public void Attack(Destructible m) {
		m.hp -= this.w.damage  ;
		if(m.hp <= 0) {
			System.out.println(ANSI_KILL+ "YOU KILLED HIM"+ ANSI_RESET);
			System.out.println("You earn : " + m.gold);
			LootItem();
			this.wallet += m.gold;
		}else {
		System.out.println(m.hp +"HP left");
		}
	}	
	
	public void changeWeapon(Weapons w) {
		this.w = w;
	}
	
	public void UsePotion(Potion p) {
		this.hp += p.value;
	}
	
	public void dropWaepon(Weapons w) {
		this.myWeapons.remove(w);
	}
	
	public void ShowInventory() throws IOException {		
		System.out.println("Inventory:" + "\n"
					      +"Golds  : " + this.wallet  +"\n");
//		myItems();
		SelectAction();
	}
	
	public void StatWeapon() {
		System.out.println("Statistics") ;
		System.out.println(this.w.damage +"\n");
	}
	
	public void Buy(Weapons w) {
		if(this.wallet >= w.price) {
			this.wallet -= w.price;
			myWeapons.add(w);			
			System.out.println("You bought a "+ w.getName());
		}else {
			System.out.println("You dont have enought golds") ;
		}
	}
	
	public String ToString() {
		return 				
		"+~~~~~~~~~~~~~~~~YOUR CHARACTER~~~~~~~~~~~~+"+'\n'+
		"  Name:"+this.name+"|"+"HP:"+this.hp +"|"+"Weapon:"+this.w.getName()+'\n'+
		"+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+"+'\n';							
	}
	


	public void Move(String direction) {  

		 switch(direction) {        
	        // Down
	        case "D":
	        	this.x++; 
	        	if(this.x > 4) {
	        		System.out.println("Invalid position\nTry again");
	            	this.x--;
	        	}

	        	break;            
	        // Top
	        case "T":
	        	this.x--;
	        	if(this.x < 0) {
	        		System.out.println("Invalid position\nTry again");
	            	this.x++;
	        	}

	        	break;  
	        	
	        // Right
	        case "R": 
	            this.y++;
	        	if(y > 4) {
	        		System.out.println("Invalid position\nTry again");
	            	this.y--;
	        	}
	        		
	            break;          
	        // Left
	        case "L":   
	        	this.y--;
	        	if(this.y < 0) {
	        		System.out.println("Invalid position\nTry again");
	            	this.y++;
	        	}
	       
	            break;
	        default:
	        	System.out.println("not valide position");
	        }		 
	}
	
	
	private void SelectAction() throws IOException {

        System.out.println("+~~~~~~~~~~~~~~[ INVENTORY ]~~~~~~~~~~~~~~+");
		for(int i = 0; i < myWeapons.size(); i++) {
		System.out.print("-"+ i + " " + myWeapons.get(i).getName() + " | ");
		}
		System.out.println();
		for(int i = 0; i < myPotions.size(); i++) {
			System.out.print("-"+ i + " " + myPotions.get(i).getName() + " | ");
		}
		System.out.println();
        System.out.println("+------------[ MENU INVENTORY ]----------+");
        System.out.println("|| ENTER to access to:                  ||\n"+
			  			   "|| =>1  Menu select a Wepon             ||\n"+
						   "|| =>2  Menu use a Potion               ||\n"+
						   "||                                      ||\n"+
						   "|| =>999 to Quit                        ||\n");	
		System.out.println("+---------------------------------------+");

		    System.out.print("\n" + ANSI_ENTER + "ENTER:" + ANSI_RESET);   
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
	        int enter = Integer.parseInt(reader.readLine());  
	        
		        switch(enter) {
		        case 1:
		        	System.out.print("\n" + ANSI_ENTER + "Change your weapon by enter his number:" + ANSI_RESET);
		        	int enter2 = Integer.parseInt(reader.readLine());
						for(int i = 0; i < myWeapons.size(); i++) {
							if(i == enter2) {
								changeWeapon(myWeapons.get(i));
								System.out.println(ANSI_INF +"You changed your weapon !" + ANSI_RESET);
							}else {
								System.out.println("wrong number");
							}
						}		        	
		        break;
		        case 2:
		        	System.out.print("\n" + ANSI_ENTER + "Use potion by enter his number:" + ANSI_RESET);
		        	int enter3 = Integer.parseInt(reader.readLine());
						for(int i = 0; i < myPotions.size(); i++) {
							if(i == enter3) {
								UsePotion(myPotions.get(i));
								System.out.println(ANSI_INF + "You Used"+ myPotions.get(enter3).getName() + ANSI_RESET );
							}else {
								System.out.println("wrong number");
							}
						}					        
		        break;
		        
	        }
	        System.out.println(this.ToString()+'\n');
	}
	
	
	
	
}
