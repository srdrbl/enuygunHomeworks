public class httpEntitiy {
    package petStore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.json.JSONObject;
import org.junit.jupiter.api.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;


    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    public class petStoreTest_Httpentity {

        Store store;
        HttpHeaders headers;
        ObjectMapper objectMapper;
        JSONObject jsonObject;
        public petStoreTest_Httpentity(){
            this.store = new Store();
            this.headers = new HttpHeaders();
            this.objectMapper = new ObjectMapper();
            this.jsonObject = new JSONObject();
        }

        @Test
        @Order(1)
        public void getInventoryTest() throws JsonProcessingException {


            RestTemplate restTemplate = new RestTemplate();

            String url = "https://petstore.swagger.io/v2/store/inventory";


            HttpEntity<String> httpEntity = new HttpEntity<>(jsonObject.toString(), headers);
            String res = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class).getBody();

            JsonNode msgResponse = objectMapper.readTree(res);
            Assertions.assertNotNull(msgResponse);
            System.out.println(msgResponse);
        }

        @Test
        @Order(2)
        public void postOrderTest() throws JsonProcessingException {

            String url = "https://petstore.swagger.io/v2/store/order";

            RestTemplate restTemplate = new RestTemplate();

            store.setId(5);
            store.setPetId(5);
            store.setQuantity(5);
            store.setShipDate("2022-07-30T18:36:23.057+0000");
            store.setStatus("placed");
            store.setComplete(true);


            HttpEntity<Store> request =
                    new HttpEntity<Store>(store, headers);
            String signupResultAsJsonStr =
                    restTemplate.postForObject(url, request, String.class);
            com.fasterxml.jackson.databind.JsonNode root = objectMapper.readTree(signupResultAsJsonStr);

            String msgX = "{\"id\":5,\"petId\":6,\"quantity\":20,\"shipDate\":\"2022-07-30T18:36:23.057+0000\",\"status\":\"placed\",\"complete\":true}";

            Assertions.assertNotNull(signupResultAsJsonStr);
            Assertions.assertNotNull(root);
            System.out.println(root);
            Assertions.assertEquals(5,request.getBody().getId());
            Assertions.assertEquals(6,request.getBody().getPetId());

        }

        @Test
        @Order(3)
        public void getOrderByIdTest() throws JsonProcessingException {

            RestTemplate restTemplate = new RestTemplate();

            String url = "https://petstore.swagger.io/v2/store/order/5";


            HttpEntity<String> httpEntity = new HttpEntity<>(jsonObject.toString(), headers);
            String res = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class).getBody();

            JsonNode msgResponse = objectMapper.readTree(res);
            Assertions.assertNotNull(msgResponse);


        }

        @Test
        @Order(4)
        public void delOrderByIdTest() throws JsonProcessingException {

            RestTemplate restTemplate = new RestTemplate();

            String url = "https://petstore.swagger.io/v2/store/order/5";


            HttpEntity<String> httpEntity = new HttpEntity<>(jsonObject.toString(), headers);
            String res = restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, String.class).getBody();

            JsonNode msgResponse = objectMapper.readTree(res);
            Assertions.assertNotNull(msgResponse);

        }

    }
}
