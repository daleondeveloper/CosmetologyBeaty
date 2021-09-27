package com.daleondeveloper.cosmetogybeaty.DB.Entity;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(indices = {@Index(value = "name",unique = true)})
public class Procedure {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String name;
    private String description;

    private long image;
    private int cost;
    private int duration;

    private boolean isAvailable;

    public Procedure(String name, String description, long image, int cost, int duration, boolean isAvailable) {
        this.name = name;
        this.description = description;
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

    public long getImage() {
        return image;
    }

    public void setImage(long image) {
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
}
