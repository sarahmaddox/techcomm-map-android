# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/techcomm/Development/adt-bundle-mac-x86_64-20130917/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# From http://realm.io/docs/java.
-keepnames public class * extends io.realm.RealmObject
-keep class io.realm.** { *; }
-dontwarn javax.**
-dontwarn io.realm.**

# From https://github.com/ragunathjawahar/android-saripaar.
-keep class com.mobsandgeeks.saripaar.** {*;}
-keep class commons.validator.routines.** {*;}

# Disable logging in release build.
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** w(...);
    public static *** v(...);
    public static *** i(...);
}