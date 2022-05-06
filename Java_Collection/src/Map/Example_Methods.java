package Map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Example_Methods {

	public static void main(String[] args) {

		Map<String, Double> CarMap = new HashMap<>() {
			{
				put("gol", 14.4);
				put("uno", 15.6);
				put("mobi", 16.1);
				put("hb20", 14.5);
				put("kwid", 15.6);
			}
		};
		System.out.println(CarMap.toString() + "\n");

		System.out.println("Substitua o consumo do gol por 15,2 km/h: ");
		CarMap.put("gol", 15.2);
		System.out.println(CarMap.toString() + "\n");

		System.out.println("Verifica se o modelo Tucson está no Map: " + CarMap.containsKey("tucson") + "\n");
		System.out.println("Verifica se o modelo Uno está no Map: " + CarMap.containsKey("uno") + "\n");

		System.out.println("Exiba o consumo do Uno: " + CarMap.get("uno") + "\n");

		System.out.println("Exiba os modelos do Map: \n " + CarMap.keySet() + "\n");

		System.out.println("Exiba os consumos dos Carros: \n" + CarMap.values() + "\n");

		System.out.println("Exiba o modelo mais econômico e seu consumo: ");
		Double maxValue = Collections.max(CarMap.values());
		for (Map.Entry<String, Double> entry : CarMap.entrySet()) {
			if (entry.getValue().equals(maxValue))
				System.out.println(entry.getKey() + " - " + maxValue);
		}
		System.out.println();

		System.out.println("Exiba o modelo menos econômico e seu consumo: ");
		Double minValue = Collections.min(CarMap.values());
		for (Map.Entry<String, Double> entry : CarMap.entrySet()) {
			if (entry.getValue().equals(minValue))
				System.out.println(entry.getKey() + " - " + minValue);
		}
		System.out.println();

		Iterator<Double> iterator = CarMap.values().iterator();
		Double sum = 0d;
		while (iterator.hasNext()) {
			sum += iterator.next();
		}
		System.out.println("Exiba a soma dos consumos: " + sum + "\n");

		System.out.println("Exiba a média dos consumos deste map: " + sum/CarMap.size() + "\n");

		Iterator<Double> iterator1 = CarMap.values().iterator();
		System.out.println("Remova os modelos com o consumo igual a 15,6 km/h: " + sum + "\n");
		while (iterator1.hasNext()) {
			if (iterator1.next().equals(15.6))
				iterator1.remove();
		}
		System.out.println(CarMap.toString() + "\n");

		System.out.println("Exiba todos o map na ordem de criação: ");
		Map<String, Double> variavelLinkedMap = new LinkedHashMap<>() {
			{
				put("gol", 14.4);
				put("uno", 15.6);
				put("mobi", 16.1);
				put("hb20", 14.5);
				put("kwid", 15.6);
			}
		};
		System.out.println(variavelLinkedMap.toString() + "\n");
		
		System.out.println("Exiba todos o map ordenada por modelo: ");
		Map<String, Double> variavelTreeMap = new TreeMap<>(variavelLinkedMap);
		System.out.println(variavelTreeMap.toString() + "\n");
		
		System.out.println("Apague o map!\n");
		CarMap.clear();
		
		System.out.println("Confira se o map está vazio: " + CarMap.isEmpty());
	}
}
