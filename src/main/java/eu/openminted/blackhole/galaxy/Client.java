package eu.openminted.blackhole.galaxy;

import com.sun.jersey.api.client.ClientResponse;

import eu.openminted.blackhole.BaseClient;
import eu.openminted.blackhole.exceptions.ResponseException;
import eu.openminted.blackhole.galaxy.beans.HasGalaxyUrl;

class Client extends BaseClient {
  private final GalaxyInstanceImpl galaxyInstance;

  Client(final GalaxyInstanceImpl galaxyInstance, final String module) {
    super(galaxyInstance.getWebResource(), module);
    this.galaxyInstance = galaxyInstance;
  }

  @Override
  protected ResponseException buildResponseException(final ClientResponse clientResponse) {
    final ResponseException exception = new GalaxyResponseException(clientResponse);
    return exception;
  }
  
  GalaxyInstance getGalaxyInstance() {
    return galaxyInstance;
  }
  
  protected <T extends HasGalaxyUrl> T setGalaxyUrl(final T bean) {
    bean.setGalaxyUrl(galaxyInstance.getGalaxyUrl());
    bean.setApiKey(galaxyInstance.getApiKey());
    return bean;
  }

}
