object ApplicationId {
    val id = "com.psflickr"
}

const val revisionPrefix = "rev"
const val conjuctionPrefix = "-"
const val pointPrefix = "."

object Release {
    const val versionMajor = 1
    const val versionMinor = 2
    const val buildNum = 0

    const val versionCode = versionMajor * 1000000 + versionMinor * 1000 + buildNum

    val versionName = StringBuilder()
        .append(versionMajor)
        .append(pointPrefix)
        .append(versionMinor)
        .append(pointPrefix)
        .append(buildNum)
        .toString()

    const val revisionCode = 1

    val versionNameDev = StringBuilder()
        .append(versionName)
        .append(conjuctionPrefix)
        .append(revisionPrefix)
        .append(conjuctionPrefix)
        .append(revisionCode).toString()

    const val compileSdkVersion = 30
    const val targetSdkVersion = 30
    const val minSdkVersion = 23

}

object Config {
    const val gradle = "com.android.tools.build:gradle:4.1.3"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlinVersion}"
    const val navigationGradle =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.navigationVersion}"
}

object Version {
    // Kotlin based
    const val kotlinVersion = "1.3.72"
    const val kotlinCoreVersion = "1.3.1"

    //RxJava & RxAndroid
    const val rxkotlinVersion = "2.2.0"
    const val rxandroidVersion = "2.1.0"
    const val rxbindingVersion = "2.1.1"

    //json
    const val moshiVersion = "1.8.0"
    const val gsonVersion = "2.8.5"
    //Dagger
    const val daggerVersion = "2.18"

    //Dependency Injection
    const val koin = "2.0.1"

    //image
    const val glideVersion = "4.9.0"

    //Networking
    const val retrofitVersion = "2.4.0"
    const val okhttpLoggingVersion = "3.11.0"

    //Android jetpack
    const val appcompatVersion = "1.1.0"
    const val constraintLayoutVersion = "2.0.0-rc1"
    const val navigationVersion = "2.3.0"
    const val lifecycleVersion = "2.0.0"
    const val materialComponentVersion = "1.0.0"
    const val legacySupportVersion = "1.0.0"

    //test
    const val testRunnerVersion = "1.1.1"
    const val junitVersion = "4.12"

    //findBugAnnotation
    const val findBugsVersion = "3.0.2"

    //timber
    const val timber = "4.7.1"

    //circular imageview
    const val circularImageViewVersion = "3.0.0"

    //permission dispatcher
    const val permissionDispatcherVersion = "4.5.0"

    //room
    const val roomVersion = "2.1.0"

    //google map sdk
    const val googleMapVersion = "17.0.0"

    //google play services - Location
    const val googleLocationServicesVersion = "16.0.0"

    const val googlePlacesSdkVersion = "2.0.0"

    //stetho
    const val stethoVersion = "1.5.1"

    //crashlytics
    const val crashlyticsVersion = "2.9.8@aar"

    //multidex
    const val multidexVersion = "2.0.1"

    //firebase
    const val firebasePerfVersion = "19.0.0"
    const val firebaseAnalytics = "17.2.0"
    const val firebaseDatabase = "19.1.0"

    //facebook
    const val shimmerVersion = "0.4.0"

    //unit test
    const val mockitoVersion = "2.21.0"
    const val mockitoInlineVersion = "2.19.0"
    const val coreTestingVersion = "1.1.1"
    const val mockitoKotlinVersion = "2.1.0"
    const val daggerMockVersion = "0.8.5"
    const val kotlinTestVersion = "3.3.2"

    // unitTests
    const val unitTests = "3.5.13"
    const val mokitoKotlin = "2.2.0"
    const val mokitoInline = "2.19.0"
    const val coreTesting = "1.1.1"
    const val daggerMock = "0.8.5"
    const val jUnit = "3.3.2"

    //image compressor
    const val imageCompressorVersion = "2.1.0"

    //image crop
    const val imageCropVersion = "2.8.0"

    //shadow
    const val shadowVersion = "0.0.4-beta3"

}

object Dependencies {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlinVersion}"
}

object Log {
    const val timber = "com.jakewharton.timber:timber:${Version.timber}"
}

object Koin {
    const val core = "org.koin:koin-core:${Version.koin}"
    const val android = "org.koin:koin-android:${Version.koin}"
    const val androidScope = "org.koin:koin-androidx-scope:${Version.koin}"
    const val androidViewModel = "org.koin:koin-androidx-viewmodel:${Version.koin}"
}

object Support {
    const val core = "androidx.core:core-ktx:${Version.kotlinCoreVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Version.appcompatVersion}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Version.constraintLayoutVersion}"
    const val lifeCycleExtensions =
        "androidx.lifecycle:lifecycle-extensions:${Version.lifecycleVersion}"
    const val materialComponent =
        "com.google.android.material:material:${Version.materialComponentVersion}"
    const val legacySupport = "androidx.legacy:legacy-support-v4:${Version.legacySupportVersion}"
    const val multidex = "androidx.multidex:multidex:${Version.multidexVersion}"

}

