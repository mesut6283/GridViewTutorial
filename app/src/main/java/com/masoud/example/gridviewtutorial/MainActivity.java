package com.masoud.example.gridviewtutorial;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    GridView MyGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyGridView = (GridView) findViewById(R.id.gridView);
        MyGridView.setAdapter(new MasoudAdapter(this));
        MyGridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(this,MyDialog.class);
        startActivity(intent);
    }
}

class Country {
    int imageId;
    String countryName;

    Country(int imageId, String countryName) {
        this.imageId = imageId;
        this.countryName = countryName;
    }
}

class MasoudAdapter extends BaseAdapter {
    ArrayList<Country> list;
    Context context;

    MasoudAdapter(Context context) {
        this.context = context;
        list = new ArrayList<Country>();
        Resources res = context.getResources();
        String[] tempCountryname = res.getStringArray(R.array.country_name);
        int[] countryImage = {R.drawable.afghanistan_flag, R.drawable.brazil_flag,
                R.drawable.croatia_flag, R.drawable.england_flag, R.drawable.france_flag,
                R.drawable.germany_flag, R.drawable.guinea_flag, R.drawable.iran_flag,
                R.drawable.japan_flag, R.drawable.nigeria_flag};
        for (int i = 0; i < 10; i++) {
            Country country = new Country(countryImage[i], tempCountryname[i]);
            list.add(country);
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_item, parent, false);
            holder = new ViewHolder(row);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }
        holder.MyCountry.setImageResource(list.get(position).imageId);

        return row;
    }

}

class ViewHolder {

    ImageView MyCountry;

    ViewHolder(View v) {
        MyCountry = (ImageView) v.findViewById(R.id.imageView);

    }
}