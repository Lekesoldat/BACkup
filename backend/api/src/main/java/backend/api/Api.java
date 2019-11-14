package backend.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import backend.api.services.PersistenceService;
import backend.core.Color;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Api
 */
public class Api {
  // Retrofitinstance
  private Retrofit retrofit;

  /**
   * Create configuration of Retrofit.
   * 
   * @param baseURL to the host.
   */
  public Api(String baseURL) {
    // Configure retrofit with its Gson-factory
    Gson gson = new GsonBuilder().setLenient().create();
    retrofit = new Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create(gson)).build();
  }

  /**
   * @return retrofit instance.
   */
  public PersistenceService createPersistenceService() {
    Color.green("Retrofit initialized.");
    return retrofit.create(PersistenceService.class);
  }
}