package eMarket;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import eMarket.controller.ProductController;
import eMarket.domain.Product;
import eMarket.controller.OrderController;
import eMarket.domain.Order;
import eMarket.controller.ItemController;
import eMarket.domain.Item;


@WebAppConfiguration
@ContextConfiguration(classes = {ProductController.class,OrderController.class,ItemController.class})
public class StepDefs {
	
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    private ResultActions result;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
	
    @Before("@logic")
    public void beforeScenario() {
    	EMarketApp.getStore().init();
    }

    @When("^I do a post \"([^\"]*)\" with id \"([^\"]*)\", name \"([^\"]*)\", description \"([^\"]*)\" and price \"([^\"]*)\"$")
    public void i_do_a_post_with_id_name_description_and_price(String request, String id, String name, String description, String price) throws Throwable {
    	result = this.mockMvc.perform(post(request)
    			.param("id", id)
    			.param("name", name)
    			.param("description", description)
    			.param("price", price));
    }

    @When("^I do a get \"([^\"]*)\"$")
    public void i_get(String arg1) throws Throwable {
		result = this.mockMvc.perform(get(arg1));
	}
    
    @Then("^I should see this view \"([^\"]*)\"$")
    public void i_should_see_this_view(String arg1) throws Throwable {
		result
		.andExpect(status().isOk())
		.andExpect(view().name(arg1));
    }    

    
    Product product;
    @Given("^I have a product with id \"([^\"]*)\", name \"([^\"]*)\", description \"([^\"]*)\" and price \"([^\"]*)\" in the catalogue$")
    public void i_have_a_product_with_id_name_description_and_price(int id, String name, String description, Double price) throws Throwable {
    	product = new Product(id,name,description,price);
    	EMarketApp.getStore().getProductList().add(product);
    }

    @When("^I edit description to \"([^\"]*)\" using \"([^\"]*)\"$")
    public void i_edit_description_to(String description, String request) throws Throwable {
        	result = this.mockMvc.perform(post(request)
        		.param("id", String.valueOf(product.getId()))
        		.param("name", product.getName())
        		.param("description", description)
        		.param("price", product.getPrice().toString()));
    }
    
    @Then("^the description should be \"([^\"]*)\" for product with id \"([^\"]*)\" in the catalogue$")
    public void the_description_should_be_for_product_with_id(String description, int productId) throws Throwable {
    	Product p2 = EMarketApp.getStore().getProductList().stream().filter(p -> (((Product) p).getId() == productId)).findAny().get();
    	assertThat(p2.getDescription(), is(description));
    }    
    
    boolean caughtException;
    @When("^I add a product with id \"([^\"]*)\", name \"([^\"]*)\", description \"([^\"]*)\" and price \"([^\"]*)\" using \"([^\"]*)\"$")
    public void i_add_a_product_with_id_name_description_and_price(String id, String name, String description, String price, String request) throws Throwable {
    	caughtException = false;
    	try {
	        result = this.mockMvc.perform(post(request)
	        		.param("id", id)
	        		.param("name", name)
	        		.param("description", description)
	        		.param("price", price));
    	} catch (Exception e) {
    		caughtException = true;
    	}
    }
    

	@Then("^I should get an exception$")
	public void i_should_get_an_exception() throws Throwable {
		assertThat(caughtException,is(true));
	}

    @Then("^the product stored with id \"([^\"]*)\" corresponds to name \"([^\"]*)\", description \"([^\"]*)\" and price \"([^\"]*)\"$")
    public void the_product_stored_with_id_corresponds_to_name_description_and_price(int id, String name, String description, Double price) throws Throwable {
        Product p2 = EMarketApp.getStore().getProductList().stream().filter(p -> (((Product) p).getId() == id)).findAny().get();
        assertThat(p2.getName(), is(name));
    	assertThat(p2.getDescription(), is(description));
    	assertThat(p2.getPrice(), is(price));
    }

    @When("^I delete the product with id \"([^\"]*)\" using \"([^\"]*)\"$")
    public void i_delete_the_product_with_id(String id, String request) throws Throwable {
    	result = this.mockMvc.perform(get(request)
    		.param("productId", id));
    }

    @Then("^the product with id \"([^\"]*)\" no longer exists in the catalogue$")
    public void the_product_with_id_no_longer_exists(int id) throws Throwable {
    	assertThat(EMarketApp.getStore().getProductList().stream().filter(p -> (((Product) p).getId() == id)).findAny().isPresent(), is(false));
    }
    
    
    
}
