/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punpuzle;

/**
 *
 * @author cdominguez
 */
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PuzzleControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void searchWords() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/search?word=dog&max=3"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[\"paraDOGx\",\"kuDOGs\",\"wisDOGm\"]")));
    }
    
}