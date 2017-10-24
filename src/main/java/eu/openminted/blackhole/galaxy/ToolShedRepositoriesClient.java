package eu.openminted.blackhole.galaxy;

import com.sun.jersey.api.client.ClientResponse;

import eu.openminted.blackhole.galaxy.beans.InstallableRepositoryRevision;
import eu.openminted.blackhole.galaxy.beans.InstalledRepository;
import eu.openminted.blackhole.galaxy.beans.RepositoryInstall;
import eu.openminted.blackhole.galaxy.beans.RepositoryWorkflow;
import eu.openminted.blackhole.galaxy.beans.Workflow;

import java.util.List;

public interface ToolShedRepositoriesClient {

  List<InstalledRepository> getRepositories();
  
  InstalledRepository showRepository(String toolShedId);

  ClientResponse installRepositoryRequest(RepositoryInstall install);

  List<InstalledRepository> installRepository(final RepositoryInstall install);
  
  ClientResponse repairRepositoryRequest(InstallableRepositoryRevision repositoryIdentifier);

  ClientResponse exportedWorkflowsRequest(String toolShedId);
  
  List<RepositoryWorkflow> exportedWorkflows(String toolShedId);
  
  ClientResponse importWorkflowRequest(String toolShedId, int index);
  
  Workflow importWorkflow(String toolShedId, int index);
  
  ClientResponse importWorkflowsRequest(String toolShedId);
  
  List<Workflow> importWorkflows(String toolShedId);

}
