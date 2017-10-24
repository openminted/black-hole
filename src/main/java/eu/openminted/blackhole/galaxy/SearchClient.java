package eu.openminted.blackhole.galaxy;

import java.util.List;
import java.util.Map;

public interface SearchClient {
  
  public class SearchResponse {
    private List<Map<String, Object>> results;

    public List<Map<String, Object>> getResults() {
      return results;
    }

    public void setResults(List<Map<String, Object>> results) {
      this.results = results;
    }
    
  }
  
  public SearchResponse search(final String searchQuery);
  
}
