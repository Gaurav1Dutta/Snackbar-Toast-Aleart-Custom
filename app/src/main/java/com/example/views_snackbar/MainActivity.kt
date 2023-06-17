package com.example.views_snackbar

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.views_snackbar.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnToast.setOnClickListener {
            Toast.makeText(this, "This Is An Toast Message", Toast.LENGTH_SHORT).show()
        }

        binding.btnSnack.setOnClickListener {
            var snackView = Snackbar.make(binding.btnSnack,"snackbar" ,Snackbar.LENGTH_INDEFINITE)
            snackView.show()//to show snackbar which is stored in snackView
            snackView.setAnchorView(R.id.btnSnack)// ede upar huna ya show
            snackView.setAction("ok"){
                Toast.makeText( this,"Hello",Toast.LENGTH_LONG).show()
            }
        }

        binding.btnAlert.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Verify User First").setCancelable(false)
                .setPositiveButton("Verify User"){ _,_->
                    Toast.makeText(this, "positive", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Exit"){ _,_->
                    Toast.makeText(this, "Press Back Two Times", Toast.LENGTH_SHORT).show()
                }
                .setNeutralButton("Stay"){ _,_->
                    Toast.makeText(this, "Stare At Screen All ", Toast.LENGTH_SHORT).show()
                }
                .show()
        }
        binding.btnCustom.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.custom_dialog)
            var btnset = dialog.findViewById<Button>(R.id.btnset)
            var etType = dialog.findViewById<EditText>(R.id.etType)
            etType.setText(binding.tvHello.text)
            btnset.setOnClickListener {
                if (etType.text.toString().isEmpty()){
                    etType.error = "enter name"
                }
                else {
                    binding.tvHello.text = etType.text.toString()
                    dialog.dismiss()
                }
                Toast.makeText(this, "Data Entered", Toast.LENGTH_SHORT).show()
            }
            var btnCancel = dialog.findViewById<Button>(R.id.btnCancel)
            btnCancel.setOnClickListener {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
                dialog.cancel()
            }
            dialog.show()
        }

    }
}