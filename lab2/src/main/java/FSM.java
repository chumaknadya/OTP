public class FSM {

    protected States _currentState;

    public FSM() {
        _currentState = States.q0;
    }

    private void start() {
        _currentState = States.q0;
    }
    public Events recognizeEvent(char currentSymbol) {
        switch(currentSymbol) {
            case '\\':
                 return Events.BACKSLASH;
            case '~':
                return Events.TILDE;
            case '%':
                return Events.PERCENT;
            case '#':
                return Events.SHARP;
            case 'd':
                return  Events.LETTER_D;
            case 'a':
            case 'b':
            case 'c':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
                return Events.LETTER;
        }
        return  Events.ANY;
    }
    public boolean scanString(String scanString) {
        if(scanString == null)
            return  false;
        start();
        for (int i = 0; i < scanString.length(); i++) {
            Events currentEvent = recognizeEvent(scanString.charAt(i));
            _currentState = nextState(currentEvent);
            if (_currentState == States.ERR) {
                return false;
            }
        }
        return _currentState == States.q6;
    }
    //default
    protected States nextState(Events currentEvent) {
        return States.ERR;
    }
}