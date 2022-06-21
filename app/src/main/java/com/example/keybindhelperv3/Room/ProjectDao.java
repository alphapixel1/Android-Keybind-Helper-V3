package com.example.keybindhelperv3.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProjectDao {

    //projects
    @Query("Select * from Project")
    List<Project> getProjects();

    @Update
    void update(Project p);
    @Delete
    void delete(Project p);
    @Insert
    long insert(Project p);
//pages
    @Query("Select * from Page where projectID=:id")
    List<Page> getProjectPages(long id);
    @Insert
    long insert(Page p);
    @Update
    void update(Page p);
    @Delete
    void delete(Page p);

//groups
    @Query("Select * from `Group` Where pageID=:id")
    List<Group> getPageGroups(long id);

    @Query("Select * from `Group`")
    List<Group> getGroups();

    @Update
    void update(Group g);
    @Query("Delete from `group` where id=:id")
    void deleteGroup(long id);
    @Insert
    long insert(Group g);
    @Query("delete from `group` where pageID=:id")
    void deleteAllPageGroups(long id);

//keybinds
    @Query("Select * from keybind")
    List<Keybind> getKeybinds();

    @Query("Select * from 'keybind' where groupID=:id")
    List<Keybind> getGroupKeybinds(long id);
    @Update
    void update(Keybind k);
    @Delete
    void delete(Keybind k);
    @Insert
    long insert(Keybind k);
    @Query("delete from keybind where groupID=:id")
    void deleteGroupKeybinds(long id);




}
