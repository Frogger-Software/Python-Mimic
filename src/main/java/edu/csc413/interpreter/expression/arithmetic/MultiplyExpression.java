package edu.csc413.interpreter.expression.arithmetic;

import edu.csc413.interpreter.ProgramState;
import edu.csc413.interpreter.expression.ArithmeticExpression;
import edu.csc413.interpreter.expression.Expression;

public class MultiplyExpression extends ArithmeticExpression {
    public MultiplyExpression(Expression lhs, Expression rhs) {
        super(lhs, rhs);
    }

    @Override
    public int evaluate(ProgramState programState) {
        return getLhsValue(programState) * getRhsValue(programState);
    }
}
