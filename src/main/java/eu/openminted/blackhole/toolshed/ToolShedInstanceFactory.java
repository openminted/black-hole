package eu.openminted.blackhole.toolshed;

import eu.openminted.blackhole.galaxy.DefaultWebResourceFactoryImpl;
import eu.openminted.blackhole.galaxy.WebResourceFactory;

public class ToolShedInstanceFactory {

  public static ToolShedInstance get(final String url, final String apiKey) {
    return get(new DefaultWebResourceFactoryImpl(url, apiKey));
  }

  public static ToolShedInstance get(final WebResourceFactory webResourceFactory) {
    return new ToolShedInstanceImpl(webResourceFactory);
  }
  
  public static ToolShedInstance getMainToolShedInstance() {
    return getMainToolShedInstance(null);
  }
  
  public static ToolShedInstance getMainToolShedInstance(final String apiKey) {
    return get("https://toolshed.g2.bx.psu.edu/", apiKey);
  }

}
