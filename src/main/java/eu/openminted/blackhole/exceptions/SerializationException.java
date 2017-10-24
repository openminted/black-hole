package eu.openminted.blackhole.exceptions;

public class SerializationException extends ApiException {

  public SerializationException() {
  }

  public SerializationException(Exception exception) {
    super(exception);
  }
  
}
