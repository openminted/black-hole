package eu.openminted.blackhole.toolshed;

import eu.openminted.blackhole.galaxy.WebResourceFactory;

class ToolShedInstanceImpl implements ToolShedInstance {
  private WebResourceFactory webResourceFactory;
  
  ToolShedInstanceImpl(final WebResourceFactory webResourceFactory) {
    this.webResourceFactory = webResourceFactory; 
  }

  public RepositoriesClient getRepositoriesClient() {
    return new RepositoriesClientImpl(webResourceFactory);
  }

  public String getUrl() {
    return webResourceFactory.getUrl();
  }
  
}
