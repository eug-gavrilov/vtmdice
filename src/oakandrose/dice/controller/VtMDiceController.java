package oakandrose.dice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import oakandrose.dice.api.ResponceDto;
import oakandrose.dice.api.VtmDiceApiConstants;
import oakandrose.dice.service.impl.CalcImpl;

@RestController
public class VtMDiceController {

	@Autowired
	CalcImpl calc;
	
	@GetMapping(value = VtmDiceApiConstants.THROW_ONE)
	int calculateOneThrow(@PathVariable("dicepool") int dicePool) {
		System.out.println(" = = = = CONTROLLER STARTED = = = = ");
		return calc.calculateOneThrow(dicePool); 
	}
	
	@GetMapping(value = VtmDiceApiConstants.THROW_DMG)
	int calculateOneThrowDmg(@PathVariable("dicepool") int dicePoolToHit, @PathVariable("dmg") int dicePoolToDmg) {
		System.out.println(" = = = = CONTROLLER STARTED = = = = ");
		return calc.calculateOneThrowDmg(dicePoolToHit, dicePoolToDmg);
	}
	
	@GetMapping(value = VtmDiceApiConstants.GET_STAT)
	ResponceDto calculateStat(@PathVariable("dicepool") int dicePoolToHit) {
		System.out.println(" = = = = CONTROLLER STARTED = = = = ");
		return calc.calculateStat(dicePoolToHit);
	}
	
	@GetMapping(value = VtmDiceApiConstants.GET_STAT_DMG)
	ResponceDto calculateStatDmg(@PathVariable("dicepool") int dicePoolToHit, @PathVariable("dmg") int dicePoolToDmg) {
		System.out.println(" = = = = CONTROLLER STARTED = = = = ");
		return calc.calculateStatDamage(dicePoolToHit, dicePoolToDmg);
	}
	
}
