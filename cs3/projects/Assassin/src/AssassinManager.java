import java.util.ArrayList;

public class AssassinManager {
    private AssassinNode ring;
    private AssassinNode graveyard;
    public AssassinManager(ArrayList<String> nameList) {
        if (nameList == null || nameList.size() == 0) throw new IllegalArgumentException();
        AssassinNode tracker = null;
        for (String s: nameList) {
            if (ring == null) {
                ring = new AssassinNode(s);
                tracker = ring; // next is null
            }
            else {
                tracker.next = new AssassinNode(s);
                tracker = tracker.next;
                tracker.next = ring; // make it circular
            }
        }
    }

    private void addGrave(AssassinNode killed, String killer) {
        killed.killer = killer;
        killed.next = null;
        if (graveyard == null) {
            graveyard = killed;
            return;
        }
        // else just add to the end
        AssassinNode tracker = graveyard;
        while (tracker.next != null) {
            tracker = tracker.next;
        }
        tracker.next = killed;
    }

    public void kill(String name) {
        if (name == null || ring == null) throw new IllegalArgumentException();
        if (ring.next == null) throw new IllegalStateException(); // should not remove entire node cause that's the winner
        if (!killRingContains(name)) throw new IllegalArgumentException(); // after checking winner
        AssassinNode tracker = ring; // tracker will be the node preceding toKill
        AssassinNode toKill;
        while (true) {
            if (tracker.next.name.equalsIgnoreCase(name)) {
                toKill = tracker.next;
                break;
            }
            tracker = tracker.next;
        }

        if (toKill == ring) { // change ring Before changing its next by adding to the grave
            ring = ring.next;
        }

        tracker.next = toKill.next;
        if (tracker.next == tracker) {
            tracker.next = null; // prevent circular quirk
        }
        addGrave(toKill, tracker.name); // disconnect it
    }

    public boolean isGameOver() {
        return ring.next == null;
    }

    public String winner() {
        return isGameOver() ? ring.name:null;
    }

    public String graveyard() {
        return backwardsGraveyard(graveyard);
    }

    private String backwardsGraveyard(AssassinNode tracker) { // recursive beauty
        return tracker == null? "":String.format("%s  %s was killed by %s\n", backwardsGraveyard(tracker.next), tracker.name, tracker.killer);
    }

    public String killRing() {
        if (ring.next == null) {
            return ring.name + " won the game!";
        }
        StringBuilder output = new StringBuilder();
        AssassinNode tracker = ring;
        while (true) {
            output.append("  ").append(tracker.name).append(" is stalking ");
            if (tracker.next == ring) {
                output.append(ring.name).append("\n");
                break;
            }
            else {
                output.append(tracker.next.name).append("\n");
            }
            tracker = tracker.next;
        }
        return output.toString();
    }

    public boolean graveyardContains(String name) { // non circular
        AssassinNode tracker = graveyard;
        while (tracker != null) {
            if (tracker.name.equalsIgnoreCase(name)) {
                return true;
            }
            tracker = tracker.next;
        }
        return false;
    }

    public boolean killRingContains(String name) {
        if (ring.name.equalsIgnoreCase(name)) return true;
        AssassinNode tracker = ring.next;
        while (tracker != null && tracker != ring) { // circular, check ring
            if (tracker.name.equalsIgnoreCase(name)) {
                return true;
            }
            tracker = tracker.next;
        }
        return false;
    }

    /**
     * Each AssassinNode object represents a single node in a linked list
     * for a game of Assassin.
     */
    private static class AssassinNode {
        public final String name;  // this person's name
        public String killer;      // name of who killed this person (null if alive)
        public AssassinNode next;  // next node in the list (null if none)
        
        /**
         * Constructs a new node to store the given name and no next node.
         */
        public AssassinNode(String name) {
            this(name, null);
        }

        /**
         * Constructs a new node to store the given name and a reference
         * to the given next node.
         */
        public AssassinNode(String name, AssassinNode next) {
            this.name = name;
            this.killer = null;
            this.next = next;
        }
    }
}
