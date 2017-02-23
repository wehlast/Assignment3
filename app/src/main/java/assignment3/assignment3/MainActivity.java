package assignment3.assignment3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Let the ViewSwitcher do the animation listening for you
        ((ViewSwitcher) findViewById(R.id.switcher)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ViewSwitcher switcher = (ViewSwitcher) v;

                if (switcher.getDisplayedChild() == 0) {
                    switcher.showNext();
                } else {
                    switcher.showPrevious();
                }
            }
        });
    }
}
