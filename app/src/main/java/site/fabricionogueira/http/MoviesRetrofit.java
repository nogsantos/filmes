package site.fabricionogueira.http;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import site.fabricionogueira.model.MovieSearchResult;

public interface MoviesRetrofit {

    @GET("./")
    Observable<MovieSearchResult> search(@Query("s") String q, @Query("r") String format);
}
