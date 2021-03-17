package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme
import dev.chrisbanes.accompanist.insets.ViewWindowInsetObserver

@ExperimentalMaterialApi
class MyFragment : Fragment() {

    companion object {
        fun newInstance() = MyFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        setContent {
                MyApplicationTheme {
                    val navController = rememberNavController()
                    var dummy: Dummy = Dummy.One
                    Scaffold(
                        content = { _ ->
                            NavHost(navController, startDestination = "start") {
                                composable("onboarding") {
                                    // this gets called twice
                                    Log.d("nav","navigated to onboarding")
                                    Onboarding(
                                        // only gets called twice if I send in a non primitive
                                        dummy = dummy
                                    )
                                }
                                composable("start") {
                                    // Only one call to navigate is made
                                    LazyColumn() {

                                    }
                                    Log.d("nav","I get called once")
                                    navController.navigate("onboarding")
                                }
                            }
                        })

                }
            }


//        }
    }
}


@Composable
fun StartComposy(
    navController: NavController
) {
    var something by remember { mutableStateOf(5) }

    something = 5
    something = 7


    LazyColumn() {
        // nothing is needed
    }
//    Log.d("nav","navigate to onboarding")
}