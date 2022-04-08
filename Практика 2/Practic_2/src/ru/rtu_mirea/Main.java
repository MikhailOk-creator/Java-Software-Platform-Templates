package ru.rtu_mirea;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Human> list = new ArrayList<Human>();
        list.add(new Human(15, "Пётр", "Сидоров", LocalDate.of(2007, 12, 5), 45));
        list.add(new Human(17, "Василий", "Пупкин", LocalDate.of(2005, 7, 9), 65));
        list.add(new Human(45, "Михаил", "Кузнецов", LocalDate.of(1977, 5, 24), 80));
        list.add(new Human(30, "Мария", "Смирнова", LocalDate.of(1992, 12, 31), 60));
        list.add(new Human(22, "Галина", "Соколова", LocalDate.of(2000, 6, 8), 55));

        Stream<Human> human_stream_1_operation = list.stream();
        Stream<Human> human_stream_2_operation = list.stream();
        Stream<Human> human_stream_3_operation = list.stream();
        Stream<Human> human_stream_4_operation = list.stream();

        System.out.println("----------------------------------------");
        human_stream_1_operation.forEach(x -> x.setWeight(x.getWeight()+3));

        System.out.println("----------------------------------------");
        human_stream_2_operation.sorted(new HumanWeightComparator())
                .forEach(x -> System.out.println(x.toString()));

        System.out.println("----------------------------------------");
        human_stream_3_operation.sorted(new HumanBirthComparator())
                .filter(x -> x.birthDate.isAfter(LocalDate.of(2000, 1, 1)))
                    .forEach(x -> System.out.println(x.toString()));

        System.out.println("----------------------------------------");
        System.out.println("Sum of all weight: " + human_stream_4_operation.reduce(0, (s, ob) -> s += ob.getWeight(), Integer::sum));
    }
}

class HumanWeightComparator implements Comparator<Human>{

    public int compare(Human a, Human b){
        return -(a.getWeight() - b.getWeight());
    }
}
class HumanBirthComparator implements Comparator<Human> {
    public int compare(Human a, Human b) {
        return a.birthDate.compareTo(b.birthDate);
    }
}
