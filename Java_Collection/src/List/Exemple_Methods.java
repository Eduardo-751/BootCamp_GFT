package List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;

public class Exemple_Methods {
	public static void main(String[] args) {

        System.out.println("Crie uma lista e adicione as sete notas: ");
        List<Double> gradeList = new ArrayList<Double>();
        gradeList.add(7.0);
        gradeList.add(8.5);
        gradeList.add(9.3);
        gradeList.add(5.0);
        gradeList.add(7.0);
        gradeList.add(0.0);
        gradeList.add(3.6);
        System.out.println(gradeList.toString());

        System.out.println("Exiba a posi��o da nota 5.0: " + gradeList.indexOf(5d));

        System.out.println("Adicione na lista a nota 8.0 na posi��o 4: ");
        gradeList.add(4, 8d);
        System.out.println(gradeList);

        System.out.println("Substitua a nota 5.0 pela nota 6.0: ");
        gradeList.set(gradeList.indexOf(5d), 6.0);
        System.out.println(gradeList);

        System.out.println("Confira se a nota 5.0 est� na lista: " + gradeList.contains(5d));

        System.out.println("Exiba a terceira nota adicionada: " + gradeList.get(2));
        System.out.println(gradeList.toString());

        System.out.println("Exiba a menor nota: " + Collections.min(gradeList));

        System.out.println("Exiba a maior nota: " + Collections.max(gradeList));

        Iterator<Double> iterator = gradeList.iterator();
        Double soma = 0d;
        while(iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("Exiba a soma dos valores: " + soma);

        System.out.println("Exiba a m�dia das notas: " + (soma/gradeList.size()));

        System.out.println("Remova a nota 0: ");
        gradeList.remove(0d);
        System.out.println(gradeList);

        System.out.println("Remova a nota da posi��o 0");
        gradeList.remove(0);
        System.out.println(gradeList);

        System.out.println("Remova as notas menores que 7 e exiba a lista: ");
        Iterator<Double> iterator1 = gradeList.iterator();
        while(iterator1.hasNext()) {
            Double next = iterator1.next();
            if(next < 7) iterator1.remove();
        }
        System.out.println(gradeList);

        System.out.println("Apague toda a lista");
        gradeList.clear();
        System.out.println(gradeList);
        
        System.out.println("Confira se a lista est� vazia: " + gradeList.isEmpty());

	}
}
