package com.example.travelmanageapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travelmanageapp.CountryDetail;
import com.example.travelmanageapp.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.example.travelmanageapp.models.Country;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    public static final String ITEM_ID_KEY = "item_id_key";
    private List<Country> countryList;
    private Context mContext;

    public CountryAdapter(Context context, List<Country> countryList) {
        this.countryList = countryList;
        this.mContext = context;
    }
    public void deleteCountryById(String itemId){
        countryList.remove(itemId);
        notifyDataSetChanged();
    }

    @Override
    public CountryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View viewItem = layoutInflater.inflate(R.layout.countrylistitem, parent, false);
        ViewHolder viewHolders = new ViewHolder(viewItem);
        return viewHolders;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Country country = countryList.get(position);

        holder.bind(country);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    public int getItemCount() {
        return countryList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView countryName;
        private ImageView imgName;
        private ImageView moreButton;

        public ViewHolder(View itemView) {
            super(itemView);
            countryName = itemView.findViewById(R.id.itemNameText);
            imgName = itemView.findViewById(R.id.imageView2);
            moreButton = itemView.findViewById(R.id.more_menu);
        }

        public void bind(final Country country) {
            countryName.setText(country.getName());
            String imageName = country.getImage();

            try {
                InputStream inputStream = itemView.getContext().getAssets().open(imageName);
                Drawable d = Drawable.createFromStream(inputStream, null);
                imgName.setImageDrawable(d);
            } catch (IOException e) {
                e.printStackTrace();
            }

            moreButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popup = new PopupMenu(itemView.getContext(), moreButton);
                    //Inflating the Popup using xml file
                    popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                    //registering popup with OnMenuItemClickListener
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()){
                                case R.id.view:
                                    System.out.println("View");
                                    String itemId = country.getId();
                                    Intent intent = new Intent(itemView.getContext(),CountryDetail.class);
                                    intent.putExtra(ITEM_ID_KEY,itemId);
                                    itemView.getContext().startActivity(intent);
                                case R.id.delete:
                                    System.out.println("Delete");
                                    String itemIds = country.getId();
                                    deleteCountryById(itemIds);
                                case R.id.edit:
                                    System.out.println("Edit");
                            }
                            return true;
                        }
                    });

                    popup.show();
                }
            });
        }

    }
}
