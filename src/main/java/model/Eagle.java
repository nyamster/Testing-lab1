package model;

public class Eagle {
    private final String name, type;
    private Nest nest;

    public Eagle(String name, String type) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Illegal name param!");
        }

        if (type.isBlank()) {
            throw new IllegalArgumentException("Illegal type param!");
        }

        this.name = name;
        this.type = type;
    }

    public int buildNest(Material material) {
        this.nest = new Nest(material);
        return this.nest.getSafety();
    }

    public boolean checkSafety() {
        if (this.nest == null) {
            throw new IllegalArgumentException("Build nest first!");
        }

        if (this.nest.getSafety() < 90) {
            System.out.println("Птенец не прошел естественный отбор(");
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
