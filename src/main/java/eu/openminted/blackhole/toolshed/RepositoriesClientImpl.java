package eu.openminted.blackhole.toolshed;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import eu.openminted.blackhole.galaxy.WebResourceFactory;
import eu.openminted.blackhole.toolshed.beans.Repository;
import eu.openminted.blackhole.toolshed.beans.RepositoryDetails;
import eu.openminted.blackhole.toolshed.beans.RepositoryRevision;

import java.util.List;
import org.codehaus.jackson.type.TypeReference;

public class RepositoriesClientImpl extends Client implements RepositoriesClient {
  private static final TypeReference<List<RepositoryDetails>> TOOL_LIST_TYPE_REFERENCE = new TypeReference<List<RepositoryDetails>>() {
  };
  private static final TypeReference<List<String>> STRING_LIST_TYPE_REFERENCE = new TypeReference<List<String>>() {
  };
  
  RepositoriesClientImpl(WebResourceFactory webResourceFactory) {
    super(webResourceFactory, "repositories");
  }
  
  public List<RepositoryDetails> getRepositories() {
    return super.get(TOOL_LIST_TYPE_REFERENCE);
  }

  public RepositoryDetails showRepository(final String repositoryId) {
    return super.show(repositoryId, RepositoryDetails.class);
  }

  public ClientResponse getInstallableRevisionsRequest(Repository repository) {
    return super.getResponse(withQueryParams(super.path("get_ordered_installable_revisions"), repository));
  }

  public List<String> getInstallableRevisions(Repository repository) {
    return read(getInstallableRevisionsRequest(repository), STRING_LIST_TYPE_REFERENCE);
  }

  public ClientResponse getRepositoryRevisionInstallInfoRequest(RepositoryRevision revision) {
    final WebResource baseResource = super.path("get_repository_revision_install_info");
    final WebResource resource = withQueryParams(baseResource, revision);
    return super.getResponse(resource);
  }
  
  private WebResource withQueryParams(final WebResource resource, RepositoryRevision revision) {
    return withQueryParams(resource, (Repository) revision).queryParam("changeset_revision", revision.getRevision());
  }
  
  private WebResource withQueryParams(final WebResource resource, final Repository repository) {
    return resource.queryParam("owner", repository.getOwner()).queryParam("name", repository.getName());
  }

}
