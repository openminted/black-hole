package eu.openminted.blackhole.toolshed;

import eu.openminted.blackhole.galaxy.beans.InstallableRepositoryRevision;
import eu.openminted.blackhole.toolshed.beans.Repository;
import eu.openminted.blackhole.toolshed.beans.RepositoryRevision;

public class ToolShedUtils {

  public static InstallableRepositoryRevision getLatestInstallableRevision(final Repository repository) {
    return getLatestInstallableRevision(ToolShedInstanceFactory.getMainToolShedInstance(), repository);
  }
  
  public static InstallableRepositoryRevision getLatestInstallableRevision(final ToolShedInstance instance, final Repository repository) {
    final RepositoryRevision revision; 
    revision = RepositoryUtils.getLatestRepositoryRevision(instance.getRepositoriesClient(), repository);
    final InstallableRepositoryRevision installableRevision;
    installableRevision = new InstallableRepositoryRevision(instance.getUrl(), revision);    
    return installableRevision;
  }
  
}
