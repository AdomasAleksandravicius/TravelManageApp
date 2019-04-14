package com.example.travelmanageapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.travelmanageapp.R;
import com.example.travelmanageapp.models.City;


import java.security.acl.Group;
import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder>{

    private List<City> cityList;
    private Context mContext;

public CityAdapter(Context context, List<City> cityList) {
        this.cityList = cityList;
        this.mContext = context;
        }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_view, parent, false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {
        final City city = cityList.get(position);
        holder.bind(city);

    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }

    public void addCity(List<City> cities) {
        cityList.clear();
        cityList.addAll(cities);
        notifyDataSetChanged();
    }

    class CityViewHolder extends RecyclerView.ViewHolder {

        private TextView name;

        private CityViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.);
        }

        private void bind(Group group) {
            name.setText(group.getName());
        }
    }
}
