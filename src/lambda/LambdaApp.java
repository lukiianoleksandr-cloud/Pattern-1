package lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LambdaApp {

    // 1. Відфільтрувати непарні числа зі списку цілих чисел
    public static List<Integer> filterOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());
    }

    // 2. Знайти середнє зі списку дійсних значень
    public static double findAverage(List<Double> numbers) {
        return numbers.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

    // 3. Сортування списку рядків в алфавітному порядку
    public static List<String> sortAlphabetically(List<String> strings) {
        return strings.stream()
                .sorted((s1, s2) -> s1.compareTo(s2))
                .collect(Collectors.toList());
    }

    // 4. Обчислення суми всіх парних чисел
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    // 5. Обчислити факторіал заданого числа
    public static long calculateFactorial(int n) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) return 1;
        return IntStream.rangeClosed(2, n)
                .mapToLong(i -> (long) i)
                .reduce(1, (a, b) -> a * b);
    }

    // 6. Розрахуйте множення та підсумовування всіх елементів у списку цілих чисел
    public static String multiplyAndSum(List<Integer> numbers) {
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        int product = numbers.isEmpty() ? 0 : numbers.stream().reduce(1, (a, b) -> a * b);
        return "Сума = " + sum + ", Добуток = " + product;
    }

    // 7. Розрахуйте квадрат кожного числа у списку цілих чисел
    public static List<Integer> squareNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    // 8. Сортування рядків на основі їх довжини в порядку зростання
    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .collect(Collectors.toList());
    }

    // 9. Підрахуйте кількість слів у реченні (слова розділені пробілами)
    public static long countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) return 0;
        return Arrays.stream(sentence.trim().split("\\s+")).count();
    }

    // 10. Знайти перший непорожній рядок у списку рядків
    public static Optional<String> findFirstNonEmpty(List<String> strings) {
        return strings.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .findFirst();
    }

    // 11. Перевірити, чи всі рядки у списку починаються з великої літери
    public static boolean checkAllCapitalized(List<String> strings) {
        if (strings.isEmpty()) return false;
        return strings.stream()
                .allMatch(s -> s != null && !s.isEmpty() && Character.isUpperCase(s.charAt(0)));
    }

    // 12. Знайти друге за величиною число в списку цілих чисел
    public static Optional<Integer> findSecondLargest(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
    }

    // 13. Знайти найбільше парне число в списку цілих чисел
    public static Optional<Integer> findLargestEven(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .max(Integer::compare);
    }
}