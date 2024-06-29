package hewan.hewanan.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import hewan.hewanan.databinding.WelcomeLayoutBinding;

public class Welcome extends AppCompatActivity {
    WelcomeLayoutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = WelcomeLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}