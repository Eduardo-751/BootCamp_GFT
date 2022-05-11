package List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Exemple_Sorting {
	public static void main(String[] args) {

		List<Cat> meusGatos = new ArrayList<>(){{
            add(new Cat("Jon", 12, "preto"));
            add(new Cat("Simba", 6, "tigrado"));
            add(new Cat("Jon", 18, "amarelo"));
        }};
        meusGatos.sort(Comparator.comparing(Cat::getName));


        System.out.println("--\tOrdem de Inserção\t---");
        System.out.println(meusGatos);

        System.out.println("--\tOrdem aleatória\t---");
        Collections.shuffle(meusGatos);
        System.out.println(meusGatos);

        System.out.println("--\tOrdem Natural (Nome)\t---");
        Collections.sort(meusGatos);
        System.out.println(meusGatos);

        System.out.println("--\tOrdem Idade\t---");
//        Collections.sort(meusGatos, new ComparatorIdade());
        meusGatos.sort(new ComparatorAge());
        System.out.println(meusGatos);

        System.out.println("--\tOrdem cor\t---");
//        Collections.sort(meusGatos, new ComparatorCor());
        meusGatos.sort(new ComparatorColor());
        System.out.println(meusGatos);

        System.out.println("--\tOrdem Nome/Cor/Idade\t---");
//        Collections.sort(meusGatos, new ComparatorNomeCorIdade());
        meusGatos.sort(new ComparatorNameAgeColor());
        System.out.println(meusGatos);
    }
}

class Cat implements Comparable<Cat>{
    private String name;
    private Integer age;
    private String color;

    public Cat(String name, Integer age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    @Override
    public int compareTo(Cat cat) {
        return this.getName().compareToIgnoreCase(cat.getName());
    }
}

class ComparatorAge implements Comparator<Cat> {
    @Override
    public int compare(Cat c1, Cat c2) {
        return Integer.compare(c1.getAge(), c2.getAge());
    }
}

class ComparatorColor implements Comparator<Cat> {
    @Override
    public int compare(Cat c1, Cat c2) {
        return c1.getColor().compareToIgnoreCase(c2.getColor());
    }
}

class ComparatorNameAgeColor implements Comparator<Cat> {
    @Override
    public int compare(Cat c1, Cat c2) {
        int name = c1.getName().compareToIgnoreCase(c2.getName());
        if (name != 0) return name;

        int color = c1.getColor().compareToIgnoreCase(c2.getColor());
        if(color !=0) return color;

        return Integer.compare(c1.getAge(), c2.getAge());

    }
}
