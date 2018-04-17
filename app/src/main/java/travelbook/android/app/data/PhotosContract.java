package travelbook.android.app.data;

/**
 * A container for constants, that define names for Photos table.
 */
public final class PhotosContract {

    private PhotosContract() {
    }

    static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + PhotosEntry.TABLE_NAME + " (" +
                    PhotosEntry.COLUMN_NAME_PHOTO_ID + " INTEGER  PRIMARY KEY," +
                    PhotosEntry.COLUMN_NAME_PHOTO_URI + " TEXT NOT NULL," +
                    PhotosEntry.COLUMN_NAME_PHOTO_DESC + " TEXT," +
                    PhotosEntry.COLUMN_NAME_IS_PRIMARY + " INTEGER," +
                    PhotosEntry.COLUMN_NAME_MEMORY + " INTEGER REFERENCES " +
                    MemoriesContract.MemoriesEntry.TABLE_NAME + " ON DELETE CASCADE)";

    static final String SQL_CREATE_UNIQUE_INDEX_MEMORY =
            "CREATE UNIQUE INDEX " + PhotosEntry.UNIQUE_INDEX_MEMORY + " ON " +
                    PhotosEntry.TABLE_NAME + "( " +
                    PhotosEntry.COLUMN_NAME_IS_PRIMARY + ", " +
                    PhotosEntry.COLUMN_NAME_MEMORY + ")";

    static final String SQL_CREATE_UNIQUE_INDEX_PHOTO_URI =
            "CREATE UNIQUE INDEX " + PhotosEntry.UNIQUE_INDEX_PHOTO_URI + " ON " +
                    PhotosEntry.TABLE_NAME + "( " +
                    PhotosEntry.COLUMN_NAME_PHOTO_URI + ")";

    public static class PhotosEntry {
        public static final String TABLE_NAME = "Photos";
        public static final String COLUMN_NAME_PHOTO_ID = "photo_id";
        public static final String COLUMN_NAME_PHOTO_URI = "photo_uri";
        public static final String COLUMN_NAME_PHOTO_DESC = "photo_desc";
        public static final String COLUMN_NAME_IS_PRIMARY = "is_primary";
        public static final String COLUMN_NAME_MEMORY = "memory";
        public static final String UNIQUE_INDEX_MEMORY = "index_is_primary_memory";
        public static final String UNIQUE_INDEX_PHOTO_URI = "index_photo_uri";
    }
}
