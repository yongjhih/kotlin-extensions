# KotSharedPreferences

## Usage

```kotlin

User(context).edit {
  name = "Andrew Chen"
  age = "18"
}

public class User {
  var name: String by Preference(default = "Andrew Chen")
  var age: Int by Preference()
}
```
