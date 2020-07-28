package com.nurozkaya.landmarkbook;

import android.graphics.Bitmap;

public class Singleton { // sadece bu sınıftan erişilmesini istediğimiz için
    private Bitmap chosenImage ;
    private static Singleton singleton;

    public Singleton () { // constructor


    }

    public Bitmap getChosenImage() { // getter andn setter
        return chosenImage;
    }

    public void setChosenImage(Bitmap chosenImage) {
        this.chosenImage = chosenImage;
    }
    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
        }
    }
}
