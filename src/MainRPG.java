import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainRPG {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_CYAN = "\u001B[1;36m";
	public static final String ANSI_SPEAK = "\u001B[38;5;123m";
	public static final String ANSI_ENTER = "\u001B[1;38;5;226m";
	
	public static void main(String[] args) throws IOException {
		BufferedReader bff = new BufferedReader(new InputStreamReader(System.in)); 
		WeaponStore store = new WeaponStore();
		Map map = new Map(5,5);
		map.SetMonsterPosition();

		System.out.println(ANSI_CYAN  +"+----*------------------*------------------*--+");
		System.out.println("   *          Welcome to the Game             " );
		System.out.println("+-------------------**------------*----------*+"+ ANSI_RESET);
		mountainStart();

		
		System.out.print("Enter 'Y' to START  |     Enter 'Q' to QUIT'"+'\n');
		System.out.print(ANSI_ENTER + "ENTER :" + ANSI_RESET);
        String resp = bff.readLine();
        resp = resp.toUpperCase();
		
		
			if(!resp.equals("Q")) {
				System.out.println("+-------------------------+");
				System.out.println("   Create your character"    );
				System.out.println("+-------------------------+");
				System.out.print(ANSI_ENTER + " - Enter your name:" + ANSI_RESET);
				String characterName = bff.readLine();
				Player player = new Player(characterName, store.defaultWeapons());
				System.out.println();				
				ShowCommand();
				
				System.out.println("    +~~~~~~~~~~~~~~~~~~~~~STORY~~~~~~~~~~~~~~~~~~~~~~+");
				System.out.println(ANSI_SPEAK  +"                      Welcome "+characterName            );
				System.out.println("    ||     \"Here you are equipped with the bare    ||"+'\n'
							     + "    ||      necessities to kill monsters to get    ||"+'\n'
							     + "    ||         gold and improve your weapon.\"      ||"+ ANSI_RESET);
				System.out.println("    +~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+"+'\n' );
		
				map.Display();
				
				while(!resp.equals("4")) {
					System.out.print(ANSI_ENTER + "ENTER :" + ANSI_RESET);
					resp = bff.readLine();
					resp = resp.toUpperCase();
	
					switch(resp){
					case "0":
						ShowCommand();
				    break;
					    
					case "1":
						store.ascii_art();
						System.out.print(ANSI_ENTER + "STORE CHOICE :" + ANSI_RESET);
						resp = bff.readLine();
						resp = resp.toUpperCase();
							if(resp.equals("H")) {
								player.Buy(store.hammer);
								System.out.println(player.ToString()+'\n');
							}
							else if(resp.equals("S")) {
								player.Buy(store.stick);
								System.out.println(player.ToString()+'\n');
							}
					break;
						
					   case "2":
						   player.ShowInventory();
					break;	
					
					   case "3":
						   player.StatWeapon();
					break;	
	
					//Move
					case "T":
						player.Move("T");
						map.SetPosition(player, 'X');
						map.Display();
						System.out.println(characterName +" heads north");
					break;	
						
					case "R":
						player.Move("R");
						map.SetPosition(player, 'X');
						map.Display();
						System.out.println(characterName +" heads east");
						
					break;
						
					case "D":
						player.Move("D");
						map.SetPosition(player, 'X');
						map.Display();
						System.out.println(characterName +" heads sud");
					break;
						
					case "L":
						player.Move("L");
						map.SetPosition(player, 'X');
						map.Display();
						System.out.println(characterName +" heads west");
					break;
					//End Move
						
					case "5":
						mountainEnd();
						System.exit(0);
					break;

				}
			}
		}else {
			mountainEnd();
			System.exit(0);
			}
		}
	
	//Ascii-Art
	private static void ShowCommand() {
		System.out.println("+-------------------[ USEFUL-COMMAND ]------------------+"+'\n'+
		                   "||                                                     ||"+'\n'+
				           "|| ENTER to access to:                                 ||"+'\n'+
				           "|| =>0  Useful Command                                 ||"+'\n'+
				           "|| =>1  Store                                          ||"+'\n'+
				           "|| =>2  Inventory                                      ||"+'\n'+
				           "|| =>3  Statistics                                     ||"+'\n'+
			               "|| =>   Move on map = 'T' |  'R'  | 'D'  | 'L'         ||"+'\n'+
                           "||                    top | right | down | left        ||"+'\n'+
                           "|| =>5  END GAME                                       ||");
        System.out.println("+-------------------------------------------------------+"+'\n');
	}
	private static void mountainStart() {
		System.out.println("        _    .  ,   .           .\r\n"
				+ "    *  / \\_ *  / \\_      _  *        *   /\\'__   *\r\n"
				+ "      /    \\  /    \\,   ((        .    _/  /  \\  *\r\n"
				+ " .   /\\/\\  /\\/ :' __ \\_  `          _^/  ^/    `-\r\n"
				+ "    /    \\/  \\  _/  \\-'\\      *    /.' ^_   \\_  \r\n"
				+ "  /\\  .-   `. \\/     \\ /==~=-=~=-=-;.  _/ \\ -. \\\r\n"
				+ " /  `-.__ ^   / .-'.--\\ =-=~_=-=~=^/  _ `--./ .-'  `\r\n"
				+ "/        `.  / /       `.~-^=-=~=^=.-'      '-._ `._"+"\n");
	}
	private static void mountainEnd() {
		System.out.println("           .          .           .     .                .     .\r\n"
				+ "  .      .      *           .       .          .                       .\r\n"
				+ "                 .       .   . *            \"you left?....wh..why?...               \r\n"
				+ "  .       ____     .      . .            .    I'll always love you, BYE.\"\r\n"
				+ "         >>         .        .               .\r\n"
				+ " .   .  /WWWI; \\  .       .    .  ____               .         .     . \r\n"
				+ "  *    /WWWWII; \\=====;    .     /WI; \\   *    .        /\\_          \r\n"
				+ "  .   /WWWWWII;..      \\_  . ___/WI;:. \\     .        _/M; \\    .   .\r\n"
				+ "     /WWWWWIIIIi;..      \\__/WWWIIII:.. \\____ .   .  /MMI:  \\   * .  \r\n"
				+ " . _/WWWWWIIIi;;;:...:   ;\\WWWWWWIIIII;.     \\     /MMWII;   \\    .  \r\n"
				+ "  /WWWWWIWIiii;;;.:.. :   ;\\WWWWWIII;;;::     \\___/MMWIIII;   \\      \r\n"
				+ " /WWWWWIIIIiii;;::.... :   ;|WWWWWWII;;::.:      :;IMWIIIII;:   \\___   \r\n"
				+ "/WWWWWWWWWIIIIIWIIii;;::;..;\\WWWWWWIII;;;:::...    ;IMIII;;     ::  \\  \r\n"
				+ "WWWWWWWWWIIIIIIIIIii;;::.;..;\\WWWWWWWWIIIII;;..  :;IMIII;:::     :    \\\r\n"
				+ "WWWWWWWWWWWWWIIIIIIii;;::..;..;\\WWWWWWWWIIII;::; :::::::::.....::       \r\n"
				+ "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%X\r\n"
				+ "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%XXXX\r\n"
				+ "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%XXXXXXX\r\n");
	}

	
}


	
		




