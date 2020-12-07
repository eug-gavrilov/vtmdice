package oakandrose.dice.service.interfaces;

public interface IVtimDiceManagement {
	
	int calculateOneThrow(int dicePool);
	int calculateOneThrowDmg(int dicePoolToHit, int dicePoolToDmg);

}
