package eu.openminted.blackhole.exceptions;

import com.sun.jersey.api.client.ClientResponse;

import eu.openminted.blackhole.util.MoreObjects;

public class ResponseException extends ApiException {
  private final Integer statusCode;
  private final String rawResponse;
  
  public ResponseException(final ClientResponse clientResponse) {
    super();
    this.statusCode = clientResponse.getStatus();
    this.rawResponse = clientResponse.getEntity(String.class);
  }

  protected MoreObjects.ToStringHelper toStringHelper() {
    return MoreObjects
            .toStringHelper(getClass())
            .add("status", statusCode)
            .add("responseBody", rawResponse);
    
  }

  @Override
  public String toString() {
    return toStringHelper().toString();
  }

  public String getResponseBody() {
    return rawResponse;
  }

  public Integer getStatusCode() {
    return statusCode;
  }
  
}
