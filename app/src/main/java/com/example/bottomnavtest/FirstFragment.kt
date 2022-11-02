package com.example.bottomnavtest

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FirstFragment: Fragment(R.layout.fragment_first) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val url = "www.wemy.academy"
        val view = inflater.inflate(R.layout.fragment_first,container,false)
        val shareBtn: Button = view.findViewById(R.id.btn_share)

        shareBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, url)
            val chooser = Intent.createChooser(intent, "Share with:")
            startActivity(chooser)
        }
        return view
    }
}