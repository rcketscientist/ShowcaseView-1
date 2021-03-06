package showcaseview.outlander.showcaseviewdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import outlander.showcaseview.ShowcaseViewBuilder;

public class MainActivity extends AppCompatActivity {

    public ShowcaseViewBuilder showcaseViewBuilder;

    private FloatingActionButton fab;
    private TextView textView;
    private ImageView imageView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView = (TextView) findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showcaseTextView();
            }
        });

        imageView = (ImageView) findViewById(R.id.imgBtn);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showcaseImage();
            }
        });

        button = (Button) findViewById(R.id.magic_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showcaseButton();
            }
        });

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showcaseFab();
            }
        });

        showcaseViewBuilder = ShowcaseViewBuilder.init(this);

        showcaseFab();

    }

    private void showcaseFab() {
        showcaseViewBuilder.setTargetView(fab)
                .setBackgroundOverlayColor(0xdd70d2cd)
                .setRingColor(0xccb9e797)
                .setRingWidth(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, getResources().getDisplayMetrics()))
                .setMarkerDrawable(getResources().getDrawable(R.drawable.arrow_up), Gravity.LEFT)
                .addCustomView(R.layout.fab_description_view, Gravity.TOP)
                .setCustomViewMargin((int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 70, getResources().getDisplayMetrics()));

        showcaseViewBuilder.show();

        showcaseViewBuilder.setClickListenerOnView(R.id.btn, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showcaseViewBuilder.hide();
            }
        });
    }

    private void showcaseTextView() {
        showcaseViewBuilder.setTargetView(textView)
                .setBackgroundOverlayColor(0xdd70d2cd)
                .setRingColor(0xccb9e797)
                .setRingWidth(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, getResources().getDisplayMetrics()))
                .setMarkerDrawable(getResources().getDrawable(android.R.drawable.arrow_down_float), Gravity.BOTTOM)
                .setDrawableLeftMargin(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics()))
                .addCustomView(R.layout.textview_description_view, Gravity.BOTTOM)
                .addCustomView(R.layout.skip_layout)
                .setCustomViewMargin((int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()));

        showcaseViewBuilder.show();

        showcaseViewBuilder.setClickListenerOnView(R.id.skip_btn, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showcaseViewBuilder.hide();
            }
        });
    }

    private void showcaseButton() {
        showcaseViewBuilder.setTargetView(button)
                .setBackgroundOverlayColor(0xee4d4d4d)
                .setRingColor(0xcc8e8e8e)
                .setRingWidth(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, getResources().getDisplayMetrics()))
                .setMarkerDrawable(getResources().getDrawable(android.R.drawable.arrow_up_float), Gravity.BOTTOM)
                .setDrawableLeftMargin(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics()))
                .addCustomView(R.layout.button_description_view_bottom, Gravity.BOTTOM)
                .addCustomView(R.layout.skip_layout)
                .addCustomView(R.layout.button_description_view_top, Gravity.TOP)
                .setCustomViewMargin((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, getResources().getDisplayMetrics()));

        showcaseViewBuilder.show();

        showcaseViewBuilder.setClickListenerOnView(R.id.skip_btn, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showcaseViewBuilder.hide();
            }
        });
    }

    private void showcaseImage() {
        showcaseViewBuilder.setTargetView(imageView)
                .setBackgroundOverlayColor(0xee4d4d4d)
                .setRingColor(0xcc8e8e8e)
                .setRingWidth(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics()))
                .setMarkerDrawable(getResources().getDrawable(android.R.drawable.arrow_down_float), Gravity.BOTTOM)
                .setDrawableLeftMargin(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics()))
                .addCustomView(R.layout.image_description_view, Gravity.BOTTOM)
                .setHideOnTouchOutside(true)
                .setCustomViewMargin((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));

        showcaseViewBuilder.show();
    }
}
