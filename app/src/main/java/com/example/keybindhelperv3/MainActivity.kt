package com.example.keybindhelperv3

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.keybindhelperv3.Room.CurrentProject
import com.example.keybindhelperv3.Room.DatabaseManager
import com.example.keybindhelperv3.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    val allActionMenuIds= setOf(R.id.action_add,R.id.action_delete_all_groups,R.id.action_show_hide_keybinds)
    val keybindsFragmentActionMenuIds= setOf(R.id.action_add,R.id.action_delete_all_groups,R.id.action_show_hide_keybinds)
    val projectsFragmentActionMenuIds= setOf(R.id.action_add)

    var Menu:Menu?=null;
    var onMenuInit:MenuInitialized?=null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)


        /*
        NICK CODE START
         */
        DatabaseManager.init(binding.root.context);
        CurrentProject.loadFirstProject()
        /*
        NICK CODE END
         */
        /*binding.appBarMain.button.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/
        //println(binding.navView.findViewById<Toolbar>(R.id.toolbar).toString()+" TOOLBAR");

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_keybind, R.id.nav_gallery, R.id.nav_projects), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)

        navView.setupWithNavController(navController)
    }
    fun showMenuItems(items:Set<Int>){
        allActionMenuIds.forEach{
            this.Menu?.findItem(it)!!.isVisible = items.contains(it)
        }
    }
    fun setAppBarTitle(s:String){
        supportActionBar!!.title=s;
    }
//todo this is probably not needed, res.menu.main.xml
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        this.Menu=menu;
        onMenuInit?.menuHasInitialized();
        makeMenuWhite(menu)

        //menu.findItem(R.id.action_settings).isVisible = false
        return true
    }
    private fun makeMenuWhite(menu:Menu){
        for (i in 0 until menu.size()) {
            val item: MenuItem = menu.getItem(i)
            val spanString = SpannableString(menu.getItem(i).title.toString())
            spanString.setSpan(ForegroundColorSpan(Color.WHITE),0,spanString.length,0)//fix the color to white
            item.title = spanString
            if(item.hasSubMenu())
                makeMenuWhite(item.subMenu)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
    interface MenuInitialized{
        fun menuHasInitialized();
    }
}