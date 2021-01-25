package ru.pavlenty.surfacegame2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.Log;

import java.util.Random;

public class Enemy {

    private Bitmap bitmap;
    private int x;
    private int y;
    private int speed = 60;

    private int maxX;
    private int maxY;
    private Rect detectCollision;

    public Enemy(Context context, int screenX, int screenY) {

        this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy);
        this.maxX = screenX;
        this.maxY = screenY;
        Random r = new Random();
        speed = r.nextInt(speed);
        x = screenX;
        y = r.nextInt(this.maxY);
        detectCollision =  new Rect(x, y, bitmap.getWidth(), bitmap.getHeight());
    }

    public void update() {
        x -= speed;
        if (x < 0 - getBitmap().getWidth()) {
            Random gen = new Random();
            x = this.maxX + gen.nextInt(1000);
            y = gen.nextInt(this.maxY);
        }
        detectCollision.left = x;
        detectCollision.top = y;
        detectCollision.right = x + bitmap.getWidth();
        detectCollision.bottom = y + bitmap.getHeight();
    }

    public boolean intersected(Player player) {
        return getDetectCollision().intersect(player.getDetectCollision());
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

    public Rect getDetectCollision() {
        return detectCollision;
    }
}
