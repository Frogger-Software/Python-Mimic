package edu.csc413.interpreter.expression.condition;

import edu.csc413.interpreter.ProgramState;
import edu.csc413.interpreter.expression.Condition;
import edu.csc413.interpreter.expression.Expression;

public class EqualsCondition extends Condition {
    public EqualsCondition(Expression lhs, Expression rhs) {
        super(lhs, rhs);
    }

    @Override
    public boolean evaluate(ProgramState programState) {
        return getLhsValue(programState) == getRhsValue(programState);
    }
}
