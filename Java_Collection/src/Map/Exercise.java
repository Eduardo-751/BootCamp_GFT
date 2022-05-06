package Map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Exercise {
	public static void main(String[] args) {

		Map<String, Integer> stateMap = new HashMap<>() {
			{
				put("PE", 0616621);
				put("AL", 3351543);
				put("CE", 9187103);
				put("RN", 3534265);
			}
		};
		System.out.println(stateMap.toString() + "\n");

		System.out.println("Substitua a população do estado RN por 3534165: ");
		stateMap.put("RN", 3534165);
		System.out.println(stateMap.toString() + "\n");

		System.out.println("Verifica se o estado PB está no Map: " + stateMap.containsKey("PB") + "\n");
		if(!stateMap.containsKey("PB"))
			stateMap.put("PB", 4039277);
		System.out.println("Verifica se o estado PB está no Map: " + stateMap.containsKey("PB") + "\n");

		System.out.println("Exiba a População de PE: " + stateMap.get("PE") + "\n");

		System.out.println("Exiba todos o estados na ordem de criação: ");
		Map<String, Integer> estadoLinkedMap = new LinkedHashMap<>() {
			{
				put("PE", 0616621);
				put("AL", 3351543);
				put("CE", 9187103);
				put("RN", 3534265);
				put("PB", 4039277);
			}
		};
		System.out.println(estadoLinkedMap.toString() + "\n");
		
		System.out.println("Exiba todos os estados ordenado por estado: ");
		Map<String, Integer> estadoTreeMap = new TreeMap<>(estadoLinkedMap);
		System.out.println(estadoTreeMap.toString() + "\n");
		
		System.out.println("Exiba o estado com a menor população e sua quantidade: ");
		Integer minValue = Collections.min(stateMap.values());
		for (Map.Entry<String, Integer> entry : stateMap.entrySet()) {
			if (entry.getValue().equals(minValue))
				System.out.println(entry.getKey() + " - " + minValue);
		}
		System.out.println();
		
		System.out.println("Exiba o estado com a maior população e sua quantidade: ");
		Integer maxValue = Collections.max(stateMap.values());
		for (Map.Entry<String, Integer> entry : stateMap.entrySet()) {
			if (entry.getValue().equals(maxValue))
				System.out.println(entry.getKey() + " - " + maxValue);
		}
		System.out.println();
		
		Iterator<Integer> iterator = stateMap.values().iterator();
		Integer sum = 0;
		while (iterator.hasNext()) {
			sum += iterator.next();
		}
		System.out.println("Exiba a soma da população desses estados: " + sum + "\n");
		
		System.out.println("Exiba a média da população desses estados: " + sum / stateMap.size() + "\n");

		Iterator<Integer> iterator1 = stateMap.values().iterator();
		System.out.println("Remova os estados com a população menor que 4000000: ");
		while (iterator1.hasNext()) {
			if (iterator1.next() < 4000000)
				iterator1.remove();
		}
		System.out.println(stateMap.toString() + "\n");
		
		System.out.println("Apague o map!\n");
		stateMap.clear();

		System.out.println("Confira se o map está vazio: " + stateMap.isEmpty());
	}
}
