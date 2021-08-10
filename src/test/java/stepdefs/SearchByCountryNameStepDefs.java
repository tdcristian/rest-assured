package stepdefs;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import world.World;

public class SearchByCountryNameStepDefs {

    private Response response;
    private World world;

    public SearchByCountryNameStepDefs(World world) {
        this.world = world;
    }


    @When("^I do a search by country with name \"([^\"]*)\"$")
    public void iDoASearchByCountryWithName(String countryName) {
        response = RestAssured.given().log().all()
                .get("https://restcountries.eu/rest/v2/{endpointName}/{countryName}", this.world.getEndpointName(), countryName);
        this.world.setResponse(response);
    }

    @Then("^I have (\\d+) results? returned$")
    public void iHaveResultReturned(int resultsNumber) {
        if (response == null) {
            response = this.world.getResponse();
            response.then().body("alpha2Code", Matchers.is("RO"));
        } else
            response.then().statusCode(HttpStatus.SC_OK)
                    .body("size()", Matchers.is(resultsNumber));
        this.world.setResponse(response);
    }

    @And("^I have first country code \"([^\"]*)\"$")
    public void iHaveFirstCountryCode(String firstCountryCode) {
        response.then().body("[0].alpha2Code", Matchers.is(firstCountryCode));
        this.world.setResponse(response);
    }

    @And("^I have the second country code \"([^\"]*)\"$")
    public void iHaveTheSecondCountryCode(String secondCountryCode) {
        response.then().body("[0].alpha3Code", Matchers.is(secondCountryCode));
        this.world.setResponse(response);
    }
}