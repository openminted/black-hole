package eu.openminted.blackhole.toolshed;

import eu.openminted.blackhole.BaseClient;
import eu.openminted.blackhole.galaxy.WebResourceFactory;

class Client extends BaseClient {

  Client(final WebResourceFactory webResourceFactory, final String module) {
    super(webResourceFactory.get(), module);
  }
  
}
