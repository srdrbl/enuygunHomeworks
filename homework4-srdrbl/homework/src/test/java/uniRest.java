public class uniRest {
    ackage petStore;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


    @TestMethodOrder(OrderAnnotation.class)
    public class petStoreTest_Unirest {


        // ! change this random number
        String id = "5";
        String petId = "5";
        String quantity = "5";

        // * body
        String body = "{\r\n  \"id\":"+ id +",\r\n  \"petId\":" + petId + ",\r\n  \"quantity\":" + quantity + ",\r\n  \"shipDate\": \"2022-07-29T17:50:33.212Z\",\r\n  \"status\": \"placed\",\r\n  \"complete\": true\r\n}";

        // * testing get inventory api

        @Test
        @Order(1)
        public void getInventoryTest() throws UnirestException {

            // * unirest from postman
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.get("https://petstore.swagger.io/v2/store/inventory")
                    .asString();

            // * check status
            Assertions.assertEquals(200,response.getStatus());
        }

        // * testing post order  api
        @Test
        @Order(2)
        public void postOrderTest() throws UnirestException, InterruptedException {

            // * unirest from postman
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.post("https://petstore.swagger.io/v2/store/order")
                    .header("Content-Type", "application/json")
                    .body(body)
                    .asString();

            // * check status
            Assertions.assertEquals(200,response.getStatus());
        }

        // * testing get order api
        @Test
        @Order(3)
        public void getOrderByIdTest() throws UnirestException, InterruptedException {

            // * unirest from postman
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.get("https://petstore.swagger.io/v2/store/order/" + id)
                    .asString();

            // * check status
            Assertions.assertEquals(200,response.getStatus());
        }

        // * testing delete order api
        @Test
        @Order(4)
        public void delOrderByIdTest() throws UnirestException, InterruptedException {

            // * unirest from postman
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.delete("https://petstore.swagger.io/v2/store/order/" + id)
                    .asString();

            // * check status
            Assertions.assertEquals(200,response.getStatus());
        }

        // * testing delete order api (but not exist order)
        @Test
        @Order(5)
        public void delOrderByIdTest2() throws UnirestException, InterruptedException {

            // * unirest from postman
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.delete("https://petstore.swagger.io/v2/store/order/" + id)
                    .asString();

            // * check status
            Assertions.assertEquals(404,response.getStatus());
        }

        // * testing get order api (but not exist order)
        @Test
        @Order(6)
        public void getOrderByIdTest2() throws UnirestException, InterruptedException {

            // * unirest from postman
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.get("https://petstore.swagger.io/v2/store/order/" + id)
                    .asString();

            // * check status
            Assertions.assertEquals(404,response.getStatus());
        }
    }
}
