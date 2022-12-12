package com.fernandoherrera.recipedirectory

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.fernandoherrera.recipedirectory.databinding.FragmentMapsBinding
import com.fernandoherrera.recipedirectory.databinding.FragmentMealSearchBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {

    private val args: MapsFragmentArgs by navArgs()

    private val callback = OnMapReadyCallback { googleMap ->

        val name = args.name
        val latLng = args.latitude
        val doubleLat: Double? = latLng?.toDouble()
        Log.d("latitude","$doubleLat")
        val latLat = args.longitude
        val doubleLong: Double? = latLat?.toDouble()
        Log.d("longitude","$doubleLong")
        val marker = LatLng(doubleLat!!, doubleLong!!)
        googleMap.addMarker(MarkerOptions().position(marker).title("Come to eat $name"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(marker))

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)

        view.findViewById<View>(R.id.map_back_arrow).setOnClickListener{
            findNavController().popBackStack()
        }
    }


}