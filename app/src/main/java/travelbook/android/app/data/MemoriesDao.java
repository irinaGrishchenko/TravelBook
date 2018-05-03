package travelbook.android.app.data;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A data access object class which provides CRUD functionality
 * for Memories persistent storage.
 */
public class MemoriesDao {

    private final TravelBookDatabaseOpenHelper travelBookDatabaseOpenHelper;
    String selection = "is_primary != ?";
    String[] selectionArgs = {"null"};

    public MemoriesDao(TravelBookDatabaseOpenHelper travelBookDatabaseOpenHelper) {
        this.travelBookDatabaseOpenHelper = travelBookDatabaseOpenHelper;
    }

    public List<Memory> fetchAll() {
        List<Memory> memoryList = new ArrayList<Memory>();

        SQLiteDatabase db = travelBookDatabaseOpenHelper.getWritableDatabase();
        Cursor cursor = db.query(
                MemoriesContract.MemoriesEntry.TABLE_NAME
                        + " LEFT JOIN " + PhotosContract.PhotosEntry.TABLE_NAME
                        + " ON " + MemoriesContract.MemoriesEntry.TABLE_NAME + " . "
                        + MemoriesContract.MemoriesEntry.COLUMN_NAME_MEMORY_ID
                        + " = " + PhotosContract.PhotosEntry.TABLE_NAME + " . "
                        + PhotosContract.PhotosEntry.COLUMN_NAME_MEMORY,
                null, selection, selectionArgs, null, null, null);


        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            long memoryId = cursor.getLong(
                    cursor.getColumnIndex(MemoriesContract.MemoriesEntry.COLUMN_NAME_MEMORY_ID));
            String memoryDesc = cursor.getString(
                    cursor.getColumnIndex(MemoriesContract.MemoriesEntry.COLUMN_NAME_MEMORY_DESC));
            String isPrimary = cursor.getString(
                    cursor.getColumnIndex(PhotosContract.PhotosEntry.COLUMN_NAME_IS_PRIMARY));

            Photo photo = Photo.builder()
                    .id(cursor.getLong(cursor.getColumnIndex(PhotosContract.PhotosEntry.COLUMN_NAME_PHOTO_ID)))
                    .uri(cursor.getString(cursor.getColumnIndex(PhotosContract.PhotosEntry.COLUMN_NAME_PHOTO_URI)))
                    .isPrimary(isPrimary != null)
                    .text(cursor.getString(cursor.getColumnIndex(PhotosContract.PhotosEntry.COLUMN_NAME_PHOTO_DESC)))
                    .build();

            Memory memory = Memory.builder()
                    .id(memoryId)
                    .description(memoryDesc)
                    .photos(Collections.singletonList(photo))
                    .build();


            memoryList.add(memory);
            cursor.moveToNext();
        }
        return memoryList;
    }
}
