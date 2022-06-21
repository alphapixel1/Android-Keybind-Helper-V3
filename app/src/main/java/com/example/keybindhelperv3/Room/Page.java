package com.example.keybindhelperv3.Room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Page {
    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo
    public String name;

    @ColumnInfo(name="projectID")
    public long projectID;

    @ColumnInfo(name="index")
    public int index;
}
