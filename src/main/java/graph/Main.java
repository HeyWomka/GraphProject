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
        System.out.println("????????.. ?? ???????? ??????????????.. (^_^')");
    }

    private static void printMainMenu() {
        System.out.println(
                "\n???????????????? ????????\n"
                        + "1. ???????? ??????????\n"
                        + "2. ?????????? ??????????\n"
                        + "0. ?????? ???????????? ???? ???????????????????? o_O");
        System.out.print("??????????: ");
    }

    public static void printOutputMenu() {
        System.out.println(
                "\n????????????????, ?????? ???????????? ??????????????: \n"
                        + "1. ?????????????? ??????????????????\n"
                        + "2. ?????????????? ??????????????????????????\n"
                        + "3. ???????????? ??????????????????\n"
                        + "4. ???????? ?????? ?????????? ^_^\n"
                        + "0. ?????????????????? ?? ???????????????? ????????");
        System.out.print("??????????: ");
    }

    public static void errorChoice() {
        System.out.println("????, ?????????? ?????????? ?????????????????????? ?????????? ;)");
    }
}