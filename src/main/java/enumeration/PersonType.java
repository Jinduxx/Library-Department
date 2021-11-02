package enumeration;

public enum PersonType {
    TEACHER(3),
    SENIOR_STUDENT(2),
    JUNIOR_STUDENT(1);

    private int priority;

    PersonType(int priority){
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
