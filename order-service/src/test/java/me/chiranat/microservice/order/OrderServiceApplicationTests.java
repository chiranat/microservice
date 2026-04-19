package me.chiranat.microservice.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MySQLContainer;

import io.restassured.RestAssured;
import me.chiranat.microservice.order.stubs.InventoryClientStub;

import static org.assertj.core.api.Assertions.assertThat;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
class OrderServiceApplicationTests {

	@ServiceConnection
	static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.3.0");
	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setup() {
		RestAssured.port = port;
		RestAssured.baseURI = "http://localhost";
	}

	static {
		mySQLContainer.start();
	}

	@Test
	void shouldPlaceOrder() {
		String placeOrderJson = """
				{
				    "skuCode":"Iphone 17",
				    "price": 999.00,
				    "quantity":1
				}
				""";

		InventoryClientStub.stubInventoryCall("Iphone 17", 1);

		var responseBodyString = RestAssured.given()
				.contentType("application/json")
				.body(placeOrderJson)
				.when()
				.post("/api/orders")
				.then()
				.statusCode(201)
				.extract()
				.body().asString();
		assertThat(responseBodyString)
				.contains("Iphone 17")
				.contains("999")
				.contains("1");
	}

}
