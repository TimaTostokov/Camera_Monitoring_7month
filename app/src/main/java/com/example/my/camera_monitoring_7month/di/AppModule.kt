package com.example.my.camera_monitoring_7month.di

import android.content.Context
import androidx.room.Room
import com.example.my.camera_monitoring_7month.data.local.db.CameraDao
import com.example.my.camera_monitoring_7month.data.local.db.DoorDao
import com.example.my.camera_monitoring_7month.data.local.db.HouseDatabase
import com.example.my.camera_monitoring_7month.data.remoute.HouseApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): HouseDatabase =
        Room.databaseBuilder(context, HouseDatabase::class.java, "house database")
            .allowMainThreadQueries().build()

    @Provides
    fun provideCameraDao(@ApplicationContext context: Context): CameraDao =
        provideAppDatabase(context).getCameraDao()

    @Provides
    fun provideDoorDao(houseDatabase: HouseDatabase): DoorDao = houseDatabase.getDoorDao()


    @Provides
    fun provideRetrofit(): Retrofit {

        val interceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient =
            OkHttpClient().newBuilder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://cars.cprogroup.ru/api/rubetek/")
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideHouseApiService(retrofit: Retrofit): HouseApiService =
        retrofit.create(HouseApiService::class.java)

}