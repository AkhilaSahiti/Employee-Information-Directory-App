package com.example.empinfo;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EmployeeDetailsActivity extends AppCompatActivity {

    String empname, empdesignation, empfield, empsalary, empemail, empphone;
    ImageView image;
    ImageButton emailbtn, messagebtn, phonebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        Intent intent = getIntent();

        empname = intent.getStringExtra("urname");
        TextView name = (TextView) findViewById(R.id.emp_name);
        name.setText(empname);

        empdesignation = intent.getStringExtra("urdesignation");
        TextView designation = (TextView) findViewById(R.id.emp_designation);
        designation.setText(empdesignation);

        empfield = intent.getStringExtra("urfield");
        TextView field = (TextView) findViewById(R.id.emp_field);
        field.setText(empfield);

        empemail = intent.getStringExtra("uremail");
        TextView email = (TextView) findViewById(R.id.emp_email);
        email.setText(empemail);

        empphone = intent.getStringExtra("urphone");
        TextView phone = (TextView) findViewById(R.id.emp_phone);
        phone.setText(empphone);

        empsalary = intent.getStringExtra("ursalary");
        TextView salary = (TextView) findViewById(R.id.emp_salary);
        salary.setText(empsalary);

       // Bitmap bitmap = (Bitmap) intent.getParcelableExtra("urphoto");
       // image.setImageBitmap(bitmap);

        if(getIntent().hasExtra("urphoto")) {
            ImageView imageView = new ImageView(this);
            Bitmap bmp = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra("yourImage"), 0, getIntent().getByteArrayExtra("yourImage").length);
            imageView.setImageBitmap(bmp);
        }

        emailbtn = (ImageButton) findViewById(R.id.emailbtn);
        emailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onemail();
            }
        });

        messagebtn = (ImageButton) findViewById(R.id.messagebtn);
        messagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onsms();
            }
        });

        phonebtn = (ImageButton) findViewById(R.id.phonebtn);
        phonebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onphone();
            }
        });

    }

    protected void onemail() {

        Intent mailintent = new Intent(Intent.ACTION_SENDTO);
        mailintent.setType("text/html");
        mailintent.setData(Uri.parse("mailto: racherlakhila@gmail.com"));
        mailintent.putExtra(Intent.EXTRA_SUBJECT, "New Employee Data: ");
        mailintent.putExtra(Intent.EXTRA_TEXT, "Name: " + empname+ " has joined the " +empfield+" as "+ empdesignation+" with a monthly Salary of " + empsalary+". EmailId: " + empemail+" and Phone: " + empphone);
        startActivity(mailintent);
    }

    protected void onsms() {

        Intent smsintent = new Intent(Intent.ACTION_SEND);
        smsintent.setData(Uri.parse("sms:"));
        smsintent.putExtra(Intent.EXTRA_SUBJECT, "New Employee Data: ");
        smsintent.putExtra(Intent.EXTRA_TEXT, "Name: " + empname+  " has joined the " +empfield+" as "+ empdesignation+" with a monthly Salary of " + empsalary+". EmailId: " + empemail+" and Phone: " + empphone);
        startActivity(smsintent);
    }

    protected void onphone() {


        Intent phoneintent=new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        //phoneintent.setData(Uri.parse("content://contacts"));

        /*phoneintent.putExtra(Intent.EXTRA_SUBJECT, "New Employee Data");
        phoneintent.putExtra(Intent.EXTRA_TEXT, "Name: " + empname);
        phoneintent.putExtra(Intent.EXTRA_TEXT, "Designation: " + empdesignation);
        phoneintent.putExtra(Intent.EXTRA_TEXT, "Field: " + empfield);
        phoneintent.putExtra(Intent.EXTRA_TEXT, "Email: " + empemail);
        phoneintent.putExtra(Intent.EXTRA_TEXT, "Phone: " + empphone);
        phoneintent.putExtra(Intent.EXTRA_TEXT, "Salary: " + empsalary);*/

        startActivity(phoneintent);


    }


}
