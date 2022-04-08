package com.example.passwordmanager.data;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.passwordmanager.model.User;

@Database(entities = (User.class),version = 1,exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {
    public  abstract UserDao getUserDao();
}
