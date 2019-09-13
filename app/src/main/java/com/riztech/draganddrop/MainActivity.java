package com.riztech.draganddrop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout linLayTarget;
    private ViewGroup rootLayout;
    private int _xDelta, _yDelta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rootLayout = findViewById(R.id.view_root);
        linLayTarget = findViewById(R.id.linLayTarget);
        linLayTarget.setOnTouchListener(new ChoiceTouchListener());
    }

    class ChoiceTouchListener implements View.OnTouchListener {


        @Override
        public boolean onTouch(View v, MotionEvent event) {
            final int X = (int) event.getRawX();
            final int Y = (int) event.getRawY();


            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                   /* MyDragShadowBuilder myDragShadowBuilder = new MyDragShadowBuilder(v);
                    v.startDrag(null, myDragShadowBuilder, null, 0);*/
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams)v.getLayoutParams();
                    _xDelta = X - lParams.leftMargin;
                    _yDelta = Y - lParams.topMargin;
                    break;
                    case MotionEvent.ACTION_MOVE:
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)v.getLayoutParams();
                        layoutParams.leftMargin = X -_xDelta;
                        layoutParams.topMargin = Y - _yDelta;
                        layoutParams.rightMargin = -250;
                        layoutParams.bottomMargin = -250;
                        v.setLayoutParams(layoutParams);
                        break;

            }

            return false;
        }
    }
}
