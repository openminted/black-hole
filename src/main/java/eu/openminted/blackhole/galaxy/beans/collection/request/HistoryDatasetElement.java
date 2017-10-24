package eu.openminted.blackhole.galaxy.beans.collection.request;

import eu.openminted.blackhole.galaxy.beans.collection.CollectionSource;

/**
 * Class describing a history dataset to be placed within a collection.
 */
public class HistoryDatasetElement extends SimpleElement {
  
  /**
   * Builds a new HistoryDatasetElement.
   */
  public HistoryDatasetElement() {
    setSource(CollectionSource.HDA);
  }
}
