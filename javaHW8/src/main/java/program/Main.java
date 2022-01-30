package program;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people1 = generateDefaultPeopleList();
        System.out.println("Изначально:\n");
        people1.forEach(System.out::println);
        System.out.println("\n-------------------------------------------------------------");

        people1.sort(Comparator
                .comparing(Person::lastName)
                .thenComparing(Person::firstName)
                // Не очень понял, что значит сверху, а что значит снизу.
                // Тут старые сначала
                .thenComparing(Comparator.comparing(Person::age).reversed())
                // Или тут сначала молодые
                //.thenComparing(Person::age)
        );

        System.out.println("\nПосле сортировки:\n");
        people1.forEach(System.out::println);
    }

    private static List<Person> generateDefaultPeopleList() {
        return Arrays.asList(
                new Person("Кучук", "Александр", (byte) 20), // Вечно молодой, вечно пьяный
                new Person("Антонов", "Борис", (byte) 15),
                new Person("Антонов", "Виктор", (byte) 15),
                new Person("Антонов", "Борис", (byte) 12),
                new Person("Борисов", "Антон", (byte) 9)
        );
    }
}
