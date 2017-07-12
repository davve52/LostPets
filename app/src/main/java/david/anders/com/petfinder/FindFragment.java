package david.anders.com.petfinder;


import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends Fragment {
    private Controller controller;
    private ImageButton btnImage;
    private Button btnPost;
    private EditText edName;
    private EditText edDesc;
    private EditText edPhone;
    private Bitmap yourSelectedImage;

    public FindFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        initComponents(view);
        registerListener();
        return view;
    }
    private void initComponents(View view) {
        btnImage = (ImageButton)view.findViewById(R.id.btnImage);
        btnPost = (Button)view.findViewById(R.id.btnPost);
        edName = (EditText)view.findViewById(R.id.edName);
        edDesc = (EditText)view.findViewById(R.id.edDesc);
        edPhone = (EditText)view.findViewById(R.id.edPhone);

    }
    public void setController(Controller controller){
        this.controller = controller;
    }

    private void registerListener() {
        btnImage.setOnClickListener(new ButtonListener());
        btnPost.setOnClickListener(new ButtonListener());
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode) {
            case 1234:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = data.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};

                    Cursor cursor = getActivity().getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String filePath = cursor.getString(columnIndex);
                    cursor.close();


                    yourSelectedImage = BitmapFactory.decodeFile(filePath);

            /* Now you have choosen image in Bitmap format in object "yourSelectedImage". You can use it in way you want! */
                }
        }

    };
    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnPost :
                    String name = edName.getText().toString();
                    String desc = edDesc.getText().toString();
                    String phone = edPhone.getText().toString();
                    break;
                case R.id.btnImage :
                    Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                    final int ACTIVITY_SELECT_IMAGE = 1234;
                    startActivityForResult(i, ACTIVITY_SELECT_IMAGE);

                    btnImage.setImageBitmap(yourSelectedImage);
                    break;
            }
        }
    }
}
