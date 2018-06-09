public class Q1 extends State {
    @Override
    void handle(StateFSM fsm, Events currentEvents) {
        switch(currentEvents) {
            case LETTER_D:
                fsm.setState(new Q2());
                break;
            case BACKSLASH:
            case LETTER:
            case SHARP:
            case TILDE:
            case PERCENT:
            case ANY:
            default:
                fsm.setState(new ERR());
                break;
        }
    }
    public String toString() {
        return "q1";
    }
}
