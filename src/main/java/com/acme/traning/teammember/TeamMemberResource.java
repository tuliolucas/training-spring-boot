package com.acme.traning.teammember;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team-members")
public class TeamMemberResource {

    private TeamMemberRepository teamMemberRepository;

    public TeamMemberResource(TeamMemberRepository teamMemberRepository) {
        this.teamMemberRepository = teamMemberRepository;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody TeamMember teamMember) {

        if(teamMember == null ||
                teamMember.getFirstName() == null ||
                    teamMember.getLastName() == null ||
                        teamMember.getRole() == null) {
            return ResponseEntity.badRequest().build();
        }

        teamMemberRepository.saveInDatabase(teamMember);

        return ResponseEntity.ok().build();
    }
}
