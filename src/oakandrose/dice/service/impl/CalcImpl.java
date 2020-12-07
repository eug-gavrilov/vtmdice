package oakandrose.dice.service.impl;

public class CalcImpl {

	public static void run(int attempts, int dicePoolToHit, int dicePoolToDamage) {

		System.out.println("Hello World");
//		calculateOneThrow(dicePoolToHit);
//		calculateStat(attempts, dicePool);
//		int res = calculateDamage(dicePoolToHit, dicePoolToDamage);
//		System.out.println("damage is "+res);
		calculateStatDamage(attempts, dicePoolToHit, dicePoolToDamage);
	}

	private static void calculateStatDamage(int attempts, int dicePoolToHit, int dicePoolToDamage) {
		
		int miss = 0;
		int[] fullResult = new int[dicePoolToHit + dicePoolToDamage];

		for (int i = 0; i < attempts; i++) {
			int result = calculateDamage(dicePoolToHit, dicePoolToDamage);
			if (result > 0) {
				fullResult[result - 1] = fullResult[result - 1] + 1;
			}
			else {
				miss++;
			}
		}
		System.out.println(miss);

		int all = 0;
		for (int i = 0; i < fullResult.length; i++) {
			all = all + fullResult[i];
//			System.out.println(fullResult[i]);
			double chance = fullResult[i] * 1.0 / attempts;
			double chances = (int) (chance * 100000) * 0.001; // вероятность с точностью до тысячных, остальное
																// отбрасывается
			System.out.println(chances);
		}

	}

	private static int calculateDamage(int dicePoolToHit, int dicePoolToDamage) {
		int successes = calculateOneThrow(dicePoolToHit);
//		System.out.println("suc on hit is "+successes);
		int dmg = 0;

		if (successes == 1) {
			int dmgPool = dicePoolToDamage;
			dmg = calculateOneThrow(dmgPool);
		}

		if (successes > 1) {
			int dmgPool = dicePoolToDamage + (successes - 1);
			dmg = calculateOneThrowDmg(dmgPool);
		}

		return dmg;

	}

	@SuppressWarnings("unused")
	private static void calculateStat(int attempts, int dicePool) {
		int[] fullResult = new int[dicePool];

		for (int i = 0; i < attempts; i++) {
			int result = calculateOneThrow(dicePool);
			if (result > 0) {
				fullResult[result - 1] = fullResult[result - 1] + 1;
			}
		}

		int all = 0;
		for (int i = 0; i < fullResult.length; i++) {
			all = all + fullResult[i];
//			System.out.println(fullResult[i]);
			double chance = fullResult[i] * 1.0 / attempts;
			double chances = (int) (chance * 10000) * 0.01; // вероятность с точностью до сотых, остальное отбрасывается
			System.out.println(chances);
		}

	}

	private static int calculateOneThrow(int dicePool) {

		int difficult = 6;
		int a = 1; // Начальное значение диапазона - "от"
		int b = 10; // Конечное значение диапазона - "до"
		int successes = 0;

		for (int i = 0; i < dicePool; i++) {
			int random_number = a + (int) (Math.random() * b);
//			System.out.println("dice is "+random_number);
			if (random_number >= difficult) {
				successes = successes + 1;
			}
			if (random_number == 1) {
				successes = successes - 1;
			}
		}
		return successes;
	}

	private static int calculateOneThrowDmg(int dmgPool) {
		int difficult = 6;
		int a = 1; // Начальное значение диапазона - "от"
		int b = 10; // Конечное значение диапазона - "до"
		int successes = 0;

		for (int i = 0; i < dmgPool; i++) {
			int random_number = a + (int) (Math.random() * b);
//			System.out.println("dice is "+random_number);
			if (random_number >= difficult) {
				successes = successes + 1;
			}

		}
		return successes;
	}
}
