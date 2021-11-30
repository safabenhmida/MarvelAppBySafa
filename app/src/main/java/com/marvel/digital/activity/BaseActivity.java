package com.marvel.digital.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.marvel.digital.R;
import com.marvel.digital.app.Config;
import com.marvel.digital.app.FrontOfficeMobileApp;
import com.marvel.digital.injection.Injector;
import org.greenrobot.eventbus.EventBus;
import javax.inject.Inject;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by BENHMIDA SAFA
 */
public class BaseActivity extends AppCompatActivity {

    @Inject
    Config config;
    @Inject
    EventBus eventBus;
    private SweetAlertDialog pDialog;
    public static int mCartItemCount = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getInjector().inject(this);
    }

    public void showProgress() {
        progressAlert(this, getResources().getString(R.string.wait_plz));
    }

    public void progressAlert(Context context, String message) {
        if (pDialog == null) {
            pDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
        }

        pDialog.getProgressHelper().setBarColor(Color.parseColor("#ee171f"));
        pDialog.setTitleText(message);
        pDialog.setCancelable(false);
        pDialog.show();
    }
    public void dismissAlert() {
        if (pDialog != null)
            pDialog.dismiss();
    }
    protected FrontOfficeMobileApp getDigitalBankApplication() {
        return (FrontOfficeMobileApp) getApplication();
    }

    protected Injector getInjector() {
        return getDigitalBankApplication().getInjector();
    }

    public void initDrawerMenu() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BaseActivity.mCartItemCount = 0;

    }

}


