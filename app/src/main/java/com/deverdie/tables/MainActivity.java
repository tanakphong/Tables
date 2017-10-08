package com.deverdie.tables;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button SelectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SelectButton = (Button) findViewById(R.id.btnSelect);
        SelectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
//                intent.addCategory(Intent.CATEGORY_OPENABLE);
//                intent.setType("*/*");
//                startActivityForResult(intent, 1);
                Intent intent = new Intent();
//                    intent.setType("text/plain");
//                Uri uri = Uri.parse("mnt/sdcard0/Download"); // a directory
                Uri uri = Uri.parse(GetAppPath(MainActivity.this));

                intent.setDataAndType(uri, "text/plain");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select a File to Upload"), 1);
            }
        });

//        HashMapMethod();
//        ListMapMethod();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            Uri selectedImageUri = data.getData();
            //String s = getRealPathFromURI(selectedImageUri);
            if (requestCode == 1) {
                Log.i("dlg", "getPath() : " + selectedImageUri.getPath());
                try {
                    String path = GetAppPath(MainActivity.this);
                    Log.i("dlg", "GetAppPath: " + path);
                    BufferedReader brTest = new BufferedReader(new FileReader(selectedImageUri.getPath()));
                    String text = brTest.readLine();
                    Log.i("dlg", "First: " + text);
                    LinkedList<String> strings = new LinkedList<>();
                    strings.add("Sunday");
                    strings.add("Monday");
                    strings.add("Tuesday");
                    strings.add("Wednesday");
                    strings.add("Thursday");
                    strings.add("Friday");
                    strings.add("Saturday");
                    for (String s : strings) {
                        Log.i("dlg", "Days: " + s);
                    }
                    LinkedHashMap<String, String> rows = addRows(text, "\t");
                    StringBuilder stringBuilder = new StringBuilder();
                    Iterator myVeryOwnIterator = rows.keySet().iterator();
                    while (myVeryOwnIterator.hasNext()) {
                        String key = (String) myVeryOwnIterator.next();
                        String value = (String) rows.get(key);
//                Log.i("dlg", "Key: "+key+" Value: "+value);
//                        stringBuilder.append(rows.get(myVeryOwnIterator.next()));
                        stringBuilder.append(key + ":" + value);
                        if (!myVeryOwnIterator.hasNext()) {
                            stringBuilder.append("\n");
                        } else {
                            stringBuilder.append("\t");
                        }
                    }
                    stringBuilder.append("----------End----------");
                    Log.i("dlg", stringBuilder.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                Log.i("dlg", "path 1 : " + readTextFilePath(selectedImageUri.getPath(), 1));
            } else if (requestCode == 2) {
                Log.i("dlg", "path 2 : " + selectedImageUri);
            }


        } else if (resultCode == Activity.RESULT_CANCELED) {
            Log.i("dlg", "onActivityResult: Cancle");
        }
    }

    private void ListMapMethod() {
//        Map<String, String> colsHashMap = new HashMap<String, String>();
//        map.put("name", "demo");
//        map.put("fname", "fdemo");
//// etc
//
//        map.get("name"); // returns "demo"
    }

    private void HashMapMethod() {
        LinkedHashMap<String, String> colsHashMap = new LinkedHashMap<>();
        colsHashMap.put("Column1", "Barcode");
        colsHashMap.put("Column2", "Code");
        colsHashMap.put("Column3", "Name");
        colsHashMap.put("Column4", "Price");

        LinkedHashMap<String, String> cols1HashMap = new LinkedHashMap<>();
        cols1HashMap.put("Column1", "80123456789");
        cols1HashMap.put("Column2", "CY-001");
        cols1HashMap.put("Column3", "Name CY-001");
        cols1HashMap.put("Column4", "Price CY-001");

        LinkedHashMap<String, String> cols2HashMap = new LinkedHashMap<>();
        cols2HashMap.put("Column1", "80123456790");
        cols2HashMap.put("Column2", "CY-002");
        cols2HashMap.put("Column3", "Name CY-002");
        cols2HashMap.put("Column4", "Price CY-002");

        LinkedHashMap<String, String> cols3HashMap = new LinkedHashMap<>();
        cols3HashMap.put("Column1", "80123456791");
        cols3HashMap.put("Column2", "CY-003");
        cols3HashMap.put("Column3", "Name CY-003");
        cols3HashMap.put("Column4", "PriceCY-003");

        List<LinkedHashMap<String, String>> rowsList = new ArrayList<>();
        rowsList.add(colsHashMap);
        rowsList.add(cols1HashMap);
        rowsList.add(cols2HashMap);
        rowsList.add(cols3HashMap);
        StringBuilder stringBuilder = new StringBuilder();

        for (LinkedHashMap rows : rowsList) {
////            Object first = rows.keySet().toArray()[0];
////            Log.i("dlg", "Get First: "+rows.get(first));
//            Object last = rows.keySet().toArray()[(rows.size()) - 1];
////            Log.i("dlg", "Get Last: "+rows.get(last));
//
//            for (Object key : rows.keySet()) {
////                System.out.println("Key : " + key.toString() + " Value : " + rows.get(key));
//                stringBuilder.append(rows.get(key) + "\t");
//                if (key == last) {
//                    stringBuilder.append("\n");
//                } else {
//                    stringBuilder.append("\t");
//                }
//            }

            Iterator myVeryOwnIterator = rows.keySet().iterator();
            while (myVeryOwnIterator.hasNext()) {
//                String key = (String) myVeryOwnIterator.next();
//                String value = (String) rows.get(key);
//                Log.i("dlg", "Key: "+key+" Value: "+value);
                stringBuilder.append(rows.get(myVeryOwnIterator.next()));
                if (!myVeryOwnIterator.hasNext()) {
                    stringBuilder.append("\n");
                } else {
                    stringBuilder.append("\t");
                }
            }
//            stringBuilder.append(
//                    rows.get("Column1") + "\t" +
//                            rows.get("Column2") + "\t" +
//                            rows.get("Column3") + "\t" +
//                            rows.get("Column4") + "\t\n");
        }
        Log.i("dlg", stringBuilder.toString());

    }

    public String readTextFilePath(String path, int loop) {
        try {

            File myFile = new File(path);
            FileInputStream fIn = new FileInputStream(myFile);
            BufferedReader bufferedreader = new BufferedReader(
                    new InputStreamReader(fIn));

            String line;
            StringBuilder stringBuilder = new StringBuilder();

//            delimiter=getDelimiter(spinner.getSelectedItem().toString());


            while ((line = bufferedreader.readLine()) != null) {
//                for (int i = 0; i < loop; i++) {
//                    StringTokenizer st = new StringTokenizer(line);
//                    while (st.hasMoreTokens('')) {
//                        System.out.println(st.nextToken());
//                        Log.i("dlg", "st: ");
//                    }
                line = line.replaceAll("\n", "");
                String[] arr = line.split("\t");
                boolean bo = true;
                for (String val : arr) {
//                    Log.i("dlg", "val : "+val+',');
                    if (!bo) {
                        stringBuilder.append(',');
                    } else {
                        bo = false;
                    }
                    stringBuilder.append(val.trim());
                }
//                    stringBuilder.append(line);
                stringBuilder.append('\n');
//                }
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            return null;
        }
    }

    public String GetAppPath(Context context) {
        String extStoreage = Environment.getExternalStorageDirectory().getAbsolutePath();
        String packageName = context.getPackageName();
        return extStoreage + "/Android/data/" + packageName;
    }

    private LinkedHashMap<String, String> addRows(String data, String delimiter) {
        LinkedHashMap<String, String> rowsStringStringLinkedHashMap = new LinkedHashMap<>();
        String[] strings = data.split("\t");
        for (int i = 0; i < strings.length; i++) {
            rowsStringStringLinkedHashMap.put("Column" + i, strings[i]);
        }
        return rowsStringStringLinkedHashMap;
    }
}
