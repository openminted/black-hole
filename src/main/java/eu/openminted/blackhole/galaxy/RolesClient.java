package eu.openminted.blackhole.galaxy;

import java.util.List;

import eu.openminted.blackhole.galaxy.beans.Role;

public interface RolesClient {
  List<Role> getRoles();

  Role getRole(final String name);
}
