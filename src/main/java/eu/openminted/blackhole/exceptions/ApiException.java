package eu.openminted.blackhole.exceptions;

/**
 * Base class for all API, communication, or serialization related
 * exceptions. The idea is to provide an consistent interface
 * and shield dependent projects from having to have explicit source code
 * dependencies on Jersey and Jackson.
 * 
 */
public class ApiException extends RuntimeException {
  
  public ApiException() {
    super();
  }
  
  public ApiException(final Exception exception) {
    super(exception);
  }

}
