package Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Challenge {
	public static void main(String[] args) {
		final int quantLancamentos = 100;

        Random random = new Random();
        Map<Integer, Integer> randomNumbersMap = new HashMap<>();
        for (int i = 0; i < quantLancamentos; i++) {
        	int number = random.nextInt(10) + 1;
            if (randomNumbersMap.containsKey(number))
            	randomNumbersMap.put(number, (randomNumbersMap.get(number) + 1));
            else randomNumbersMap.put(number, 1);
        }

        System.out.println("\nValor  Quant. de vezes");
        for (Map.Entry<Integer, Integer> entry : randomNumbersMap.entrySet()) {
            System.out.printf("%3d %12d\n", entry.getKey(), entry.getValue());
        }
    }
}
