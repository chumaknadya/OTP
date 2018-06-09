public class Q6 extends State {
    @Override
    void handle(StateFSM fsm, Events currentEvents) {
        switch(currentEvents) {
            case BACKSLASH:
            case SHARP:
            case TILDE:
            case PERCENT:
            case LETTER:
            case LETTER_D:
            case ANY:
            default:
                fsm.setState(new ERR());
                break;
        }
    }
    public String toString() {
        return "q6";
    }
}
