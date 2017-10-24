package eu.openminted.blackhole.galaxy;

import java.util.List;

import org.codehaus.jackson.type.TypeReference;

import eu.openminted.blackhole.galaxy.beans.Job;
import eu.openminted.blackhole.galaxy.beans.JobDetails;

/**
 * Implementation for interacting with Galaxy's Job API.
 * 
 * @author Franklin Bristow franklin.bristow@phac-aspc.gc.ca
 *
 */
public class JobsClientImpl extends Client implements JobsClient {

	JobsClientImpl(GalaxyInstanceImpl galaxyInstance) {
		super(galaxyInstance, "jobs");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Job> getJobs() {
		return get(new TypeReference<List<Job>>() {
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JobDetails showJob(final String id) {
		return super.show(id, JobDetails.class);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Job> getJobsForHistory(String historyId) {
		return get(getWebResource().queryParam("history_id", historyId), new TypeReference<List<Job>>() {
		});
	}

}
