package edu.csc413.interpreter.statement;

import edu.csc413.interpreter.ProgramState;
import edu.csc413.interpreter.expression.Expression;

public class ReturnStatement implements Statement {
    private Expression returnValue;

    public ReturnStatement(Expression expression) {
        this.returnValue = expression;
    }

    @Override
    public void run(ProgramState programState) {
        programState.setReturnValue(returnValue.evaluate(programState));
    }
}
