package pl.olszak.michal.smartwatchplayground.di.module

import android.content.res.Resources
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pl.olszak.michal.smartwatchplayground.BuildConfig
import pl.olszak.michal.smartwatchplayground.R
import pl.olszak.michal.smartwatchplayground.di.scope.PerApplication
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author molszak
 *         created on 09.11.2017.
 */
@PerApplication
@Module
class ApiModule {

    @Provides
    @PerApplication
    internal fun provideMoshi() : Moshi {
        return Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
    }

    @Provides
    @PerApplication
    internal fun provideOkhttp(resources: Resources) : OkHttpClient {
        val builder = OkHttpClient.Builder()

        builder.connectTimeout(60L, TimeUnit.SECONDS)
                .readTimeout(60L, TimeUnit.SECONDS)

        val key = resources.getString(R.string.open_weather_api_key)

        val interceptor = Interceptor { chain ->
            val original = chain.request()
            val url = original.url()

            val newUrl = url.newBuilder()
                    .addQueryParameter("APPID", key)
                    .build()

            val builder = original.newBuilder()
                    .url(newUrl)

            //needs finishing

            return chain.proceed(builder.build())
        }

        if(BuildConfig.DEBUG){
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(logging)
        }

        return builder.build()
    }

    @Provides
    @PerApplication
    internal fun provideRestAdapter(client : OkHttpClient, moshi : Moshi, resources: Resources) : Retrofit{
        val builder = Retrofit.Builder()

        val baseUrl = resources.getString(R.string.base_url)

        builder.client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .baseUrl(baseUrl)

        return builder.build()
    }

}