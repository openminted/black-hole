package eu.openminted.blackhole.galaxy;

import java.util.List;

import com.sun.jersey.api.client.ClientResponse;

import eu.openminted.blackhole.galaxy.beans.User;
import eu.openminted.blackhole.galaxy.beans.UserCreate;

public interface UsersClient {
  List<User> getUsers();

  ClientResponse createUserRequest(final String remoteUserEmail);

  User createUser(final String remoteUserEmail);

  ClientResponse createUserRequest(final UserCreate userCreate);

  User createUser(final UserCreate userCreate);

  String createApiKey(final String userId);
  
  User showUser(String id);
}
