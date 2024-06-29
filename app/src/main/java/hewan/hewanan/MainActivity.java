package hewan.hewanan;

import android.os.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import hewan.hewanan.ViewModel.AdapterView;
import hewan.hewanan.databinding.ActivityMainBinding;
import hewan.hewanan.model.hewanmodel;
import androidx.recyclerview.widget.GridLayoutManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

  private ActivityMainBinding binding;
  ArrayList<hewanmodel> list_hewan;
  RecyclerView RecyclerView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    // Remove this line if you don't want AndroidIDE to show this app's logs
    super.onCreate(savedInstanceState);
    // Inflate and get instance of binding
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    // set content view to binding's root
    setContentView(binding.getRoot());
    _init_();
    
    //TambahkanDatanyaDisini
    tambah_data(String.format("Kodok"), R.raw.kodok, R.drawable.kodok);
    tambah_data(String.format("Anjing"), R.raw.dog, R.drawable.dog);
    tambah_data(String.format("Monyet"), R.raw.monyet, R.drawable.monyet);
    
    sort_method();
  }

  public void tambah_data(String nama, int suara, int gambar) {
    list_hewan.add(new hewanmodel(nama, suara, gambar));
  }

  void _init_() {
    list_hewan = new ArrayList<hewanmodel>();
    AdapterView adapter = new AdapterView(list_hewan, this);
    binding.recyclerView.setAdapter(adapter);
    binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
  }

  void sort_method() {
    Collections.sort(
        list_hewan,
        new Comparator<hewanmodel>() {
          @Override
          public int compare(hewanmodel arg0, hewanmodel arg1) {
            return arg0.nama.compareTo(arg1.nama);
          }
        });
  }
}
