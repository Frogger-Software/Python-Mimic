package edu.csc413.interpreter.statement;

import edu.csc413.interpreter.ProgramState;
import edu.csc413.interpreter.expression.Expression;

import java.util.List;

public class ForStatement extends BlockStatement {
    private String loopVariable;
    private Expression rangeStart;
    private Expression rangeEnd;

    public ForStatement(
            String loopVariableName,
            Expression rangeStart,
            Expression rangeEnd,
            List<Statement> bodyStatements) {
        super(null, bodyStatements);
        this.loopVariable = loopVariableName;
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
    }

    @Override
    public void run(ProgramState programState) {
        //int start = rangeStart.evaluate(programState);//waste of memory?
        int end = rangeEnd.evaluate(programState);

        programState.setVariable(loopVariable, rangeStart.evaluate(programState));// i = 0
        while (programState.getVariable(loopVariable) < end) {//i < n
            for (Statement statement : getStatements()) {
                statement.run(programState);
                if (programState.hasReturnValue()) {
                    return;
                }
            }
            programState.setVariable(loopVariable, programState.getVariable(loopVariable) + 1);//i++
        }
    }
}
