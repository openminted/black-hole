package eu.openminted.blackhole.galaxy;

import java.util.Map;
import org.codehaus.jackson.type.TypeReference;

class ConfigurationClientImpl extends Client implements ConfigurationClient {
  
  ConfigurationClientImpl(GalaxyInstanceImpl galaxyInstance) {
    super(galaxyInstance, "configuration");
  }

  public Map<String, Object> getRawConfiguration() {
    final String json = getJson(getWebResource());
    return readJson(json, new TypeReference<Map<String, Object>>() {
    });
  }

}
