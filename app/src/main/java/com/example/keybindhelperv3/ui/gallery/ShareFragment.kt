package com.example.keybindhelperv3.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.keybindhelperv3.R

class ShareFragment : Fragment() {

    private var root:View?=null;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        root=LayoutInflater.from(this.context).inflate(R.layout.fragment_share, container)


        return root!!
    }

    override fun onDestroyView() {
        super.onDestroyView()
        root=null;
    }
}