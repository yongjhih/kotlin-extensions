# KotSharedPreferences

## Usage

```kotlin

User().edit(context) {
  name = "Andrew Chen"
  age = "20"
}

public class User {
  var name: String by Preference()
  var age: Int by Preference(default = 18)
}
```
