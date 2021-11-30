package com.marvel.digital.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.marvel.digital.R;
import com.marvel.digital.presenter.DetailsPersonelPresenter;
import com.marvel.digital.service.GetImageFromUrl;
import com.marvel.digital.task.response.MarvelDetailsResponse;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by BENHMIDA SAFA
 */

public class DetailsPersonelActivity extends BaseActivity {

    @Inject
    DetailsPersonelPresenter mDetailsPersonelPresenter;
    MarvelDetailsResponse mMarvelDetailsResponse ;

    @BindView(R.id.picture)
    ImageView picture;

    @BindView(R.id.layout)
    LinearLayout layout;

    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.status)
    TextView status;

    @BindView(R.id.species)
    TextView species;

    @BindView(R.id.gender)
    TextView gender;

    @BindView(R.id.date)
    TextView date;

    @BindView(R.id.nameLocation)
    TextView nameLocation;

    @BindView(R.id.nameOrigin)
    TextView nameOrigin;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_perosnel);
        getInjector().inject(this);
        ButterKnife.bind(this);
        initDrawerMenu();

        mDetailsPersonelPresenter.setmDetailsPersonelActivity(this);
        Intent intent = getIntent();
        String ID = intent.getStringExtra("id");
        mDetailsPersonelPresenter.GetDetailsPersonnel(Integer.valueOf(ID));
        showProgress();
    }

    public void GetMarvelDetailsPersonal(MarvelDetailsResponse marvelDetailsResponse) {
        this.mMarvelDetailsResponse = marvelDetailsResponse;
        new GetImageFromUrl(picture).execute(mMarvelDetailsResponse.getImage());
        name.setText(marvelDetailsResponse.getName());
        status.setText(marvelDetailsResponse.getStatus());
        gender.setText(marvelDetailsResponse.getGender());
        species.setText(marvelDetailsResponse.getSpecies());
        date.setText(marvelDetailsResponse.getCreated());
        nameLocation.setText(marvelDetailsResponse.getLocation().getName());
        nameOrigin.setText(marvelDetailsResponse.getOrigin().getName());
    }

}
