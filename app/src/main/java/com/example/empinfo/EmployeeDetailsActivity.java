package com.example.empinfo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

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

        Intent mailintent = new Intent(Intent.ACTION_SEND);
        mailintent.setData(Uri.parse("mailto:"));
        mailintent.putExtra(Intent.EXTRA_SUBJECT, "New Employee Data");
        mailintent.putExtra(Intent.EXTRA_TEXT, "Name: " + empname);
        mailintent.putExtra(Intent.EXTRA_TEXT, "Designation: " + empdesignation);
        mailintent.putExtra(Intent.EXTRA_TEXT, "Field: " + empfield);
        mailintent.putExtra(Intent.EXTRA_TEXT, "Email: " + empemail);
        mailintent.putExtra(Intent.EXTRA_TEXT, "Phone: " + empphone);
        mailintent.putExtra(Intent.EXTRA_TEXT, "Salary: " + empsalary);
        startActivity(mailintent);
    }

    protected void onsms() {

        Intent smsintent = new Intent(Intent.ACTION_SEND);
        smsintent.setData(Uri.parse("sms:"));
        smsintent.putExtra(Intent.EXTRA_SUBJECT, "New Employee Data");
        smsintent.putExtra(Intent.EXTRA_TEXT, "Name: " + empname);
        smsintent.putExtra(Intent.EXTRA_TEXT, "Designation: " + empdesignation);
        smsintent.putExtra(Intent.EXTRA_TEXT, "Field: " + empfield);
        smsintent.putExtra(Intent.EXTRA_TEXT, "Email: " + empemail);
        smsintent.putExtra(Intent.EXTRA_TEXT, "Phone: " + empphone);
        smsintent.putExtra(Intent.EXTRA_TEXT, "Salary: " + empsalary);
        startActivity(smsintent);
    }

    protected void onphone() {

        Intent phonentent=new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        phonentent.setData(Uri.parse("content://contacts"));
        phonentent.putExtra(Intent.EXTRA_SUBJECT, "New Employee Data");
        phonentent.putExtra(Intent.EXTRA_TEXT, "Name: " + empname);
        phonentent.putExtra(Intent.EXTRA_TEXT, "Designation: " + empdesignation);
        phonentent.putExtra(Intent.EXTRA_TEXT, "Field: " + empfield);
        phonentent.putExtra(Intent.EXTRA_TEXT, "Email: " + empemail);
        phonentent.putExtra(Intent.EXTRA_TEXT, "Phone: " + empphone);
        phonentent.putExtra(Intent.EXTRA_TEXT, "Salary: " + empsalary);
        startActivity(phonentent);


    }


}
