package com.daleondeveloper.cosmetogybeaty.DB.Entity;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(indices = {@Index(value = "name",unique = true)})
public class Procedure {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String name;
    private String shortDescription;
    private String description;
    private String youtubeId;
    private String image;

    private int cost;
    private int duration;

    private boolean isAvailable;

    public Procedure(String name, String shortDescription, String description, String youtubeId, String image, int cost, int duration, boolean isAvailable) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.description = description;
        this.youtubeId = youtubeId;
        this.image = image;
        this.cost = cost;
        this.duration = duration;
        this.isAvailable = isAvailable;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
