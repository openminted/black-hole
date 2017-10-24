package eu.openminted.blackhole.galaxy;

import java.util.List;

import com.sun.jersey.api.client.ClientResponse;

import eu.openminted.blackhole.galaxy.beans.Workflow;
import eu.openminted.blackhole.galaxy.beans.WorkflowDetails;
import eu.openminted.blackhole.galaxy.beans.WorkflowInvocation;
import eu.openminted.blackhole.galaxy.beans.WorkflowInvocationInputs;
import eu.openminted.blackhole.galaxy.beans.WorkflowInvocationStep;

public interface WorkflowsClient {
  List<Workflow> getWorkflows();

  WorkflowDetails showWorkflow(String workflowId);

  String exportWorkflow(String id);

  Workflow importWorkflow(String json);

  ClientResponse importWorkflowResponse(String json);
  
  ClientResponse invokeWorkflowResponse(WorkflowInvocationInputs workflowInputs);
  
  WorkflowInvocation invokeWorkflow(WorkflowInvocationInputs workflowInputs);
  
  WorkflowInvocation showInvocation(String workflowId, String invocationId);
  
  WorkflowInvocationStep showInvocationStep(String workflowId, String invocationId, String stepId);
  
  ClientResponse cancelWorkflowInvocation(String workflowId, String invocationId);
  
  /**
   * Deletes the workflow with the given id (this is irreversible). This will
   * return a {@link ClientResponse} object providing access to the status code
   * and the non-serialized body of the response.
   * 
   * @param id
   *          The id of the workflow to delete.
   * @return A {@link ClientResponse} for this request. The status code provided
   *         by {@link ClientResponse#getClientResponseStatus()} should be
   *         verified for success.
   */
  ClientResponse deleteWorkflow(String id);
  
  Workflow createWorkflow(String name);
}
