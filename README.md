# KotSharedPreferences

<!--[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-RxParse-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/1670)-->
[![JitPack](https://img.shields.io/github/tag/yongjhih/kotlin-sharedpreferences.svg?label=JitPack)](https://jitpack.io/#yongjhih/kotlin-sharedpreferences)
[![Download](https://api.bintray.com/packages/yongjhih/maven/kotlin-sharedpreferences/images/download.svg) ](https://bintray.com/yongjhih/maven/kotlin-sharedpreferences/_latestVersion)
[![javadoc](https://img.shields.io/github/tag/yongjhih/kotlin-sharedpreferences.svg?label=javadoc)](https://jitpack.io/com/github/yongjhih/kotlin-sharedpreferences/rxparse/c3256ac553/javadoc/)
[![Build Status](https://travis-ci.org/yongjhih/kotlin-sharedpreferences.svg)](https://travis-ci.org/yongjhih/kotlin-sharedpreferences)
[![Join the chat at https://gitter.im/yongjhih/kotlin-sharedpreferences](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/yongjhih/kotlin-sharedpreferences?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

![](art/kotlin-sharedpreferences.png)

## Usage

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

User(context).edit() {
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

public class User(context: Context) : Preferences(context) {
  var name: String by Preference()
  var age: Int by Preference(default = 14)
}
```

## Installation

jcenter:

```gradle
compile 'com.infstory:kotlin-sharedpreferences:1.0.0'
```

jitpack:

```gradle
compile 'com.infstory:kotlin-sharedpreferences:-SNAPSHOT'
```
