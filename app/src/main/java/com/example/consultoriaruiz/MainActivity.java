package com.example.consultoriaruiz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionMenu;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final FloatingActionMenu fab = findViewById(R.id.a);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_gallery, R.id.nav_slideshow, R.id.fragment_sobrenos, R.id.livro_digital)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                int menuId = destination.getId();
                switch (menuId)
                {
                    case R.id.livro_digital:

                        break;
                    }
            }
        });
    }


    public void AULA1 (View view)
    {Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(
            "https://youtu.be/s4Me9oAXAsw"));
    startActivity(browserIntent);
    }

    public void AULA2 (View view)
    {Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/gAY7IYMQXRo"));
    startActivity(browserIntent);
    }
    public void AULA3 (View view)
    {Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/5lmWwAQKD0g"));
        startActivity(browserIntent);
    }
    public void AULA3PT2 (View view)
    {Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/AEZlhVpJYaM"));
        startActivity(browserIntent);
    }
    public void AULA4 (View view)
    {Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/_qDbdqVmwyI"));
        startActivity(browserIntent);
    }

    public void INSTA (View view)
    {Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/consultoriaruiz/"));
    startActivity(browserIntent);}

    public void YOUTUBE (View view)
    {Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCxqgDz08asWVdwuDpT0w9dA"));
        startActivity(browserIntent);}

    public void WHATS (View view)
    {Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=5511977488763&text=Ol%C3%A1%2C%20Consultoria%20Ruiz.%20"));
        startActivity(browserIntent);}

    public void TELEGRAM (View view)
    {Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/comunidadeconsultoriaruiz"));
        startActivity(browserIntent);}


    public void Canal (View view)
    {Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCxqgDz08asWVdwuDpT0w9dA"));
        startActivity(browserIntent);}


    public void ComprarLivro (View view)
    {Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hotmart.com/product/manual-do-investidor-de-pardal-a-aguia"));
        startActivity(browserIntent);}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}