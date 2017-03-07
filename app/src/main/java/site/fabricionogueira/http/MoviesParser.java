package site.fabricionogueira.http;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.schedulers.Schedulers;
import site.fabricionogueira.model.MovieSearchResult;


public class MoviesParser {

    public static Observable<MovieSearchResult> searchByTitle(String q) throws IOException {
        RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()); // Thread IO

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(rxAdapter)
                .build();

        MoviesRetrofit api = retrofit.create(MoviesRetrofit.class);

        return api.search(q, "json");
    }


}
