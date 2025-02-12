package edu.nku.classapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

//
class MainActivity : AppCompatActivity() {

    private val name = listOf("Ironman", "Spiderman", "Pepper", "Thor")
    private val lastName = listOf("Pots", "Stark", "Odinson")
    private val place = listOf("Earth", "Asgard", "USA", "England")
    private val position = listOf("Boss", "Manager", "Clerk", "Assistant Manager")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val characters = mutableListOf<IronmanCharacter>()

        for (i in 0 until 30) {
            characters.add(createCharacter(i))
        }

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = IronmanCharacterAdapter(characters)
    }

    fun createCharacter(Id: Int): IronmanCharacter {
        return IronmanCharacter(
            age = Random.nextInt(1, 100),
            id = Id,
            name = "${name.random()} ${lastName.random()}",
            place = place.random(), // ✅ Using existing place
            position = position.random(), // ✅ Assign random position
            picture = R.drawable.ic_launcher_background
        )
    }
}
