package com.acme.traning.teammember;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeamMemberRepository {

    private List<TeamMember> teamMembers = new ArrayList<>();

    public void saveInDatabase(TeamMember validTeamMember) {
        teamMembers.add(validTeamMember);
    }

    public Integer getCount() {
        return teamMembers.size();
    }
}
