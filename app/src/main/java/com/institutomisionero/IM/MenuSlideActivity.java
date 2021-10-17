package com.institutomisionero.IM;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.institutomisionero.IM.databinding.ActivityMenuSlideBinding;

import de.hdodenhof.circleimageview.CircleImageView;

public class MenuSlideActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMenuSlideBinding binding;
    private TextView userNombre,userEmail;
    private CircleImageView userImg;
    private FirebaseAuth mAuth;
    Button btnCerrarSesion;

    //Variables opcionales para desloguear de google tambien
    private GoogleSignInClient mGoogleSignInClient;
    private GoogleSignInOptions gso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMenuSlideBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMenuSlide.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.coritarioFragment,
                R.id.facebookFragment, R.id.instagramFragment, R.id.youtubeFragment, R.id.donacionesFragment,R.id.acercaDeFragment)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_menu_slide);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //******************************************************************************************************************

        //Banner de datos de usuario
        NavigationView navigationview = (NavigationView) findViewById(R.id.nav_view);
        View navHeaderView =  navigationView.getHeaderView(0);;

        userImg = (CircleImageView) navHeaderView.findViewById(R.id.userImagen);
        userNombre = (TextView) navHeaderView.findViewById(R.id.userNombre);
        userEmail = (TextView) navHeaderView.findViewById(R.id.userEmail);
        btnCerrarSesion = (Button) navHeaderView.findViewById(R.id.btnLogout);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser != null) {
            //Setear datos:
            userNombre.setText(currentUser.getDisplayName());
            userEmail.setText(currentUser.getEmail());
            //cargar imágen con glide:
            Glide.with(this).load(currentUser.getPhotoUrl()).into(userImg);

            //Configurar las gso para google signIn con el fin de luego desloguear de google
            gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken(getString(R.string.default_web_client_id))
                    .requestEmail()
                    .build();
            mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

            btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //cerrar sesion con firebase
                    mAuth.signOut();
                    //cerrar sesion con google sign out
                    mGoogleSignInClient.signOut().addOnCompleteListener(task -> {
                        //Abrir MainActivity con SigIn button
                        if (task.isSuccessful()) {
                            Intent loginActivity = new Intent(getApplicationContext(), loginActivity.class);
                            startActivity(loginActivity);
                            MenuSlideActivity.this.finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "No se pudo cerrar sesión con google",
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                }
            });
        }
        else{
            //Datos
            userNombre.setText(R.string.app_name);
            userEmail.setText(R.string.email_im);

            //Boton
            btnCerrarSesion.setText(R.string.login);
            btnCerrarSesion.setOnClickListener(v -> {
                Intent intent = new Intent(MenuSlideActivity.this, loginActivity.class);
                startActivity(intent);
                MenuSlideActivity.this.finish();
            });
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_slide, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_menu_slide);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {

        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            getFragmentManager().popBackStack();
        } else {
            getFragmentManager().popBackStack();
        }
    }
}