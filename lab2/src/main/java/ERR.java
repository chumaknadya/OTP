public class ERR extends State {
    @Override
    void handle(StateFSM fsm, Events currentEvents) {
        fsm.setState(new ERR());
    }
    public String toString() {
        return "ERR";
    }
}
