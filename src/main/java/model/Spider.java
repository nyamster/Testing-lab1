package model;

public class Spider {
    private final String name, role;

    public Spider(String name, String role) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Illegal name param!");
        }

        if (role.isBlank()) {
            throw new IllegalArgumentException("Illegal role param!");
        }

        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}
