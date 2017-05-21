package com.waxjar.heroesofthestormtimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private int number_of_maps = 13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set recyclerview
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Set Data
        // Map titles
        String[] mapTitle = {"Battlefield of Eternity", "Blackheart's Bay", "Braxis Holdout", "Cursed Hollow",
                         "Dragon Shire", "Garden of Terror", "Hanamura", "Haunted Mines", "Infernal Shrines",
                         "Sky Temple", "Tomb of the Spider Queen", "Towers of Doom", "Warhead Junction"};
        // Main map image
        int[] mapImages = {R.drawable.battle, R.drawable.blackhearts, R.drawable.braxxis, R.drawable.cursed,
                R.drawable.dragon, R.drawable.garden, R.drawable.hanamura, R.drawable.haunted, R.drawable.infernal,
                R.drawable.temple, R.drawable.spider, R.drawable.towers, R.drawable.warhead};
        // Tall image for count down background
        int[] mapTallImages = {R.drawable.battle_tall, R.drawable.blackheart_tall, R.drawable.braxis_tall, R.drawable.cursed_tall,
                R.drawable.dragon_tall, R.drawable.garden_tall, R.drawable.hanamura_tall, R.drawable.haunted_tall, R.drawable.infernal_tall,
                R.drawable.temple_tall, R.drawable.spider_tall, R.drawable.towers_tall, R.drawable.warhead_tall};
        // Instructions on when to start timer again
        String[] infoText = {"Press when immortal dies","Press when final cannon fired",
                             "Press when zergs are gone","NOT AVAILABLE","Press when dragon dies",
                             "Press when night ends","NOT AVAILABLE","Press when golem dies",
                             "Press when immortal dies","Press when temples end","NOT AVAILABLE",
                             "Press when altars are collected","Press when nukes are collected"};
        // Countdown text
        String[] timeText = {"FIGHT!","COINS!","BEACONS!","","SHRINES!","GARDEN!","","MINES!","SHRINES!","TEMPLES!","","ALTARS!","NUKES!"};
        // Camp information per map, currently not being used
        String[] bruiserText = {"","","","","","","","","","","","",""};
        String[] mercText = {"","","","","","","","","","","","",""};
        String[] bossText = {"","","","","","","","","","","","",""};
        // Timers per map in milliseconds
        int[] first_time = {105000, 50000, 120000, 0, 75000, 90000, 0, 120000, 120000, 90000, 0, 120000, 120000};
        int[] second_time = {105000, 165000, 115000, 0, 120000, 200000, 0, 120000, 120000, 120000, 0, 120000, 180000};

        // Populate maps
        Map[] maps = new Map[number_of_maps];
        for(int i = 0; i < number_of_maps; i++) {
            Map m = new Map(i, mapTitle[i], mapImages[i], infoText[i], timeText[i], bruiserText[i],
                    mercText[i], bossText[i], first_time[i], second_time[i], mapTallImages[i]);
            maps[i] = m;
        }

        // Get Adapter
        mAdapter = new MapAdapter(maps, this);
        // Set Adapter
        mRecyclerView.setAdapter(mAdapter);
    }
}
