package eu.openminted.blackhole.toolshed;

import java.util.List;

import eu.openminted.blackhole.toolshed.beans.Repository;
import eu.openminted.blackhole.toolshed.beans.RepositoryRevision;

public class RepositoryUtils {

  public static RepositoryRevision getLatestRepositoryRevision(final RepositoriesClient client, final String owner, final String name) {
    return getLatestRepositoryRevision(client, new Repository(owner, name));
  }
  
  public static RepositoryRevision getLatestRepositoryRevision(final RepositoriesClient client, final Repository repository) {
    final List<String> installableRevisions = client.getInstallableRevisions(repository);
    final String latest = installableRevisions.get(installableRevisions.size() - 1);
    return new RepositoryRevision(repository, latest);
  }
  
}
