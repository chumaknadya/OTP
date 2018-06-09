import MatrixManager.MatrixAnalyzer;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static junit.framework.Assert.assertEquals;


public class Steps {

    private MatrixAnalyzer matrixAnalyzer;
    private String result;
    private Exception exception;

    @Given("matrixAnalyzer")
    public void evaluator() {
        matrixAnalyzer = new MatrixAnalyzer();
    }


    @When("matrix $string")
    public void evaluate(String string) {
        result = matrixAnalyzer.calc(string);
        if(result == null){
            result = "null";
        }
    }

    @Then("should equal $expected")
    public void shouldEqual(String expected) {
        assertEquals(expected, result);
    }
}
