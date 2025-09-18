public class Container {
	String id, description, weight;

    Container(String id, String description, String weight) {
        this.id = id;
        this.description = description;
        this.weight = weight;
    }

    public String toString() {
        return id + " | " + description + " | " + weight;
    }
}
