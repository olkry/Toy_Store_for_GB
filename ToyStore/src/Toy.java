import java.util.PriorityQueue;
import java.util.Random;

public class Toy {
    int id;
    String name;
    int frequency;

    public Toy(int id, String name, int frequency) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }

    public static Toy getRandomToy(PriorityQueue<Toy> queue, Random random) {
        int allToyWeight = queue.stream().mapToInt(t -> t.frequency).sum();
        int takeRandomToy = random.nextInt(allToyWeight);
        for (Toy toy : queue) {
            takeRandomToy -= toy.frequency;
            if (takeRandomToy < 0) {
                return toy;
            }
        }
        return queue.peek();
    }

    public static Toy getRandom602020(PriorityQueue<Toy> queue, Random random) {
        int randNum = random.nextInt(100);

        if (randNum < 20) {
            return queue.stream().filter(toy -> toy.id == 1).findFirst().orElse(queue.peek());
        } else if (randNum < 40) {
            return queue.stream().filter(toy -> toy.id == 2).findFirst().orElse(queue.peek());
        } else {
            return queue.stream().filter(toy -> toy.id == 3).findFirst().orElse(queue.peek());
        }
    }

}
