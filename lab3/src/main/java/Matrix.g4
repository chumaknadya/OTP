grammar Matrix;

/*
 * Parser Rules
 */

root:
     input EOF                              # RootRule
;


input:
    assignment                              # ToSetVariable
    | sum NL? EOF                           # ExecuteExpression
;

assignment:
	VAR EQUAL input                         # MakeAssignment
;

sum:
    sum PLUS inverse                       # MakePlus
    | inverse                              # ToInverse
;
inverse:
    inverse INVERSE                        # MakeInverse
    | determinant                          # ToDeterminant
;

determinant:
     DETERMINANT determinant                # MakeDeterminant
     | atom                                 # ToAtom
;


atom:
    NUMBER                                  # MakeNumber
    | MATRIX                                # MakeMatrix
    | VAR                                   # Variable
    | LB sum RB                             # MakeBraces

;


// Variable
VAR : [a-cA-C_][a-cA-C_0-9]*;

// Values

NUMBER : '-'?([0-9]+ | [0-9]+'.'[0-9]+);
VECTOR : '['NUMBER(','WHITESPACE* NUMBER)*']' ;
MATRIX : '['VECTOR(','WHITESPACE* VECTOR)*']' ;

// Symbols

EQUAL : '=';
WHITESPACE : [ \n\t\r]+ -> skip;
LB: '(';
RB: ')';
NL: '\n';

// Operation symbols

PLUS : '+';
INVERSE: '^-1';
DETERMINANT: 'det';