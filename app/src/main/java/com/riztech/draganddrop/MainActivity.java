package com.riztech.draganddrop;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        LinearLayout llContainerMain = (LinearLayout) findViewById(R.id.llMainContainer);
        DragDropView dragDropView = new DragDropView(context);
        dragDropView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        ImageView ivTest = new ImageView(context);
        ivTest.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher_foreground));
        dragDropView.AddDraggableView(ivTest, 50, 50, RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        llContainerMain.addView(dragDropView);



    }

}