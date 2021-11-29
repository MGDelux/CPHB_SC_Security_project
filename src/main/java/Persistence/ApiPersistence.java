package Persistence;

import Models.Store.Api;
import Service.Interfaces.IApiService;

/**
 * CREATED BY mathias @ 29-11-2021 - 12:17
 **/
public class ApiPersistence {
    private final IApiService APIService;

    public ApiPersistence(IApiService apiService) {
        APIService = apiService;
    }

    public String getAPIKey() {
        return this.APIService.getApiKey();
    }
}
