

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    public double[] convertToArray(double[][] arr) {
        double newArray[] = new double[arr.length*arr[0].length];
        for(int i = 0; i < arr.length; i++) {
            double[] row = arr[i];
            for(int j = 0; j < row.length; j++) {
                double number = arr[i][j];
                newArray[i*row.length+j] = number;
            }
        }
        return newArray;
    }
     @Test
     public void matrixOf0sConstructorTest(){
         Matrix matrix = new Matrix(2,2);
         double [][]A = new double[][]{{0,0},{0,0}};
         assertArrayEquals(convertToArray(A),matrix.toArray());
     }
     @Test
     public void matrixWithDataConstructorTest(){
         double [][] A = {
                 {0.8,1.6},
                 {7.9,6.2}
         };
         Matrix matrixA = new Matrix(A);
         double [][]B = new double[][]{
                 {0.8,1.6},
                 {7.9,6.2}
         };
         assertArrayEquals(convertToArray(B),matrixA.toArray());
     }
     @Test
     public void equalMatrixTest(){
         double [][] A = {
                 {0.5,1.6,0.8,8.9},
                 {4.2,4.7,1,6.8},
                 {0.8,34.5,2.7,3.5},
                 {4.6,7.6,2.3,6.1}
         };
         double [][] B = {
                 {0.5,1.6,0.8,8.9},
                 {4.2,4.7,1,6.8},
                 {0.8,34.5,2.7,3.5},
                 {4.6,7.6,2.3,6.1}
         };
         Matrix matrixA = new Matrix(A);
         Matrix matrixB = new Matrix(B);
         assertTrue(matrixA.Equals(matrixB));
     }
     @Test
     public void toStringTest(){
        double [][]A = new double[][]{
                {1,2},
                {2,3}
        };
        Matrix matrixA = new Matrix(A);
        assertEquals("1.0\t2.0\t2.0\t3.0\t",matrixA.toString());
     }
    @Test
    public void toStringOneElementMatrixTest(){
        double [][]A = new double[][]{
                {0}
        };
        Matrix matrixA = new Matrix(A);
        assertNotEquals("0\t",matrixA.toString());
    }
     @Test
     public void plusTest(){
         double [][] A = {
                 {0,1},
                 {7,6}
         };
         double [][] B = {
                 {1,2},
                 {3,4}
         };
         Matrix matrixA = new Matrix(A);
         Matrix matrixB = new Matrix(B);
         double [][]C = new double[][]{
                 {1,3},
                 {10,10}
         };
         assertArrayEquals(convertToArray(C),matrixA.Plus(matrixB).toArray());

     }
     @Test
     public void adjoint2MatrixTest(){
         double [][] A = {
                 {3,4},
                 {1,5}
         };
         Matrix matrixA = new Matrix(A);
         assertArrayEquals(convertToArray(new double[][]{{5,-4},{-1,3}}),matrixA.adjoint().toArray());

     }
    @Test
    public void adjoint1MatrixTest(){
        double [][] A = {{3}};
        Matrix matrixA = new Matrix(A);
        assertArrayEquals(convertToArray(new double[][]{{1}}),matrixA.adjoint().toArray());

    }
     @Test
     public void inverseTest(){
         double [][] A = {
                 {2,5,7},
                 {6,3,4},
                 {5,-2,-3}
         };
         Matrix matrixA = new Matrix(A);
         assertArrayEquals(convertToArray(new double[][]{{1,-1,1},{-38,41,-34},{27,-29,24}}),matrixA.inverseMatrix().toArray());
     }
     @Test
     public void determinant4MatrixTest(){
        double [][] A = {
                {0.5,1.6,0.8,8.9},
                {4.2,4.7,1,6.8},
                {0.8,34.5,2.7,3.5},
                {4.6,7.6,2.3,6.1}


        };
        Matrix matrixA = new Matrix(A);
        assertEquals(matrixA.Determinant(),-1285.1784,0.001);
     }
     @Test
     public void determinant3MatrixTest(){
         double [][] A = {
                 {0,1,0},
                 {4,4,1},
                 {0,34,2}
         };
         Matrix matrixA = new Matrix(A);
         assertEquals(matrixA.Determinant(),-8.0,0.001);
     }
     @Test
     public void determinant2MatrixTest(){
         double [][] C = {
                 {3.2,1},
                 {-3.29,4.8}
         };
         Matrix matrixC = new Matrix(C);
         assertEquals(matrixC.Determinant(),18.65,0.001);
     }
     @Test
     public void determinant1MatrixTest(){
         double[][]D ={{3}};
         Matrix matrixD = new Matrix(D);
         assertEquals(matrixD.Determinant(),3.0,0.001);
     }
    @Test
    public void addingMatrixOtherSizeExceptionTest(){
          double [][] A = new double[][] {
                    {0,2},
                    {0,4}
          };
          double [][]B = new double [][]{
                  {0,4,2},
                  {8,3,1}
          };
           Matrix matrixA = new Matrix(A);
           Matrix matrixB = new Matrix(B);
           Throwable exception = assertThrows(RuntimeException.class, () -> {
                matrixA.Plus(matrixB);
           });
           assertEquals("Illegal matrix dimensions.", exception.getMessage());
    }
    @Test
    public void equalMatrixExceptionTest(){
        double [][] A = new double[][] {
                {0,2},
                {0,4}
        };
        double [][]B = new double [][]{
                {0,4,2},
                {8,3,1}
        };
        Matrix matrixA = new Matrix(A);
        Matrix matrixB = new Matrix(B);
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            matrixA.Equals(matrixB);
        });
        assertEquals("Illegal matrix dimensions.", exception.getMessage());
    }
    @Test
    public void inverseMatrixExceptionTest(){
         double [][]A = new double [][]{
                 {0,23,0},
                 {0,4,0},
                 {0,7,8}
         };
         Matrix matrixA = new Matrix(A);
         Throwable exception = assertThrows(RuntimeException.class, () -> {
            matrixA.inverseMatrix();
         });
         assertEquals("Division by zero", exception.getMessage());

    }
    @Test
    public void determinantExceptionTest(){
        double [][]A = new double [][]{
                {0,23,0},
                {0,4,0}
        };
        Matrix matrixA = new Matrix(A);
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            matrixA.Determinant();
        });
        assertEquals("Is not square matrix", exception.getMessage());
    }
    @Test
    public void  inverseExceptionTest(){
        double [][]A = new double [][]{
                {0,23,0},
                {0,4,0}
        };
        Matrix matrixA = new Matrix(A);
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            matrixA.inverseMatrix();
        });
        assertEquals("Is not square matrix", exception.getMessage());
    }
    @Test
    public void adjointExceptionTest(){
        double [][]A = new double [][]{
                {0,23,0},
                {0,4,0}
        };
        Matrix matrixA = new Matrix(A);
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            matrixA.adjoint();
        });
        assertEquals("Is not square matrix", exception.getMessage());
    }


}