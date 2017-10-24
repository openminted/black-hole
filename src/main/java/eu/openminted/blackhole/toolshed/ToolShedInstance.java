package eu.openminted.blackhole.toolshed;

public interface ToolShedInstance {

  RepositoriesClient getRepositoriesClient();

  public String getUrl();
  
}
