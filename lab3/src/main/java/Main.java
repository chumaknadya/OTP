import MatrixManager.Matrix;
import MatrixManager.MatrixAnalyzer;

import java.util.Scanner;

public class Main {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        MatrixAnalyzer matrixAnalyzer = new MatrixAnalyzer();
        System.out.println("Matrix A");
        System.out.println(matrixAnalyzer.calc("A=[[6,8],[6,2]]"));
        System.out.println("Matrix B");
        System.out.println(matrixAnalyzer.calc("B=[[3,4],[5,8]]"));
        System.out.println("Inverse Matrix");
        System.out.println(matrixAnalyzer.calc("B^-1"));
        System.out.println("Adding operation");
        System.out.println(matrixAnalyzer.calc("A+B^-1"));
        System.out.println("Determinant of matrix");
        System.out.println(matrixAnalyzer.calc("det(A+B^-1)"));
        double[][] data = { {5,2}, {1,2} };
        Matrix m = new Matrix(data);
        System.out.println(m.toString());
    }


}