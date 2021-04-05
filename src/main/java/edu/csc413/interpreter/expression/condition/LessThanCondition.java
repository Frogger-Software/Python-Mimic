package edu.csc413.interpreter.expression.condition;

import edu.csc413.interpreter.ProgramState;
import edu.csc413.interpreter.expression.Condition;
import edu.csc413.interpreter.expression.Expression;

public class LessThanCondition extends Condition {
    public LessThanCondition(Expression lhs, Expression rhs) {
        super(lhs, rhs);
    }

    @Override
    public boolean evaluate(ProgramState programState) {
        return getLhsValue(programState) < getRhsValue(programState);
    }
}
