package MatrixManager;


import AntlrGen.MatrixBaseVisitor;
import AntlrGen.MatrixLexer;
import AntlrGen.MatrixParser;
import MatrixManager.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;

public class MatrixAnalyzer extends MatrixBaseVisitor<MatrixAnalyzer.Variable> {
    private HashMap<String, Variable> variables = new HashMap<>();
    public class Variable<T> {
        private T value;

        Variable(T value) {
            this.value = value;
        }

        public T getValue() {
            return this.value;
        }

        public Class getType() {
            return this.value.getClass();
        }

        public T setValue(T value) {
            T oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }


    @Override
    public Variable visitRootRule(AntlrGen.MatrixParser.RootRuleContext ctx) {
        return visit(ctx.input());
    }

    @Override
    public Variable visitToSetVariable(AntlrGen.MatrixParser.ToSetVariableContext ctx) {
        return visit(ctx.assignment());
    }

    @Override
    public Variable visitExecuteExpression(AntlrGen.MatrixParser.ExecuteExpressionContext ctx) {
        return visit(ctx.sum());
    }

    @Override
    public Variable visitMakeAssignment(AntlrGen.MatrixParser.MakeAssignmentContext ctx) {
        String variableName = ctx.VAR().getText();
        variables.put(variableName, visit(ctx.input()));
        return variables.get(variableName);
    }
    @Override
    public Variable visitToInverse(MatrixParser.ToInverseContext ctx) {
        return visit(ctx.inverse());
    }

    @Override public Variable visitMakePlus(MatrixParser.MakePlusContext ctx) {
        Variable variable0 = visit(ctx.inverse());
        Variable variable1 = visit(ctx.sum());
        if (variable0.getType() != Matrix.class || variable1.getType() != Matrix.class) {
            throw new ParseCancellationException("Invalid type.");
        }
        Matrix matrix0 = (Matrix) variable0.getValue();
        Matrix matrix1 = (Matrix) variable1.getValue();
        return new Variable<>(matrix0.Plus(matrix1));
    }

    @Override
    public Variable visitToDeterminant(MatrixParser.ToDeterminantContext ctx) {
        return visit(ctx.determinant());
    }

    @Override public Variable visitMakeInverse(MatrixParser.MakeInverseContext ctx) {
        Variable variable = visit(ctx.inverse());
        if (variable.getType() != Matrix.class) {
            throw new ParseCancellationException("Operand should be matrix");
        }
        Matrix matrix = (Matrix) variable.getValue();
        return new Variable<>(matrix.inverseMatrix());
    }

    @Override
    public Variable visitMakeDeterminant(MatrixParser.MakeDeterminantContext ctx) {
        Variable variable = visit(ctx.determinant());
        if (variable.getType() != Matrix.class) {
            throw new ParseCancellationException("Operand should be matrix");
        }
        Matrix matrix = (Matrix) variable.getValue();
        return new Variable<>(matrix.Determinant());
    }

    @Override
    public Variable visitToAtom(MatrixParser.ToAtomContext ctx) {
        return visit(ctx.atom());
    }

    @Override
    public Variable visitMakeNumber(MatrixParser.MakeNumberContext ctx) {
        return new Variable<>(Integer.parseInt(ctx.NUMBER().toString()));
    }

    @Override
    public Variable visitMakeMatrix(MatrixParser.MakeMatrixContext ctx) {
        return new Variable<>(Matrix.parseFromString(ctx.MATRIX().toString()));
    }

    @Override
    public Variable visitVariable(MatrixParser.VariableContext ctx) {
        String variableName = ctx.VAR().getText();
        Variable variable = variables.get(variableName);
        if(variable == null){
            throw new ParseCancellationException("Variable is not defined");
        }
        return variable;
    }

    @Override
    public Variable visitMakeBraces(MatrixParser.MakeBracesContext ctx) {
        return visit(ctx.sum());
    }
    public String calc(String expression) {
        try {
            CharStream input = CharStreams.fromString(expression);
            MatrixLexer lexer = new MatrixLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            MatrixParser parser = new MatrixParser(tokens);
            ParseTree tree = parser.input();
            return  this.visit(tree).getValue().toString();
        }catch (Exception e){
            return  e.getMessage();
        }

    }
}
