package com.eylem.activity_lifecycle

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.eylem.activity_lifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //onCreate de daha kullanıcı birşey görmeden yapılan işlemler vardır
        // mesela internetten ya da veri tabanından veri çekmek gibi.
        //onCreate altına ve yazıldıysa onlar çalışır kullanıcı burada birşey görmez
        println("onCreate Çalıştı")
    }
    // onStart da arayüze geçiş hazırlığı oluyor örneğin ilk arayüz gelme aşaması.
    // ilk görüntü gelir gibi olduğu  ekrandeki hareketlenmedir. çok kısa sürer.
    override fun onStart() {
        super.onStart()
        println("onStart Çalıştı")
    }
    // onResume ise kullanıcının uygulama ile etkileşime girdiği andır.
    override fun onResume() {
        super.onResume()
        println("onResume Çalıştı")
    }
    // onPause ise kullanıcının uygulamadan çıktığı andır. yani burada  onStart da olduğu gibi
    // ilk arayüzün kapanır gibi olduğu  andır. çok kısa sürer.
    override fun onPause() {
        super.onPause()
        println("onPause Çalıştı")
    }
    // onStop ise uygulama alta alınınca çalışır(alt+tab) gibi. yani uygulamadan
    // tam çıkılmaz başka uygulamaya geçilirken ki gibi
    // stop olur ve arka planda hala kalmaya devam eder. ve tekrar uygulama açılırsa
    // onCreate çalıştırılmadan uygulama onStart ardında da onResume çalıştırır
    override fun onStop() {
        super.onStop()
        println("onStop Çalıştı")
    }
    // onDestroy ise uygulama tamamen kapatılınca çalışır.
    // onDestroydan sonra uygulama tekrar çalıştırılırsa önce onCreate -> onStart -> onResume
    //şeklinde çalışır.
    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy Çalıştı")
    }
}