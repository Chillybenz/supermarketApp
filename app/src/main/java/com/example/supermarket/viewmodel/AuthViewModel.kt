package com.example.supermarket.viewmodel

import androidx.lifecycle.ViewModel
import com.example.supermarket.model.UserModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore

class AuthViewModel: ViewModel() {
    private val auth = Firebase.auth
    private val firestore = Firebase.firestore

    fun login(){

    }
    fun signup(email: String, name: String, password: String, onResult : (Boolean, String?) -> Unit){
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener{
                if(it.isSuccessful){
                    var userId = it.result?.user?.uid
                    val userModel = UserModel(name,email,userId!!)
                    firestore.collection("users").document(userId)
                        .set(userModel)
                        .addOnCompleteListener {
                            dbTask ->
                            if(dbTask.isSuccessful){
                                onResult(true,null)
                            }
                            else{
                                onResult(false,"Something went wrong")
                            }
                        }

                }else{
                    onResult(false,it.exception?.localizedMessage)
                }
            }
    }
}