package adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
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

import models.Country;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    public static final String ITEM_ID_KEY = "item_id_key";
    private List<Country> countryList;
    private Context mContext;

    public CountryAdapter(Context context, List<Country> countryList){
        this.countryList = countryList;
        this.mContext = context;
    }
@Override
    public CountryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View viewItem = layoutInflater.inflate(R.layout.countrylistitem,parent,false);
        ViewHolder viewHolders = new ViewHolder(viewItem);
        return viewHolders;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        final Country country = countryList.get(position);

        try {
            holder.countryName.setText(country.getName());
            String imageName = country.getImage();
            InputStream inputStream = mContext.getAssets().open(imageName);
            Drawable d = Drawable.createFromStream(inputStream,null);
            holder.imgName.setImageDrawable(d);
        }catch (IOException e){
            e.printStackTrace();
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemId =country.getId();
                Intent intent = new Intent(mContext, CountryDetail.class);
                intent.putExtra(ITEM_ID_KEY,itemId);
                mContext.startActivity(intent);
                }
        });
    }

    public int getItemCount(){
        return countryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView countryName;
        public ImageView imgName;
        public View mView;
        public ViewHolder(View itemView){
            super(itemView);
            countryName = (TextView)itemView.findViewById(R.id.itemNameText);
            imgName = (ImageView)itemView.findViewById(R.id.imageView2);
            mView = itemView;
        }


    }
}
