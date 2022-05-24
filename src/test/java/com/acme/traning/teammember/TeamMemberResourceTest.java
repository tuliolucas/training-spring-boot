package com.acme.traning.teammember;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.text.IsEqualIgnoringCase.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

class TeamMemberResourceTest {

    @Mock
    private TeamMemberRepository teamMemberRepositoryMock;
    private TeamMemberResource teamMemberResource;

    @BeforeEach
    public void init() {
        openMocks(this);
        teamMemberResource = new TeamMemberResource(teamMemberRepositoryMock);
    }

    @Test
    public void shouldReturnErrorWhenDataIsNull() {
        TeamMember teamMember = null;
        ResponseEntity responseEntity = teamMemberResource.save(teamMember);
        HttpStatus statusCode = responseEntity.getStatusCode();
        assertThat(statusCode.toString(), equalToIgnoringCase(BAD_REQUEST.toString()));
    }

    @Test
    public void shouldReturnErrorWhenDataIsInvalid() {
        TeamMember teamMember = new TeamMember(null, null, null);
        ResponseEntity responseEntity = teamMemberResource.save(teamMember);
        HttpStatus statusCode = responseEntity.getStatusCode();
        assertThat(statusCode.toString(), equalToIgnoringCase(BAD_REQUEST.toString()));
    }

    @Test
    public void shouldReturnErrorWhenFirstNameIsNull() {
        TeamMember teamMember = new TeamMember(null, "Luciano", "Developer");
        ResponseEntity responseEntity = teamMemberResource.save(teamMember);
        HttpStatus statusCode = responseEntity.getStatusCode();
        assertThat(statusCode.toString(), equalToIgnoringCase(BAD_REQUEST.toString()));
    }

    @Test
    public void shouldReturnErrorWhenLastNameIsNull() {
        TeamMember teamMember = new TeamMember("Athiley", null, "Developer");
        ResponseEntity responseEntity = teamMemberResource.save(teamMember);
        HttpStatus statusCode = responseEntity.getStatusCode();
        assertThat(statusCode.toString(), equalToIgnoringCase(BAD_REQUEST.toString()));
    }

    @Test
    public void shouldReturnErrorWhenRoleIsNull() {
        TeamMember teamMember = new TeamMember("Athiley", "Luciano", null);
        ResponseEntity responseEntity = teamMemberResource.save(teamMember);
        HttpStatus statusCode = responseEntity.getStatusCode();
        assertThat(statusCode.toString(), equalToIgnoringCase(BAD_REQUEST.toString()));
    }

    @Test
    public void shouldReturnOkWhenTeamMembersIsCreatedSuccessfully() {
        TeamMember teamMember = new TeamMember("Athiley", "Luciano", "Developer");

        ResponseEntity responseEntity = teamMemberResource.save(teamMember);

        HttpStatus statusCode = responseEntity.getStatusCode();
        assertThat(statusCode.toString(), equalToIgnoringCase(OK.toString()));
    }

    @Test
    public void shouldCallTeamMemberRepositorySuccessfully(){

        TeamMember validTeamMember = new TeamMember("Túlio", "Cruz", "BA");

        teamMemberResource.save(validTeamMember);

        verify(teamMemberRepositoryMock).saveInDatabase(validTeamMember);
    }
}