object Image {
    const val glide = "com.github.bumptech.glide:glide:${Version.glideVersion}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Version.glideVersion}"
}

object Arch {
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Version.navigationVersion}"
    const val navigationKtx = "androidx.navigation:navigation-ui-ktx:${Version.navigationVersion}"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofitVersion}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Version.retrofitVersion}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Version.retrofitVersion}"
    const val adapterRxJava = "com.squareup.retrofit2:adapter-rxjava2:${Version.retrofitVersion}"
    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Version.okhttpLoggingVersion}"
}

object Json {
    const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Version.moshiVersion}"
    const val moshiKapt = "com.squareup.moshi:moshi-kotlin-codegen:${Version.moshiVersion}"
    const val gson = "com.google.code.gson:gson:${Version.gsonVersion}"
}


object Reactivex {
    const val android = "io.reactivex.rxjava2:rxandroid:${Version.rxandroidVersion}"
    const val kotlin = "io.reactivex.rxjava2:rxkotlin:${Version.rxkotlinVersion}"
    const val rxBinding = "com.jakewharton.rxbinding2:rxbinding:${Version.rxbindingVersion}"
}

object Dagger {
    const val dagger = "com.google.dagger:dagger:${Version.daggerVersion}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Version.daggerVersion}"
}

object TestLibs {
    const val junit = "junit:junit:${Version.junitVersion}"
    const val testRunner = "androidx.test:runner:${Version.testRunnerVersion}"
}

object Annotation {
    const val findBugs = "com.google.code.findbugs:jsr305:${Version.findBugsVersion}"
}

object CircularImageView {
    const val circularImageView = "de.hdodenhof:circleimageview:${Version.circularImageViewVersion}"
}

object Database {
    //room database
    const val room = "androidx.room:room-runtime:${Version.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Version.roomVersion}"
    const val roomRx = "androidx.room:room-rxjava2:${Version.roomVersion}"
    const val stetho = "com.facebook.stetho:stetho:${Version.stethoVersion}"
}

object PermissionDispatcher {
    const val permissionsDispatcher =
        "org.permissionsdispatcher:permissionsdispatcher:${Version.permissionDispatcherVersion}"
    const val permissionsDispatcherProcessor =
        "org.permissionsdispatcher:permissionsdispatcher-processor:${Version.permissionDispatcherVersion}"
}

object GoogleMapSdk {
    const val googleMap = "com.google.android.gms:play-services-maps:${Version.googleMapVersion}"
    const val googleLocationServices =
        "com.google.android.gms:play-services-location:${Version.googleLocationServicesVersion}"
    const val googlePlaces =
        "com.google.android.libraries.places:places:${Version.googlePlacesSdkVersion}"
}

object Firebase {
    const val crashlytics = "com.crashlytics.sdk.android:crashlytics:${Version.crashlyticsVersion}"
    const val performance = "com.google.firebase:firebase-perf:${Version.firebasePerfVersion}"
    const val analytics = "com.google.firebase:firebase-analytics:${Version.firebaseAnalytics}"
    const val database = "com.google.firebase:firebase-database:${Version.firebaseDatabase}"
}

object Facebook {
    val shimmer = "com.facebook.shimmer:shimmer:${Version.shimmerVersion}"
}

object UnitTest {
    const val mockitoCore = "org.mockito:mockito-core:${Version.mockitoVersion}"
    const val mockitoInline = "org.mockito:mockito-inline:${Version.mockitoInlineVersion}"
    const val coreTesting = "android.arch.core:core-testing:${Version.coreTestingVersion}"
    const val mockitoKotlin =
        "com.nhaarman.mockitokotlin2:mockito-kotlin:${Version.mockitoKotlinVersion}"
    const val daggerMock =
        "com.github.fabioCollini.daggermock:daggermock-kotlin:${Version.daggerMockVersion}"
    const val kotlinTest = "io.kotlintest:kotlintest-runner-junit5:${Version.kotlinTestVersion}"
}

object ImageCompress {
    const val zeloryCompressor = "id.zelory:compressor:${Version.imageCompressorVersion}"
}

object ImageCrop {
    const val imageCropper =
        "com.theartofdev.edmodo:android-image-cropper:${Version.imageCropVersion}"
}

object CustomShadow {
    const val shadow = "com.loopeer.lib:shadow:${Version.shadowVersion}"
}

object Unittests {
    const val CoreMockito =
        "org.mockito:mockito-core:${Version.unitTests}"
    const val MokitoKotlin =
        "com.nhaarman.mockitokotlin2:mockito-kotlin:${Version.mokitoKotlin}"
    const val MokitoInline = "org.mockito:mockito-inline:${Version.mokitoInline}"
    const val CoreTesting = "android.arch.core:core-testing:${Version.coreTesting}"
    const val DaggerMock =
        "com.github.fabioCollini.daggermock:daggermock-kotlin:${Version.daggerMock}"
    const val Junit = "io.kotlintest:kotlintest-runner-junit5:${Version.jUnit}"
}