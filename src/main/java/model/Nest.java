package model;

public class Nest {
    private Material material;
    private int safety;

    public Nest(Material material) {
        this.material = material;
        switch(material) {
            case PAPER:
                this.safety = 95;
                break;
            case WOOD:
                this.safety = 80;
                break;
            case STONE:
                this.safety = 90;
                break;
            case GARBAGE:
                this.safety = 60;
                break;
        }
    }

    public int getSafety() {
        return safety;
    }
}
