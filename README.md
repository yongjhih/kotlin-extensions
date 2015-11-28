# KotSharedPreferences

## Usage

```kotlin

User().edit(context) {
  name = "Andrew Chen"
  age = "18"
}

public class User {
  var name: String by Preference(default = "Andrew Chen")
  var age: Int by Preference()
}
```
