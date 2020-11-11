package com.example.paging.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Student.class},version = 1,exportSchema = false)
public abstract class StudentDatabase extends RoomDatabase {
    public static final String[] data = {
            "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
            "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale",
            "Aisy Cendre", "Allgauer Emmentaler", "Alverca", "Ambert", "American Cheese",
            "Ami du Chambertin", "Anejo Enchilado", "Anneau du Vic-Bilh", "Anthoriro", "Appenzell",
            "Aragon", "Ardi Gasna", "Ardrahan", "Armenian String", "Aromes au Gene de Marc",
            "Asadero", "Asiago", "Aubisque Pyrenees", "Autun", "Avaxtskyr", "Baby Swiss",
            "Babybel", "Baguette Laonnaise", "Bakers", "Baladi", "Balaton", "Bandal", "Banon",
            "Barry's Bay Cheddar", "Basing", "Basket Cheese", "Bath Cheese", "Bavarian Bergkase",
            "Baylough", "Beaufort", "Beauvoorde", "Beenleigh Blue", "Beer Cheese", "Bel Paese",
            "Bergader", "Bergere Bleue", "Berkswell", "Beyaz Peynir", "Bierkase", "Bishop Kennedy",
            "Blarney", "Bleu d'Auvergne", "Bleu de Gex", "Bleu de Laqueuille",
            "Bleu de Septmoncel", "Bleu Des Causses", "Blue", "Blue Castello", "Blue Rathgore",
            "Blue Vein (Australian)", "Blue Vein Cheeses", "Bocconcini", "Bocconcini (Australian)"
    };

    public static StudentDatabase instance;

    public static StudentDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, StudentDatabase.class, "st.db")
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            new IOExecutor(() -> {
                                //插入一些模拟数据
                                List<Student> list = new ArrayList<>();
                                Student student;
                                for (String d : data) {
                                    student = new Student(d);
                                    list.add(student);
                                }
                                getInstance(context).getStudentDao().insert(list);
                            });
                        }
                    })
                    .build();
        }
        return instance;
    }

    public abstract PagingDao getStudentDao();


    /**
     * io线程异步执行
     */
    static class IOExecutor {

        private ExecutorService IO_EXECUTOR = Executors.newSingleThreadExecutor();

        public IOExecutor(Runnable task) {
            IO_EXECUTOR.execute(task);
        }
    }
}
