package eu.openminted.blackhole.galaxy;

import java.util.Map;

public interface ConfigurationClient {

  Map<String, Object> getRawConfiguration();
  
}
