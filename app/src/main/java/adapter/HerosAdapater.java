package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kiran.apiexample.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import model.Heros;

public class HerosAdapater extends RecyclerView.Adapter<HerosAdapater.ViewHolder>
{
    private static final String TAG = "HerosAdapater";
    private List<Heros> lstHeros = new ArrayList<>();
    Context context;

    public HerosAdapater(List<Heros> lstHeros, Context context) {
        this.lstHeros = lstHeros;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem,viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Heros hero = lstHeros.get(i);
       // viewHolder.avatar.setImageResource(hero.getId());
        viewHolder.name.setText(hero.getName());
        viewHolder.realName.setText(hero.getRealName());
        viewHolder.superPowers.setText(hero.getSuperPowers());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView avatar;
        TextView name , realName , superPowers;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
         //   avatar = itemView.findViewById(R.id.avatar);
            name = itemView.findViewById(R.id.lblName);
            realName = itemView.findViewById(R.id.lblRealName);
            superPowers = itemView.findViewById(R.id.lblSuperPowers);
        }
    }
}

