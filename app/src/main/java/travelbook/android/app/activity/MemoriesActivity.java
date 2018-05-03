package travelbook.android.app.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import travelbook.android.app.R;
import travelbook.android.app.data.MemoriesDao;
import travelbook.android.app.data.Memory;
import travelbook.android.app.data.TravelBookDatabaseOpenHelper;

public class MemoriesActivity extends AppCompatActivity {

    private static final String TAG = MemoriesActivity.class.getSimpleName();

    private MemoriesDao memoriesDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memories);
        setTitle(R.string.memories_title);

        memoriesDao = new MemoriesDao(new TravelBookDatabaseOpenHelper(getApplicationContext()));
        final List<Memory> memories = memoriesDao.fetchAll();
        Log.d(TAG, "Fetched memories: " + memories);
    }
}
