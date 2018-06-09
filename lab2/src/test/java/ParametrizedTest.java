import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import org.junit.runners.Parameterized;
import java.util.*;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
public class ParametrizedTest {
    SwitchFSM switchFSM = new SwitchFSM();
    TransTableFSM transTableFSM = new TransTableFSM();
    StateFSM stateFSM = new StateFSM();


    //Value Source
    @DisplayName("Should return true")
    @ParameterizedTest
    @ValueSource(strings = {"\\d%#","\\d~#","\\da#","\\ddddddddffff#","\\ddddddd%#",
    "\\ddddd~#","\\daaaaaa#"})
    void FSMTrueTestWithValueSource(String scanString){
        assertAll("three implementations of the analyzer",
                ()-> assertTrue(switchFSM.scanString(scanString)),
                ()-> assertTrue(transTableFSM.scanString(scanString)),
                ()-> assertTrue(stateFSM.scanString(scanString))
        );

    }

    @DisplayName("Should return false")
    @ParameterizedTest
    @ValueSource(strings = {"","\\dss","d%#","d\\d%#","\\d~#f","\\d%%%%#","\\d~~~#"})
    void FSMfalseTestWithValueSource(String scanString){
        assertAll("three implementations of the analyzer",
                ()-> assertFalse(switchFSM.scanString(scanString)),
                ()-> assertFalse(transTableFSM.scanString(scanString)),
                ()-> assertFalse(stateFSM.scanString(scanString))
        );
    }
    //Method Source
    static Stream<Arguments> trueStrings () {
        return Stream.of(Arguments.of("\\ds#", true),
                Arguments.of("\\ddd%#", true),
                Arguments.of("\\ddd~#", true),
                Arguments.of("\\dddcccccc#", true),
                Arguments.of("\\drrrrr#", true));
    }
    static Stream<Arguments> falseStrings () {
        return Stream.of(Arguments.of("\\ds", false), Arguments.of("d\\d~#", false),
                         Arguments.of("\\d%#h", false),Arguments.of("\\d%%%%#", false),
                         Arguments.of("\\dddddddrrrrrr%h", false),Arguments.of(null, false));
    }
    @ParameterizedTest (name = "{index} => string = {0}, => {1}")
    @MethodSource(value = {"trueStrings", "falseStrings"})
    void testMethodSource(String scanString, boolean expected) {
        assertAll("three implementations of the analyzer",
                ()-> assertEquals(expected,switchFSM.scanString(scanString)),
                ()-> assertEquals(expected,transTableFSM.scanString(scanString)),
                ()-> assertEquals(expected,stateFSM.scanString(scanString))
        );
    }
    //CSVFileSource
    @ParameterizedTest  (name = "{index} => string = {0}, => {1}")
    @CsvFileSource(resources = "/testFsm.csv")
    void tesWithCsvFileSource(String scanString,boolean expected) {
        assertAll("three implementations of the analyzer",
                ()-> assertEquals(expected,switchFSM.scanString(scanString)),
                ()-> assertEquals(expected,transTableFSM.scanString(scanString)),
                ()-> assertEquals(expected,stateFSM.scanString(scanString))
        );
    }
    //Argument Source
    static class stringProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of("\\d%#", true), Arguments.of("\\d~#", true),
                    Arguments.of("\\da#", true), Arguments.of("\\ddddddddffff#", true),
                    Arguments.of("\\ddddd~#", true),Arguments.of("\\daaaaaa#", true),
                    Arguments.of("\\dss", false), Arguments.of("", false),
                    Arguments.of("d%#", false), Arguments.of("d\\d%#", false),
                    Arguments.of("\\d%%%%#", false), Arguments.of(null,false)
            );
        }
    }
    @ParameterizedTest (name = "{index} => string = {0}, => {1}")
    @ArgumentsSource(stringProvider.class)
    void testWithArgumentSource(String scanString,boolean expected) {
        assertAll("three implementations of the analyzer",
                ()-> assertEquals(expected,switchFSM.scanString(scanString)),
                ()-> assertEquals(expected,transTableFSM.scanString(scanString)),
                ()-> assertEquals(expected,stateFSM.scanString(scanString))
        );
    }

}
