
public class Transition {
    protected States _startEvent;
    protected States _endEvent;
    protected Events _trigger;

    public Transition(States startEvent, States endEvent, Events currentEvent) {
        _startEvent = startEvent;
        _endEvent = endEvent;
        _trigger = currentEvent;
    }
}
