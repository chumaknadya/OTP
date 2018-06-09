public class Q2 extends State {
    @Override
    void handle(StateFSM fsm, Events currentEvents) {
        switch(currentEvents) {
            case BACKSLASH:
            case SHARP:
            case TILDE:
                fsm.setState(new Q4());
                break;
            case PERCENT:
                fsm.setState(new Q3());
                break;
            case LETTER:
                fsm.setState(new Q5());
                break;
            case LETTER_D:
                fsm.setState(new Q2());
                break;
            case ANY:
            default:
                fsm.setState(new ERR());
                break;
        }
    }
    public String toString() {
        return "q2";
    }
}
