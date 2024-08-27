public class Event extends Task {
    private String from;
    private String to;

    public Event(String eventDescription, String from, String to) {
        super(eventDescription);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + this.from + " to: " + this.to + ")";
    }

    @Override
    public String toSaveRepresentation() {
        return "E | " + super.toSaveRepresentation() + " | " + this.from + " | " + this.to;
    }
}
