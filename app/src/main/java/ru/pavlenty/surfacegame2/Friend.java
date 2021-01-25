package ru.pavlenty.surfacegame2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.Log;

import java.util.Random;

public class Friend {

    private Bitmap bitmap;
    private int x;
    private int y;
    private int speed = 20;

    private int maxX;
    private int maxY;

    public Friend(Context context, int screenX, int screenY) {
        Log.d("RRR screenX",Integer.toString(screenX));

        this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.friend);
        this.maxX = screenX;
        this.maxY = screenY;
        Random r = new Random();
        speed = r.nextInt(6);
        x = screenX;
        y = r.nextInt(this.maxY);
    }

    public void update(int playerSpeed) {
        x -= playerSpeed;
        if (x < 0 - getBitmap().getWidth()) {
            Random gen = new Random();
            x = this.maxX + gen.nextInt(1500);
            y = gen.nextInt(this.maxY);
        }
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
