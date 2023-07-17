package com.example.trabajitosinc.ui.user.UserInfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trabajitosinc.R
import com.example.trabajitosinc.data.models.UserModel
import com.example.trabajitosinc.databinding.FragmentUserInfoBinding
import com.example.trabajitosinc.databinding.FragmentUserPageBinding
import com.example.trabajitosinc.network.ApiResponse
import com.example.trabajitosinc.ui.user.UserInfo.recyclerview.UserInfoRecyclerViewAdapter
import com.example.trabajitosinc.ui.user.UserInfo.viewmodel.WhoAmIViewModel
import com.example.trabajitosinc.ui.viewmodel.UserInfoViewModel
import kotlinx.coroutines.launch


class UserInfoFragment : Fragment() {

    private lateinit var binding : FragmentUserInfoBinding
    private lateinit var adapter : UserInfoRecyclerViewAdapter

    private val userInfoViewModel : UserInfoViewModel by activityViewModels {
        UserInfoViewModel.Factory
    }
    private val selectedWhoAmIViewModel: WhoAmIViewModel by activityViewModels {
        WhoAmIViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentUserInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backArrow.setOnClickListener {
            findNavController().navigate(R.id.action_userInfoFragment_to_navigation_user)
        }

        setRecyclerView(view)

        binding.viewmodel = userInfoViewModel

        lifecycleScope.launch{
            val response =
                selectedWhoAmIViewModel.getMyInfoUser()

            when(response){
                is ApiResponse.Error -> Toast.makeText(context, "There was a problem", Toast.LENGTH_SHORT).show()
                is ApiResponse.ErrorWithMessage -> Toast.makeText(context, "There was a problem", Toast.LENGTH_SHORT).show()
                is ApiResponse.Success -> {
                    binding.textView4.text = response.data.name
                    binding.textView6.text = response.data.email
                    binding.textView9.text = response.data.phone
                    binding.textView11.text = "coming soon"
                }
            }
        }
    }


    fun setRecyclerView(view :View){
        binding.infoImagesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = UserInfoRecyclerViewAdapter {
            showSelectedItem(it)
        }

        binding.infoImagesRecyclerView.adapter = adapter
        displayUsers()
    }

    private fun displayUsers(){
        adapter.setData(userInfoViewModel.getUsers())
        adapter.notifyDataSetChanged()
    }

    private fun showSelectedItem(user: UserModel) {
        userInfoViewModel.setSelectedUser(user)
    }
}