package groomingSalon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

//    •	Field data – List that holds added pets
//•	Method add(Pet pet) – adds an entity to the data if there is an empty place in the grooming salon for the pet.
//            •	Method remove(String name) – removes the pet by given name, if such exists, and returns boolean.
//            •	Method getPet(String name, String owner) – returns the pet with the given name and owner or null if no such pet exists.
//            •	Getter getCount – returns the number of pets.
//•	getStatistics() – returns a String in the following format:
//    o	" The grooming salon has the following clients:
//    {name} {owner}
//    {name} {owner}
//   (…)"

    public void add(Pet pet) {
        if (capacity > this.data.size()) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet pet : this.data) {
            if (pet.getName().equals(name)) {
                return this.data.remove(pet);
            }
        }

        return false;
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : this.data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }

        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        return String.format("The grooming salon has the following clients:%n%s", this.data
                .stream()
                .map(p -> String.format("%s %s", p.getName(), p.getOwner()))
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
