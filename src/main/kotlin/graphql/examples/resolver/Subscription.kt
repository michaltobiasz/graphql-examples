package graphql.examples.resolver

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver
import graphql.examples.pojo.Score
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import org.reactivestreams.Publisher
import org.springframework.stereotype.Component
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

@Component
class Subscription : GraphQLSubscriptionResolver {

    fun scores(title: String): Publisher<Score> {
        val observable = Observable.create<Score> { emitter ->
            val scheduledThreadPool = Executors.newScheduledThreadPool(1)
            scheduledThreadPool.scheduleAtFixedRate({
                val score = Score(title, (Math.random() * 5).toInt())
                emitter.onNext(score)
            }, 0, 2, TimeUnit.SECONDS)
        }

        val connect = observable.share().publish()
        connect.connect()
        return connect.toFlowable(BackpressureStrategy.BUFFER)
    }
}