package de.adesso.gitstalker.core.objects;

import de.adesso.gitstalker.core.resources.createdReposByMembers.ResponseCreatedReposByMembers;
import de.adesso.gitstalker.core.resources.externalRepo_Resources.ResponseExternalRepository;
import de.adesso.gitstalker.core.resources.memberID_Resources.ResponseMemberID;
import de.adesso.gitstalker.core.resources.memberPR_Resources.ResponseMemberPR;
import de.adesso.gitstalker.core.resources.member_Resources.ResponseMember;
import de.adesso.gitstalker.core.resources.organisation_Resources.ResponseOrganization;
import de.adesso.gitstalker.core.resources.organization_validation.ResponseOrganizationValidation;
import de.adesso.gitstalker.core.resources.repository_Resources.ResponseRepository;
import de.adesso.gitstalker.core.resources.team_Resources.ResponseTeam;

public class Response {

    private ResponseOrganizationValidation responseOrganizationValidation;
    private ResponseMemberID responseMemberID;
    private ResponseMemberPR responseMemberPR;
    private ResponseOrganization responseOrganization;
    private ResponseMember responseMember;
    private ResponseRepository responseRepository;
    private ResponseTeam responseTeam;
    private ResponseExternalRepository responseExternalRepository;
    private ResponseCreatedReposByMembers responseCreatedReposByMembers;

    public Response() {
    }

    public Response(ResponseOrganizationValidation responseOrganizationValidation) {
        this.responseOrganizationValidation = responseOrganizationValidation;
    }

    public Response(ResponseCreatedReposByMembers responseCreatedReposByMembers) {
        this.responseCreatedReposByMembers = responseCreatedReposByMembers;
    }

    public Response(ResponseExternalRepository responseExternalRepository) {
        this.responseExternalRepository = responseExternalRepository;
    }

    public Response(ResponseTeam responseTeam) {
        this.responseTeam = responseTeam;
    }

    public Response(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }

    public Response(ResponseMember responseMember) {
        this.responseMember = responseMember;
    }

    public Response(ResponseMemberPR responseMemberPR) {
        this.responseMemberPR = responseMemberPR;
    }

    public Response(ResponseMemberID responseMemberID) {
        this.responseMemberID = responseMemberID;
    }

    public Response(ResponseOrganization responseOrganization) {
        this.responseOrganization = responseOrganization;
    }

    public ResponseOrganizationValidation getResponseOrganizationValidation() {
        return responseOrganizationValidation;
    }

    public ResponseTeam getResponseTeam() {
        return responseTeam;
    }

    public ResponseMemberID getResponseMemberID() {
        return responseMemberID;
    }

    public ResponseOrganization getResponseOrganization() {
        return responseOrganization;
    }

    public ResponseMemberPR getResponseMemberPR() {
        return responseMemberPR;
    }

    public ResponseMember getResponseMember() {
        return responseMember;
    }

    public ResponseRepository getResponseRepository() {
        return responseRepository;
    }

    public ResponseExternalRepository getResponseExternalRepository() {
        return responseExternalRepository;
    }

    public ResponseCreatedReposByMembers getResponseCreatedReposByMembers() {
        return responseCreatedReposByMembers;
    }
}
