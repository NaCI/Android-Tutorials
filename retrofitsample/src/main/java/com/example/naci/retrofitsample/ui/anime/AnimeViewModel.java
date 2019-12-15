package com.example.naci.retrofitsample.ui.anime;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import android.text.TextUtils;

import com.example.naci.retrofitsample.App;
import com.example.naci.retrofitsample.R;
import com.example.naci.retrofitsample.network.AnimeService;
import com.example.naci.retrofitsample.network.model.AnimeModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimeViewModel extends ViewModel {
    public final MutableLiveData<Object> animeListResponse = new MutableLiveData<>();
    public final MutableLiveData<Boolean> showProgress = new MutableLiveData<>();
    public final MutableLiveData<String> errorString = new MutableLiveData<>();


    void getAnimeListRequest(String genre) {
        showProgress.setValue(true);
        AnimeService service = App.getRetrofitInstance().create(AnimeService.class);
        Call<AnimeModel> call = service.getAnimeListByGenre(genre);
        call.enqueue(new Callback<AnimeModel>() {
            @Override
            public void onResponse(Call<AnimeModel> call, Response<AnimeModel> response) {
                if (response.body() != null) {
                    animeListResponse.setValue(response.body());
                }
                showProgress.setValue(false);
            }

            @Override
            public void onFailure(Call<AnimeModel> call, Throwable t) {
                animeListResponse.setValue(t);
                showProgress.setValue(false);
            }
        });
    }

    public void onFetchClicked(String genreText) {
        if (!TextUtils.isEmpty(genreText)) {
            errorString.setValue(null);
            getAnimeListRequest(genreText);
        } else {
            errorString.setValue(App.getStringById(R.string.error_input_empty));
        }
    }
}
