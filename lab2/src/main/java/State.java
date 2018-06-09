public  abstract class State {
    abstract void handle(StateFSM fsm, Events currentEvents);
}
