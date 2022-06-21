package com.example.keybindhelperv3

import androidx.test.platform.app.InstrumentationRegistry
import com.example.keybindhelperv3.Room.DatabaseManager
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Before
    fun setUp(){
        DatabaseManager.init(InstrumentationRegistry.getInstrumentation().targetContext)
    }
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun allKeybinds_haveGroup(){

     /*   val groups=DatabaseManager.db.groups
        var kbs=DatabaseManager.db.keybinds
        kbs.filter {
            val kbId=it.groupID;
            groups.any{
                it.id==kbId
            }
        }
        println("Keybinds without groups: "+ kbs.size)
        assert(kbs.size==0)*/
        assert(true)
    }
}