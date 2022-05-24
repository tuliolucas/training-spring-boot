package com.acme.traning.teammember;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

class TeamMemberRepositoryTest {

    private static final String FIRST_NAME = "Athiley";
    private static final String LAST_NAME = "Luciano";
    private static final String ROLE = "Developer";

    @Test
    public void shouldCreateANewTeamMemberSuccessfully(){
        TeamMemberRepository teamMemberRepository = new TeamMemberRepository();

        assertThat(teamMemberRepository.getCount(), comparesEqualTo(0));

        TeamMember teamMember = new TeamMember(FIRST_NAME, LAST_NAME, ROLE);
        teamMemberRepository.saveInDatabase(teamMember);

        assertThat(teamMemberRepository.getCount(), comparesEqualTo(1));
    }
}