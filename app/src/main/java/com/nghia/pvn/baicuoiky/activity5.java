package com.nghia.pvn.baicuoiky;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class activity5 extends Fragment {

    ListView listViewshopee;
    ListViewBaseAdapter adapter;
    ArrayList<ListViewBean> arr_bean_shopee;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_5,container,false);
        listViewshopee  = (ListView) view.findViewById(R.id.listviewCauthu);
        arr_bean_shopee = new ArrayList<ListViewBean>();
        arr_bean_shopee.add(new ListViewBean(R.drawable.house, "Coffee funky"));
        arr_bean_shopee.add(new ListViewBean(R.drawable.login, "Profile"));
        arr_bean_shopee.add(new ListViewBean(R.drawable.custom, "History"));
        arr_bean_shopee.add(new ListViewBean(R.drawable.thanhtoan, "Payment"));
        arr_bean_shopee.add(new ListViewBean(R.drawable.help, "Help"));
        arr_bean_shopee.add(new ListViewBean(R.drawable.st, "Setting"));
        arr_bean_shopee.add(new ListViewBean(R.drawable.export, "Log Out"));
        adapter = new ListViewBaseAdapter(arr_bean_shopee,getActivity());
        listViewshopee.setAdapter(adapter);
        listViewshopee.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent intent = new Intent(getActivity(),MainActivity.class);
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(getActivity(),Profile.class);
                    startActivity(intent);
                }else if (position == 6) {
                    final AlertDialog.Builder alertDialogbuilder = new AlertDialog.Builder(getActivity());
                    alertDialogbuilder.setTitle("Đăng Xuất");
                    alertDialogbuilder.setMessage("Do you wanna quit");
                    alertDialogbuilder.setCancelable(false).setPositiveButton("Đăng Xuất", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getActivity(),Login.class);
                            startActivity(intent);
                        }
                    }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    alertDialogbuilder.show();
                }
            }
        });
        return view;
    }
}
