public class Q3 extends State {
    @Override
    void handle(StateFSM fsm, Events currentEvents) {
        switch(currentEvents) {
            case SHARP:
                fsm.setState(new Q6());
                break;
            case TILDE:
            case PERCENT:
            case BACKSLASH:
            case LETTER:
            case LETTER_D:
            case ANY:
            default:
                fsm.setState(new ERR());
                break;
        }
    }
    public String toString() {
        return "q3";
    }
}
