package guild;

import java.util.LinkedHashMap;
import java.util.Map;

public class Guild {
    private String name;
    private int capacity;
    private Map<String, Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new LinkedHashMap<>();
    }

    public void addPlayer(Player player) {
        if (capacity > roster.size()) {
            roster.put(player.getName(), player);
        }
    }

    public boolean removePlayer(String name) {
        Player remove = this.roster.remove(name);

        return remove != null;
    }

    public int count() {
        return roster.size();
    }

    public void promotePlayer(String name) {
        if (this.roster.get(name) != null) {
            this.roster.get(name).setRank("Member");
        }
    }

    public void demotePlayer(String name) {
        if (this.roster.get(name) != null) {
            this.roster.get(name).setRank("Trial");
        }
    }

    public Player[] kickPlayersByClass(String clazz) {

        Player[] removedPlayers;

        removedPlayers = this.roster.values()
                .stream()
                .filter(p -> p.getClazz()
                        .equals(clazz))
                .toArray(Player[]::new);

        for (Player removedPlayer : removedPlayers) {
            this.roster.remove(removedPlayer.getName());
        }

        return removedPlayers;
    }

    public String report() {
        StringBuilder output = new StringBuilder();

        output.append("Players in the guild: " + this.name + ":" + System.lineSeparator());

        for (Player player : this.roster.values()) {
            output.append(String.format("Player %s: %s%n" +
                    "Rank: %s%n" +
                    "Description: %s%n", player.getName(), player.getClazz(), player.getRank(), player.getDescription()));
        }

        return output.toString().trim();
    }
}
