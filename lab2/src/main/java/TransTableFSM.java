import java.util.Iterator;
import java.util.LinkedList;

public class TransTableFSM extends FSM {
    private LinkedList<Transition> transitions;

    public TransTableFSM() {
        transitions = new LinkedList<Transition>();
        buildTransitionTable();
    }
    public void addTransition(States startState,States endState,Events e){
        transitions.add(new Transition(startState,endState,e));
    }
    public void buildTransitionTable() {
        addTransition(States.q0,States.q1,Events.BACKSLASH);
        addTransition(States.q1,States.q2,Events.LETTER_D);
        addTransition(States.q2,States.q3,Events.PERCENT);
        addTransition(States.q2,States.q4,Events.TILDE);
        addTransition(States.q2,States.q5,Events.LETTER);
        addTransition(States.q2,States.q2,Events.LETTER_D);
        addTransition(States.q3,States.q6,Events.SHARP);
        addTransition(States.q4,States.q6,Events.SHARP);
        addTransition(States.q5,States.q6,Events.SHARP);
        addTransition(States.q5,States.q5,Events.LETTER);
    }
    protected States nextState(Events currentEvent) {
        Iterator<Transition> iter = transitions.iterator();
        while (iter.hasNext()) {
            Transition transition = iter.next();
            if (_currentState == transition._startEvent && currentEvent == transition._trigger) {
                return transition._endEvent;
            }
        }
        return States.ERR;
    }

}
