package lessen1;

import java.util.*;

public class PerfomanceLab1 {
    private static Map<Integer, List<String>> playerCards = new HashMap<>();


    public static void start(int n, int c) {


        if (n <= 0 || c <= 0) {
            System.out.println("Некорректные данные");

        }

        List<String> cards = new ArrayList<>();    // создаем список всех карт
        for (int i = 1; i <= 10; i++) {
            cards.add("R" + i);
            cards.add("G" + i);
            cards.add("B" + i);
            cards.add("W" + i);
        }
        Collections.shuffle(cards);                // перемешиваем все карты
        for (int i = 1; i <= n; i++) {
            int start = (i - 1) * c;                // берем индекс вычитаем 1 * на кол-во карт
            int end = start + c;
            if (end > cards.size()) {
                end = cards.size();
            }
            playerCards.put(i, new ArrayList<>(cards.subList(start, end)));
        }
    }

    public static String getCards(int c) {                  // метод для получения карт игрока
        if (playerCards.get(c) == null) {

            System.out.println("Игрок не найден");

        }
        List<String> cards = playerCards.get(c);
        StringBuilder sb = new StringBuilder();
        sb.append(c).append(" ");
        for (String card : cards) {
            sb.append(card).append(" ");
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println("Добро пожаловать ^_^.");
        System.out.println("Введите команду 'start №1 №2': №1-количество игроков №2-количество карт(на игрока)");
        Scanner scanner = new Scanner(System.in);
        while (true){
            String command = scanner.nextLine();
            if (command.startsWith("start")) {
                String[] params = command.split(" ");
                int n = Integer.parseInt(params[1]);
                int c = Integer.parseInt(params[2]);
                PerfomanceLab1.start(n, c);
                if ((n * c) > 40){
                    System.out.println("Слишком много игроков, выгоните кого-нибудь из-за стола");
                    break;
                }

                System.out.println("Введите команду 'get-cards №' №-номер игрока");


            } else if (command.startsWith("get-cards")) {

                String[] params = command.split(" ");
                int c = Integer.parseInt(params[1]);
                System.out.println(PerfomanceLab1.getCards(c));
            }else {
                System.out.println("Некорректная команда");
            }
        }
    }
}