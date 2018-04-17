package travelbook.android.app.data;

/**
 * A container for constants, that define names for Memories table.
 */
public final class MemoriesContract {

    private MemoriesContract() {
    }

    static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + MemoriesEntry.TABLE_NAME + " (" +
                    MemoriesEntry.COLUMN_NAME_MEMORY_ID + " INTEGER PRIMARY KEY," +
                    MemoriesEntry.COLUMN_NAME_MEMORY_DESC + " TEXT)";

    public static class MemoriesEntry {
        public static final String TABLE_NAME = "Memories";
        public static final String COLUMN_NAME_MEMORY_ID = "memory_id";
        public static final String COLUMN_NAME_MEMORY_DESC = "memory_desc";
    }
}

