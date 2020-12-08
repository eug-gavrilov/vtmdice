package oakandrose.dice.service.impl;

import org.springframework.stereotype.Service;

import oakandrose.dice.api.ResponceDto;
import oakandrose.dice.service.interfaces.IVtimDiceManagement;

@Service	
public class CalcImpl implements IVtimDiceManagement {

	int ATTEMPTS = 1000000;
	int DIFFICULT = 6;
	int a = 1; // min on 1d10 dice
	int b = 10; // max on 1d10 dice

	@Override
	public int calculateOneThrow(int dicePool) {

		int successes = 0;

		for (int i = 0; i < dicePool; i++) {
			int random_number = a + (int) (Math.random() * b); // 1d10 roll
			if (random_number >= DIFFICULT) {
				successes = successes + 1;
			}
			if (random_number == 1) { // rule of natural 1
				successes = successes - 1;
			}
		}
		return successes;
	}

	@Override
	public int calculateOneThrowDmg(int dicePoolToHit, int dicePoolToDmg) {

		int successes = 0;

		for (int i = 0; i < dicePoolToDmg; i++) {
			int random_number = a + (int) (Math.random() * b);
			if (random_number >= DIFFICULT) {
				successes = successes + 1;
			}

		}
		return successes;
	}

	@Override
	public ResponceDto calculateStat(int dicePool) {
		
		double miss = 0;
		
		int[] fullResult = new int[dicePool];

		for (int i = 0; i < ATTEMPTS; i++) {
			int result = calculateOneThrow(dicePool);
			if (result > 0) {
				fullResult[result - 1] = fullResult[result - 1] + 1;
			}
			else {
				miss++;
			}
		}
		
		double misses;
		misses = miss * 1.0 / ATTEMPTS;
		misses = (int) (misses * 10000) * 0.01;
		
		int all = 0;
		double[] chancesResult = new double[dicePool];
		
		for (int i = 0; i < fullResult.length; i++) {
			all = all + fullResult[i];
			double chance = fullResult[i] * 1.0 / ATTEMPTS;
			double chances = (int) (chance * 10000) * 0.01; // percentage with two decimal places
			chancesResult[i] = chances;
		}
		
		
		ResponceDto responce = new ResponceDto(fullResult, chancesResult, misses);
		return responce;
	}

	@Override
	public ResponceDto calculateStatDamage(int dicePoolToHit, int dicePoolToDmg) {
		
		int miss = 0;
		int[] fullResult = new int[dicePoolToHit + dicePoolToDmg];

		for (int i = 0; i < ATTEMPTS; i++) {
			int result = calculateOneThrowDmg(dicePoolToHit, dicePoolToDmg);
			if (result > 0) {
				fullResult[result - 1] = fullResult[result - 1] + 1;
			}
			else {
				miss++;
			}
		}
		
		double misses;
		misses = miss * 1.0 / ATTEMPTS;
		misses = (int) (misses * 10000) * 0.01;

		int all = 0;
		double[] chancesResult = new double[dicePoolToHit + dicePoolToDmg];
		for (int i = 0; i < fullResult.length; i++) {
			all = all + fullResult[i];
			double chance = fullResult[i] * 1.0 / ATTEMPTS;
			double chances = (int) (chance * 100000) * 0.001;
			chancesResult[i] = chances;
		}
		ResponceDto responce = new ResponceDto(fullResult, chancesResult, misses);
		return responce;
	}

}
