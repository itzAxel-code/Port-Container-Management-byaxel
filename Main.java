import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayDeque<Container> containerStack = new ArrayDeque<>();
        ArrayDeque<Ship> shipQueue = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Port Container Management System ===");
            System.out.println("[1] Store container");
            System.out.println("[2] View containers");
            System.out.println("[3] Register ship");
            System.out.println("[4] View ships");
            System.out.println("[5] Load next ship");
            System.out.println("[0] Exit");
            System.out.print("Choice: ");
            int ch = Integer.parseInt(sc.nextLine());

            if (ch == 0) {
                System.out.println("Exiting...");
                break;
            }

            switch (ch) {
                case 1 -> {
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Description: ");
                    String desc = sc.nextLine();
                    System.out.print("Weight: ");
                    String wt = sc.nextLine();
                    Container c = new Container(id, desc, wt);
                    containerStack.push(c);
                    System.out.println("Stored: " + c);
                }
                case 2 -> {
                    if (containerStack.isEmpty()) {
                        System.out.println("No containers.");
                    } else {
                        System.out.println("TOP →");
                        for (Container c : containerStack) System.out.println(c);
                        System.out.println("← BOTTOM");
                    }
                }
                case 3 -> {
                    System.out.print("Ship name: ");
                    String name = sc.nextLine();
                    System.out.print("Captain: ");
                    String cap = sc.nextLine();
                    Ship s = new Ship(name, cap);
                    shipQueue.offer(s);
                    System.out.println("Registered: " + s);
                }
                case 4 -> {
                    if (shipQueue.isEmpty()) {
                        System.out.println("No ships.");
                    } else {
                        System.out.println("FRONT →");
                        for (Ship s : shipQueue) System.out.println(s);
                        System.out.println("← REAR");
                    }
                }
                case 5 -> {
                    if (containerStack.isEmpty() || shipQueue.isEmpty()) {
                        System.out.println("Cannot load. Need both containers and ships.");
                    } else {
                        Container c = containerStack.pop();
                        Ship s = shipQueue.poll();
                        System.out.println("Loaded: " + c + " → " + s);
                        System.out.println("Remaining containers: " + containerStack.size());
                        System.out.println("Remaining ships: " + shipQueue.size());
                    }
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
