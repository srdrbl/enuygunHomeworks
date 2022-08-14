public class restAssured {
    package petStore;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    public class petStoreTest_RestAssured {

        Response response;

        // ! change this variables to random number
        String id = "5";
        String petId = "5";
        String quantity = "5";
        String body = "{\r\n  \"id\":"+ id +",\r\n  \"petId\":" + petId + ",\r\n  \"quantity\":" + quantity + ",\r\n  \"shipDate\": \"2022-07-29T17:50:33.212Z\",\r\n  \"status\": \"placed\",\r\n  \"complete\": true\r\n}";


        Store store = new Store();


        JSONObject request = new JSONObject();

        @Test
        @Order(1)
        public void getInventoryTest() {

            String url = "https://petstore.swagger.io/v2/store/inventory";
            response = given().get(url);
            response.then().statusCode(200).log().all();

            Assertions.assertEquals(200,response.getStatusCode());

        }

        // * testing post order  api
        @Test
        @Order(2)
        public void postOrderTest() {

            request.put("id",5);
            request.put("petId",5);
            request.put("quantity",5);
            request.put("shipDate","2022-07-30T18:36:23.057+0000");
            request.put("status","placed");
            request.put("completed",true);
            baseURI = "https://petstore.swagger.io/v2/";
            response = given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(request)
                    .log().all()
                    .when()
                    .post("store/order");

            response
                    .then()
                    .log()
                    .all()
                    .statusCode(200);

            Assertions.assertEquals(200,response.getStatusCode());
        }





        // * testing get order api
        @Test
        @Order(3)
        public void getOrderByIdTest()  {

            String url = "https://petstore.swagger.io/v2/store/order/" + id;
            response = given().get(url);
            response.then().statusCode(200).log().all();

            Assertions.assertEquals(200,response.getStatusCode());

        }



        // * testing delete order api
        @Test
        @Order(4)
        public void delOrderByIdTest()  {

            String url = "https://petstore.swagger.io/v2/store/order/" + id;
            response = given().delete(url);
            response.then().statusCode(200).log().all();

            Assertions.assertEquals(200,response.getStatusCode());

        }

        // * testing delete order api (but not exist order)
        @Test
        @Order(5)
        public void delOrderByIdTest2()  {

            String url = "https://petstore.swagger.io/v2/store/order/" + id;
            response = given().delete(url);
            response.then().statusCode(404).log().all();

            Assertions.assertEquals(404,response.getStatusCode());

        }

        // * testing get order api (but not exist order)
        @Test
        @Order(6)
        public void getOrderByIdTest2()  {

            String url = "https://petstore.swagger.io/v2/store/order/" + id;
            response = given().get(url);
            response.then().statusCode(404).log().all();

            Assertions.assertEquals(404,response.getStatusCode());

        }

    }
}
