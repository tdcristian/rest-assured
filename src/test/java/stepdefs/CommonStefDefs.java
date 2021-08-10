package stepdefs;

import cucumber.api.java.en.Given;
import world.World;

public class CommonStefDefs {
    public World world;

    public CommonStefDefs(World world) {
        this.world = world;
    }

    @Given("^I have the \"([^\"]*)\" endpoint available$")
    public void iHaveTheEndpointAvailable(String endpointName) {
        this.world.setEndpointName(endpointName);
    }
}
