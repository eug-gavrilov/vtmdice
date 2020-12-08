package oakandrose.dice.api;

import java.util.Arrays;

public class ResponceDto {

	int[] fullResult;
	double[] chancesResult;
	double miss;

	public double getMiss() {
		return miss;
	}

	public void setMiss(double miss) {
		this.miss = miss;
	}

	public int[] getFullResult() {
		return fullResult;
	}

	public void setFullResult(int[] fullResult) {
		this.fullResult = fullResult;
	}

	public double[] getChancesResult() {
		return chancesResult;
	}

	public void setChancesResult(double[] chancesResult) {
		this.chancesResult = chancesResult;
	}

	public ResponceDto() {}

	public ResponceDto(int[] fullResult, double[] chancesResult, double miss) {
		this.fullResult = fullResult;
		this.chancesResult = chancesResult;
		this.miss = miss;
	}

	@Override
	public String toString() {
		return "ResponceDto [fullResult=" + Arrays.toString(fullResult) + ", chancesResult="
				+ Arrays.toString(chancesResult) + ", miss=" + miss + "]";
	}
}
