package org.example;

public class Guerreo extends Personaje{

    private String id;
    public Guerreo() {
        super(15);
        this.id = "1"+super.getId();
    }

    @Override
    public String toString() {
        return "Guerreo{" +
                "id='" + id + '\'' +
                '}';
    }
}
