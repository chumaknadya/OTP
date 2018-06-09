public class Q5 extends State {
    @Override
    void handle(StateFSM fsm, Events currentEvents) {
        switch(currentEvents) {
            case SHARP:
                fsm.setState(new Q6());
                break;
            case LETTER:
                fsm.setState(new Q5());
                break;
            case BACKSLASH:
            case TILDE:
            case PERCENT:
            case LETTER_D:
            case ANY:
            default:
                fsm.setState(new ERR());
                break;
        }
    }
    public String toString() {
        return "q5";
    }
}
