# kotlin-extensions

<!--[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-RxParse-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/1670)-->
<!--[![Download](https://api.bintray.com/packages/yongjhih/maven/kotlin-android-extensions/images/download.svg) ](https://bintray.com/yongjhih/maven/kotlin-android-extensions/_latestVersion)-->
[![JitPack](https://img.shields.io/github/tag/yongjhih/kotlin-android-extensions.svg?label=JitPack)](https://jitpack.io/#yongjhih/kotlin-android-extensions)
[![javadoc](https://img.shields.io/github/tag/yongjhih/kotlin-android-extensions.svg?label=javadoc)](https://jitpack.io/com/github/yongjhih/kotlin-android-extensions/-SNAPSHOT/javadoc/)
[![Build Status](https://travis-ci.org/yongjhih/kotlin-android-extensions.svg)](https://travis-ci.org/yongjhih/kotlin-android-extensions)
[![Join the chat at https://gitter.im/yongjhih/kotlin-android-extensions](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/yongjhih/kotlin-android-extensions?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Kotlin](https://img.shields.io/maven-central/v/org.jetbrains.kotlin/kotlin-maven-plugin.svg?label=Kotlin)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22org.jetbrains.kotlin%22)

![](art/kotlin-database.png)

## Usage

## Database

Before:

```java
db.beginTransaction();
try {
  db.delete("users", "first_name = ?", new String[] { "Andrew" });
  db.setTransactionSuccessful();
} finally {
  db.endTransaction()
}
```

or

```java
Databases.from(db).inTransaction(it -> {
  it.delete("users", "first_name = ?", new String[] { "Andrew" });
});
```

After:

```kotlin
db.inTransation {
  delete("users", "first_name = ?", arrayOf("Andrew"))
}
```

Before:

```java
String firstName = cursor.getString(cursor.getColumnIndexOrThrow("first_name"));
```

After:

```kotlin
val firstName = cursor.getString("first_name");
```

Before:

```java
String firstName = null;
int firstNameColumnIndex = cursor.getColumnIndexOrThrow("first_name");
if (!cursor.isNull(firstNameColumnIndex)) {
  firstName = cursor.getString(firstNameColumnIndex);
}
firstNameView.setText(firstName != null ? firstName : "Andrew");
```

After:

```kotlin
val firstName = cursor.getStringOrNull("first_name")
firstNameView.setText(firstName ?: "Andrew")
```

## SharedPreferences

Before:

```java
SharePreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
SharePreferences.Editor editor = prefs.edit();
editor.putString("name", "Andrew Chen");
editor.putInt("age", 18, 14);
editor.apply();
```

After:

```kotlin

User(context).edit {
  name = "Andrew Chen"
  age = "18"
}

public class User(context: Context) : Preferences(context) {
  var name: String by Preference()
  var age: Int by Preference(default = 14)
}
```

or

```kotlin
User user = User(context)
user.name = "Andrew Chen"
user.age = 18
user.apply()
```

### Bonus - SharedPreferences Extension:

Before:

```java
SharedPreferences.Editor editor = prefs.edit();

editor.putString("first_name", "Andrew");
editor.putString("last_name", "Chen");
editor.remove("age");

editor.apply();
```

or

```java
SharedPreferencesUtils.from(prefs).apply(editor -> {
  editor.putString("first_name", "Andrew");
  editor.putString("last_name", "Chen");
  editor.remove("age");
});
```

After:

```kotlin
prefs.edit {
  putString("first_name", "Andrew")
  putString("last_name", "Chen")
  remove("age")
}
```

## System Services

Before:

```java
NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
```

After:

```kotlin
val notificationManager = context.getNotificationManager()
```


```kotlin
preferences.edit {
  putString("first_name", "Andrew")
  putString("last_name", "Chen")
  remove("age")
}
```

## Notification

Before:

```java
Notification notification = new NotificationCompat.Builder(context)
  .setContentTitle("Hello")
  .setSubText("World")
  .build();
```

After:

```kotlin
val notification = Notification.build(context) {
  setContentTitle("Hello")
  setSubText("World")
}
```

## Query

## Math



## Installation

jcenter:

```gradle
dependencies {
    compile 'com.infstory:kotlinx-android-sharedpreferences:1.0.0'
    compile 'com.infstory:kotlinx-android-database:1.0.0'
    compile 'com.infstory:kotlinx-android-system-services:1.0.0'
    compile 'com.infstory:kotlinx-android-notification:1.0.0'
    compile 'com.infstory:kotlinx-math:1.0.0'
}
```

jitpack:

```gradle
repositories {
    // ...
    maven { url "https://jitpack.io" }
}
dependencies {
    compile 'com.github.yongjhih.kotlin-extensions:kotlinx-android-sharedpreferences:-SNAPSHOT'
    compile 'com.github.yongjhih.kotlin-extensions:kotlinx-android-database:-SNAPSHOT'
    compile 'com.github.yongjhih.kotlin-extensions:kotlinx-android-system-services:-SNAPSHOT'
    compile 'com.github.yongjhih.kotlin-extensions:kotlinx-android-notification:-SNAPSHOT'
    compile 'com.github.yongjhih.kotlin-extensions:kotlinx-math:-SNAPSHOT'
}
```

## License

```
Copyright 2015 8tory, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
