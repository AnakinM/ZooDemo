package pl.pjatk.zoo.ZooDemo.Controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import  static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import  static org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import  static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import  static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import  static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class ZooRestControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnSuccess_exampleZoo() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/zoo/example");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"name\":\"Jurassic Park\",\"location\":\"Gdansk\",\"animals\":[{\"id\":1,\"specimen\":\"tadek\",\"diet\":\"MEAT\",\"type\":\"LAND\",\"healthy\":true,\"hungry\":false}],\"closed\":false}"));
    }

    @Test
    void shouldReturnSuccess_getEmptyZoo() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/zoo/empty");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"name\":\"Jurassic Park\",\"location\":\"Gdansk\",\"animals\":null,\"closed\":false}"));
    }

    @Test
    void shouldReturnSuccess_getEmptyZooWithName() throws Exception {
        String name = "abc";
        MockHttpServletRequestBuilder getRequestBuilder = get("/zoo/emptywithname").param("name", name);
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"name\":\"abc\",\"location\":\"Gdansk\",\"animals\":null,\"closed\":false}"));
    }
}
