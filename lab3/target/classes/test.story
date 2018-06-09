Scenario: Expression with matrix
Given matrixAnalyzer
When matrix A=[[5,2],[1,4]]
Then should equal [ 5.0 2.0 ][ 1.0 4.0 ]
When matrix A
When matrix [ 5.0 2.0 ][ 1.0 2.0 ]
When matrix C=[[5,8].
Then should equal null
When matrix C=[[5]
Then should equal String index out of range: 7
When matrix 55=[[5,8]]
Then should equal 55
When matrix W
When matrix Variable is not defined
When matrix B=[[3,4],[5,8]]
Then should equal [ 3.0 4.0 ][ 5.0 8.0 ]
When matrix B^-1
Then should equal [ 2.0 -1.0 ][ -1.25 0.75 ]
When matrix A+B
Then should equal [ 8.0 6.0 ][ 6.0 12.0 ]
When matrix det(A)
Then should equal 18.0

Scenario: Expression with matrix operations
When matrix det([[5,2],[1,4]]+[[3,4],[5,8]]^-1)
Then should equal 33.5
When matrix det(A+B^-1)
Then should equal 33.5
When matrix C=det(A+B^-1)
Then should equal 33.5
When matrix C
Then should equal 33.5
When matrix det([[8,9],[55,3]] + [[3,4],[5]^-1)
Then should equal Invalid type.
When matrix det(A+a^-1)
Then should equal Variable is not defined



