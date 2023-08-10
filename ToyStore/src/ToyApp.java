import java.util.InputMismatchException;
import java.util.Scanner;

public class ToyApp {

    public static void appStart(){
        try (Scanner scan = new Scanner(System.in)) {
            int choice;
            boolean invalidInput;

            do {
                invalidInput = false;
                System.out.println("Выберете, какой вариант рандомайзера вы хотите выбрать.");
                System.out.println("1 - Вариант чистого рандома основанный на весе игрушки");
                System.out.println("2 - Вариант более приближенный к соотношению 20/20/60");
                System.out.println("0 - Выйти из программы");


                try {
                    choice = scan.nextInt();
                    switch (choice) {
                        case 1:
                        case 2:
                            ToyShop.start(choice);
                            System.out.println("Успешно выполнено, проверьте resLog.");
                            choice = 0;
                            break;
                        case 0:
                            System.out.println("Программа завершена.");
                            break;
                        default:
                            System.out.println("Введена неправильная команда!");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Введена неверная команда. Пожалуйста, введите число.");
                    scan.next();
                    invalidInput = true;
                    choice = -1;
                }
            } while (invalidInput || choice != 0);

        }
    }
}
