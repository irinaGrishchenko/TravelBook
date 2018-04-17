package travelbook.android.app.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

/**
 * A class for working with the database.
 */
public class TravelBookDatabaseOpenHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "travelbook.db";

    public TravelBookDatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MemoriesContract.SQL_CREATE_ENTRIES);

        db.execSQL(PhotosContract.SQL_CREATE_ENTRIES);

        db.execSQL(PhotosContract.SQL_CREATE_UNIQUE_INDEX_MEMORY);

        db.execSQL(PhotosContract.SQL_CREATE_UNIQUE_INDEX_PHOTO_URI);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            db.setForeignKeyConstraintsEnabled(true);
        } else {
            db.execSQL("PRAGMA foreign_keys = 1");
        }
    }
}
