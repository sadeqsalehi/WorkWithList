package ir.sadeqsalehi.workwithlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SimpleListViewActivity extends AppCompatActivity {

    List<String> cities = new ArrayList<>();
    ListView citiesListView;
    ArrayAdapter<String> adapter;
    int selectedItemIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateCitiesList();
        citiesListView = findViewById(R.id.listView);
        refreshDisplay();
    }

    private void populateCitiesList() {

        cities.add("Abadan");
        cities.add("Paris");
        cities.add("NewYork");
        cities.add("Berlin");
        cities.add("Ahwaz");
        cities.add("Baghdad");
        cities.add("Kuwait");
        cities.add("Tokyo");
        cities.add("Moscow");
        cities.add("Cairo");
        cities.add("Muscat");
        cities.add("Doha");

    }

    private void refreshDisplay() {
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cities);
        citiesListView.setAdapter(adapter);
        citiesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedItemIndex = position;
                Toast.makeText(SimpleListViewActivity.this, cities.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Add").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                cities.add("NewDelhi");
                adapter.notifyDataSetChanged();
                return false;
            }
        });
        menu.add("Remove").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (!cities.isEmpty())
                    cities.remove(selectedItemIndex);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
