package miwok.android.example.com.learnc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HeadingAdapter extends RecyclerView.Adapter<HeadingAdapter.ViewHolder> {
    TextView s_no;
    int b;
    private ArrayList<Heading> words;
    private Context context;




    public HeadingAdapter(Activity context, ArrayList<Heading> words) {
        this.context=context;
         this.words=words;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
         b =position;
        b=b+1;
        final Heading currentheading =words.get(position);

        holder.title.setText(currentheading.getmTitle());

        String tmpStr10 = String.valueOf(b);
          holder.s_no.setText(tmpStr10+".");
        holder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentheading.getInt()>100)
                {
                    Intent intent=new Intent(context,learn.class).putExtra("Roll",currentheading.getInt());
                    context.startActivity(intent);
                }
                else{
//                Toast.makeText(context, "Url is "+currentheading.getmUrl(), Toast.LENGTH_SHORT).show();
               // Toast.makeText(context, "Roll no Id is "+currentheading.getInt(), Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(context,WebView.class).putExtra("Roll",currentheading.getInt());
                context.startActivity(intent);}
            }
        });

    }

    @Override
    public int getItemCount() {
        return  this.words.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private View parentView;
        private TextView s_no;

        public ViewHolder(View view){
            super(view);
            this.parentView=view;
            this.title=(TextView)view.findViewById(R.id.title);
            this.s_no = (TextView) view.findViewById(R.id.s_no);

//            this.sno=(TextView)view.findViewById(R.id.s_no);
        }
    }
}
