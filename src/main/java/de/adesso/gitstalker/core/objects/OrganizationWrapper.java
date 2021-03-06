package de.adesso.gitstalker.core.objects;

import de.adesso.gitstalker.core.enums.RequestType;
import de.adesso.gitstalker.core.repositories.OrganizationRepository;
import org.springframework.data.annotation.Id;

import java.util.*;

public class OrganizationWrapper {

    @Id
    private String id;

    private String organizationName;
    private OrganizationDetail organizationDetail;
    private ArrayList<String> memberIDs = new ArrayList<>();
    private HashMap<String, ArrayList<String>> memberPRRepoIDs = new HashMap<>();
    private HashMap<String, Member> members = new HashMap<>();
    private Set<RequestType> finishedRequests = new HashSet<>();
    private HashMap<String, Repository> repositories = new HashMap<>();
    private HashMap<String, Integer> memberAmount = new HashMap<>();
    private HashMap<String, Team> teams = new HashMap<>();
    private HashMap<String, Repository> externalRepos = new HashMap<>();
    private HashMap<String, ArrayList<Repository>> createdReposByMembers = new HashMap<>();
    private Date lastUpdateTimestamp;
    private int completeUpdateCost = 0;

    /**
     * Wrapper for all the needed information of a organization.
     *
     * @param organizationName Specified organizationName on GitHub
     */
    public OrganizationWrapper(String organizationName) {
        this.organizationName = organizationName;
    }

    public int getCompleteUpdateCost() {
        return completeUpdateCost;
    }

    public void setCompleteUpdateCost(int completeUpdateCost) {
        this.completeUpdateCost += completeUpdateCost;
    }

    public Date getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    public void setLastUpdateTimestamp(Date lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    public String getId() {
        return id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public OrganizationDetail getOrganizationDetail() {
        return organizationDetail;
    }

    public void setOrganizationDetail(OrganizationDetail organizationDetail) {
        this.organizationDetail = organizationDetail;
    }

    public ArrayList<String> getMemberIDs() {
        return memberIDs;
    }

    public void setMemberIDs(ArrayList<String> memberIDs) {
        this.memberIDs = memberIDs;
    }

    public void addMemberIDs(ArrayList<String> memberIDs) {
        this.memberIDs.addAll(memberIDs);
    }

    public HashMap<String, ArrayList<String>> getMemberPRRepoIDs() {
        return memberPRRepoIDs;
    }

    public void setMemberPRRepoIDs(HashMap<String, ArrayList<String>> memberPRRepoIDs) {
        this.memberPRRepoIDs = memberPRRepoIDs;
    }

    public void addMemberPRs(HashMap<String, ArrayList<String>> memberPRRepoIDs) {
        this.memberPRRepoIDs.putAll(memberPRRepoIDs);
    }

    public HashMap<String, Member> getMembers() {
        return members;
    }

    public void setMembers(HashMap<String, Member> members) {
        this.members = members;
    }

    public void addMembers(HashMap<String, Member> members) {
        this.members.putAll(members);
    }

    public Set<RequestType> getFinishedRequests() {
        return finishedRequests;
    }

    public void addFinishedRequest(RequestType finishedRequest) {
        this.finishedRequests.add(finishedRequest);
    }

    public void setRepositories(HashMap<String, Repository> repositories) {
        this.repositories = repositories;
    }

    public HashMap<String, Repository> getRepositories() {
        return repositories;
    }

    public void addRepositories(HashMap<String, Repository> repositories) {
        this.repositories.putAll(repositories);
    }

    public HashMap<String, Integer> getMemberAmount() {
        return memberAmount;
    }

    public void addMemberAmount(Integer memberAmount) {
        this.memberAmount.put(new Date().toString(), memberAmount);
    }

    public HashMap<String, Team> getTeams() {
        return teams;
    }

    public void setTeams(HashMap<String, Team> teams) {
        this.teams = teams;
    }

    public void addTeams(HashMap<String,Team> teams) {
        this.teams.putAll(teams);
    }

    public HashMap<String, Repository> getExternalRepos() {
        return externalRepos;
    }

    public void setExternalRepos(HashMap<String, Repository> externalRepos) {
        this.externalRepos = externalRepos;
    }

    public void addExternalRepos(HashMap<String, Repository> externalRepos) {
        this.externalRepos.putAll(externalRepos);
    }

    public HashMap<String, ArrayList<Repository>> getCreatedReposByMembers() {
        return createdReposByMembers;
    }

    public void setCreatedReposByMembers(HashMap<String, ArrayList<Repository>> createdReposByMembers) {
        this.createdReposByMembers = createdReposByMembers;
    }

    public void addCreatedReposByMembers(HashMap<String, ArrayList<Repository>> createdReposByMembers) {
        this.createdReposByMembers.putAll(createdReposByMembers);
    }

    public void prepareOrganizationForUpdate(OrganizationRepository organizationRepository){
        this.organizationDetail = null;
        this.memberIDs = new ArrayList<>();
        this.memberPRRepoIDs = new HashMap<>();
        this.members = new HashMap<>();
        this.finishedRequests = new HashSet<>();
        this.repositories = new HashMap<>();
        this.teams = new HashMap<>();
        this.externalRepos = new HashMap<>();
        this.createdReposByMembers = new HashMap<>();
        this.completeUpdateCost = 0;
        this.lastUpdateTimestamp = null;

        organizationRepository.save(this);
    }
}
