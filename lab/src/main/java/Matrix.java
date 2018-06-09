

public class Matrix {
    private  int M;             // number of rows
    private  int N;             // number of columns
    private  double[][] data;   // M-by-N array

    // create M-by-N matrix of 0's
    public Matrix(int M, int N) {
        this.M = M;
        this.N = N;
        data = new double[M][N];
    }
    // create matrix based on 2d array
    public Matrix(double[][] data) {
        M = data.length;
        N = data[0].length;
        this.data = new double[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                this.data[i][j] = data[i][j];
            }
        }
    }

    // copy constructor
    private Matrix(Matrix A) { this(A.data); }

    public double[] toArray() {
        double newArray[] = new double[this.data.length*this.data[0].length];
        for(int i = 0; i < this.data.length; i++) {
            double[] row = this.data[i];
            for(int j = 0; j < row.length; j++) {
                double number = this.data[i][j];
                newArray[i*row.length+j] = number;
            }
        }
        return newArray;
    }

    // print matrix to standard output
    public void PrintMatrix() {
        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                System.out.printf("%9.3f ", data[i][j]);
            }
            System.out.println();
        }
    }

    // adding matrix (Example: A + B)
    public Matrix Plus(Matrix B) {
        Matrix A = this;
        if (B.M != A.M || B.N != A.N) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(M, N);
        for (int i = 0; i < A.M; i++)
            for (int j = 0; j < A.N; j++)
                C.data[i][j] = A.data[i][j] + B.data[i][j];
        return C;
    }

    public boolean Equals(Matrix B) {
        Matrix A = this;
        if (!isMatricesOfTheSameSize(A,B)) throw new RuntimeException("Illegal matrix dimensions.");
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                if (A.data[i][j] != B.data[i][j]) return false;
        return true;
    }
   // @Override
    public String toString(){
        String str ="";
        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                str += data[i][j] + "\t";
            }
        }
        return str;
    }

    private Matrix multiplyByConstant(Matrix matrix,double constant) {
        Matrix res = new Matrix(N,M);
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++){
                res.data[i][j] = matrix.data[i][j]*constant;
            }
        }
        return res;
    }
    public Matrix inverseMatrix(){
        Matrix adjoint = adjoint();
        double det = determinant(this.data,this.N);
        if (det != 0){
            Matrix res =  multiplyByConstant(adjoint,1/det);
            return res;
        }
        throw new RuntimeException("Division by zero");
    }

    public double Determinant() {
        return determinant(this.data,this.N);
    }

    private boolean isSquareMatrix(double [][]A){
        if(A[0].length == A.length)
            return true;
        return false;
    }

    private boolean isMatricesOfTheSameSize (Matrix A,Matrix B) {
        if(A.N == B.N && A.M == B.M)
            return true;
        return false;
    }

    private double determinant(double A[][], int n){
        if (!isSquareMatrix(A))
            throw new RuntimeException("Is not square matrix");
        double D = 0;
        if (n == 1)
            return A[0][0];
        double temp[][] = new double[n][n];
        int sign = 1;
        for (int f = 0; f < n; f++) {
            temp = getCofactor(A, 0, f, n);
            D += sign * A[0][f] * determinant(temp, n - 1);
            sign = -sign;
        }

        return D;
    }
    // Function to get adjoint of A[N][N] in adj[N][N].
    public  Matrix  adjoint() {
        Matrix A = this;
        Matrix res = new Matrix(M,N);
        if (!isSquareMatrix(A.data))
            throw new RuntimeException("Is not square matrix");
        if (A.N == 1) {
            res.data[0][0] = 1;
            return res;
        }
        int sign = 1;
        double temp[][] = new double[A.N][A.N];
        for (int i=0; i< N; i++) {
            for (int j=0; j< N; j++) {
                temp = getCofactor(A.data, i, j, A.N);
                sign = ((i+j)%2 == 0)? 1: -1;
                res.data[j][i] = (sign)*(determinant(temp,A.N-1));
            }
        }
        return res;
    }
    // Function to get cofactor of A[p][q] in temp[][]. n is current
    // dimension of A[][]
    private double[][] getCofactor(double[][] A, int p, int q, int n) {
        int i = 0, j = 0;
        double[][] temp = new double[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++){
                if (row != p && col != q) {
                    temp[i][j++] = A[row][col];
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }

        return temp;

    }
}
