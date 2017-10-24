package eu.openminted.blackhole.toolshed;

import com.sun.jersey.api.client.ClientResponse;

import eu.openminted.blackhole.toolshed.beans.Repository;
import eu.openminted.blackhole.toolshed.beans.RepositoryDetails;
import eu.openminted.blackhole.toolshed.beans.RepositoryRevision;

import java.util.List;

public interface RepositoriesClient {

  List<RepositoryDetails> getRepositories();
  
  RepositoryDetails showRepository(final String repositoryId);
  
  ClientResponse getInstallableRevisionsRequest(final Repository repository);
  
  List<String> getInstallableRevisions(final Repository repository);
  
  // API returns a list (length 3) of heterogenous data structures. Maybe should wait until a cleaned up
  // version of this is available.
  ClientResponse getRepositoryRevisionInstallInfoRequest(final RepositoryRevision revision);
  
}
