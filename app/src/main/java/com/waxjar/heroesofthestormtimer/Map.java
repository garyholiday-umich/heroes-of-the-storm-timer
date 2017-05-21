package com.waxjar.heroesofthestormtimer;


import java.io.Serializable;

public class Map implements Serializable {

    private int map_id, image, first_time, second_time, tall_image;
    private String title, info, time_text, bruiser, merc, boss;
    private boolean first = true;

    public Map(int map_id, String title, int image, String info, String time_text, String bruiser, String merc,
               String boss, int first_time, int second_time, int tall_image) {
        this.map_id = map_id;
        this.title = title;
        this.image = image;
        this.info = info;
        this.time_text = time_text;
        this.bruiser = bruiser;
        this.merc = merc;
        this.boss = boss;
        this.first_time = first_time;
        this.second_time = second_time;
        this.tall_image = tall_image;
    }

    public String getTitle() {
        return title;
    }

    public int getTallImage() {
        return tall_image;
    }

    public void setFirst() {
        first = false;
    }

    public int getImage() {
        return image;
    }

    public String getInfoText() {
        return info;
    }

    public long getTimer() {
        if(first) return first_time;
        return second_time;
    }

    public String timeText() {
        return time_text;
    }

    public String getBruiserInfo() {
        return bruiser;
    }
    public String getMercInfo() {
        return merc;
    }
    public String getBossInfo() {
        return boss;
    }

}