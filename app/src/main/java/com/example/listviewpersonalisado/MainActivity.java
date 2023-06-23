package com.example.listviewpersonalisado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private SearchView searchView;
    private AdapterAlumno adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<alumnoItem> list = new ArrayList<>();

        list.add(new alumnoItem(getString(R.string.item2019030344), getString(R.string.msg2019030344),
                R.drawable.x2019030344));
        list.add(new alumnoItem(getString(R.string.item2020030174), getString(R.string.msg2020030174),
                R.drawable.x2020030174));
        list.add(new alumnoItem(getString(R.string.item2020030176), getString(R.string.msg2020030176),
                R.drawable.x2020030176));
        list.add(new alumnoItem(getString(R.string.item2020030181), getString(R.string.msg2020030181),
                R.drawable.x2020030181));
        list.add(new alumnoItem(getString(R.string.item2020030184), getString(R.string.msg2020030184),
                R.drawable.x2020030184));
        list.add(new alumnoItem(getString(R.string.item2020030189), getString(R.string.msg2020030189),
                R.drawable.x2020030189));
        list.add(new alumnoItem(getString(R.string.item2020030199), getString(R.string.msg2020030199),
                R.drawable.x2020030199));
        list.add(new alumnoItem(getString(R.string.item2020030212), getString(R.string.msg2020030212),
                R.drawable.x2020030212));
        list.add(new alumnoItem(getString(R.string.item2020030241), getString(R.string.msg2020030241),
                R.drawable.x2020030241));
        list.add(new alumnoItem(getString(R.string.item2020030243), getString(R.string.msg2020030243),
                R.drawable.x2020030243));
        list.add(new alumnoItem(getString(R.string.item2020030249), getString(R.string.msg2020030249),
                R.drawable.x2020030249));
        list.add(new alumnoItem(getString(R.string.item2020030264), getString(R.string.msg2020030264),
                R.drawable.x2020030264));
        list.add(new alumnoItem(getString(R.string.item2020030268), getString(R.string.msg2020030268),
                R.drawable.x2020030268));
        list.add(new alumnoItem(getString(R.string.item2020030292), getString(R.string.msg2020030292),
                R.drawable.x2020030292));
        list.add(new alumnoItem(getString(R.string.item2020030304), getString(R.string.msg2020030304),
                R.drawable.x2020030304));
        list.add(new alumnoItem(getString(R.string.item2020030306), getString(R.string.msg2020030306),
                R.drawable.x2020030306));
        list.add(new alumnoItem(getString(R.string.item2020030313), getString(R.string.msg2020030313),
                R.drawable.x2020030313));
        list.add(new alumnoItem(getString(R.string.item2020030315), getString(R.string.msg2020030315),
                R.drawable.x2020030315));
        list.add(new alumnoItem(getString(R.string.item2020030322), getString(R.string.msg2020030322),
                R.drawable.x2020030322));
        list.add(new alumnoItem(getString(R.string.item2020030325), getString(R.string.msg2020030325),
                R.drawable.x2020030325));
        list.add(new alumnoItem(getString(R.string.item2020030327), getString(R.string.msg2020030327),
                R.drawable.x2020030327));
        list.add(new alumnoItem(getString(R.string.item2020030329), getString(R.string.msg2020030329),
                R.drawable.x2020030329));
        list.add(new alumnoItem(getString(R.string.item2020030332), getString(R.string.msg2020030332),
                R.drawable.x2020030332));
        list.add(new alumnoItem(getString(R.string.item2020030333), getString(R.string.msg2020030333),
                R.drawable.x2020030333));
        list.add(new alumnoItem(getString(R.string.item2020030389), getString(R.string.msg2020030389),
                R.drawable.x2020030389));
        list.add(new alumnoItem(getString(R.string.item2020030766), getString(R.string.msg2020030766),
                R.drawable.x2020030766));
        list.add(new alumnoItem(getString(R.string.item2020030771), getString(R.string.msg2020030771),
                R.drawable.x2020030771));
        list.add(new alumnoItem(getString(R.string.item2020030777), getString(R.string.msg2020030777),
                R.drawable.x2020030777));
        list.add(new alumnoItem(getString(R.string.item2020030799), getString(R.string.msg2020030799),
                R.drawable.x2020030799));
        list.add(new alumnoItem(getString(R.string.item2020030808), getString(R.string.msg2020030808),
                R.drawable.x2020030808));
        list.add(new alumnoItem(getString(R.string.item2020030819), getString(R.string.msg2020030819),
                R.drawable.x2020030819));
        list.add(new alumnoItem(getString(R.string.item2020030865), getString(R.string.msg2020030865),
                R.drawable.x2020030865));

        lv = findViewById(R.id.listview1);
        adaptador = new AdapterAlumno(this, list);
        lv.setAdapter(adaptador);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(adapterView.getContext(),getString(R.string.msgSeleccionado).toString()
                                +" "+((alumnoItem) adapterView.getItemAtPosition(i)).getTextMatricula(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.searchview, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_search);
        searchView = (SearchView) menuItem.getActionView();
        setupSearchView();

        return true;
    }

    public void setupSearchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if(adaptador != null) {
                    adaptador.getFilter().filter(s);
                }
                return true;
            }
        });
    }
}
