package com.ur.popandroid.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.auth.ActionCodeSettings
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import com.ur.popandroid.R
import kotlinx.android.synthetic.main.activity_authentication.*

class AuthenticationActivity : AppCompatActivity() {
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        sharedPref = this.getPreferences(Context.MODE_PRIVATE)

        FirebaseDynamicLinks.getInstance()
            .getDynamicLink(intent)
            .addOnSuccessListener(this) { pendingDynamicLinkData ->
                if (pendingDynamicLinkData != null) {
                    val auth = FirebaseAuth.getInstance()
                    val intent = intent
                    val emailLink = intent.data!!.toString()
                    if (auth.isSignInWithEmailLink(emailLink)) {
                        val email : String = sharedPref.getString("email", "none found")!!
                        auth.signInWithEmailLink(email, emailLink)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    Log.d("login", "Successfully signed in with email link!")
                                    val intent = Intent(this, MainActivity::class.java)
                                    startActivity(intent)
                                } else {
                                    Log.e("login", "Error signing in with email link", task.exception)
                                }
                            }
                    }
                }
            }
    }

    fun onSignIn(v: View){

        sharedPref = this.getPreferences(Context.MODE_PRIVATE)

        val actionCodeSettings = ActionCodeSettings.newBuilder()
            .setUrl("https://popandroid-ec528.firebaseapp.com/")
            .setHandleCodeInApp(true)
            .setAndroidPackageName(
                "com.ur.popandroid",
                true, /* installIfNotAvailable */
                "12" /* minimumVersion */)
            .build()
        val auth = FirebaseAuth.getInstance()
        auth.sendSignInLinkToEmail(authentication_activity_edtxt_email.text.toString(), actionCodeSettings)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("signin", "Email sent")
                    val editor = sharedPref.edit()
                    editor.putString("email", authentication_activity_edtxt_email.text.toString())
                    editor.apply()
                }
                else{
                    Log.d("signin", task.exception?.message)
                }
            }
    }

}
