package hewan.hewanan.ViewModel;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.*;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.*;
import hewan.hewanan.model.hewanmodel;
import hewan.hewanan.R;
import java.util.ArrayList;

public class AdapterView extends RecyclerView.Adapter<AdapterView.ViewHolder> {
  public ArrayList<hewanmodel> model_hewan;
  public Context ctx;
  public Handler handler;

  public AdapterView(ArrayList<hewanmodel> model_hewan, Context ctx) {
    this.model_hewan = model_hewan;
    this.ctx = ctx;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
    View view =
        LayoutInflater.from(arg0.getContext()).inflate(R.layout.rows_hewan_cardview, arg0, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ViewHolder arg0, int arg1) {
    // perubahan itemview
    hewanmodel hewanmodel = model_hewan.get(arg1);

    arg0.nama_hewan.setText(hewanmodel.nama);
    arg0.gambar_hewan.setBackgroundResource(hewanmodel.gambar);
    
    //arg0.gambar_hewan.setImageResource(hewanmodel.gambar);
    
    arg0.setSuara_hewan(hewanmodel.suara);
  }

  @Override
  public int getItemCount() {
    return this.model_hewan.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    // Inisialisasi View
    public ImageView gambar_hewan;
    public TextView nama_hewan;
    public int suara_hewan;
    public MediaPlayer play_sound;
    public CardView cardview;
    
    public ViewHolder(View view) {
      super(view);
      this.gambar_hewan = view.findViewById(R.id.rows_hewanImageView);
      this.nama_hewan = view.findViewById(R.id.rows_hewanTextView_nama);
      this.cardview = view.findViewById(R.id.cardview);
      
      cardview.setOnClickListener(
          (View v) -> {
            cardview.setClickable(false);
            cardview.setCardBackgroundColor(Color.RED);
            //cardview.setBackgroundColor(Color.RED);
            play_sound = MediaPlayer.create(ctx, suara_hewan);
            play_sound.setOnCompletionListener(
                new MediaPlayer.OnCompletionListener() {
                  @Override
                  public void onCompletion(MediaPlayer arg0) {
                    if (play_sound != null) {
                      play_sound.release();
                      cardview.setCardBackgroundColor(Color.WHITE);
                      //cardview.setBackgroundColor(Color.WHITE);
                      cardview.setClickable(true);
                    }
                    // TODO: Implement this method

                  }
                });
            play_sound.start();
          });
    }

    public void setSuara_hewan(int suara) {
      this.suara_hewan = suara;
    }
  }
}
