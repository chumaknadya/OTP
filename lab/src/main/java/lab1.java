

import java.util.Scanner;
public class lab1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter The Number Of Matrix Rows and Columns(Rows==Columns)");
        int matrixRow = scan.nextInt();
        double[][] matrix = new double[matrixRow][matrixRow];
        System.out.println("Enter a Matrix A");
        enterMatrixData(scan, matrix, matrixRow, matrixRow);
        Matrix matrixA = new Matrix(matrix);
        System.out.println("Enter a Matrix B");
        double[][] mat = new double[matrixRow][matrixRow];
        enterMatrixData(scan, mat, matrixRow, matrixRow);
        Matrix matrixB = new Matrix(mat);
        matrixA.PrintMatrix();
        System.out.println("---------------------------");
        matrixB.PrintMatrix();
        System.out.println("if matrix A and B are equals: "+ matrixA.Equals(matrixB));
        System.out.println("Adding A + B");
        matrixA.Plus(matrixB).PrintMatrix();
        System.out.println("Inverse Matrix A:");
        System.out.println(matrixA.inverseMatrix().toString());
        System.out.println("Determinant: " +matrixA.Determinant());
    }
    public static void enterMatrixData(Scanner scan, double[][] matrix, int matrixRow, int matrixCol){
        System.out.println("Enter Matrix Data");
        for (int i = 0; i < matrixRow; i++) {
            for (int j = 0; j < matrixCol; j++) {
                System.out.printf("Row %d,Column %d: ",i,j);
                matrix[i][j] = scan.nextDouble();
            }
        }
    }
}
