package oakandrose.dice.api;

public interface VtmDiceApiConstants {

	String THROW_ONE = "/en/v1/throw/{dicepool}";
	String THROW_DMG = "/en/v1/dicepool/{dicepool}/dmg/{dmg}";

	String GET_STAT = "/en/v1/stat/{dicepool}";
	String GET_STAT_DMG = "/en/v1/stat/dicepool/{dicepool}/dmg/{dmg}";

}
