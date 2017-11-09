package pl.olszak.michal.smartwatchplayground.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author molszak
 *         created on 09.11.2017.
 */
class PlaygroundSchedulersFacade @Inject internal constructor(): PlaygroundSchedulers {

    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    override fun io(): Scheduler {
        return Schedulers.io()
    }

    override fun computation(): Scheduler {
        return Schedulers.computation()
    }
}