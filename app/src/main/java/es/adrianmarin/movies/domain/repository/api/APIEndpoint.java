package es.adrianmarin.movies.domain.repository.api;

import retrofit.Endpoint;

/**
 * @author Adrián Marín González
 * @since 25/10/15.
 */
public class APIEndpoint implements Endpoint {

    private String url;

    public APIEndpoint(){
        this.url = APIGlobals.ENDPOINT;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getName() {
        return null;
    }

}
