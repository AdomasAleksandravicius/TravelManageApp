package Screens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travelmanageapp.R;

import java.util.ArrayList;
import java.util.List;

import adapters.CountryAdapter;
import adapters.CountryAdapterListView;
import models.Country;
import sample.SampleData;

public class ListScreen extends AppCompatActivity {

    List<Country> countryList = SampleData.countryList;
    List<String>itemNames = new ArrayList<>();
    TextView button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_screen);


        button = (TextView) findViewById(R.id.button1);
        registerForContextMenu(button);
        CountryAdapter countryAdapter = new CountryAdapter(this,countryList);

        RecyclerView view = (RecyclerView) findViewById(R.id.rvItems);
        view.setAdapter(countryAdapter);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_list,menu);
    }


    public boolean onContextItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.pmnuShare:
                Toast.makeText(this,"Shared",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.pmnuDelete:
                Toast.makeText(this,"delete",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.pmnuEdit:
                Toast.makeText(this,"edit",Toast.LENGTH_SHORT).show();
                return true;
                default:
                    return  super.onContextItemSelected(menuItem);
        }


    }
}
