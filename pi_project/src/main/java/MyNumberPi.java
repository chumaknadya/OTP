import java.util.Arrays;

public class MyNumberPi {
    private static final int PI_LENGTH = 4000;
    public static void myPiNumber(String dayMonth){
        System.out.println("Calculating Pi ...");
        System.out.printf("Digits of Pi in base-16:");
        int [] digits = PiGenerator.computePiInHex(PI_LENGTH );
        System.out.println(Arrays.toString(digits));
        System.out.println("My Pi Day");
        char[] alphabet10 = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        String strDigit =  DigitsToStringConverter.convert(BaseTranslator.convertBase(digits,16,10,PI_LENGTH ),10,alphabet10);
        int myPiNumber = strDigit.indexOf(dayMonth);
        System.out.printf("My Bith %d --> %d",dayMonth,myPiNumber);
    }
    public static void main(String[] args) {
       myPiNumber("1910");
    }

}
