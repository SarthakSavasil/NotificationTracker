package com.sarthaksavasil.notificationtracker;


import android.app.Activity;
//import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Belal on 2/26/2017.
 */

public class DataList extends ArrayAdapter<Data> {
    private Activity context;
    List<Data> dataL;

    public DataList(Activity context, List<Data> datasL) {
        super(context, R.layout.layout_data, datasL);
        this.context = context;
        this.dataL = datasL;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_data, null, true);

        TextView header = (TextView) listViewItem.findViewById(R.id.package_name);
        TextView title = (TextView) listViewItem.findViewById(R.id.title);
        TextView descrip = (TextView) listViewItem.findViewById(R.id.decription);

        Data artist = dataL.get(position);
        header.setText(artist.getPackageName());
        title.setText(artist.getTitle());
        descrip.setText(artist.getDecription());

        return listViewItem;
    }
}