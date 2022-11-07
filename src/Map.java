import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Map {
    private int nbRow;
    private int nbColumn;
    private char [][] map; //matrix       
    
    public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_ENTER = "\u001B[38;5;226m";
	public static final String ANSI_WIN = "\u001B[38;5;40m";
	
    public Map(int l, int c) {        
        this.nbRow = l;
        this.nbColumn = c; 
       
        map = new char[nbRow][nbColumn];
    
        for(int i = 0; i < nbRow ; i++) {            
            for(int j = 0 ; j < nbColumn ; j++) {                
                map[i][j] = '.';
                map[4][0] = 'X';//set player
            }
        }
     }
  
       
    public void Display() {  
		System.out.println("     ~x The MAP x~" );	
        for(int i = 0; i < nbRow ; i++) {            
            for(int j = 0 ; j < nbColumn ; j++) {
            	System.out.print(" | " + map[i][j]);
            }
            System.out.println(" | ");
        }
        System.out.println();
    }
    
    public void SetPosition(Player p, char t) throws IOException {
    	//Clean Map à l'endroit où le personnage se trouvait
    	Destructible monster = new Monster();	 
    	for(int i = 0; i < nbRow ; i++) {
        	for(int j = 0 ; j < nbColumn ; j++) {
        		if(map[i][j] == 'X'){
        			map[i][j] = '.';
        			}
                }
            }
    	 if( p.getY() < 0 || p.getY() > nbColumn || p.getY() < 0 || p.getY() > nbColumn) {
    		 System.out.print("Placement error!"+'\n');
    		 return; // else Index x out of bounds
    		 }
    	 
    	 //if Monster
    	 if(map[p.getX()][p.getY()] == 'M') {

     	   	System.out.println("You met a Monster"+'\n');
     	    while(monster.hp > 0) {			
     	    	System.out.println("+-------------------------+"+'\n'+
     	    					   "      Select an action"     +'\n'+
     	    					   "+-------------------------+");
     	        System.out.println("  1. Attack  |  2. Run Away");
     	        System.out.print(ANSI_ENTER + "ENTER :" + ANSI_RESET);
     	        BufferedReader bff = new BufferedReader(new InputStreamReader(System.in)); 
     	        String action = bff.readLine();
     	        action  = action.toUpperCase();
     	        
     	        switch(action) {
     	        case "1":
     	        	System.out.println(p.getName() +" attack "+ monster.getName()+'\n');
         	    	p.Attack(monster);
     	        	break;
     	        case "2":
     	        	 monster.hp = 0;
     	        	 System.out.println("Run Away...");
     	        	 break;
     	        default:    	        	 
     	        	monster.hp = 0;
     	        	System.out.println("Run Away...");
     	        	break;
     	        }    	    	   	    	
     		 }
     	 }
    	 
    	 if(map[p.getX()][p.getY()] == '.' || map[p.getX()][p.getY()] == 'M') {//if empty
    		 map[p.getX()][p.getY()] = t;
    		 }else{
    			 System.out.print("Not valid Placement."+'\n');
    			 return;
    		 }
    	 
    	 
    	 
    	//END GAME
        if(p.getX() == 0 && p.getY() == 4) {
        	 YouWin();
        	 System.exit(0);
        }       
    }
    

    public void SetMonsterPosition(){
		for(int i = 0; i < 5; i++) {
			int randomCol = ThreadLocalRandom.current().nextInt(0, nbColumn);
			int randomRow = ThreadLocalRandom.current().nextInt(0, nbRow);
			if(map[randomRow][randomCol] != map[4][0]) {//cant be placed on player start position
				map[randomRow][randomCol] = 'M';
			}
			
        }		
    }
    	

    
    
    private static void YouWin() {
    	System.out.print(ANSI_WIN+"__   _____  _   _  __        _____ _   _   _ \r\n"
    			+ "\\ \\ / / _ \\| | | | \\ \\      / |_ _| | / | | |\r\n"
    			+ " \\ V | | | | | | |  \\ \\ /\\ / / | || |/  | | |\r\n"
    			+ "  | || |_| | |_| |   \\ V  V /  | ||  /| | |_|\r\n"
    			+ "  |_| \\___/ \\___/     \\_/\\_/  |___|_/ |_| (_)"+ANSI_RESET);
    }


}
