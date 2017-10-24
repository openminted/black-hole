package eu.openminted.blackhole.galaxy;

import java.util.List;

import org.codehaus.jackson.type.TypeReference;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import eu.openminted.blackhole.galaxy.beans.Workflow;
import eu.openminted.blackhole.galaxy.beans.WorkflowDetails;
import eu.openminted.blackhole.galaxy.beans.WorkflowInvocation;
import eu.openminted.blackhole.galaxy.beans.WorkflowInvocationInputs;
import eu.openminted.blackhole.galaxy.beans.WorkflowInvocationStep;

class WorkflowsClientImpl extends Client implements WorkflowsClient {
  public WorkflowsClientImpl(GalaxyInstanceImpl galaxyInstance) {
    super(galaxyInstance, "workflows");
  }

  public List<Workflow> getWorkflows() {
    return get(new TypeReference<List<Workflow>>() {
    });
  }

  public ClientResponse showWorkflowResponse(final String id) {
    return super.show(id, ClientResponse.class);
  }

  public WorkflowDetails showWorkflow(final String id) {
    return super.show(id, WorkflowDetails.class);
  }

  public String exportWorkflow(final String id) {
    WebResource webResource = getWebResource().path("download").path(id);
    return webResource.get(String.class);
  }
  
  public ClientResponse invokeWorkflowResponse(WorkflowInvocationInputs workflowInputs) {
	WebResource webResource = getWebResource().path(workflowInputs.getWorkflowId()).path("invocations");
    return super.create(webResource, workflowInputs);
  }

  public WorkflowInvocation invokeWorkflow(final WorkflowInvocationInputs workflowInputs) {
    return invokeWorkflowResponse(workflowInputs).getEntity(WorkflowInvocation.class);
  }
  
  public WorkflowInvocation showInvocation(String workflowId, String invocationId) {
	  ///GET to api/workflows/{workflow_id}/invocations/{invocation_id}
	  WebResource webResource = getWebResource().path(workflowId).path("invocations").path(invocationId);
	  return super.getResponse(webResource).getEntity(WorkflowInvocation.class);
  }
  
  public WorkflowInvocationStep showInvocationStep(String workflowId, String invocationId, String stepId) {
	  WebResource webResource = getWebResource().path(workflowId).path("invocations").path(invocationId).path("steps").path(stepId);
	  return super.getResponse(webResource).getEntity(WorkflowInvocationStep.class);
  }

  public ClientResponse importWorkflowResponse(final String json) {
    final String payload = String.format("{\"workflow\": %s}", json);
    return create(getWebResource(), payload);
  }

  public Workflow importWorkflow(String json) {
    return importWorkflowResponse(json).getEntity(Workflow.class);
  }

  @Override
  public ClientResponse deleteWorkflow(String id) {
    return deleteResponse(getWebResource(id));
  }
  
  @Override
  public ClientResponse cancelWorkflowInvocation(String workflowId, String invocationId) {
	  return deleteResponse(getWebResource().path(workflowId).path("invocations").path(invocationId));
  }
  
  @Override
	public Workflow createWorkflow(String name) {
		return importWorkflow("{\"name\": \"" + name + "\", \"steps\": {}, \"annotation\": \"\"}");
	}
}
