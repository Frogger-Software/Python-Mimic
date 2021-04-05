package edu.csc413.interpreter.expression;

import edu.csc413.interpreter.ProgramState;
import edu.csc413.interpreter.statement.Statement;

import java.util.LinkedList;
import java.util.List;

public class FunctionCallExpression implements Expression {
    private String functionName;
    private List<Expression> parameterValues;

    public FunctionCallExpression(String functionName, List<Expression> parameterValues) {
        this.functionName = functionName;
        this.parameterValues = parameterValues;
    }

    @Override
    public int evaluate(ProgramState programState) {
        List<Integer> valuesList = new LinkedList<>();
        for(int i = 0; i < parameterValues.size(); i++){
            valuesList.add(parameterValues.get(i).evaluate(programState));//save values before we use new call frame
        }
        programState.addCallFrame();
        int i = 0;
        for (String parameterName : programState.getParameterNames(functionName)) {
            programState.setVariable(parameterName, valuesList.get(i));
            i++;
        }
        for (Statement statement : programState.getFunctionStatements(functionName)) {
            statement.run(programState);
            if (programState.hasReturnValue()) {
                int returnValue = programState.getReturnValue();
                programState.clearReturnValue();
                programState.removeCallFrame();
                return returnValue;
            }
        }
        programState.removeCallFrame();
        return -1;
    }
}
