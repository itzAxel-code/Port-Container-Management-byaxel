public class Ship {
	String name, captain;

    Ship(String name, String captain) {
        this.name = name;
        this.captain = captain;
    }

    public String toString() {
        return name + " | Capt. " + captain;
    }
}
