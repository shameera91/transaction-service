package com.app.transactionservice;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.app.transactionservice.dto.TransactionInputDTO;
import com.app.transactionservice.repository.TransactionRepository;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TransactionServiceApplicationTests {

    private static final String TRANSACTION_RESOURCE = "api/v1/transaction";
    private static final String TRANSACTION_BY_ID_RESOURCE = "api/v1/transaction/{id}";


    private static final Long PARENT_TRAN_ID = 345l;
    private static final String SERVICE_NAME = "service name";
    private static final String USER_NAME = "user one";
    private static final String USER_PROFILE_NAME = "profile one";
    private static final String SESSION_ID = "S00445";
    private static final String EXECUTION_TIME = "334";
    private static final Date REQUEST_TIME = new Date();

    TransactionInputDTO transactionInput;
    @LocalServerPort
    private int port;

    @Autowired
    TransactionRepository transactionRepository;

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;

        transactionInput = new TransactionInputDTO(PARENT_TRAN_ID, SERVICE_NAME, USER_NAME, USER_PROFILE_NAME,
                SESSION_ID, EXECUTION_TIME, REQUEST_TIME);

    }

    @AfterEach
    public void cleanUp() {
        this.transactionRepository.deleteAll();
    }

    @Test
    public void testSaveTransaction() {
        RestAssured.given().contentType(ContentType.JSON).body(transactionInput).post(TRANSACTION_RESOURCE + "/save")
                .then().statusCode(HttpStatus.SC_CREATED).body("transactionId", notNullValue())
                .body("parentTranId", equalTo(PARENT_TRAN_ID.intValue())).body("serviceName", equalTo(SERVICE_NAME))
                .body("userName", equalTo(USER_NAME)).body("userProfileName", equalTo(USER_PROFILE_NAME))
                .body("sessionId", equalTo(SESSION_ID));
    }

    @Test
    public void testGetTransactionById() {
        String responseString = RestAssured.given().contentType(ContentType.JSON).body(transactionInput).post(TRANSACTION_RESOURCE + "/save")
                .then().statusCode(HttpStatus.SC_CREATED).extract().asString();
        Long id = JsonPath.from(responseString).getLong("transactionId");

        RestAssured.given().contentType(ContentType.JSON).pathParam("id", id)
                .get(TRANSACTION_BY_ID_RESOURCE).then().statusCode(HttpStatus.SC_OK).body("transactionId", equalTo(id.intValue()));
    }

    @Test
    public void testGetTransactionWhenInvalidIdPresent() {
        String responseString = RestAssured.given().contentType(ContentType.JSON).body(transactionInput).post(TRANSACTION_RESOURCE + "/save")
                .then().statusCode(HttpStatus.SC_CREATED).extract().asString();
        Long id = JsonPath.from(responseString).getLong("transactionId");

        RestAssured.given().contentType(ContentType.JSON).pathParam("id", 2l)
                .get(TRANSACTION_BY_ID_RESOURCE).then().statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

    @Test
    public void testGetTransactionWhenEmptyIdPresent() {
        String responseString = RestAssured.given().contentType(ContentType.JSON).body(transactionInput).post(TRANSACTION_RESOURCE + "/save")
                .then().statusCode(HttpStatus.SC_CREATED).extract().asString();
        Long id = JsonPath.from(responseString).getLong("transactionId");

        RestAssured.given().contentType(ContentType.JSON).pathParam("id", "")
                .get(TRANSACTION_BY_ID_RESOURCE).then().statusCode(HttpStatus.SC_NOT_FOUND);
    }


}
