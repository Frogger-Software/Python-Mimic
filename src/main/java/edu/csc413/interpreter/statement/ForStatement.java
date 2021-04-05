package edu.csc413.interpreter.statement;

import edu.csc413.interpreter.ProgramState;
import edu.csc413.interpreter.expression.Expression;

import java.util.List;

public class ForStatement implements Statement {
    private String loopVariable;
    Expression rangeStart;
    Expression rangeEnd;
    private List<Statement> bodyStatements;

    public ForStatement(
            String loopVariableName,
            Expression rangeStart,
            Expression rangeEnd,
            List<Statement> bodyStatements){
        this.loopVariable = loopVariableName;
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
        this.bodyStatements = bodyStatements;
    }
    @Override
    public void run(ProgramState programState) {
        programState.setVariable(loopVariable, rangeStart.evaluate(programState));// i = 0
        while (programState.getVariable(loopVariable) < rangeEnd.evaluate(programState)){//i < n
            for(Statement statement: bodyStatements){
                statement.run(programState);
            }
            programState.setVariable(loopVariable, programState.getVariable(loopVariable) + 1);//i++
        }
    }
}
