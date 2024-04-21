# Rapport
Det första steget var, likt tidigare, att skapa en fork av projektet på LenaSYS Github. Först ut var att lägga till en ny aktivitet. Jag valde att namnge den _OtherActivity_. Utöver att skapa själva klassen, lades några rader kod till i den tomma klassen samt en mindre uppdatering till _AndroidManifest.xml_.

**OtherActivity.java**
```
package com.example.screens;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
```

**AndroidManifest.xml**

```
...
<activity android:name=".OtherActivity" />
...
```

Nästa steg var att lägga till en klickbar knapp i första aktiviten för att starta den nya aktiviteten samt skapa en ny vy som ska visas. En knapp lades till med texten "Click me!"

**activity_main.xml**
```
<Button
        android:id="@+id/presser"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="160dp"
        android:layout_marginLeft="160dp"
        android:layout_marginTop="20dp"
        android:layout_marginEnd="160dp"
        android:layout_marginRight="160dp"
        android:layout_marginBottom="287dp"
        android:text="Click me!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView" />
```

Den nya vyn innehåller tre stycken _textView_'s som innehåller några slumpmässiga meddelanden (en av dessa kommer att läggas till och uppdateras senare).

**activity_other.xml**
```
...
<TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Welcome to the other activity!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/textView3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="176dp"
        android:layout_marginLeft="176dp"
        android:layout_marginTop="100dp"
        android:layout_marginEnd="177dp"
        android:layout_marginRight="177dp"
        android:layout_marginBottom="237dp"
        android:text="What's this, another activity?"
        app:layout_constraintBottom_toTopOf="@+id/textView"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
...
```
För att knappen ska fungera lades en _OnClickListener_ till knappen för att den ska kunna reagera på användarens inmatning. I denna _OnClickListener_ implenterades även funktionalitet för att starta nästa aktivitet.
**MainActivity.java**
```
    // Try to find button by ID
    Button btn = findViewById(R.id.presser);
    // Create a on-click listener
    btn.setOnClickListener(new View.OnClickListener() {
        // Implement functionality for clicking on btn
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, OtherActivity.class);
            startActivity(intent);
        }
    });
```

Sista steget är att skicka med information till den andra aktiviteten med hjälp av _intents_, _bundles_ och _extras_. Information skickades från _MainActivty.java_ till _OtherActivity.java_. Den följande koden lades till i **MainActivity.java** för att skicka vidare datan.
```
    // Send data to intent
    intent.putExtra("number", 18321982);
```
och följande i **OtherActivity.java** för att ta emot och extrahera datan. Utöver att hämta ut informationen uppdaterades en tredje _textView_ med ID:et "numberText" för att visa att informationen har hämtats från _intent_
```
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int number = extras.getInt("number");

            // Use the number to update the text element
            TextView myNumberText = findViewById(R.id.numberText);
            myNumberText.setText("Number carried from intent " + number);
        }
```

Den tredje _textView_ lades även till för att sedan användas för att visa den hämtade datan.
**activity_other.xml**
```
    <TextView
        android:id="@+id/numberText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="170dp"
        android:layout_marginLeft="170dp"
        android:layout_marginTop="97dp"
        android:layout_marginEnd="170dp"
        android:layout_marginRight="170dp"
        android:layout_marginBottom="121dp"
        android:text="XX Number"
        app:layout_constraintBottom_toTopOf="@+id/textView"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView3" />
```

Skärmklipp på skärmen för _MainActivity_
![Screenshot_20240421_224548](https://github.com/a20gabpa/mobileapp-programming-screens/assets/102604680/8047937b-7429-4234-82e2-38e640fd298a)
Skärklipp på skärmen för _OtherActivity_
![Screenshot_20240421_224559](https://github.com/a20gabpa/mobileapp-programming-screens/assets/102604680/1ecd096f-959e-4298-97d1-809abe7c74ee)


