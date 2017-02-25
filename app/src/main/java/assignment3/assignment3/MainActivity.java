package assignment3.assignment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewSwitcher;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Long> resultListGreen = new ArrayList<Long>();
    List<String> resultListGreenS = new ArrayList<String>();
    List<Long> resultListRed = new ArrayList<Long>(resultListGreen.size());
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Let the ViewSwitcher do the animation listening (red button will fade in 1 sec, best result
        // is one sec.
        ((ViewSwitcher) findViewById(R.id.switcher)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ViewSwitcher switcher = (ViewSwitcher) v;
                long startTime = System.nanoTime();
                if (switcher.getDisplayedChild() == 0) {
                    switcher.showNext();
                    long estimatedTimeGreen = System.nanoTime() - startTime;
                    resultListGreen.add(estimatedTimeGreen);
                } else {
                    switcher.showPrevious();
                    long estimatedTimeRed = System.nanoTime() - startTime;
                    resultListRed.add(estimatedTimeRed);
                }
            }

        });


        // Locate the button in activity_main.xml
        button = (Button) findViewById(R.id.Button);

        // Capture button clicks and push the results from the green button
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                for (Long myLong : resultListGreen) {
                    resultListGreenS.add(String.valueOf(myLong));
                }
                Intent intent = new Intent(MainActivity.this, result.class);
                intent.putStringArrayListExtra("green", (ArrayList<String>) resultListGreenS);
                startActivity(intent);

            }
        });
    }



}
