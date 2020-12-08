package oakandrose.dice.service.interfaces;

import oakandrose.dice.api.ResponceDto;

public interface IVtimDiceManagement {
	
	int calculateOneThrow(int dicePool);
	int calculateOneThrowDmg(int dicePoolToHit, int dicePoolToDmg);
	ResponceDto calculateStat(int dicePool);
	ResponceDto calculateStatDamage(int dicePoolToHit, int dicePoolToDmg);

}
