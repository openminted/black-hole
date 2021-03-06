package eu.openminted.blackhole.galaxy;

import java.util.List;

import com.sun.jersey.api.client.ClientResponse;

import eu.openminted.blackhole.galaxy.beans.DirectoryLibraryUpload;
import eu.openminted.blackhole.galaxy.beans.FileLibraryUpload;
import eu.openminted.blackhole.galaxy.beans.FilesystemPathsLibraryUpload;
import eu.openminted.blackhole.galaxy.beans.GalaxyObject;
import eu.openminted.blackhole.galaxy.beans.Library;
import eu.openminted.blackhole.galaxy.beans.LibraryContent;
import eu.openminted.blackhole.galaxy.beans.LibraryDataset;
import eu.openminted.blackhole.galaxy.beans.LibraryFolder;
import eu.openminted.blackhole.galaxy.beans.LibraryPermissions;
import eu.openminted.blackhole.galaxy.beans.UrlLibraryUpload;

public interface LibrariesClient {
  ClientResponse createLibraryRequest(Library library);

  Library createLibrary(Library library);
  
  List<Library> getLibraries();

  ClientResponse createFolderRequest(String libraryId, LibraryFolder libraryFolder);

  LibraryFolder createFolder(String libraryId, LibraryFolder libraryFolder);

  ClientResponse uploadFileFromUrlRequest(String libraryId, UrlLibraryUpload upload);

  ClientResponse uploadServerDirectoryRequest(String libraryId, DirectoryLibraryUpload upload);

  ClientResponse uploadFilesystemPathsRequest(String libraryId, FilesystemPathsLibraryUpload upload);
  
  /**
   * Uploads a file from a local filesystem path to a library.
   * @param libraryId  The Library to upload the file to.
   * @param upload  The object representing an upload request.
   * @return  A GalaxyObject representing the response for this upload.
   */
  GalaxyObject uploadFilesystemPaths(final String libraryId, final FilesystemPathsLibraryUpload upload);

  ClientResponse uploadFile(String libraryId, FileLibraryUpload upload);

  LibraryContent getRootFolder(String libraryId);

  List<LibraryContent> getLibraryContents(String libraryId);

  ClientResponse uploadFileFromUrl(String libraryId, FilesystemPathsLibraryUpload upload);

  ClientResponse setLibraryPermissions(String libraryId, LibraryPermissions permissions);
  
  /**
   * Gets a ClientResponse object for a request to show details on a dataset within a Library.
   * @param libraryId  The id of the Library the dataset is located within.
   * @param datasetId  The id of the dataset to get details.
   * @return A {@link ClientResponse} object representing details on the showDatasets request.
   */
  ClientResponse showDatasetRequest(String libraryId, String datasetId);
  
  /**
   * Gets details about a given library dataset.
   * @param libraryId  The id of the Library the dataset is located within.
   * @param datasetId  The id of the dataset to get details.
   * @return  A {@link LibraryDataset} object representing details for this dataset.
   */
  LibraryDataset showDataset(String libraryId, String datasetId);
  
  /**
   * Deletes the given library from Galaxy (this is irreversible). This will return a
   * {@link ClientResponse} object providing access to the status code and the
   * non-serialized body of the response.
   * 
   * @param libraryId
   *          The id of the library to delete.
   * @return A {@link ClientResponse} for the deleted library. The status code
   *         provided by {@link ClientResponse#getClientResponseStatus()} should
   *         be verified for success.
   */
  ClientResponse deleteLibraryRequest(String libraryId);
}