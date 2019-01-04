package com.coryperkins.HelloConstraint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button mResetCountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // store a reference to the show_count View so we can access it at runtime
        mShowCount = (TextView) findViewById(R.id.show_count);

        // store a reference to the reset_count Button so we can change its color from outside its
        // onClick event handler
        mResetCountButton = (Button) findViewById(R.id.button_zero);
    }

    public void showToast(View view) {
        // create and display a Toast message
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        // increment the count
        mCount++;

        // if mCount is odd set the button's background color to purple, else set it to the
        // theme's primary color
        if (mCount % 2 == 0) {
            view.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        } else {
            view.setBackgroundColor(getResources().getColor(android.R.color.holo_purple));
        }

        // set the reset button's background color to purple to signify it is now active
        if (mResetCountButton != null) {
            mResetCountButton.setBackgroundColor(
                    getResources().getColor(android.R.color.holo_purple)
            );
        }

        // update the text view to display the new value of mCount
        updateCountView();
    }

    public void resetCount(View view) {
        // reset mCount
        mCount = 0;

        // update the text view to display the new value of mCount
        updateCountView();

        // set the background color back to grey (to signify that this button is no longer active)
        view.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
    }


    private void updateCountView() {
        // stringify the new value of mCount and display it in the text view
        // probably should make sure the text view exists first...
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
    }
}
