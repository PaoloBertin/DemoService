package eu.opensource.demoService.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import eu.opensource.demoService.web.util.DemoInput;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class DemoControllerTest {

    @Autowired
    private MockMvc mvc;

    private String url = "/service1";

    @Test
    void operationsSuccessTest() throws Exception {

        DemoInput demoInput = new DemoInput(10.0, 2.0, "div");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        String requestJson = objectMapper.writeValueAsString(demoInput);

        mvc.perform(post(url + "/calculate").contentType(MediaType.APPLICATION_JSON)
                                            .content(requestJson))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.message", equalTo("ok")))
           .andExpect(jsonPath("$.result", equalTo(5.0)))
        ;
    }

    @Test
    void OperationFailedTest() throws Exception {

        DemoInput demoInput = new DemoInput(10.0, 2.0, "dov");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        String requestJson = objectMapper.writeValueAsString(demoInput);

        mvc.perform(post(url + "/calculate").contentType(MediaType.APPLICATION_JSON)
                                            .content(requestJson))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.message", equalTo("invalid operation")))
           .andExpect(jsonPath("$.result", equalTo(0.0)))
        ;

    }
}