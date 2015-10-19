package com.dream.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dream.app.R;
import com.dream.model.entity.ModelBean;

import java.util.List;


/**
 * Description:RecyclerView ������
 * User: xjp
 * Date: 2015/6/8
 * Time: 10:15
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {


    private Context context;
    private List<ModelBean> list;
    private Resources res;
    private OnItemClickListener listener;

    public RecyclerAdapter(Context context, List<ModelBean> list) {
        this.context = context;
        this.list = list;
        res = context.getResources();
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        final ModelBean bean = list.get(position);
        holder.title.setText(bean.getTitle());
        holder.imageView.setImageResource(bean.getResId());
        Bitmap bitmap = BitmapFactory.decodeResource(res, bean.getResId());
        //�첽���bitmapͼƬ��ɫֵ
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch vibrant = palette.getVibrantSwatch();//�л���
                Palette.Swatch c = palette.getDarkVibrantSwatch();//�л��� ��ɫ
                Palette.Swatch d = palette.getLightVibrantSwatch();//�л��� ��ɫ
                Palette.Swatch f = palette.getMutedSwatch();//���
                Palette.Swatch a = palette.getDarkMutedSwatch();//��� ��ɫ
                Palette.Swatch b = palette.getLightMutedSwatch();//��� ��ɫ

                if (vibrant != null) {
                    int color1 = vibrant.getBodyTextColor();//������ɫ
                    int color2 = vibrant.getTitleTextColor();//������ɫ
                    int color3 = vibrant.getRgb();//rgb��ɫ

                    holder.title.setBackgroundColor(vibrant.getRgb());
                    holder.title.setTextColor(vibrant.getTitleTextColor());
                }
            }
        });

        /**
         * ���ýӿڻص�
         */
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != listener)
                    listener.onItemClick(position, bean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return null == list ? 0 : list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView title;

        public MyViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.pic);
            title = (TextView) view.findViewById(R.id.name);
        }
    }

    /**
     * �ڲ��ӿڻص�����
     */
    public interface OnItemClickListener {
        void onItemClick(int position, Object object);
    }

    /**
     * ���ü�������
     *
     * @param listener
     */
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

}
