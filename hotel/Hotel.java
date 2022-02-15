package hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (capacity > this.roster.size()) {
            roster.add(person);
        }
    }

    public boolean remove(String name) {
        for (Person person : this.roster) {
            if (person.getName().equals(name)) {
                this.roster.remove(person);
                return true;
            }
        }

        return false;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return this.roster.size();
    }

    public Person getPerson(String name, String hometown) {

        for (Person p : this.roster) {
            if (p.getName().equals(name) && p.getHometown().equals(hometown)) {
                return p;
            }
        }

        return null;
    }

    public String getStatistics() {
        return String.format("The people in the hotel %s are:%n%s", this.name, this.roster
                .stream()
                .map(Person::toString)
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
