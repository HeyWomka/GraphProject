package graph;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x = 0;
        String mainMenuChoice = "";

        while (!"0".equals(mainMenuChoice)){
            printMainMenu();
            mainMenuChoice = scan.nextLine();

            try {
                x = Integer.parseInt(mainMenuChoice);
            } catch (NumberFormatException e){
                errorChoice();
            }

            switch (x){
                case 1:
                    Graph.fillAll();
                    break;
                case 2:
                    int z = 0;
                    String outputMenuChoice = "";

                    while(!"0".equals(outputMenuChoice)) {
                        printOutputMenu();
                        outputMenuChoice = scan.nextLine();

                        try {
                            z = Integer.parseInt(outputMenuChoice);
                        } catch (NumberFormatException e){
                            errorChoice();
                        }

                        switch (z) {
                            case 1:
                                Graph.printAdjacencyMatrix();
                                break;
                            case 2:
                                Graph.printIncidenceMatrix();
                                break;
                            case 3:
                                Graph.printAdjacencyList();
                                break;
                            case 4:
                                Graph.printAll();
                                break;
                            case 0:
                                break;
                            default:
                                errorChoice();
                                break;
                        }
                    }
                    break;
                case 0:
                    break;
                default:
                    errorChoice();
                    break;
            }
        }
        System.out.println("Пока.. Я буду скучать.. (^_^')");
    }

    private static void printMainMenu() {
        System.out.println(
                "\nОсновное меню\n"
                        + "1. Ввод графа\n"
                        + "2. Вывод графа\n"
                        + "0. Для выхода из приложения o_O");
        System.out.print("Выбор: ");
    }

    public static void printOutputMenu() {
        System.out.println(
                "\nВыберите, что хотите увидеть: \n"
                        + "1. Матрица смежности\n"
                        + "2. Матрица инцидентности\n"
                        + "3. Список смежности\n"
                        + "4. Хочу всё сразу ^_^\n"
                        + "0. Вернуться в основное меню");
        System.out.print("Выбор: ");
    }

    public static void errorChoice() {
        System.out.println("Хм, думаю стоит попробовать снова ;)");
    }
}