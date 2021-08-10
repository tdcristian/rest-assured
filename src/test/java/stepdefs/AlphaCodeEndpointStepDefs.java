package stepdefs;

import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import world.World;

public class AlphaCodeEndpointStepDefs {
    private Response response;
    private World world;

    public AlphaCodeEndpointStepDefs(World world) {
        this.world = world;
    }


    @When("^I do a search by country code \"([^\"]*)\"$")
    public void iDoASearchByCountryCode(String countryCode) {
        response = RestAssured.given().log().all().when().get("https://restcountries.eu/rest/v2/{endpointName}/{CountryCode}", this.world.getEndpointName(), countryCode);
        this.world.setResponse(response);
    }


}
