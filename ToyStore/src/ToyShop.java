import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;

public class ToyShop {

    public static void start(int choice) {
        String[] toyLists = {"1 2 конструктор", "2 2 робот", "3 6 кукла"};

        PriorityQueue<Toy> toyQueue = new PriorityQueue<>((toy1, toy2) -> toy2.frequency - toy1.frequency);

        for (String toyString : toyLists) {
            String[] element = toyString.split(" ");
            int id = Integer.parseInt(element[0]);
            int frequency = Integer.parseInt(element[1]);
            String name = element[2];
            toyQueue.offer(new Toy(id, name, frequency));
        }

        Random random = new Random();

        if (choice == 1){
            try (FileWriter writer = new FileWriter("C:/learning/Toy_Store_for_GB/ToyStore/src/resLog.txt")) {
                for (int i = 0; i < 10; i++) {
                    Toy toySelect = Toy.getRandomToy(toyQueue, random);
                    writer.write("Выпала игрушка: " + toySelect.id + " " + toySelect.name + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (choice == 2) {
            try (FileWriter writer = new FileWriter("C:/learning/Toy_Store_for_GB/ToyStore/src/resLog.txt")) {
                for (int i = 0; i < 10; i++) {
                    Toy toySelect = Toy.getRandom602020(toyQueue, random);
                    writer.write("Выпала игрушка: " + toySelect.id + " " + toySelect.name + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
