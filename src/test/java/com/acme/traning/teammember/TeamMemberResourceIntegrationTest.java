package com.acme.traning.teammember;

import org.hamcrest.text.IsEqualIgnoringCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.IsEqualIgnoringCase.*;
import static org.springframework.boot.test.context.SpringBootTest.*;
import static org.springframework.http.HttpStatus.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TeamMemberResourceIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldStoreTeamMembersSuccessfully(){
        String json = "{\n" +
                "\t\"firstName\": \"Rebecca\",\n" +
                "\t\"lastName\": \"Parsons\",\n" +
                "\t\"role\": \"Developer\"\n" +
                "}\n";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity(json, headers);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity("/team-members", httpEntity, String.class);

        assertThat(responseEntity.getStatusCode().toString(), equalToIgnoringCase(OK.toString()));


    }
}
