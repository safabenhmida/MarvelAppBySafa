package com.marvel.digital.view;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.ActivityOptionsCompat;
import com.marvel.digital.R;
import com.marvel.digital.activity.DetailsPersonelActivity;
import com.marvel.digital.service.GetImageFromUrl;
import com.marvel.digital.task.response.Results;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by BENHMIDA SAFA
 */

public class GridMarvelComicsAdapter extends BaseAdapter  {

    private List<Results> listData;
    private LayoutInflater layoutInflater;
    private Context context;
    RelativeLayout select_perosnel;
    ArrayList<Results> arrayList;
    ViewHolder holder;

    public GridMarvelComicsAdapter(Context aContext,  List<Results> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
        this.arrayList = new ArrayList<Results>();
        this.arrayList.addAll(listData);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.row_gridview, null);
            holder = new ViewHolder();
            holder.img_row = (ImageView) convertView.findViewById(R.id.img_row);
            holder.img_row_state = (ImageView) convertView.findViewById(R.id.img_row_state);
            holder.txt_name_row = (TextView) convertView.findViewById(R.id.txt_name_row);
            holder.txt_state_row = (TextView) convertView.findViewById(R.id.txt_state_row);
            select_perosnel = (RelativeLayout) convertView.findViewById(R.id.select_personel);
            select_perosnel.setTag(position);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Results results = this.listData.get(position);
        holder.txt_name_row.setText(results.getName());
        new GetImageFromUrl(holder.img_row).execute(results.getImage());
        holder.txt_state_row.setText(results.getStatus());

        if (results.getStatus().equals(context.getResources().getString(R.string.Alive))){
            holder.img_row_state.setBackground(context.getResources().getDrawable(R.drawable.record_green));
        }
        else if (results.getStatus().equals(context.getResources().getString(R.string.Dead))) {
            holder.img_row_state.setBackgroundResource(R.drawable.record_red);

        }else if (results.getStatus().equals(context.getResources().getString(R.string.Unknown))){
            holder.img_row_state.setBackground(context.getResources().getDrawable(R.drawable.record_orange));
        }


        select_perosnel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDetails(position);
            }
        });

        return convertView;
    }


    static class ViewHolder {
        ImageView img_row;
        ImageView img_row_state;
        TextView txt_name_row;
        TextView txt_state_row;
    }

    //filter
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        listData.clear();
        if (charText.length()==0){
            listData.addAll(arrayList);
        }
        else {
            for (Results results : arrayList){
                if (results.getName().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    listData.add(results);
                }
            }
        }
        notifyDataSetChanged();
    }

    public void showDetails (int position){

        Intent intent = new Intent(context, DetailsPersonelActivity.class);
        // Pass data object in the bundle and marvel details activity.
        intent.putExtra("id",String.valueOf(listData.get(position).id));
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity)context, holder.img_row, listData.get(position).name);
        context.startActivity(intent, options.toBundle());
    }

}