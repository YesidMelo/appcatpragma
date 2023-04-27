package com.pruebatecnica.appcatspragma.views.fragments

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.pruebatecnica.appcatspragma.databinding.FragmentFirstBinding
import com.pruebatecnica.appcatspragma.viewModels.ListCatsViewModel
import com.pruebatecnica.appcatspragma.viewModels.ListCatsViewModelImpl
import com.pruebatecnica.appcatspragma.views.adapters.ListCatsAdapter

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ListCatsFragment : Fragment() {

    private val viewModel : ListCatsViewModel = ListCatsViewModelImpl()
    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listenListCats()
        listenExceptions()
        reloadView()
        viewModel.loadListCats()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //region metodos privados
    private fun listenListCats() {
        viewModel
            .getListCatsLiveData()
            .observe(viewLifecycleOwner) {
                binding.recyclerviewCatlist.adapter = ListCatsAdapter(listCats = it)
                binding.recyclerviewCatlist.layoutManager = LinearLayoutManager(context)
                binding.recyclerviewCatlist.setHasFixedSize(true)
                binding.textViewWithoutList.visibility = View.GONE
                binding.recyclerviewCatlist.visibility = View.VISIBLE
            }
    }

    private fun listenExceptions() {
        viewModel
            .notifyErrorLiveData()
            .observe(viewLifecycleOwner) {
                if (it == null) return@observe
                binding.textViewWithoutList.visibility = View.VISIBLE
                binding.recyclerviewCatlist.visibility = View.GONE
                Snackbar.make(binding.root, "Surgio un problema inesperado, revisa tu conexion a internet", Snackbar.LENGTH_LONG)
                    .setAction("Aceptar", null).show()
            }
    }

    private fun reloadView() {
        binding.textViewWithoutList.setOnClickListener {
            binding.textViewWithoutList.visibility = View.GONE
            binding.recyclerviewCatlist.visibility = View.GONE
            viewModel.loadListCats()
        }
    }

    //endregion
}