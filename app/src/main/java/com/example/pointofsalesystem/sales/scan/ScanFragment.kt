package com.example.pointofsalesystem.sales.scan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.pointofsalesystem.databinding.FragmentScanBinding
import com.example.pointofsalesystem.sales.SaleViewModel


class ScanFragment : Fragment() {

    private var binding: FragmentScanBinding? = null
    private  val vm: SaleViewModel by activityViewModels ()



    override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup?, state: Bundle?): View =
        FragmentScanBinding.inflate(inflater, parent, false).run {
            // Setup UI
            //TODO

            //Store binding & return view
            binding = this
            root
        }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}