package List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Exercise {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Double> temperaturas = new ArrayList<Double>();

		System.out.print("Digite a temperatura: ");
		double temp = scan.nextDouble();
		temperaturas.add(temp);

		System.out.print("Todas as temperaturas: ");
		temperaturas.forEach(t -> System.out.print(t + " "));

		double media = temperaturas.stream().mapToDouble(Double::doubleValue).average().orElse(0d);
		System.out.printf("\nMédia das temperaturas: %.1f\n", media);

		System.out.print("Temperaturas acima da média: ");
		temperaturas.stream().filter(t -> t > media).forEach(t -> System.out.printf("%.1f ", t));

		System.out.println("\n\nMeses das temperaturas acima da média: ");
		Iterator<Double> iterator = temperaturas.iterator();

		int count = 0;
		while (iterator.hasNext()) {
			Double temp1 = iterator.next();
			if (temp1 > media) {
				switch (count) {
				case (0):
					System.out.printf("1 - janeiro: %.1f\n ", temp1);
					break;
				case (1):
					System.out.printf("2 - fevereiro: %.1f\n", temp1);
					break;
				case (2):
					System.out.printf("3 - março: %.1f\n", temp1);
					break;
				case (3):
					System.out.printf("4 - abril: %.1f\n", temp1);
					break;
				case (4):
					System.out.printf("5 - maio: %.1f\n", temp1);
					break;
				case (5):
					System.out.printf("6 - junho: %.1f\n", temp1);
					break;
				default:
					System.out.println("Não houve temperatura acima da média.");
				}
			}
			count++;
		}
	}
}
