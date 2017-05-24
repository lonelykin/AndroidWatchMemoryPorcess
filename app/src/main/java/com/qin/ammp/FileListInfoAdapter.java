package com.qin.ammp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by akin on 2016/7/18.
 */
public class FileListInfoAdapter extends BaseAdapter
{
    private List<String> file_list = null;
    LayoutInflater infater = null;

    public FileListInfoAdapter(Context context, List<String> files)
    {
        infater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        file_list = files;
    }
    @Override
    public int getCount()
    {
        return file_list.size();
    }

    @Override
    public Object getItem(int position)
    {
        return file_list.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup arg2)
    {
        View view = null;
        ViewHolder holder = null;
        if (convertview == null || convertview.getTag() == null)
        {
            view = infater.inflate(R.layout.file_list_item, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else
        {
            view = convertview;
            holder = (ViewHolder) convertview.getTag();
        }
        String fileName = (String) getItem(position);
        holder.fileName.setText(fileName);
        return view;
    }

    class ViewHolder
    {
        TextView fileName;   // 文件名

        public ViewHolder(View view)
        {
            this.fileName = (TextView) view.findViewById(R.id.fileName);
        }
    }
}
