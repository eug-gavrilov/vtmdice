package oakandrose.dice;

import oakandrose.dice.service.impl.CalcImpl;

public class VtmDiceWebAppl {
	public static void main(String[] args) {
		
		int attempts = 1000000;
//		int attempts = 1;
		
		int dex = 3;
		int brawl = 3;
		int dicePoolToHit = dex+brawl+2;
		
		int str = 3;
		int bonusByTrick = 1;
		int dicePoolToDamage = str+bonusByTrick+1;
		
//		CalcImpl.run(attempts, dicePoolToHit, dicePoolToDamage);
	}
}
