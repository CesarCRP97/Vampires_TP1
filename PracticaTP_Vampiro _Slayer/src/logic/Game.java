package logic;

import java.util.Random;

import GameObjects.Player;
import GameObjects.Slayer;
import GameObjects.Vampire;
import lists.SlayerList;
import lists.VampireList;
import logic.Level;
import logic.GameObjectBoard;



public class Game {
	
	private Level level;
	private Long seed;
	
	public Game(Long seed , Level level){	
		
		this.seed = seed;
		this.level = level;
		
	}
	
	Random Aleatorio = new Random();
	SlayerList Slist;
	VampireList Vlist;
	Player User;
	
	int Scont = Slist.getScont();
	int Vcont = Vlist.getContador_Vamp();
	Slayer[] Sarray = Slist.getSarray();
	Vampire[] Varray = Vlist.getVarray();
	
	public boolean HayGanador(int Vcont, Slayer[] Sarray, Vampire[] Varray ) {
		
		boolean ganador = false;
		
		if(Vcont != 0 && Scont != 0) {
		
			for(int i = 0; i < Varray.length; i++) {
			
				int posVx = Varray[i].getposVx();
			
				if( posVx == 0) {
				
					ganador = true;
				}
		}
		
		}else if(Scont == 0) {
			
			ganador = true;
			
		}else if(Vcont == 0) {
			
			ganador = true;
		}
		
		return ganador;
	}
	
	public boolean RepartirMonedas(Player User, Random Aleatorio ) {
		
		boolean cobrado = false;
		int numAlea = 0;
		int Umoney = User.getMoney();
		numAlea = Aleatorio.nextInt(2);
		
		if(numAlea == 0) {
			
			System.out.println(" El usuario no recibe las 10 monedas extras...");
			cobrado = false;
			
		}else {
			
			Umoney = Umoney + 10;
			User.setMoney(Umoney);
			System.out.println(" El usuario ha recibido 10 monedas extras...");
			cobrado = true;
			
		}
		
		
		return cobrado;
	}


	public boolean PuedeComprarSlayer(Player User) {
		
		boolean puedeComprar = false;
		int money = 0;
		
		money = User.getMoney();
		
		if(money >= Slayer.Coste) {
			
			puedeComprar = true;
		}
	
		return puedeComprar;
	}
	
	public boolean PuedeAnyadirVampiro(Level level, Random Aleatorio) {
		
		boolean puede = false;
		int frecuencia = 0;
		int numAlea = 0;
		
		frecuencia = (int) (10 * level.getvampireFrequency());
		
		switch(frecuencia) {
		
		case 1: 
			
			numAlea = Aleatorio.nextInt(10);
			if(numAlea == 1) {
				
				System.out.println(" Se puede anyadir un nuevo vampiro...");
				puede = true;
				
			}else {
				
				puede = false;
			}
			break;
			
		case 2: 
			
			numAlea = Aleatorio.nextInt(10);
			if(numAlea == 1 || numAlea == 2) {
				
				System.out.println(" Se puede anyadir un nuevo vampiro...");
				puede = true;
				
			}else {
				
				puede = false;
			}
			break;
		
		case 3: 
			
			numAlea = Aleatorio.nextInt(10);
			if(numAlea == 1 || numAlea == 2 || numAlea == 3) {
				
				System.out.println(" Se puede anyadir un nuevo vampiro...");
				puede = true;
				
			}else {
				
				puede = false;
			}
			break;
		}
		
		return puede;
	}

	
}
