package com.bw.zhangzhenming20200414.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.bw.zhangzhenming20200414.R;

/**
 * 时间：2020/4/14
 * 作者：张振明
 * 类的作用：
 */
public class MyCircleView extends View {
    public MyCircleView(Context context) {
        super(context);
    }

    public MyCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //画
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Resources resources = getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(resources, R.mipmap.user);
        //
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        //画笔
        Paint paint = new Paint();
        paint.setShader(bitmapShader);
        //画圆
        canvas.drawCircle(getWidth()/2,getHeight()/2,100,paint);
    }
}
