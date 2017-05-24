package com.qin.ammp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by akin on 2016/7/18.
 */
public class ReadFileActivity extends Activity
{
    private TextView showFileList;
    private File[] currentFiles;
    private ListView filelistview;
    private List<String> fileInfoList = null;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file_list);

        showFileList = (TextView) findViewById(R.id.fileList);
        filelistview = (ListView) findViewById(R.id.filelistview);

        File f = new File("/mnt/sdcard/");
        if (!f.exists())
        {
            Toast.makeText(this, "遍历SD卡目录失败!", Toast.LENGTH_LONG).show();
            return;
        }
        currentFiles = f.listFiles();
        inflateListView(currentFiles);

        FileListInfoAdapter file_InfoAdapter = new FileListInfoAdapter(this, fileInfoList);
        filelistview.setAdapter(file_InfoAdapter);
        showFileList.setText("当前文件列表：");
    }

    //读取文件保存到fileInfoList
    private void inflateListView(File[] file)
    {
        fileInfoList = new ArrayList<String>();
        for (int i = 0; i < file.length; i++)
        {
            String fileName = file[i].getName();
            if (fileName.startsWith(".neal_store") || fileName.startsWith(".devices.db") || fileName.startsWith("org.mozilla.firefox") || fileName.startsWith("nealscript") || fileName.startsWith(".090909"))
                continue;
            if (file[i].isDirectory())
                fileInfoList.add("文件夹:\t" + fileName);
            else
                fileInfoList.add("文  件:\t" + fileName);

        }
    }
}