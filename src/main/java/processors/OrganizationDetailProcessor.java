package processors;

import enums.RequestType;
import objects.OrganizationDetail;
import objects.OrganizationWrapper;
import objects.Query;
import repositories.OrganizationRepository;
import repositories.RequestRepository;
import resources.organisation_Resources.Organization;

public class OrganizationDetailProcessor extends ResponseProcessor {

    private RequestRepository requestRepository;
    private OrganizationRepository organizationRepository;
    private Query requestQuery;
    private OrganizationWrapper organization;

    public OrganizationDetailProcessor() {
    }

    private void setUp(Query requestQuery, RequestRepository requestRepository, OrganizationRepository organizationRepository) {
        this.requestQuery = requestQuery;
        this.requestRepository = requestRepository;
        this.organizationRepository = organizationRepository;
        this.organization = this.organizationRepository.findByOrganizationName(requestQuery.getOrganizationName());
    }

    public void processResponse(Query requestQuery, RequestRepository requestRepository, OrganizationRepository organizationRepository) {
        this.setUp(requestQuery,requestRepository,organizationRepository);
        super.updateRateLimit(this.requestQuery.getQueryResponse().getResponseOrganization().getData().getRateLimit(), requestQuery.getQueryRequestType());
        this.processQueryResponse();
        super.doFinishingQueryProcedure(requestRepository, organizationRepository, this.organization, requestQuery, RequestType.ORGANIZATION_DETAIL);
    }

    private void processQueryResponse(){
        Organization organization = this.requestQuery.getQueryResponse().getResponseOrganization().getData().getOrganization();

        this.organization.setOrganizationDetail(new OrganizationDetail(
                organization.getName(),
                organization.getDescription(),
                organization.getWebsiteUrl(),
                organization.getUrl(),
                organization.getLocation(),
                organization.getAvatarUrl(),
                organization.getMembers().getTotalCount(),
                organization.getRepositories().getTotalCount(),
                organization.getTeams().getTotalCount()));
        this.organization.addMemberAmount(organization.getMembers().getTotalCount());
    }
}
