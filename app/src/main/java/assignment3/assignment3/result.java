package assignment3.assignment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class result extends AppCompatActivity {
    List<String> resultListGreenS = new ArrayList<String>();
    ListView lw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        resultListGreenS = intent.getStringArrayListExtra("green");
        // Get the reference of greenlist
        lw = (ListView) findViewById(R.id.greenlist);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                resultListGreenS);

        lw.setAdapter(arrayAdapter);
    }
}
