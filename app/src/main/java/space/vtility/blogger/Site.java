package space.vtility.blogger;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class Site{

    String name;


    public Site(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

   /* public void getPref(){
        SharedPreferences.Editor editor = getSharedPreferences("swap",MODE_PRIVATE).edit();
    }*/


}
