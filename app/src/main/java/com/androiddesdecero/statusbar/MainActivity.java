package com.androiddesdecero.statusbar;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
Status Bar
En Android la Barra de Estado contiene Iconos de Notifiación e Iconos del Sistema.
Podemos cambiar el color de la barra, el color de los iconos y tambien ocultar dicha barra de estado.

Se suele ocultar la barra de estado para dar más espacio a la visualización y esto ofrece al usuario una experiencia más envolvente
*/

public class MainActivity extends AppCompatActivity {

    private Button hideStatusBar;
    private Button changeColorStatusBar;
    private Button darkenIconsColorStatusBar;
    private Button lightIconsColorStatusBar;
    private Button makeContentAppearBehindStatusBar;
    private int numeroColor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ocultar Action Bar
        getSupportActionBar().hide();
        //Poner el Backgroun con un Gradiente
        getWindow().setBackgroundDrawableResource(R.drawable.gradient);

        setUpStatusBar();
    }

    private void setUpStatusBar(){
        /*
        1 -> Oscurecer Iconos Status Bar
        */
        darkenIconsColorStatusBar = findViewById(R.id.darkenIconsColorStatusBar);
        darkenIconsColorStatusBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                }
            }
        });

        /*
        2 -> Aclarar Iconos Status Bar
        */
        lightIconsColorStatusBar = findViewById(R.id.lightIconsColorStatusBar);
        lightIconsColorStatusBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    getWindow().getDecorView().setSystemUiVisibility(0);
                }
            }
        });

        /*
        3 -> Cambiar Color Status Bar
        3.1 Transparent
        3.2 Color rojo
        3.3 Color Opaco
        */
        changeColorStatusBar = findViewById(R.id.changeColorStatusBar);
        changeColorStatusBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    switch (numeroColor){
                        case 0:
                            getWindow().setStatusBarColor(Color.TRANSPARENT);
                            break;
                        case 1:
                            getWindow().setStatusBarColor(Color.RED);
                            break;
                        case 2:
                            getWindow().setStatusBarColor(Color.parseColor("#BBFFFFFF"));
                            break;
                    }
                    if(numeroColor++ == 2)numeroColor=0;
                }
            }
        });

        /*
        4 -> Eliminar Status Bar
        */
        hideStatusBar = findViewById(R.id.hideStatusBar);
        hideStatusBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View decorView = getWindow().getDecorView();
                int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
                decorView.setSystemUiVisibility(uiOptions);
            }
        });

        /*
        5 -> Quitar la Barra pero dejar los Iconos
        */
        makeContentAppearBehindStatusBar = findViewById(R.id.makeContentAppearBehindStatusBar);
        makeContentAppearBehindStatusBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    getWindow().setStatusBarColor(Color.TRANSPARENT);
                }
            }
        });
    }

}
