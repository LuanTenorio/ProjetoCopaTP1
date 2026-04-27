package com.github.luantenorio.projetocopatp1.util;

import com.github.luantenorio.projetocopatp1.interfaces.Persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class DAO<T> implements Persistence<T> {

    private static final String HOME = System.getProperty("user.home");
    private static final File folder = new File(HOME, ".projetocopatp1");
    private final File databaseFile;

    public DAO(String fileName) {
        if (!folder.exists())
            folder.mkdirs();

        this.databaseFile = new File(folder, fileName);
    }

    protected List<T> readFile() {
        if (!databaseFile.exists())
            return new ArrayList<>();

        try{
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(databaseFile));
            return (List<T>) stream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    protected boolean saveFile(List<T> arr) {
        try {
            ObjectOutputStream strem = new ObjectOutputStream(new FileOutputStream(databaseFile));
            strem.writeObject(arr);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    protected void clearAll(){
        this.saveFile(new ArrayList<>());
    }
}
