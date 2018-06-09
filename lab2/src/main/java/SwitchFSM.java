public class SwitchFSM extends FSM {

    protected States nextState(Events currentEvent) {
        switch (_currentState) {
            case q0:
                switch(currentEvent) {
                    case BACKSLASH:
                        return States.q1;
                    case SHARP:
                    case TILDE:
                    case PERCENT:
                    case LETTER:
                    case LETTER_D:
                    case ANY:
                    default:
                        return States.ERR;
                }

            case q1:
                switch(currentEvent) {
                    case LETTER_D:
                        return States.q2;
                    case SHARP:
                    case TILDE:
                    case PERCENT:
                    case LETTER:
                    case BACKSLASH:
                    case ANY:
                    default:
                        return States.ERR;
                }

            case q2:
                switch(currentEvent) {
                    case LETTER_D:
                        return  States.q2;
                    case PERCENT:
                        return States.q3;
                    case TILDE:
                        return States.q4;
                    case LETTER:
                        return States.q5;
                    case ANY:
                    case BACKSLASH:
                    case SHARP:
                    default:
                        return States.ERR;
                }

            case q3:
                switch(currentEvent) {
                    case SHARP:
                        return States.q6;
                    case ANY:
                    case BACKSLASH:
                    case LETTER:
                    case TILDE:
                    case PERCENT:
                    case LETTER_D:
                    default:
                        return States.ERR;
                }

            case q4:
                switch(currentEvent) {
                    case SHARP:
                        return States.q6;
                    case ANY:
                    case BACKSLASH:
                    case LETTER:
                    case TILDE:
                    case PERCENT:
                    case LETTER_D:
                    default:
                        return States.ERR;
                }

            case q5:
                switch(currentEvent) {
                    case SHARP:
                        return States.q6;
                    case LETTER:
                        return  States.q5;
                    case LETTER_D:
                    case ANY:
                    case BACKSLASH:
                    case TILDE:
                    case PERCENT:
                    default:
                        return States.ERR;
                }
            case q6:
                switch(currentEvent) {
                    case SHARP:
                    case ANY:
                    case BACKSLASH:
                    case LETTER:
                    case TILDE:
                    case PERCENT:
                    case LETTER_D:
                    default:
                        return States.END;
                }

            case ERR:
                default:
                    return States.ERR;
        }
    }
}
